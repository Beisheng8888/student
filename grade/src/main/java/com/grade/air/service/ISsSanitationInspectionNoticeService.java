package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.SsSanitationInspectionNotice;

/**
 * 卫生检查通知Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface ISsSanitationInspectionNoticeService 
{
    /**
     * 查询卫生检查通知
     * 
     * @param inspectionId 卫生检查通知主键
     * @return 卫生检查通知
     */
    public SsSanitationInspectionNotice selectSsSanitationInspectionNoticeByInspectionId(Long inspectionId);

    /**
     * 查询卫生检查通知列表
     * 
     * @param ssSanitationInspectionNotice 卫生检查通知
     * @return 卫生检查通知集合
     */
    public List<SsSanitationInspectionNotice> selectSsSanitationInspectionNoticeList(SsSanitationInspectionNotice ssSanitationInspectionNotice);

    /**
     * 新增卫生检查通知
     * 
     * @param ssSanitationInspectionNotice 卫生检查通知
     * @return 结果
     */
    public int insertSsSanitationInspectionNotice(SsSanitationInspectionNotice ssSanitationInspectionNotice);

    /**
     * 修改卫生检查通知
     * 
     * @param ssSanitationInspectionNotice 卫生检查通知
     * @return 结果
     */
    public int updateSsSanitationInspectionNotice(SsSanitationInspectionNotice ssSanitationInspectionNotice);

    /**
     * 批量删除卫生检查通知
     * 
     * @param inspectionIds 需要删除的卫生检查通知主键集合
     * @return 结果
     */
    public int deleteSsSanitationInspectionNoticeByInspectionIds(Long[] inspectionIds);

    /**
     * 删除卫生检查通知信息
     * 
     * @param inspectionId 卫生检查通知主键
     * @return 结果
     */
    public int deleteSsSanitationInspectionNoticeByInspectionId(Long inspectionId);
}
