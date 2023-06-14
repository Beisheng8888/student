package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LixiaoGraduateManagementMapper;
import com.grade.air.domain.LixiaoGraduateManagement;
import com.grade.air.service.ILixiaoGraduateManagementService;

/**
 * 准毕业生管理数据Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LixiaoGraduateManagementServiceImpl implements ILixiaoGraduateManagementService 
{
    @Autowired
    private LixiaoGraduateManagementMapper lixiaoGraduateManagementMapper;

    /**
     * 查询准毕业生管理数据
     * 
     * @param studentId 准毕业生管理数据主键
     * @return 准毕业生管理数据
     */
    @Override
    public LixiaoGraduateManagement selectLixiaoGraduateManagementByStudentId(Long studentId)
    {
        return lixiaoGraduateManagementMapper.selectLixiaoGraduateManagementByStudentId(studentId);
    }

    /**
     * 查询准毕业生管理数据列表
     * 
     * @param lixiaoGraduateManagement 准毕业生管理数据
     * @return 准毕业生管理数据
     */
    @Override
    public List<LixiaoGraduateManagement> selectLixiaoGraduateManagementList(LixiaoGraduateManagement lixiaoGraduateManagement)
    {
        return lixiaoGraduateManagementMapper.selectLixiaoGraduateManagementList(lixiaoGraduateManagement);
    }

    /**
     * 新增准毕业生管理数据
     * 
     * @param lixiaoGraduateManagement 准毕业生管理数据
     * @return 结果
     */
    @Override
    public int insertLixiaoGraduateManagement(LixiaoGraduateManagement lixiaoGraduateManagement)
    {
        return lixiaoGraduateManagementMapper.insertLixiaoGraduateManagement(lixiaoGraduateManagement);
    }

    /**
     * 修改准毕业生管理数据
     * 
     * @param lixiaoGraduateManagement 准毕业生管理数据
     * @return 结果
     */
    @Override
    public int updateLixiaoGraduateManagement(LixiaoGraduateManagement lixiaoGraduateManagement)
    {
        return lixiaoGraduateManagementMapper.updateLixiaoGraduateManagement(lixiaoGraduateManagement);
    }

    /**
     * 批量删除准毕业生管理数据
     * 
     * @param studentIds 需要删除的准毕业生管理数据主键
     * @return 结果
     */
    @Override
    public int deleteLixiaoGraduateManagementByStudentIds(Long[] studentIds)
    {
        return lixiaoGraduateManagementMapper.deleteLixiaoGraduateManagementByStudentIds(studentIds);
    }

    /**
     * 删除准毕业生管理数据信息
     * 
     * @param studentId 准毕业生管理数据主键
     * @return 结果
     */
    @Override
    public int deleteLixiaoGraduateManagementByStudentId(Long studentId)
    {
        return lixiaoGraduateManagementMapper.deleteLixiaoGraduateManagementByStudentId(studentId);
    }
}
