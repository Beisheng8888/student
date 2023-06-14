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
import com.grade.air.domain.LqEnrollment;
import com.grade.air.service.ILqEnrollmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学籍情况Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/enrollmentae")
public class LqEnrollmentController extends BaseController
{
    @Autowired
    private ILqEnrollmentService lqEnrollmentService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询学籍情况列表
     */
    @PreAuthorize("@ss.hasPermi('air:enrollmentae:list')")
    @GetMapping("/list")
    public TableDataInfo list(LqEnrollment lqEnrollment)
    {
        startPage();
        List<LqEnrollment> list = lqEnrollmentService.selectLqEnrollmentList(lqEnrollment);
        return getDataTable(list);
    }

    /**
     * 导出学籍情况列表
     */
    @PreAuthorize("@ss.hasPermi('air:enrollmentae:export')")
    @Log(title = "学籍情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LqEnrollment lqEnrollment)
    {
        List<LqEnrollment> list = lqEnrollmentService.selectLqEnrollmentList(lqEnrollment);
        ExcelUtil<LqEnrollment> util = new ExcelUtil<LqEnrollment>(LqEnrollment.class);
        util.exportExcel(response, list, "学籍情况数据");
    }

    /**
     * 获取学籍情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:enrollmentae:query')")
    @GetMapping(value = "/{studentID}")
    public AjaxResult getInfo(@PathVariable("studentID") Long studentID)
    {
        return success(lqEnrollmentService.selectLqEnrollmentByStudentID(studentID));
    }

    /**
     * 新增学籍情况
     */
    @PreAuthorize("@ss.hasPermi('air:enrollmentae:add')")
    @Log(title = "学籍情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LqEnrollment lqEnrollment)
    {
        SysUser sysUser = userService.selectUserByNickName(lqEnrollment.getStudentName());
        lqEnrollment.setUserId(sysUser.getUserId());
        return toAjax(lqEnrollmentService.insertLqEnrollment(lqEnrollment));
    }

    /**
     * 修改学籍情况
     */
    @PreAuthorize("@ss.hasPermi('air:enrollmentae:edit')")
    @Log(title = "学籍情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LqEnrollment lqEnrollment)
    {
        return toAjax(lqEnrollmentService.updateLqEnrollment(lqEnrollment));
    }

    /**
     * 删除学籍情况
     */
    @PreAuthorize("@ss.hasPermi('air:enrollmentae:remove')")
    @Log(title = "学籍情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIDs}")
    public AjaxResult remove(@PathVariable Long[] studentIDs)
    {
        return toAjax(lqEnrollmentService.deleteLqEnrollmentByStudentIDs(studentIDs));
    }
}
