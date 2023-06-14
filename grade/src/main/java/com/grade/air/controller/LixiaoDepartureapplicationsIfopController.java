package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.grade.air.domain.LixiaoDepartureapplicationsIfop;
import com.grade.air.service.ILixiaoDepartureapplicationsIfopService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 离校审核结果Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/ifopps")
public class LixiaoDepartureapplicationsIfopController extends BaseController
{
    @Autowired
    private ILixiaoDepartureapplicationsIfopService lixiaoDepartureapplicationsIfopService;

    /**
     * 查询离校审核结果列表
     */
    @PreAuthorize("@ss.hasPermi('air:ifopps:list')")
    @GetMapping("/list")
    public TableDataInfo list(LixiaoDepartureapplicationsIfop lixiaoDepartureapplicationsIfop)
    {
        startPage();
        List<LixiaoDepartureapplicationsIfop> list = lixiaoDepartureapplicationsIfopService.selectLixiaoDepartureapplicationsIfopList(lixiaoDepartureapplicationsIfop);
        return getDataTable(list);
    }

    /**
     * 导出离校审核结果列表
     */
    @PreAuthorize("@ss.hasPermi('air:ifopps:export')")
    @Log(title = "离校审核结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LixiaoDepartureapplicationsIfop lixiaoDepartureapplicationsIfop)
    {
        List<LixiaoDepartureapplicationsIfop> list = lixiaoDepartureapplicationsIfopService.selectLixiaoDepartureapplicationsIfopList(lixiaoDepartureapplicationsIfop);
        ExcelUtil<LixiaoDepartureapplicationsIfop> util = new ExcelUtil<LixiaoDepartureapplicationsIfop>(LixiaoDepartureapplicationsIfop.class);
        util.exportExcel(response, list, "离校审核结果数据");
    }

    /**
     * 获取离校审核结果详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:ifopps:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lixiaoDepartureapplicationsIfopService.selectLixiaoDepartureapplicationsIfopById(id));
    }

    /**
     * 新增离校审核结果
     */
    @PreAuthorize("@ss.hasPermi('air:ifopps:add')")
    @Log(title = "离校审核结果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LixiaoDepartureapplicationsIfop lixiaoDepartureapplicationsIfop)
    {
        return toAjax(lixiaoDepartureapplicationsIfopService.insertLixiaoDepartureapplicationsIfop(lixiaoDepartureapplicationsIfop));
    }

    /**
     * 修改离校审核结果
     */
    @PreAuthorize("@ss.hasPermi('air:ifopps:edit')")
    @Log(title = "离校审核结果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LixiaoDepartureapplicationsIfop lixiaoDepartureapplicationsIfop)
    {
        return toAjax(lixiaoDepartureapplicationsIfopService.updateLixiaoDepartureapplicationsIfop(lixiaoDepartureapplicationsIfop));
    }

    /**
     * 删除离校审核结果
     */
    @PreAuthorize("@ss.hasPermi('air:ifopps:remove')")
    @Log(title = "离校审核结果", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lixiaoDepartureapplicationsIfopService.deleteLixiaoDepartureapplicationsIfopByIds(ids));
    }
}
