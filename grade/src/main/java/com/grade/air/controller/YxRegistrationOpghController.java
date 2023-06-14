package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.grade.air.domain.YxRegistration;
import com.grade.air.service.IYxRegistrationService;
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
import com.grade.air.domain.YxRegistrationOpgh;
import com.grade.air.service.IYxRegistrationOpghService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预报到登记Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/opghbe")
public class YxRegistrationOpghController extends BaseController
{
    @Autowired
    private IYxRegistrationOpghService yxRegistrationOpghService;

    @Autowired
    private IYxRegistrationService yxRegistrationService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询预报到登记列表
     */
    @PreAuthorize("@ss.hasPermi('air:opghbe:list')")
    @GetMapping("/list")
    public TableDataInfo list(YxRegistrationOpgh yxRegistrationOpgh)
    {
        startPage();
        List<YxRegistrationOpgh> list = yxRegistrationOpghService.selectYxRegistrationOpghList(yxRegistrationOpgh);
        return getDataTable(list);
    }

    /**
     * 导出预报到登记列表
     */
    @PreAuthorize("@ss.hasPermi('air:opghbe:export')")
    @Log(title = "预报到登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YxRegistrationOpgh yxRegistrationOpgh)
    {
        List<YxRegistrationOpgh> list = yxRegistrationOpghService.selectYxRegistrationOpghList(yxRegistrationOpgh);
        ExcelUtil<YxRegistrationOpgh> util = new ExcelUtil<YxRegistrationOpgh>(YxRegistrationOpgh.class);
        util.exportExcel(response, list, "预报到登记数据");
    }

    /**
     * 获取预报到登记详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:opghbe:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(yxRegistrationOpghService.selectYxRegistrationOpghById(id));
    }

    /**
     * 新增预报到登记
     */
    @PreAuthorize("@ss.hasPermi('air:opghbe:add')")
    @Log(title = "预报到登记", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YxRegistrationOpgh yxRegistrationOpgh)
    {
        SysUser sysUser = userService.selectUserByNickName(yxRegistrationOpgh.getStudentName());
        yxRegistrationOpgh.setUserId(sysUser.getUserId());
        YxRegistration yr=new YxRegistration();
        yr.setStudentName(yxRegistrationOpgh.getStudentName());
        yr.setTrainNumber(yxRegistrationOpgh.getTrainNumber());
        yr.setFlightNumber(yxRegistrationOpgh.getFlightNumber());
        yr.setArrivalTime(yxRegistrationOpgh.getArrivalTime());
        yr.setPickupLocation(yxRegistrationOpgh.getPickupLocation());
        yxRegistrationService.insertYxRegistration(yr);
        return toAjax(yxRegistrationOpghService.insertYxRegistrationOpgh(yxRegistrationOpgh));
    }

    /**
     * 修改预报到登记
     */
    @PreAuthorize("@ss.hasPermi('air:opghbe:edit')")
    @Log(title = "预报到登记", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YxRegistrationOpgh yxRegistrationOpgh)
    {
        return toAjax(yxRegistrationOpghService.updateYxRegistrationOpgh(yxRegistrationOpgh));
    }

    /**
     * 删除预报到登记
     */
    @PreAuthorize("@ss.hasPermi('air:opghbe:remove')")
    @Log(title = "预报到登记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(yxRegistrationOpghService.deleteYxRegistrationOpghByIds(ids));
    }
}
