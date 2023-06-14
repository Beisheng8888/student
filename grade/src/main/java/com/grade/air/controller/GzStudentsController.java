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
import com.grade.air.domain.GzStudents;
import com.grade.air.service.IGzStudentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生证办理Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/studentset")
public class GzStudentsController extends BaseController
{
    @Autowired
    private IGzStudentsService gzStudentsService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询学生证办理列表
     */
    @PreAuthorize("@ss.hasPermi('air:studentset:list')")
    @GetMapping("/list")
    public TableDataInfo list(GzStudents gzStudents)
    {
        startPage();

        List<GzStudents> list = gzStudentsService.selectGzStudentsList(gzStudents);
        return getDataTable(list);
    }

    /**
     * 导出学生证办理列表
     */
    @PreAuthorize("@ss.hasPermi('air:studentset:export')")
    @Log(title = "学生证办理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GzStudents gzStudents)
    {
        List<GzStudents> list = gzStudentsService.selectGzStudentsList(gzStudents);
        ExcelUtil<GzStudents> util = new ExcelUtil<GzStudents>(GzStudents.class);
        util.exportExcel(response, list, "学生证办理数据");
    }

    /**
     * 获取学生证办理详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:studentset:query')")
    @GetMapping(value = "/{studentID}")
    public AjaxResult getInfo(@PathVariable("studentID") Long studentID)
    {
        return success(gzStudentsService.selectGzStudentsByStudentID(studentID));
    }

    /**
     * 新增学生证办理
     */
    @PreAuthorize("@ss.hasPermi('air:studentset:add')")
    @Log(title = "学生证办理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GzStudents gzStudents)
    {
        SysUser sysUser = userService.selectUserByNickName(String.valueOf(gzStudents.getUserId()));
        gzStudents.setUserId(Long.valueOf(sysUser.getUserId()));
        return toAjax(gzStudentsService.insertGzStudents(gzStudents));
    }

    /**
     * 修改学生证办理
     */
    @PreAuthorize("@ss.hasPermi('air:studentset:edit')")
    @Log(title = "学生证办理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GzStudents gzStudents)
    {
        return toAjax(gzStudentsService.updateGzStudents(gzStudents));
    }

    /**
     * 删除学生证办理
     */
    @PreAuthorize("@ss.hasPermi('air:studentset:remove')")
    @Log(title = "学生证办理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIDs}")
    public AjaxResult remove(@PathVariable Long[] studentIDs)
    {
        return toAjax(gzStudentsService.deleteGzStudentsByStudentIDs(studentIDs));
    }
}
