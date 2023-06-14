package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LixiaoDeparturenoticesMapper;
import com.grade.air.domain.LixiaoDeparturenotices;
import com.grade.air.service.ILixiaoDeparturenoticesService;

/**
 * 离校注意事项公告Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LixiaoDeparturenoticesServiceImpl implements ILixiaoDeparturenoticesService 
{
    @Autowired
    private LixiaoDeparturenoticesMapper lixiaoDeparturenoticesMapper;

    /**
     * 查询离校注意事项公告
     * 
     * @param noticeID 离校注意事项公告主键
     * @return 离校注意事项公告
     */
    @Override
    public LixiaoDeparturenotices selectLixiaoDeparturenoticesByNoticeID(Long noticeID)
    {
        return lixiaoDeparturenoticesMapper.selectLixiaoDeparturenoticesByNoticeID(noticeID);
    }

    /**
     * 查询离校注意事项公告列表
     * 
     * @param lixiaoDeparturenotices 离校注意事项公告
     * @return 离校注意事项公告
     */
    @Override
    public List<LixiaoDeparturenotices> selectLixiaoDeparturenoticesList(LixiaoDeparturenotices lixiaoDeparturenotices)
    {
        return lixiaoDeparturenoticesMapper.selectLixiaoDeparturenoticesList(lixiaoDeparturenotices);
    }

    /**
     * 新增离校注意事项公告
     * 
     * @param lixiaoDeparturenotices 离校注意事项公告
     * @return 结果
     */
    @Override
    public int insertLixiaoDeparturenotices(LixiaoDeparturenotices lixiaoDeparturenotices)
    {
        return lixiaoDeparturenoticesMapper.insertLixiaoDeparturenotices(lixiaoDeparturenotices);
    }

    /**
     * 修改离校注意事项公告
     * 
     * @param lixiaoDeparturenotices 离校注意事项公告
     * @return 结果
     */
    @Override
    public int updateLixiaoDeparturenotices(LixiaoDeparturenotices lixiaoDeparturenotices)
    {
        return lixiaoDeparturenoticesMapper.updateLixiaoDeparturenotices(lixiaoDeparturenotices);
    }

    /**
     * 批量删除离校注意事项公告
     * 
     * @param noticeIDs 需要删除的离校注意事项公告主键
     * @return 结果
     */
    @Override
    public int deleteLixiaoDeparturenoticesByNoticeIDs(Long[] noticeIDs)
    {
        return lixiaoDeparturenoticesMapper.deleteLixiaoDeparturenoticesByNoticeIDs(noticeIDs);
    }

    /**
     * 删除离校注意事项公告信息
     * 
     * @param noticeID 离校注意事项公告主键
     * @return 结果
     */
    @Override
    public int deleteLixiaoDeparturenoticesByNoticeID(Long noticeID)
    {
        return lixiaoDeparturenoticesMapper.deleteLixiaoDeparturenoticesByNoticeID(noticeID);
    }
}
