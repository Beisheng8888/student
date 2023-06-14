package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.SsSanitationInspectionNotice;

/**
 * 卫生检查通知Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface SsSanitationInspectionNoticeMapper 
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
     * 删除卫生检查通知
     * 
     * @param inspectionId 卫生检查通知主键
     * @return 结果
     */
    public int deleteSsSanitationInspectionNoticeByInspectionId(Long inspectionId);

    /**
     * 批量删除卫生检查通知
     * 
     * @param inspectionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSsSanitationInspectionNoticeByInspectionIds(Long[] inspectionIds);
}
