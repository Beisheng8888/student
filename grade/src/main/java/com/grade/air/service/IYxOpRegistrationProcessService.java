package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.YxOpRegistrationProcess;

/**
 * 报到行政流程反馈Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IYxOpRegistrationProcessService 
{
    /**
     * 查询报到行政流程反馈
     * 
     * @param recordId 报到行政流程反馈主键
     * @return 报到行政流程反馈
     */
    public YxOpRegistrationProcess selectYxOpRegistrationProcessByRecordId(Long recordId);

    /**
     * 查询报到行政流程反馈列表
     * 
     * @param yxOpRegistrationProcess 报到行政流程反馈
     * @return 报到行政流程反馈集合
     */
    public List<YxOpRegistrationProcess> selectYxOpRegistrationProcessList(YxOpRegistrationProcess yxOpRegistrationProcess);

    /**
     * 新增报到行政流程反馈
     * 
     * @param yxOpRegistrationProcess 报到行政流程反馈
     * @return 结果
     */
    public int insertYxOpRegistrationProcess(YxOpRegistrationProcess yxOpRegistrationProcess);

    /**
     * 修改报到行政流程反馈
     * 
     * @param yxOpRegistrationProcess 报到行政流程反馈
     * @return 结果
     */
    public int updateYxOpRegistrationProcess(YxOpRegistrationProcess yxOpRegistrationProcess);

    /**
     * 批量删除报到行政流程反馈
     * 
     * @param recordIds 需要删除的报到行政流程反馈主键集合
     * @return 结果
     */
    public int deleteYxOpRegistrationProcessByRecordIds(Long[] recordIds);

    /**
     * 删除报到行政流程反馈信息
     * 
     * @param recordId 报到行政流程反馈主键
     * @return 结果
     */
    public int deleteYxOpRegistrationProcessByRecordId(Long recordId);
}
