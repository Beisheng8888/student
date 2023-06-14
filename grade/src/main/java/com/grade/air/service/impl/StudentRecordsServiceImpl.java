package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.StudentRecordsMapper;
import com.grade.air.domain.StudentRecords;
import com.grade.air.service.IStudentRecordsService;

import javax.annotation.Resource;
import javax.validation.Validator;

/**
 * 档案查询Service业务层处理
 * 
 * @author l
 * @date 2023-06-05
 */
@Service
public class StudentRecordsServiceImpl implements IStudentRecordsService 
{
    @Resource
    private StudentRecordsMapper studentRecordsMapper;
    @Autowired
    protected Validator validator;
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    /**
     * 查询档案查询
     * 
     * @param studentId 档案查询主键
     * @return 档案查询
     */
    @Override
    public StudentRecords selectStudentRecordsByStudentId(Long studentId)
    {
        return studentRecordsMapper.selectStudentRecordsByStudentId(studentId);
    }

    /**
     * 查询档案查询列表
     * 
     * @param studentRecords 档案查询
     * @return 档案查询
     */
    @Override
    public List<StudentRecords> selectStudentRecordsList(StudentRecords studentRecords)
    {
        return studentRecordsMapper.selectStudentRecordsList(studentRecords);
    }

    /**
     * 新增档案查询
     * 
     * @param studentRecords 档案查询
     * @return 结果
     */
    @Override
    public int insertStudentRecords(StudentRecords studentRecords)
    {
        return studentRecordsMapper.insertStudentRecords(studentRecords);
    }

    /**
     * 修改档案查询
     * 
     * @param studentRecords 档案查询
     * @return 结果
     */
    @Override
    public int updateStudentRecords(StudentRecords studentRecords)
    {
        return studentRecordsMapper.updateStudentRecords(studentRecords);
    }

    /**
     * 批量删除档案查询
     * 
     * @param studentIds 需要删除的档案查询主键
     * @return 结果
     */
    @Override
    public int deleteStudentRecordsByStudentIds(Long[] studentIds)
    {
        return studentRecordsMapper.deleteStudentRecordsByStudentIds(studentIds);
    }

    /**
     * 删除档案查询信息
     * 
     * @param studentId 档案查询主键
     * @return 结果
     */
    @Override
    public int deleteStudentRecordsByStudentId(Long studentId)
    {
        return studentRecordsMapper.deleteStudentRecordsByStudentId(studentId);
    }

    @Override
    public String importUser(List<StudentRecords> userList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new ServiceException("导入学生基本信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (StudentRecords stu : userList)
        {
            try
            {
                // 验证是否存在这个用户
                StudentRecords u = studentRecordsMapper.selectStudentRecordsByStudentId(stu.getStudentId());
                if (StringUtils.isNull(u))
                {
                    BeanValidators.validateWithException(validator, stu);
                    stu.setCreateBy(operName);
                    this.insertStudentRecords(stu);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、学号 " + stu.getStudentId() + " 导入成功");
                }
                else if (updateSupport)
                {
                    BeanValidators.validateWithException(validator, stu);
                    stu.setUpdateBy(operName);
                    this.updateStudentRecords(stu);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、学号 " + stu.getStudentId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、学号 " + stu.getStudentId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、学号 " + stu.getStudentId() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
