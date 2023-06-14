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
import com.grade.air.domain.PerAttendance;
import com.grade.air.service.IPerAttendanceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程考勤Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/attendancefa")
public class PerAttendanceController extends BaseController
{
    @Autowired
    private IPerAttendanceService perAttendanceService;
    @Autowired
    private ISysUserService sysUserService;
    /**
     * 查询课程考勤列表
     */
    @PreAuthorize("@ss.hasPermi('air:attendancefa:list')")
    @GetMapping("/list")
    public TableDataInfo list(PerAttendance perAttendance)
    {
        startPage();
        List<PerAttendance> list = perAttendanceService.selectPerAttendanceList(perAttendance);
        return getDataTable(list);
    }

    /**
     * 导出课程考勤列表
     */
    @PreAuthorize("@ss.hasPermi('air:attendancefa:export')")
    @Log(title = "课程考勤", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PerAttendance perAttendance)
    {
        List<PerAttendance> list = perAttendanceService.selectPerAttendanceList(perAttendance);
        ExcelUtil<PerAttendance> util = new ExcelUtil<PerAttendance>(PerAttendance.class);
        util.exportExcel(response, list, "课程考勤数据");
    }

    /**
     * 获取课程考勤详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:attendancefa:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(perAttendanceService.selectPerAttendanceById(id));
    }

    /**
     * 新增课程考勤
     */
    @PreAuthorize("@ss.hasPermi('air:attendancefa:add')")
    @Log(title = "课程考勤", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PerAttendance perAttendance)
    {
        SysUser sysUser=sysUserService.selectUserByNickName(String.valueOf(perAttendance.getUserId()));
        perAttendance.setId(sysUser.getUserId());
        return toAjax(perAttendanceService.insertPerAttendance(perAttendance));
    }

    /**
     * 修改课程考勤
     */
    @PreAuthorize("@ss.hasPermi('air:attendancefa:edit')")
    @Log(title = "课程考勤", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PerAttendance perAttendance)
    {
        return toAjax(perAttendanceService.updatePerAttendance(perAttendance));
    }

    /**
     * 删除课程考勤
     */
    @PreAuthorize("@ss.hasPermi('air:attendancefa:remove')")
    @Log(title = "课程考勤", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(perAttendanceService.deletePerAttendanceByIds(ids));
    }
}
