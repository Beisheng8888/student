package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.YxOpRegistrationProcessMapper;
import com.grade.air.domain.YxOpRegistrationProcess;
import com.grade.air.service.IYxOpRegistrationProcessService;

/**
 * 报到行政流程反馈Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class YxOpRegistrationProcessServiceImpl implements IYxOpRegistrationProcessService 
{
    @Autowired
    private YxOpRegistrationProcessMapper yxOpRegistrationProcessMapper;

    /**
     * 查询报到行政流程反馈
     * 
     * @param recordId 报到行政流程反馈主键
     * @return 报到行政流程反馈
     */
    @Override
    public YxOpRegistrationProcess selectYxOpRegistrationProcessByRecordId(Long recordId)
    {
        return yxOpRegistrationProcessMapper.selectYxOpRegistrationProcessByRecordId(recordId);
    }

    /**
     * 查询报到行政流程反馈列表
     * 
     * @param yxOpRegistrationProcess 报到行政流程反馈
     * @return 报到行政流程反馈
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<YxOpRegistrationProcess> selectYxOpRegistrationProcessList(YxOpRegistrationProcess yxOpRegistrationProcess)
    {
        return yxOpRegistrationProcessMapper.selectYxOpRegistrationProcessList(yxOpRegistrationProcess);
    }

    /**
     * 新增报到行政流程反馈
     * 
     * @param yxOpRegistrationProcess 报到行政流程反馈
     * @return 结果
     */
    @Override
    public int insertYxOpRegistrationProcess(YxOpRegistrationProcess yxOpRegistrationProcess)
    {
        return yxOpRegistrationProcessMapper.insertYxOpRegistrationProcess(yxOpRegistrationProcess);
    }

    /**
     * 修改报到行政流程反馈
     * 
     * @param yxOpRegistrationProcess 报到行政流程反馈
     * @return 结果
     */
    @Override
    public int updateYxOpRegistrationProcess(YxOpRegistrationProcess yxOpRegistrationProcess)
    {
        return yxOpRegistrationProcessMapper.updateYxOpRegistrationProcess(yxOpRegistrationProcess);
    }

    /**
     * 批量删除报到行政流程反馈
     * 
     * @param recordIds 需要删除的报到行政流程反馈主键
     * @return 结果
     */
    @Override
    public int deleteYxOpRegistrationProcessByRecordIds(Long[] recordIds)
    {
        return yxOpRegistrationProcessMapper.deleteYxOpRegistrationProcessByRecordIds(recordIds);
    }

    /**
     * 删除报到行政流程反馈信息
     * 
     * @param recordId 报到行政流程反馈主键
     * @return 结果
     */
    @Override
    public int deleteYxOpRegistrationProcessByRecordId(Long recordId)
    {
        return yxOpRegistrationProcessMapper.deleteYxOpRegistrationProcessByRecordId(recordId);
    }
}
