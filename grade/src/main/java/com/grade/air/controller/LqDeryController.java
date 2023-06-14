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
import com.grade.air.domain.LqDery;
import com.grade.air.service.ILqDeryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学籍调动结果Controller
 *
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/deryab")
public class LqDeryController extends BaseController {
    @Autowired
    private ILqDeryService lqDeryService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询学籍调动结果列表
     */
    @PreAuthorize("@ss.hasPermi('air:deryab:list')")
    @GetMapping("/list")
    public TableDataInfo list(LqDery lqDery) {
        startPage();
        List<LqDery> list = lqDeryService.selectLqDeryList(lqDery);
        return getDataTable(list);
    }

    /**
     * 导出学籍调动结果列表
     */
    @PreAuthorize("@ss.hasPermi('air:deryab:export')")
    @Log(title = "学籍调动结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LqDery lqDery) {
        List<LqDery> list = lqDeryService.selectLqDeryList(lqDery);
        ExcelUtil<LqDery> util = new ExcelUtil<LqDery>(LqDery.class);
        util.exportExcel(response, list, "学籍调动结果数据");
    }

    /**
     * 获取学籍调动结果详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:deryab:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(lqDeryService.selectLqDeryById(id));
    }

    /**
     * 新增学籍调动结果
     */
    @PreAuthorize("@ss.hasPermi('air:deryab:add')")
    @Log(title = "学籍调动结果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LqDery lqDery) {
        SysUser sysUser = userService.selectUserByNickName(String.valueOf(lqDery.getUserId()));
        lqDery.setUserId(sysUser.getUserId());
        return toAjax(lqDeryService.insertLqDery(lqDery));
    }

    /**
     * 修改学籍调动结果
     */
    @PreAuthorize("@ss.hasPermi('air:deryab:edit')")
    @Log(title = "学籍调动结果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LqDery lqDery) {
        return toAjax(lqDeryService.updateLqDery(lqDery));
    }

    /**
     * 删除学籍调动结果
     */
    @PreAuthorize("@ss.hasPermi('air:deryab:remove')")
    @Log(title = "学籍调动结果", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(lqDeryService.deleteLqDeryByIds(ids));
    }
}
