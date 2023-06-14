package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.grade.air.domain.SsCampusStayApplicationType;
import com.grade.air.service.ISsCampusStayApplicationTypeService;
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
import com.grade.air.domain.SsCampusStayApplication;
import com.grade.air.service.ISsCampusStayApplicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 假期留校申请Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/applicationga")
public class SsCampusStayApplicationController extends BaseController
{
    @Autowired
    private ISsCampusStayApplicationService ssCampusStayApplicationService;

    @Autowired
    private ISsCampusStayApplicationTypeService ssCampusStayApplicationTypeService;


    /**
     * 查询假期留校申请列表
     */
    @PreAuthorize("@ss.hasPermi('air:applicationga:list')")
    @GetMapping("/list")
    public TableDataInfo list(SsCampusStayApplication ssCampusStayApplication)
    {
        startPage();
        List<SsCampusStayApplication> list = ssCampusStayApplicationService.selectSsCampusStayApplicationList(ssCampusStayApplication);
        return getDataTable(list);
    }

    /**
     * 导出假期留校申请列表
     */
    @PreAuthorize("@ss.hasPermi('air:applicationga:export')")
    @Log(title = "假期留校申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SsCampusStayApplication ssCampusStayApplication)
    {
        List<SsCampusStayApplication> list = ssCampusStayApplicationService.selectSsCampusStayApplicationList(ssCampusStayApplication);
        ExcelUtil<SsCampusStayApplication> util = new ExcelUtil<SsCampusStayApplication>(SsCampusStayApplication.class);
        util.exportExcel(response, list, "假期留校申请数据");
    }

    /**
     * 获取假期留校申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:applicationga:query')")
    @GetMapping(value = "/{applicationId}")
    public AjaxResult getInfo(@PathVariable("applicationId") Long applicationId)
    {
        return success(ssCampusStayApplicationService.selectSsCampusStayApplicationByApplicationId(applicationId));
    }

    /**
     * 新增假期留校申请
     */
    @PreAuthorize("@ss.hasPermi('air:applicationga:add')")
    @Log(title = "假期留校申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SsCampusStayApplication ssCampusStayApplication)
    {
        SsCampusStayApplicationType ac=new SsCampusStayApplicationType();
        ac.setStudentId(ssCampusStayApplication.getStudentId());
        ac.setStartDate(ssCampusStayApplication.getStartDate());
        ac.setEndDate(ssCampusStayApplication.getEndDate());
        ac.setReason(ssCampusStayApplication.getReason());
        ssCampusStayApplicationTypeService.insertSsCampusStayApplicationType(ac);
        return toAjax(ssCampusStayApplicationService.insertSsCampusStayApplication(ssCampusStayApplication));
    }

    /**
     * 修改假期留校申请
     */
    @PreAuthorize("@ss.hasPermi('air:applicationga:edit')")
    @Log(title = "假期留校申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SsCampusStayApplication ssCampusStayApplication)
    {
        return toAjax(ssCampusStayApplicationService.updateSsCampusStayApplication(ssCampusStayApplication));
    }

    /**
     * 删除假期留校申请
     */
    @PreAuthorize("@ss.hasPermi('air:applicationga:remove')")
    @Log(title = "假期留校申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applicationIds}")
    public AjaxResult remove(@PathVariable Long[] applicationIds)
    {
        return toAjax(ssCampusStayApplicationService.deleteSsCampusStayApplicationByApplicationIds(applicationIds));
    }
}
