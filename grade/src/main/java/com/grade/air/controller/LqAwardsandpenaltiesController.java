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
import com.grade.air.domain.LqAwardsandpenalties;
import com.grade.air.service.ILqAwardsandpenaltiesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 奖惩通告Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/awardsandpenaltiesad")
public class LqAwardsandpenaltiesController extends BaseController
{
    @Autowired
    private ILqAwardsandpenaltiesService lqAwardsandpenaltiesService;

    /**
     * 查询奖惩通告列表
     */
    @PreAuthorize("@ss.hasPermi('air:awardsandpenaltiesad:list')")
    @GetMapping("/list")
    public TableDataInfo list(LqAwardsandpenalties lqAwardsandpenalties)
    {
        startPage();
        List<LqAwardsandpenalties> list = lqAwardsandpenaltiesService.selectLqAwardsandpenaltiesList(lqAwardsandpenalties);
        return getDataTable(list);
    }

    /**
     * 导出奖惩通告列表
     */
    @PreAuthorize("@ss.hasPermi('air:awardsandpenaltiesad:export')")
    @Log(title = "奖惩通告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LqAwardsandpenalties lqAwardsandpenalties)
    {
        List<LqAwardsandpenalties> list = lqAwardsandpenaltiesService.selectLqAwardsandpenaltiesList(lqAwardsandpenalties);
        ExcelUtil<LqAwardsandpenalties> util = new ExcelUtil<LqAwardsandpenalties>(LqAwardsandpenalties.class);
        util.exportExcel(response, list, "奖惩通告数据");
    }

    /**
     * 获取奖惩通告详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:awardsandpenaltiesad:query')")
    @GetMapping(value = "/{studentID}")
    public AjaxResult getInfo(@PathVariable("studentID") Long studentID)
    {
        return success(lqAwardsandpenaltiesService.selectLqAwardsandpenaltiesByStudentID(studentID));
    }

    /**
     * 新增奖惩通告
     */
    @PreAuthorize("@ss.hasPermi('air:awardsandpenaltiesad:add')")
    @Log(title = "奖惩通告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LqAwardsandpenalties lqAwardsandpenalties)
    {
        return toAjax(lqAwardsandpenaltiesService.insertLqAwardsandpenalties(lqAwardsandpenalties));
    }

    /**
     * 修改奖惩通告
     */
    @PreAuthorize("@ss.hasPermi('air:awardsandpenaltiesad:edit')")
    @Log(title = "奖惩通告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LqAwardsandpenalties lqAwardsandpenalties)
    {
        return toAjax(lqAwardsandpenaltiesService.updateLqAwardsandpenalties(lqAwardsandpenalties));
    }

    /**
     * 删除奖惩通告
     */
    @PreAuthorize("@ss.hasPermi('air:awardsandpenaltiesad:remove')")
    @Log(title = "奖惩通告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIDs}")
    public AjaxResult remove(@PathVariable Long[] studentIDs)
    {
        return toAjax(lqAwardsandpenaltiesService.deleteLqAwardsandpenaltiesByStudentIDs(studentIDs));
    }
}
