package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.SsSanitationInspectionNoticeMapper;
import com.grade.air.domain.SsSanitationInspectionNotice;
import com.grade.air.service.ISsSanitationInspectionNoticeService;

/**
 * 卫生检查通知Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class SsSanitationInspectionNoticeServiceImpl implements ISsSanitationInspectionNoticeService 
{
    @Autowired
    private SsSanitationInspectionNoticeMapper ssSanitationInspectionNoticeMapper;

    /**
     * 查询卫生检查通知
     * 
     * @param inspectionId 卫生检查通知主键
     * @return 卫生检查通知
     */
    @Override
    public SsSanitationInspectionNotice selectSsSanitationInspectionNoticeByInspectionId(Long inspectionId)
    {
        return ssSanitationInspectionNoticeMapper.selectSsSanitationInspectionNoticeByInspectionId(inspectionId);
    }

    /**
     * 查询卫生检查通知列表
     * 
     * @param ssSanitationInspectionNotice 卫生检查通知
     * @return 卫生检查通知
     */
    @Override
    public List<SsSanitationInspectionNotice> selectSsSanitationInspectionNoticeList(SsSanitationInspectionNotice ssSanitationInspectionNotice)
    {
        return ssSanitationInspectionNoticeMapper.selectSsSanitationInspectionNoticeList(ssSanitationInspectionNotice);
    }

    /**
     * 新增卫生检查通知
     * 
     * @param ssSanitationInspectionNotice 卫生检查通知
     * @return 结果
     */
    @Override
    public int insertSsSanitationInspectionNotice(SsSanitationInspectionNotice ssSanitationInspectionNotice)
    {
        return ssSanitationInspectionNoticeMapper.insertSsSanitationInspectionNotice(ssSanitationInspectionNotice);
    }

    /**
     * 修改卫生检查通知
     * 
     * @param ssSanitationInspectionNotice 卫生检查通知
     * @return 结果
     */
    @Override
    public int updateSsSanitationInspectionNotice(SsSanitationInspectionNotice ssSanitationInspectionNotice)
    {
        return ssSanitationInspectionNoticeMapper.updateSsSanitationInspectionNotice(ssSanitationInspectionNotice);
    }

    /**
     * 批量删除卫生检查通知
     * 
     * @param inspectionIds 需要删除的卫生检查通知主键
     * @return 结果
     */
    @Override
    public int deleteSsSanitationInspectionNoticeByInspectionIds(Long[] inspectionIds)
    {
        return ssSanitationInspectionNoticeMapper.deleteSsSanitationInspectionNoticeByInspectionIds(inspectionIds);
    }

    /**
     * 删除卫生检查通知信息
     * 
     * @param inspectionId 卫生检查通知主键
     * @return 结果
     */
    @Override
    public int deleteSsSanitationInspectionNoticeByInspectionId(Long inspectionId)
    {
        return ssSanitationInspectionNoticeMapper.deleteSsSanitationInspectionNoticeByInspectionId(inspectionId);
    }
}
