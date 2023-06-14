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
import com.grade.air.domain.GzStudentdiscipline;
import com.grade.air.service.IGzStudentdisciplineService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学员通报Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/studentdisciplineef")
public class GzStudentdisciplineController extends BaseController
{
    @Autowired
    private IGzStudentdisciplineService gzStudentdisciplineService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询学员通报列表
     */
    @PreAuthorize("@ss.hasPermi('air:studentdisciplineef:list')")
    @GetMapping("/list")
    public TableDataInfo list(GzStudentdiscipline gzStudentdiscipline)
    {
        startPage();
        List<GzStudentdiscipline> list = gzStudentdisciplineService.selectGzStudentdisciplineList(gzStudentdiscipline);
        return getDataTable(list);
    }

    /**
     * 导出学员通报列表
     */
    @PreAuthorize("@ss.hasPermi('air:studentdisciplineef:export')")
    @Log(title = "学员通报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GzStudentdiscipline gzStudentdiscipline)
    {
        List<GzStudentdiscipline> list = gzStudentdisciplineService.selectGzStudentdisciplineList(gzStudentdiscipline);
        ExcelUtil<GzStudentdiscipline> util = new ExcelUtil<GzStudentdiscipline>(GzStudentdiscipline.class);
        util.exportExcel(response, list, "学员通报数据");
    }

    /**
     * 获取学员通报详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:studentdisciplineef:query')")
    @GetMapping(value = "/{recordID}")
    public AjaxResult getInfo(@PathVariable("recordID") Long recordID)
    {
        return success(gzStudentdisciplineService.selectGzStudentdisciplineByRecordID(recordID));
    }

    /**
     * 新增学员通报
     */
    @PreAuthorize("@ss.hasPermi('air:studentdisciplineef:add')")
    @Log(title = "学员通报", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GzStudentdiscipline gzStudentdiscipline)
    {
        SysUser sysUser = userService.selectUserByNickName(String.valueOf(gzStudentdiscipline.getUserId()));
        gzStudentdiscipline.setUserId(sysUser.getUserId());
        return toAjax(gzStudentdisciplineService.insertGzStudentdiscipline(gzStudentdiscipline));
    }

    /**
     * 修改学员通报
     */
    @PreAuthorize("@ss.hasPermi('air:studentdisciplineef:edit')")
    @Log(title = "学员通报", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GzStudentdiscipline gzStudentdiscipline)
    {
        return toAjax(gzStudentdisciplineService.updateGzStudentdiscipline(gzStudentdiscipline));
    }

    /**
     * 删除学员通报
     */
    @PreAuthorize("@ss.hasPermi('air:studentdisciplineef:remove')")
    @Log(title = "学员通报", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIDs}")
    public AjaxResult remove(@PathVariable Long[] recordIDs)
    {
        return toAjax(gzStudentdisciplineService.deleteGzStudentdisciplineByRecordIDs(recordIDs));
    }
}
