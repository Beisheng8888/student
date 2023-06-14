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
import com.grade.air.domain.PerElective;
import com.grade.air.service.IPerElectiveService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学员成绩Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/electivefd")
public class PerElectiveController extends BaseController
{
    @Autowired
    private IPerElectiveService perElectiveService;

    /**
     * 查询学员成绩列表
     */
    @PreAuthorize("@ss.hasPermi('air:electivefd:list')")
    @GetMapping("/list")
    public TableDataInfo list(PerElective perElective)
    {
        startPage();
        List<PerElective> list = perElectiveService.selectPerElectiveList(perElective);
        return getDataTable(list);
    }

    /**
     * 导出学员成绩列表
     */
    @PreAuthorize("@ss.hasPermi('air:electivefd:export')")
    @Log(title = "学员成绩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PerElective perElective)
    {
        List<PerElective> list = perElectiveService.selectPerElectiveList(perElective);
        ExcelUtil<PerElective> util = new ExcelUtil<PerElective>(PerElective.class);
        util.exportExcel(response, list, "学员成绩数据");
    }

    /**
     * 获取学员成绩详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:electivefd:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(perElectiveService.selectPerElectiveById(id));
    }

    /**
     * 新增学员成绩
     */
    @PreAuthorize("@ss.hasPermi('air:electivefd:add')")
    @Log(title = "学员成绩", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PerElective perElective)
    {
        return toAjax(perElectiveService.insertPerElective(perElective));
    }

    /**
     * 修改学员成绩
     */
    @PreAuthorize("@ss.hasPermi('air:electivefd:edit')")
    @Log(title = "学员成绩", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PerElective perElective)
    {
        return toAjax(perElectiveService.updatePerElective(perElective));
    }

    /**
     * 删除学员成绩
     */
    @PreAuthorize("@ss.hasPermi('air:electivefd:remove')")
    @Log(title = "学员成绩", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(perElectiveService.deletePerElectiveByIds(ids));
    }
}
