package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.grade.air.domain.SsNetworkFaultRepairApplicationDemo;
import com.grade.air.service.ISsNetworkFaultRepairApplicationDemoService;
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
import com.grade.air.domain.SsNetworkFaultRepairApplication;
import com.grade.air.service.ISsNetworkFaultRepairApplicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网络故障保修Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/applicationgh")
public class SsNetworkFaultRepairApplicationController extends BaseController
{
    @Autowired
    private ISsNetworkFaultRepairApplicationService ssNetworkFaultRepairApplicationService;

    @Autowired
    private ISsNetworkFaultRepairApplicationDemoService ssNetworkFaultRepairApplicationDemoService;

    /**
     * 查询网络故障保修列表
     */
    @PreAuthorize("@ss.hasPermi('air:applicationgh:list')")
    @GetMapping("/list")
    public TableDataInfo list(SsNetworkFaultRepairApplication ssNetworkFaultRepairApplication)
    {
        startPage();
        List<SsNetworkFaultRepairApplication> list = ssNetworkFaultRepairApplicationService.selectSsNetworkFaultRepairApplicationList(ssNetworkFaultRepairApplication);
        return getDataTable(list);
    }

    /**
     * 导出网络故障保修列表
     */
    @PreAuthorize("@ss.hasPermi('air:applicationgh:export')")
    @Log(title = "网络故障保修", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SsNetworkFaultRepairApplication ssNetworkFaultRepairApplication)
    {
        List<SsNetworkFaultRepairApplication> list = ssNetworkFaultRepairApplicationService.selectSsNetworkFaultRepairApplicationList(ssNetworkFaultRepairApplication);
        ExcelUtil<SsNetworkFaultRepairApplication> util = new ExcelUtil<SsNetworkFaultRepairApplication>(SsNetworkFaultRepairApplication.class);
        util.exportExcel(response, list, "网络故障保修数据");
    }

    /**
     * 获取网络故障保修详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:applicationgh:query')")
    @GetMapping(value = "/{applicationId}")
    public AjaxResult getInfo(@PathVariable("applicationId") Long applicationId)
    {
        return success(ssNetworkFaultRepairApplicationService.selectSsNetworkFaultRepairApplicationByApplicationId(applicationId));
    }

    /**
     * 新增网络故障保修
     */
    @PreAuthorize("@ss.hasPermi('air:applicationgh:add')")
    @Log(title = "网络故障保修", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SsNetworkFaultRepairApplication ssNetworkFaultRepairApplication)
    {
        SsNetworkFaultRepairApplicationDemo sn=new SsNetworkFaultRepairApplicationDemo();
        sn.setDormitoryName(ssNetworkFaultRepairApplication.getDormitoryName());
        sn.setReportDate(ssNetworkFaultRepairApplication.getReportDate());
        sn.setReportDescription(ssNetworkFaultRepairApplication.getReportDescription());
        ssNetworkFaultRepairApplicationDemoService.insertSsNetworkFaultRepairApplicationDemo(sn);
        return toAjax(ssNetworkFaultRepairApplicationService.insertSsNetworkFaultRepairApplication(ssNetworkFaultRepairApplication));
    }

    /**
     * 修改网络故障保修
     */
    @PreAuthorize("@ss.hasPermi('air:applicationgh:edit')")
    @Log(title = "网络故障保修", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SsNetworkFaultRepairApplication ssNetworkFaultRepairApplication)
    {
        return toAjax(ssNetworkFaultRepairApplicationService.updateSsNetworkFaultRepairApplication(ssNetworkFaultRepairApplication));
    }

    /**
     * 删除网络故障保修
     */
    @PreAuthorize("@ss.hasPermi('air:applicationgh:remove')")
    @Log(title = "网络故障保修", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applicationIds}")
    public AjaxResult remove(@PathVariable Long[] applicationIds)
    {
        return toAjax(ssNetworkFaultRepairApplicationService.deleteSsNetworkFaultRepairApplicationByApplicationIds(applicationIds));
    }
}
