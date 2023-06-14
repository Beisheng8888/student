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
import com.grade.air.domain.PerAttendanceType;
import com.grade.air.service.IPerAttendanceTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程信息Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/typefs")
public class PerAttendanceTypeController extends BaseController
{
    @Autowired
    private IPerAttendanceTypeService perAttendanceTypeService;
    @Autowired
    private ISysUserService userService;
    /**
     * 查询课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('air:typefs:list')")
    @GetMapping("/list")
    public TableDataInfo list(PerAttendanceType perAttendanceType)
    {
        startPage();
        List<PerAttendanceType> list = perAttendanceTypeService.selectPerAttendanceTypeList(perAttendanceType);
        return getDataTable(list);
    }

    /**
     * 导出课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('air:typefs:export')")
    @Log(title = "课程信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PerAttendanceType perAttendanceType)
    {
        List<PerAttendanceType> list = perAttendanceTypeService.selectPerAttendanceTypeList(perAttendanceType);
        ExcelUtil<PerAttendanceType> util = new ExcelUtil<PerAttendanceType>(PerAttendanceType.class);
        util.exportExcel(response, list, "课程信息数据");
    }

    /**
     * 获取课程信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:typefs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(perAttendanceTypeService.selectPerAttendanceTypeById(id));
    }

    /**
     * 新增课程信息
     */
    @PreAuthorize("@ss.hasPermi('air:typefs:add')")
    @Log(title = "课程信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PerAttendanceType perAttendanceType)
    {
        SysUser sysUser=userService.selectUserByNickName(String.valueOf(perAttendanceType.getUserId()));
        perAttendanceType.setUserId(sysUser.getUserId());
        return toAjax(perAttendanceTypeService.insertPerAttendanceType(perAttendanceType));
    }

    /**
     * 修改课程信息
     */
    @PreAuthorize("@ss.hasPermi('air:typefs:edit')")
    @Log(title = "课程信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PerAttendanceType perAttendanceType)
    {
        return toAjax(perAttendanceTypeService.updatePerAttendanceType(perAttendanceType));
    }

    /**
     * 删除课程信息
     */
    @PreAuthorize("@ss.hasPermi('air:typefs:remove')")
    @Log(title = "课程信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(perAttendanceTypeService.deletePerAttendanceTypeByIds(ids));
    }
}
