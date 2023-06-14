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
import com.grade.air.domain.PerIntegration;
import com.grade.air.service.IPerIntegrationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 数据集成Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/integrationfg")
public class PerIntegrationController extends BaseController
{
    @Autowired
    private IPerIntegrationService perIntegrationService;

    /**
     * 查询数据集成列表
     */
    @PreAuthorize("@ss.hasPermi('air:integrationfg:list')")
    @GetMapping("/list")
    public TableDataInfo list(PerIntegration perIntegration)
    {
        startPage();
        List<PerIntegration> list = perIntegrationService.selectPerIntegrationList(perIntegration);
        return getDataTable(list);
    }

    /**
     * 导出数据集成列表
     */
    @PreAuthorize("@ss.hasPermi('air:integrationfg:export')")
    @Log(title = "数据集成", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PerIntegration perIntegration)
    {
        List<PerIntegration> list = perIntegrationService.selectPerIntegrationList(perIntegration);
        ExcelUtil<PerIntegration> util = new ExcelUtil<PerIntegration>(PerIntegration.class);
        util.exportExcel(response, list, "数据集成数据");
    }

    /**
     * 获取数据集成详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:integrationfg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(perIntegrationService.selectPerIntegrationById(id));
    }

    /**
     * 新增数据集成
     */
    @PreAuthorize("@ss.hasPermi('air:integrationfg:add')")
    @Log(title = "数据集成", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PerIntegration perIntegration)
    {
        return toAjax(perIntegrationService.insertPerIntegration(perIntegration));
    }

    /**
     * 修改数据集成
     */
    @PreAuthorize("@ss.hasPermi('air:integrationfg:edit')")
    @Log(title = "数据集成", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PerIntegration perIntegration)
    {
        return toAjax(perIntegrationService.updatePerIntegration(perIntegration));
    }

    /**
     * 删除数据集成
     */
    @PreAuthorize("@ss.hasPermi('air:integrationfg:remove')")
    @Log(title = "数据集成", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(perIntegrationService.deletePerIntegrationByIds(ids));
    }
}
