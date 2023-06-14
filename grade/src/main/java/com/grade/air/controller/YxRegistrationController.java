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
import com.grade.air.domain.YxRegistration;
import com.grade.air.service.IYxRegistrationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预报到登记反馈Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/registrationbd")
public class YxRegistrationController extends BaseController
{
    @Autowired
    private IYxRegistrationService yxRegistrationService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询预报到登记反馈列表
     */
    @PreAuthorize("@ss.hasPermi('air:registrationbd:list')")
    @GetMapping("/list")
    public TableDataInfo list(YxRegistration yxRegistration)
    {
        startPage();
        List<YxRegistration> list = yxRegistrationService.selectYxRegistrationList(yxRegistration);
        return getDataTable(list);
    }

    /**
     * 导出预报到登记反馈列表
     */
    @PreAuthorize("@ss.hasPermi('air:registrationbd:export')")
    @Log(title = "预报到登记反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YxRegistration yxRegistration)
    {
        List<YxRegistration> list = yxRegistrationService.selectYxRegistrationList(yxRegistration);
        ExcelUtil<YxRegistration> util = new ExcelUtil<YxRegistration>(YxRegistration.class);
        util.exportExcel(response, list, "预报到登记反馈数据");
    }

    /**
     * 获取预报到登记反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:registrationbd:query')")
    @GetMapping(value = "/{registrationID}")
    public AjaxResult getInfo(@PathVariable("registrationID") Long registrationID)
    {

        return success(yxRegistrationService.selectYxRegistrationByRegistrationID(registrationID));
    }

    /**
     * 新增预报到登记反馈
     */
    @PreAuthorize("@ss.hasPermi('air:registrationbd:add')")
    @Log(title = "预报到登记反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YxRegistration yxRegistration)
    {
        SysUser sysUser = userService.selectUserByNickName(yxRegistration.getStudentName());
        yxRegistration.setUserId(sysUser.getUserId());
        return toAjax(yxRegistrationService.insertYxRegistration(yxRegistration));
    }

    /**
     * 修改预报到登记反馈
     */
    @PreAuthorize("@ss.hasPermi('air:registrationbd:edit')")
    @Log(title = "预报到登记反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YxRegistration yxRegistration)
    {
        return toAjax(yxRegistrationService.updateYxRegistration(yxRegistration));
    }

    /**
     * 删除预报到登记反馈
     */
    @PreAuthorize("@ss.hasPermi('air:registrationbd:remove')")
    @Log(title = "预报到登记反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{registrationIDs}")
    public AjaxResult remove(@PathVariable Long[] registrationIDs)
    {
        return toAjax(yxRegistrationService.deleteYxRegistrationByRegistrationIDs(registrationIDs));
    }
}
