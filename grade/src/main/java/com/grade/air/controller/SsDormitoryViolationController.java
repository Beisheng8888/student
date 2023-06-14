package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysUserService;
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
import com.grade.air.domain.SsDormitoryViolation;
import com.grade.air.service.ISsDormitoryViolationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍违纪Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/violationgy")
public class SsDormitoryViolationController extends BaseController
{
    @Autowired
    private ISsDormitoryViolationService ssDormitoryViolationService;
    @Autowired
    private ISysUserService userService;

    /**
     * 查询宿舍违纪列表
     */
    @PreAuthorize("@ss.hasPermi('air:violationgy:list')")
    @GetMapping("/list")
    public TableDataInfo list(SsDormitoryViolation ssDormitoryViolation)
    {
        startPage();
        List<SsDormitoryViolation> list = ssDormitoryViolationService.selectSsDormitoryViolationList(ssDormitoryViolation);
        return getDataTable(list);
    }

    /**
     * 导出宿舍违纪列表
     */
    @PreAuthorize("@ss.hasPermi('air:violationgy:export')")
    @Log(title = "宿舍违纪", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SsDormitoryViolation ssDormitoryViolation)
    {
        List<SsDormitoryViolation> list = ssDormitoryViolationService.selectSsDormitoryViolationList(ssDormitoryViolation);
        ExcelUtil<SsDormitoryViolation> util = new ExcelUtil<SsDormitoryViolation>(SsDormitoryViolation.class);
        util.exportExcel(response, list, "宿舍违纪数据");
    }

    /**
     * 获取宿舍违纪详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:violationgy:query')")
    @GetMapping(value = "/{violationId}")
    public AjaxResult getInfo(@PathVariable("violationId") Long violationId)
    {
        return success(ssDormitoryViolationService.selectSsDormitoryViolationByViolationId(violationId));
    }

    /**
     * 新增宿舍违纪
     */
    @PreAuthorize("@ss.hasPermi('air:violationgy:add')")
    @Log(title = "宿舍违纪", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SsDormitoryViolation ssDormitoryViolation)
    {
        SysUser sysUser = userService.selectUserByNickName(String.valueOf(ssDormitoryViolation.getUserId()));
        ssDormitoryViolation.setUserId(sysUser.getUserId());
        return toAjax(ssDormitoryViolationService.insertSsDormitoryViolation(ssDormitoryViolation));
    }

    /**
     * 修改宿舍违纪
     */
    @PreAuthorize("@ss.hasPermi('air:violationgy:edit')")
    @Log(title = "宿舍违纪", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SsDormitoryViolation ssDormitoryViolation)
    {
        return toAjax(ssDormitoryViolationService.updateSsDormitoryViolation(ssDormitoryViolation));
    }

    /**
     * 删除宿舍违纪
     */
    @PreAuthorize("@ss.hasPermi('air:violationgy:remove')")
    @Log(title = "宿舍违纪", businessType = BusinessType.DELETE)
	@DeleteMapping("/{violationIds}")
    public AjaxResult remove(@PathVariable Long[] violationIds)
    {
        return toAjax(ssDormitoryViolationService.deleteSsDormitoryViolationByViolationIds(violationIds));
    }
}
