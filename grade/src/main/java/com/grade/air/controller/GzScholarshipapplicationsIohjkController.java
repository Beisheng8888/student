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
import com.grade.air.domain.GzScholarshipapplicationsIohjk;
import com.grade.air.service.IGzScholarshipapplicationsIohjkService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资助申请结果Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/iohjked")
public class GzScholarshipapplicationsIohjkController extends BaseController
{
    @Autowired
    private IGzScholarshipapplicationsIohjkService gzScholarshipapplicationsIohjkService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询资助申请结果列表
     */
    @PreAuthorize("@ss.hasPermi('air:iohjked:list')")
    @GetMapping("/list")
    public TableDataInfo list(GzScholarshipapplicationsIohjk gzScholarshipapplicationsIohjk)
    {
        startPage();
        List<GzScholarshipapplicationsIohjk> list = gzScholarshipapplicationsIohjkService.selectGzScholarshipapplicationsIohjkList(gzScholarshipapplicationsIohjk);
        return getDataTable(list);
    }

    /**
     * 导出资助申请结果列表
     */
    @PreAuthorize("@ss.hasPermi('air:iohjked:export')")
    @Log(title = "资助申请结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GzScholarshipapplicationsIohjk gzScholarshipapplicationsIohjk)
    {
        List<GzScholarshipapplicationsIohjk> list = gzScholarshipapplicationsIohjkService.selectGzScholarshipapplicationsIohjkList(gzScholarshipapplicationsIohjk);
        ExcelUtil<GzScholarshipapplicationsIohjk> util = new ExcelUtil<GzScholarshipapplicationsIohjk>(GzScholarshipapplicationsIohjk.class);
        util.exportExcel(response, list, "资助申请结果数据");
    }

    /**
     * 获取资助申请结果详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:iohjked:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(gzScholarshipapplicationsIohjkService.selectGzScholarshipapplicationsIohjkById(id));
    }

    /**
     * 新增资助申请结果
     */
    @PreAuthorize("@ss.hasPermi('air:iohjked:add')")
    @Log(title = "资助申请结果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GzScholarshipapplicationsIohjk gzScholarshipapplicationsIohjk)
    {
        SysUser sysUser = userService.selectUserByNickName(String.valueOf(gzScholarshipapplicationsIohjk.getUserId()));
        gzScholarshipapplicationsIohjk.setUserId(sysUser.getUserId());
        return toAjax(gzScholarshipapplicationsIohjkService.insertGzScholarshipapplicationsIohjk(gzScholarshipapplicationsIohjk));
    }

    /**
     * 修改资助申请结果
     */
    @PreAuthorize("@ss.hasPermi('air:iohjked:edit')")
    @Log(title = "资助申请结果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GzScholarshipapplicationsIohjk gzScholarshipapplicationsIohjk)
    {
        return toAjax(gzScholarshipapplicationsIohjkService.updateGzScholarshipapplicationsIohjk(gzScholarshipapplicationsIohjk));
    }

    /**
     * 删除资助申请结果
     */
    @PreAuthorize("@ss.hasPermi('air:iohjked:remove')")
    @Log(title = "资助申请结果", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(gzScholarshipapplicationsIohjkService.deleteGzScholarshipapplicationsIohjkByIds(ids));
    }
}
