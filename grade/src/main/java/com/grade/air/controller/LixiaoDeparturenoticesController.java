package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.grade.air.domain.LixiaoDeparturenotices;
import com.grade.air.service.ILixiaoDeparturenoticesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 离校注意事项公告Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/departurenotices")
public class LixiaoDeparturenoticesController extends BaseController
{
    @Autowired
    private ILixiaoDeparturenoticesService lixiaoDeparturenoticesService;

    /**
     * 查询离校注意事项公告列表
     */
    @PreAuthorize("@ss.hasPermi('air:departurenotices:list')")
    @GetMapping("/list")
    public TableDataInfo list(LixiaoDeparturenotices lixiaoDeparturenotices)
    {
        startPage();
        List<LixiaoDeparturenotices> list = lixiaoDeparturenoticesService.selectLixiaoDeparturenoticesList(lixiaoDeparturenotices);
        return getDataTable(list);
    }

    /**
     * 导出离校注意事项公告列表
     */
    @PreAuthorize("@ss.hasPermi('air:departurenotices:export')")
    @Log(title = "离校注意事项公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LixiaoDeparturenotices lixiaoDeparturenotices)
    {
        List<LixiaoDeparturenotices> list = lixiaoDeparturenoticesService.selectLixiaoDeparturenoticesList(lixiaoDeparturenotices);
        ExcelUtil<LixiaoDeparturenotices> util = new ExcelUtil<LixiaoDeparturenotices>(LixiaoDeparturenotices.class);
        util.exportExcel(response, list, "离校注意事项公告数据");
    }

    /**
     * 获取离校注意事项公告详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:departurenotices:query')")
    @GetMapping(value = "/{noticeID}")
    public AjaxResult getInfo(@PathVariable("noticeID") Long noticeID)
    {
        return success(lixiaoDeparturenoticesService.selectLixiaoDeparturenoticesByNoticeID(noticeID));
    }

    /**
     * 新增离校注意事项公告
     */
    @PreAuthorize("@ss.hasPermi('air:departurenotices:add')")
    @Log(title = "离校注意事项公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LixiaoDeparturenotices lixiaoDeparturenotices)
    {
        return toAjax(lixiaoDeparturenoticesService.insertLixiaoDeparturenotices(lixiaoDeparturenotices));
    }

    /**
     * 修改离校注意事项公告
     */
    @PreAuthorize("@ss.hasPermi('air:departurenotices:edit')")
    @Log(title = "离校注意事项公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LixiaoDeparturenotices lixiaoDeparturenotices)
    {
        return toAjax(lixiaoDeparturenoticesService.updateLixiaoDeparturenotices(lixiaoDeparturenotices));
    }

    /**
     * 删除离校注意事项公告
     */
    @PreAuthorize("@ss.hasPermi('air:departurenotices:remove')")
    @Log(title = "离校注意事项公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{noticeIDs}")
    public AjaxResult remove(@PathVariable Long[] noticeIDs)
    {
        return toAjax(lixiaoDeparturenoticesService.deleteLixiaoDeparturenoticesByNoticeIDs(noticeIDs));
    }
}
