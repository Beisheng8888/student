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
import com.grade.air.domain.LqGerendangan;
import com.grade.air.service.ILqGerendanganService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生档案维护Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/gerendanganat")
public class LqGerendanganController extends BaseController
{
    @Autowired
    private ILqGerendanganService lqGerendanganService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询学生档案维护列表
     */
    @PreAuthorize("@ss.hasPermi('air:gerendanganat:list')")
    @GetMapping("/list")
    public TableDataInfo list(LqGerendangan lqGerendangan)
    {
        startPage();
        List<LqGerendangan> list = lqGerendanganService.selectLqGerendanganList(lqGerendangan);
        return getDataTable(list);
    }

    /**
     * 导出学生档案维护列表
     */
    @PreAuthorize("@ss.hasPermi('air:gerendanganat:export')")
    @Log(title = "学生档案维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LqGerendangan lqGerendangan)
    {
        List<LqGerendangan> list = lqGerendanganService.selectLqGerendanganList(lqGerendangan);
        ExcelUtil<LqGerendangan> util = new ExcelUtil<LqGerendangan>(LqGerendangan.class);
        util.exportExcel(response, list, "学生档案维护数据");
    }

    /**
     * 获取学生档案维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:gerendanganat:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lqGerendanganService.selectLqGerendanganById(id));
    }

    /**
     * 新增学生档案维护
     */
    @PreAuthorize("@ss.hasPermi('air:gerendanganat:add')")
    @Log(title = "学生档案维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LqGerendangan lqGerendangan)
    {
        SysUser sysUser = userService.selectUserByNickName(String.valueOf(lqGerendangan.getUserId()));
        lqGerendangan.setUserId(sysUser.getUserId());
        return toAjax(lqGerendanganService.insertLqGerendangan(lqGerendangan));
    }

    /**
     * 修改学生档案维护
     */
    @PreAuthorize("@ss.hasPermi('air:gerendanganat:edit')")
    @Log(title = "学生档案维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LqGerendangan lqGerendangan)
    {
        return toAjax(lqGerendanganService.updateLqGerendangan(lqGerendangan));
    }

    /**
     * 删除学生档案维护
     */
    @PreAuthorize("@ss.hasPermi('air:gerendanganat:remove')")
    @Log(title = "学生档案维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lqGerendanganService.deleteLqGerendanganByIds(ids));
    }
}
