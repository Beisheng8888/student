package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.grade.air.domain.GzScholarshipapplicationsIohjk;
import com.grade.air.service.IGzScholarshipapplicationsIohjkService;
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
import com.grade.air.domain.GzScholarshipapplications;
import com.grade.air.service.IGzScholarshipapplicationsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资助申请Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/scholarshipapplicationsec")
public class GzScholarshipapplicationsController extends BaseController
{
    @Autowired
    private IGzScholarshipapplicationsService gzScholarshipapplicationsService;

    @Autowired
    private IGzScholarshipapplicationsIohjkService gzScholarshipapplicationsIohjkService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询资助申请列表
     */
    @PreAuthorize("@ss.hasPermi('air:scholarshipapplicationsec:list')")
    @GetMapping("/list")
    public TableDataInfo list(GzScholarshipapplications gzScholarshipapplications)
    {
        startPage();
        List<GzScholarshipapplications> list = gzScholarshipapplicationsService.selectGzScholarshipapplicationsList(gzScholarshipapplications);
        return getDataTable(list);
    }

    /**
     * 导出资助申请列表
     */
    @PreAuthorize("@ss.hasPermi('air:scholarshipapplicationsec:export')")
    @Log(title = "资助申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GzScholarshipapplications gzScholarshipapplications)
    {
            List<GzScholarshipapplications> list = gzScholarshipapplicationsService.selectGzScholarshipapplicationsList(gzScholarshipapplications);
        ExcelUtil<GzScholarshipapplications> util = new ExcelUtil<GzScholarshipapplications>(GzScholarshipapplications.class);
        util.exportExcel(response, list, "资助申请数据");
    }

    /**
     * 获取资助申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:scholarshipapplicationsec:query')")
    @GetMapping(value = "/{applicationID}")
    public AjaxResult getInfo(@PathVariable("applicationID") Long applicationID)
    {
        return success(gzScholarshipapplicationsService.selectGzScholarshipapplicationsByApplicationID(applicationID));
    }

    /**
     * 新增资助申请
     */
    @PreAuthorize("@ss.hasPermi('air:scholarshipapplicationsec:add')")
    @Log(title = "资助申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GzScholarshipapplications gzScholarshipapplications)
    {
        SysUser sysUser = userService.selectUserByNickName(String.valueOf(gzScholarshipapplications.getUserId()));
        gzScholarshipapplications.setUserId(Long.valueOf(sysUser.getUserId()));
        GzScholarshipapplicationsIohjk jk=new GzScholarshipapplicationsIohjk();
        jk.setStudentName(gzScholarshipapplications.getStudentName());
        jk.setApplicationDate(gzScholarshipapplications.getApplicationDate());
        jk.setAmount(gzScholarshipapplications.getAmount());
        gzScholarshipapplicationsIohjkService.insertGzScholarshipapplicationsIohjk(jk);
        return toAjax(gzScholarshipapplicationsService.insertGzScholarshipapplications(gzScholarshipapplications));
    }

    /**
     * 修改资助申请
     */
    @PreAuthorize("@ss.hasPermi('air:scholarshipapplicationsec:edit')")
    @Log(title = "资助申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GzScholarshipapplications gzScholarshipapplications)
    {
        return toAjax(gzScholarshipapplicationsService.updateGzScholarshipapplications(gzScholarshipapplications));
    }

    /**
     * 删除资助申请
     */
    @PreAuthorize("@ss.hasPermi('air:scholarshipapplicationsec:remove')")
    @Log(title = "资助申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applicationIDs}")
    public AjaxResult remove(@PathVariable Long[] applicationIDs)
    {
        return toAjax(gzScholarshipapplicationsService.deleteGzScholarshipapplicationsByApplicationIDs(applicationIDs));
    }
}
