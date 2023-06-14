package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.LixiaoDeparturenotices;

/**
 * 离校注意事项公告Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface ILixiaoDeparturenoticesService 
{
    /**
     * 查询离校注意事项公告
     * 
     * @param noticeID 离校注意事项公告主键
     * @return 离校注意事项公告
     */
    public LixiaoDeparturenotices selectLixiaoDeparturenoticesByNoticeID(Long noticeID);

    /**
     * 查询离校注意事项公告列表
     * 
     * @param lixiaoDeparturenotices 离校注意事项公告
     * @return 离校注意事项公告集合
     */
    public List<LixiaoDeparturenotices> selectLixiaoDeparturenoticesList(LixiaoDeparturenotices lixiaoDeparturenotices);

    /**
     * 新增离校注意事项公告
     * 
     * @param lixiaoDeparturenotices 离校注意事项公告
     * @return 结果
     */
    public int insertLixiaoDeparturenotices(LixiaoDeparturenotices lixiaoDeparturenotices);

    /**
     * 修改离校注意事项公告
     * 
     * @param lixiaoDeparturenotices 离校注意事项公告
     * @return 结果
     */
    public int updateLixiaoDeparturenotices(LixiaoDeparturenotices lixiaoDeparturenotices);

    /**
     * 批量删除离校注意事项公告
     * 
     * @param noticeIDs 需要删除的离校注意事项公告主键集合
     * @return 结果
     */
    public int deleteLixiaoDeparturenoticesByNoticeIDs(Long[] noticeIDs);

    /**
     * 删除离校注意事项公告信息
     * 
     * @param noticeID 离校注意事项公告主键
     * @return 结果
     */
    public int deleteLixiaoDeparturenoticesByNoticeID(Long noticeID);
}
