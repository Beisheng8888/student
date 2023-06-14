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
import com.grade.air.domain.LqAcademicrecords;
import com.grade.air.service.ILqAcademicrecordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学习情况Controller
 *
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/academicrecordsac")
public class LqAcademicrecordsController extends BaseController {
    @Autowired
    private ILqAcademicrecordsService lqAcademicrecordsService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询学习情况列表
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsac:list')")
    @GetMapping("/list")
    public TableDataInfo list(LqAcademicrecords lqAcademicrecords) {
        startPage();
        List<LqAcademicrecords> list = lqAcademicrecordsService.selectLqAcademicrecordsList(lqAcademicrecords);
        return getDataTable(list);
    }

    /**
     * 导出学习情况列表
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsac:export')")
    @Log(title = "学习情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LqAcademicrecords lqAcademicrecords) {
        List<LqAcademicrecords> list = lqAcademicrecordsService.selectLqAcademicrecordsList(lqAcademicrecords);
        ExcelUtil<LqAcademicrecords> util = new ExcelUtil<LqAcademicrecords>(LqAcademicrecords.class);
        util.exportExcel(response, list, "学习情况数据");
    }

    /**
     * 获取学习情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsac:query')")
    @GetMapping(value = "/{studentID}")
    public AjaxResult getInfo(@PathVariable("studentID") Long studentID) {
        return success(lqAcademicrecordsService.selectLqAcademicrecordsByStudentID(studentID));
    }

    /**
     * 新增学习情况
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsac:add')")
    @Log(title = "学习情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LqAcademicrecords lqAcademicrecords) {
        SysUser sysUser = userService.selectUserByNickName(lqAcademicrecords.getStudentName());
        lqAcademicrecords.setUserId(sysUser.getUserId());
        return toAjax(lqAcademicrecordsService.insertLqAcademicrecords(lqAcademicrecords));
    }

    /**
     * 修改学习情况
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsac:edit')")
    @Log(title = "学习情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LqAcademicrecords lqAcademicrecords) {
        return toAjax(lqAcademicrecordsService.updateLqAcademicrecords(lqAcademicrecords));
    }

    /**
     * 删除学习情况
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsac:remove')")
    @Log(title = "学习情况", businessType = BusinessType.DELETE)
    @DeleteMapping("/{studentIDs}")
    public AjaxResult remove(@PathVariable Long[] studentIDs) {
        return toAjax(lqAcademicrecordsService.deleteLqAcademicrecordsByStudentIDs(studentIDs));
    }
}
