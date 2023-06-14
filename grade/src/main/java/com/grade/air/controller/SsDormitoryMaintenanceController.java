package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.grade.air.domain.SsDormitoryMaintenanceWoif;
import com.grade.air.service.ISsDormitoryMaintenanceWoifService;
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
import com.grade.air.domain.SsDormitoryMaintenance;
import com.grade.air.service.ISsDormitoryMaintenanceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍报修Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/maintenancegd")
public class SsDormitoryMaintenanceController extends BaseController
{
    @Autowired
    private ISsDormitoryMaintenanceService ssDormitoryMaintenanceService;

    @Autowired
    private ISsDormitoryMaintenanceWoifService ssDormitoryMaintenanceWoifService;

    /**
     * 查询宿舍报修列表
     */
    @PreAuthorize("@ss.hasPermi('air:maintenancegd:list')")
    @GetMapping("/list")
    public TableDataInfo list(SsDormitoryMaintenance ssDormitoryMaintenance)
    {
        startPage();
        List<SsDormitoryMaintenance> list = ssDormitoryMaintenanceService.selectSsDormitoryMaintenanceList(ssDormitoryMaintenance);
        return getDataTable(list);
    }

    /**
     * 导出宿舍报修列表
     */
    @PreAuthorize("@ss.hasPermi('air:maintenancegd:export')")
    @Log(title = "宿舍报修", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SsDormitoryMaintenance ssDormitoryMaintenance)
    {
        List<SsDormitoryMaintenance> list = ssDormitoryMaintenanceService.selectSsDormitoryMaintenanceList(ssDormitoryMaintenance);
        ExcelUtil<SsDormitoryMaintenance> util = new ExcelUtil<SsDormitoryMaintenance>(SsDormitoryMaintenance.class);
        util.exportExcel(response, list, "宿舍报修数据");
    }

    /**
     * 获取宿舍报修详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:maintenancegd:query')")
    @GetMapping(value = "/{maintenanceId}")
    public AjaxResult getInfo(@PathVariable("maintenanceId") Long maintenanceId)
    {
        return success(ssDormitoryMaintenanceService.selectSsDormitoryMaintenanceByMaintenanceId(maintenanceId));
    }

    /**
     * 新增宿舍报修
     */
    @PreAuthorize("@ss.hasPermi('air:maintenancegd:add')")
    @Log(title = "宿舍报修", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SsDormitoryMaintenance ssDormitoryMaintenance)
    {
        SsDormitoryMaintenanceWoif wo=new SsDormitoryMaintenanceWoif();
        wo.setDormitoryName(ssDormitoryMaintenance.getDormitoryName());
        wo.setReportDate(ssDormitoryMaintenance.getReportDate());
        wo.setReportDescription(ssDormitoryMaintenance.getReportDescription());
        ssDormitoryMaintenanceWoifService.insertSsDormitoryMaintenanceWoif(wo);
        return toAjax(ssDormitoryMaintenanceService.insertSsDormitoryMaintenance(ssDormitoryMaintenance));
    }

    /**
     * 修改宿舍报修
     */
    @PreAuthorize("@ss.hasPermi('air:maintenancegd:edit')")
    @Log(title = "宿舍报修", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SsDormitoryMaintenance ssDormitoryMaintenance)
    {
        return toAjax(ssDormitoryMaintenanceService.updateSsDormitoryMaintenance(ssDormitoryMaintenance));
    }

    /**
     * 删除宿舍报修
     */
    @PreAuthorize("@ss.hasPermi('air:maintenancegd:remove')")
    @Log(title = "宿舍报修", businessType = BusinessType.DELETE)
	@DeleteMapping("/{maintenanceIds}")
    public AjaxResult remove(@PathVariable Long[] maintenanceIds)
    {
        return toAjax(ssDormitoryMaintenanceService.deleteSsDormitoryMaintenanceByMaintenanceIds(maintenanceIds));
    }
}
