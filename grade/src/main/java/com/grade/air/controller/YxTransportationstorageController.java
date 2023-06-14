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
import com.grade.air.domain.YxTransportationstorage;
import com.grade.air.service.IYxTransportationstorageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 接送与寄存Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/transportationstoragebg")
public class YxTransportationstorageController extends BaseController
{
    @Autowired
    private IYxTransportationstorageService yxTransportationstorageService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询接送与寄存列表
     */
    @PreAuthorize("@ss.hasPermi('air:transportationstoragebg:list')")
    @GetMapping("/list")
    public TableDataInfo list(YxTransportationstorage yxTransportationstorage)
    {
        startPage();
        List<YxTransportationstorage> list = yxTransportationstorageService.selectYxTransportationstorageList(yxTransportationstorage);
        return getDataTable(list);
    }

    /**
     * 导出接送与寄存列表
     */
    @PreAuthorize("@ss.hasPermi('air:transportationstoragebg:export')")
    @Log(title = "接送与寄存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YxTransportationstorage yxTransportationstorage)
    {
        List<YxTransportationstorage> list = yxTransportationstorageService.selectYxTransportationstorageList(yxTransportationstorage);
        ExcelUtil<YxTransportationstorage> util = new ExcelUtil<YxTransportationstorage>(YxTransportationstorage.class);
        util.exportExcel(response, list, "接送与寄存数据");
    }

    /**
     * 获取接送与寄存详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:transportationstoragebg:query')")
    @GetMapping(value = "/{transportationStorageID}")
    public AjaxResult getInfo(@PathVariable("transportationStorageID") Long transportationStorageID)
    {
        return success(yxTransportationstorageService.selectYxTransportationstorageByTransportationStorageID(transportationStorageID));
    }

    /**
     * 新增接送与寄存
     */
    @PreAuthorize("@ss.hasPermi('air:transportationstoragebg:add')")
    @Log(title = "接送与寄存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YxTransportationstorage yxTransportationstorage)
    {
        SysUser sysUser = userService.selectUserByNickName(yxTransportationstorage.getStudentName());
        yxTransportationstorage.setUserId(sysUser.getUserId());
        return toAjax(yxTransportationstorageService.insertYxTransportationstorage(yxTransportationstorage));
    }

    /**
     * 修改接送与寄存
     */
    @PreAuthorize("@ss.hasPermi('air:transportationstoragebg:edit')")
    @Log(title = "接送与寄存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YxTransportationstorage yxTransportationstorage)
    {
        return toAjax(yxTransportationstorageService.updateYxTransportationstorage(yxTransportationstorage));
    }

    /**
     * 删除接送与寄存
     */
    @PreAuthorize("@ss.hasPermi('air:transportationstoragebg:remove')")
    @Log(title = "接送与寄存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{transportationStorageIDs}")
    public AjaxResult remove(@PathVariable Long[] transportationStorageIDs)
    {
        return toAjax(yxTransportationstorageService.deleteYxTransportationstorageByTransportationStorageIDs(transportationStorageIDs));
    }
}
