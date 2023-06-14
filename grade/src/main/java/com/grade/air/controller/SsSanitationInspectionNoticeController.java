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
import com.grade.air.domain.SsSanitationInspectionNotice;
import com.grade.air.service.ISsSanitationInspectionNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 卫生检查通知Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/noticegl")
public class SsSanitationInspectionNoticeController extends BaseController
{
    @Autowired
    private ISsSanitationInspectionNoticeService ssSanitationInspectionNoticeService;

    /**
     * 查询卫生检查通知列表
     */
    @PreAuthorize("@ss.hasPermi('air:noticegl:list')")
    @GetMapping("/list")
    public TableDataInfo list(SsSanitationInspectionNotice ssSanitationInspectionNotice)
    {
        startPage();
        List<SsSanitationInspectionNotice> list = ssSanitationInspectionNoticeService.selectSsSanitationInspectionNoticeList(ssSanitationInspectionNotice);
        return getDataTable(list);
    }

    /**
     * 导出卫生检查通知列表
     */
    @PreAuthorize("@ss.hasPermi('air:noticegl:export')")
    @Log(title = "卫生检查通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SsSanitationInspectionNotice ssSanitationInspectionNotice)
    {
        List<SsSanitationInspectionNotice> list = ssSanitationInspectionNoticeService.selectSsSanitationInspectionNoticeList(ssSanitationInspectionNotice);
        ExcelUtil<SsSanitationInspectionNotice> util = new ExcelUtil<SsSanitationInspectionNotice>(SsSanitationInspectionNotice.class);
        util.exportExcel(response, list, "卫生检查通知数据");
    }

    /**
     * 获取卫生检查通知详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:noticegl:query')")
    @GetMapping(value = "/{inspectionId}")
    public AjaxResult getInfo(@PathVariable("inspectionId") Long inspectionId)
    {
        return success(ssSanitationInspectionNoticeService.selectSsSanitationInspectionNoticeByInspectionId(inspectionId));
    }

    /**
     * 新增卫生检查通知
     */
    @PreAuthorize("@ss.hasPermi('air:noticegl:add')")
    @Log(title = "卫生检查通知", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SsSanitationInspectionNotice ssSanitationInspectionNotice)
    {
        return toAjax(ssSanitationInspectionNoticeService.insertSsSanitationInspectionNotice(ssSanitationInspectionNotice));
    }

    /**
     * 修改卫生检查通知
     */
    @PreAuthorize("@ss.hasPermi('air:noticegl:edit')")
    @Log(title = "卫生检查通知", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SsSanitationInspectionNotice ssSanitationInspectionNotice)
    {
        return toAjax(ssSanitationInspectionNoticeService.updateSsSanitationInspectionNotice(ssSanitationInspectionNotice));
    }

    /**
     * 删除卫生检查通知
     */
    @PreAuthorize("@ss.hasPermi('air:noticegl:remove')")
    @Log(title = "卫生检查通知", businessType = BusinessType.DELETE)
	@DeleteMapping("/{inspectionIds}")
    public AjaxResult remove(@PathVariable Long[] inspectionIds)
    {
        return toAjax(ssSanitationInspectionNoticeService.deleteSsSanitationInspectionNoticeByInspectionIds(inspectionIds));
    }
}
