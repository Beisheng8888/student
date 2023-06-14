package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.grade.air.domain.LqDery;
import com.grade.air.service.ILqDeryService;
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
import com.grade.air.domain.LqXueji;
import com.grade.air.service.ILqXuejiService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学籍调动Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/xuejiaa")
public class LqXuejiController extends BaseController
{
    @Autowired
    private ILqXuejiService lqXuejiService;

    @Autowired
    private ILqDeryService lqDeryService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询学籍调动列表
     */
    @PreAuthorize("@ss.hasPermi('air:xuejiaa:list')")
    @GetMapping("/list")
    public TableDataInfo list(LqXueji lqXueji)
    {
        startPage();
        List<LqXueji> list = lqXuejiService.selectLqXuejiList(lqXueji);
        return getDataTable(list);
    }

    /**
     * 导出学籍调动列表
     */
    @PreAuthorize("@ss.hasPermi('air:xuejiaa:export')")
    @Log(title = "学籍调动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LqXueji lqXueji)
    {
        List<LqXueji> list = lqXuejiService.selectLqXuejiList(lqXueji);
        ExcelUtil<LqXueji> util = new ExcelUtil<LqXueji>(LqXueji.class);
        util.exportExcel(response, list, "学籍调动数据");
    }

    /**
     * 获取学籍调动详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:xuejiaa:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lqXuejiService.selectLqXuejiById(id));
    }

    /**
     * 新增学籍调动
     */
    @PreAuthorize("@ss.hasPermi('air:xuejiaa:add')")
    @Log(title = "学籍调动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LqXueji lqXueji)
    {
        SysUser sysUser = userService.selectUserByNickName(lqXueji.getStudentName());
        lqXueji.setUserId(sysUser.getUserId());
        LqDery lq=new LqDery();
        lq.setGradeClass(lqXueji.getGradeClass());
        lq.setAdmissionDate(lqXueji.getAdmissionDate());
        lq.setAcademicSystem(lqXueji.getAcademicSystem());
        lq.setDepartment(lqXueji.getDepartment());
        lq.setMajor(lqXueji.getMajor());
        lq.setStudentName(lqXueji.getStudentName());
        lqDeryService.insertLqDery(lq);
        return toAjax(lqXuejiService.insertLqXueji(lqXueji));
    }

    /**
     * 修改学籍调动
     */
    @PreAuthorize("@ss.hasPermi('air:xuejiaa:edit')")
    @Log(title = "学籍调动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LqXueji lqXueji)
    {
        return toAjax(lqXuejiService.updateLqXueji(lqXueji));
    }

    /**
     * 删除学籍调动
     */
    @PreAuthorize("@ss.hasPermi('air:xuejiaa:remove')")
    @Log(title = "学籍调动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lqXuejiService.deleteLqXuejiByIds(ids));
    }
}
