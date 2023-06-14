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
import com.grade.air.domain.LixiaoDepartureapplications;
import com.grade.air.service.ILixiaoDepartureapplicationsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 离校申请Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/departureapplicationspa")
public class LixiaoDepartureapplicationsController extends BaseController
{
    @Autowired
    private ILixiaoDepartureapplicationsService lixiaoDepartureapplicationsService;

    /**
     * 查询离校申请列表
     */
    @PreAuthorize("@ss.hasPermi('air:departureapplicationspa:list')")
    @GetMapping("/list")
    public TableDataInfo list(LixiaoDepartureapplications lixiaoDepartureapplications)
    {
        startPage();
        List<LixiaoDepartureapplications> list = lixiaoDepartureapplicationsService.selectLixiaoDepartureapplicationsList(lixiaoDepartureapplications);
        return getDataTable(list);
    }

    /**
     * 导出离校申请列表
     */
    @PreAuthorize("@ss.hasPermi('air:departureapplicationspa:export')")
    @Log(title = "离校申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LixiaoDepartureapplications lixiaoDepartureapplications)
    {
        List<LixiaoDepartureapplications> list = lixiaoDepartureapplicationsService.selectLixiaoDepartureapplicationsList(lixiaoDepartureapplications);
        ExcelUtil<LixiaoDepartureapplications> util = new ExcelUtil<LixiaoDepartureapplications>(LixiaoDepartureapplications.class);
        util.exportExcel(response, list, "离校申请数据");
    }

    /**
     * 获取离校申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:departureapplicationspa:query')")
    @GetMapping(value = "/{applicationID}")
    public AjaxResult getInfo(@PathVariable("applicationID") Long applicationID)
    {
        return success(lixiaoDepartureapplicationsService.selectLixiaoDepartureapplicationsByApplicationID(applicationID));
    }

    /**
     * 新增离校申请
     */
    @PreAuthorize("@ss.hasPermi('air:departureapplicationspa:add')")
    @Log(title = "离校申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LixiaoDepartureapplications lixiaoDepartureapplications)
    {
        return toAjax(lixiaoDepartureapplicationsService.insertLixiaoDepartureapplications(lixiaoDepartureapplications));
    }

    /**
     * 修改离校申请
     */
    @PreAuthorize("@ss.hasPermi('air:departureapplicationspa:edit')")
    @Log(title = "离校申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LixiaoDepartureapplications lixiaoDepartureapplications)
    {
        return toAjax(lixiaoDepartureapplicationsService.updateLixiaoDepartureapplications(lixiaoDepartureapplications));
    }

    /**
     * 删除离校申请
     */
    @PreAuthorize("@ss.hasPermi('air:departureapplicationspa:remove')")
    @Log(title = "离校申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applicationIDs}")
    public AjaxResult remove(@PathVariable Long[] applicationIDs)
    {
        return toAjax(lixiaoDepartureapplicationsService.deleteLixiaoDepartureapplicationsByApplicationIDs(applicationIDs));
    }
}
