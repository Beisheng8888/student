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
import com.grade.air.domain.LqStudents;
import com.grade.air.service.ILqStudentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生信息Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/studentsaf")
public class LqStudentsController extends BaseController
{
    @Autowired
    private ILqStudentsService lqStudentsService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('air:studentsaf:list')")
    @GetMapping("/list")
    public TableDataInfo list(LqStudents lqStudents)
    {
        startPage();
        List<LqStudents> list = lqStudentsService.selectLqStudentsList(lqStudents);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('air:studentsaf:export')")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LqStudents lqStudents)
    {
        List<LqStudents> list = lqStudentsService.selectLqStudentsList(lqStudents);
        ExcelUtil<LqStudents> util = new ExcelUtil<LqStudents>(LqStudents.class);
        util.exportExcel(response, list, "学生信息数据");
    }

    /**
     * 获取学生信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:studentsaf:query')")
    @GetMapping(value = "/{studentID}")
    public AjaxResult getInfo(@PathVariable("studentID") Long studentID)
    {
        return success(lqStudentsService.selectLqStudentsByStudentID(studentID));
    }

    /**
     * 新增学生信息
     */
    @PreAuthorize("@ss.hasPermi('air:studentsaf:add')")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LqStudents lqStudents)
    {
        SysUser sysUser = userService.selectUserByNickName(lqStudents.getName());
        lqStudents.setUserId(sysUser.getUserId());
        return toAjax(lqStudentsService.insertLqStudents(lqStudents));
    }

    /**
     * 修改学生信息
     */
    @PreAuthorize("@ss.hasPermi('air:studentsaf:edit')")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LqStudents lqStudents)
    {
        return toAjax(lqStudentsService.updateLqStudents(lqStudents));
    }

    /**
     * 删除学生信息
     */
    @PreAuthorize("@ss.hasPermi('air:studentsaf:remove')")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIDs}")
    public AjaxResult remove(@PathVariable Long[] studentIDs)
    {
        return toAjax(lqStudentsService.deleteLqStudentsByStudentIDs(studentIDs));
    }
}
