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
import com.grade.air.domain.GzAcademicrecords;
import com.grade.air.service.IGzAcademicrecordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学籍成绩Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/academicrecordsea")
public class GzAcademicrecordsController extends BaseController
{
    @Autowired
    private IGzAcademicrecordsService gzAcademicrecordsService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询学籍成绩列表
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsea:list')")
    @GetMapping("/list")
    public TableDataInfo list(GzAcademicrecords gzAcademicrecords)
    {
        startPage();

        List<GzAcademicrecords> list = gzAcademicrecordsService.selectGzAcademicrecordsList(gzAcademicrecords);

        return getDataTable(list);
    }

    /**
     * 导出学籍成绩列表
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsea:export')")
    @Log(title = "学籍成绩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GzAcademicrecords gzAcademicrecords)
    {
        List<GzAcademicrecords> list = gzAcademicrecordsService.selectGzAcademicrecordsList(gzAcademicrecords);
        ExcelUtil<GzAcademicrecords> util = new ExcelUtil<GzAcademicrecords>(GzAcademicrecords.class);
        util.exportExcel(response, list, "学籍成绩数据");
    }

    /**
     * 获取学籍成绩详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsea:query')")
    @GetMapping(value = "/{recordID}")
    public AjaxResult getInfo(@PathVariable("recordID") Long recordID)
    {
        return success(gzAcademicrecordsService.selectGzAcademicrecordsByRecordID(recordID));
    }

    /**
     * 新增学籍成绩
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsea:add')")
    @Log(title = "学籍成绩", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GzAcademicrecords gzAcademicrecords)
    {
        SysUser sysUser = userService.selectUserByNickName(String.valueOf(gzAcademicrecords.getUserId()));
        gzAcademicrecords.setUserId(sysUser.getUserId());
        return toAjax(gzAcademicrecordsService.insertGzAcademicrecords(gzAcademicrecords));
    }

    /**
     * 修改学籍成绩
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsea:edit')")
    @Log(title = "学籍成绩", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GzAcademicrecords gzAcademicrecords)
    {
        return toAjax(gzAcademicrecordsService.updateGzAcademicrecords(gzAcademicrecords));
    }

    /**
     * 删除学籍成绩
     */
    @PreAuthorize("@ss.hasPermi('air:academicrecordsea:remove')")
    @Log(title = "学籍成绩", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIDs}")
    public AjaxResult remove(@PathVariable Long[] recordIDs)
    {
        return toAjax(gzAcademicrecordsService.deleteGzAcademicrecordsByRecordIDs(recordIDs));
    }

}
