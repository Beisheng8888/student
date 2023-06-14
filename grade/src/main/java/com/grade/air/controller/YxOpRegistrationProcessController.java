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
import com.grade.air.domain.YxOpRegistrationProcess;
import com.grade.air.service.IYxOpRegistrationProcessService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报到行政流程反馈Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/processbc")
public class YxOpRegistrationProcessController extends BaseController
{
    @Autowired
    private IYxOpRegistrationProcessService yxOpRegistrationProcessService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询报到行政流程反馈列表
     */
    @PreAuthorize("@ss.hasPermi('air:processbc:list')")
    @GetMapping("/list")
    public TableDataInfo list(YxOpRegistrationProcess yxOpRegistrationProcess)
    {
        startPage();
        List<YxOpRegistrationProcess> list = yxOpRegistrationProcessService.selectYxOpRegistrationProcessList(yxOpRegistrationProcess);
        return getDataTable(list);
    }

    /**
     * 导出报到行政流程反馈列表
     */
    @PreAuthorize("@ss.hasPermi('air:processbc:export')")
    @Log(title = "报到行政流程反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YxOpRegistrationProcess yxOpRegistrationProcess)
    {
        List<YxOpRegistrationProcess> list = yxOpRegistrationProcessService.selectYxOpRegistrationProcessList(yxOpRegistrationProcess);
        ExcelUtil<YxOpRegistrationProcess> util = new ExcelUtil<YxOpRegistrationProcess>(YxOpRegistrationProcess.class);
        util.exportExcel(response, list, "报到行政流程反馈数据");
    }

    /**
     * 获取报到行政流程反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:processbc:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(yxOpRegistrationProcessService.selectYxOpRegistrationProcessByRecordId(recordId));
    }

    /**
     * 新增报到行政流程反馈
     */
    @PreAuthorize("@ss.hasPermi('air:processbc:add')")
    @Log(title = "报到行政流程反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YxOpRegistrationProcess yxOpRegistrationProcess)
    {
        SysUser sysUser = userService.selectUserByNickName(yxOpRegistrationProcess.getName());
        yxOpRegistrationProcess.setUserId(sysUser.getUserId());
        return toAjax(yxOpRegistrationProcessService.insertYxOpRegistrationProcess(yxOpRegistrationProcess));
    }

    /**
     * 修改报到行政流程反馈
     */
    @PreAuthorize("@ss.hasPermi('air:processbc:edit')")
    @Log(title = "报到行政流程反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YxOpRegistrationProcess yxOpRegistrationProcess)
    {
        return toAjax(yxOpRegistrationProcessService.updateYxOpRegistrationProcess(yxOpRegistrationProcess));
    }

    /**
     * 删除报到行政流程反馈
     */
    @PreAuthorize("@ss.hasPermi('air:processbc:remove')")
    @Log(title = "报到行政流程反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(yxOpRegistrationProcessService.deleteYxOpRegistrationProcessByRecordIds(recordIds));
    }
}
