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
import com.grade.air.domain.SsNetworkFaultRepairApplicationDemo;
import com.grade.air.service.ISsNetworkFaultRepairApplicationDemoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网络故障保修反馈Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/demogo")
public class SsNetworkFaultRepairApplicationDemoController extends BaseController
{
    @Autowired
    private ISsNetworkFaultRepairApplicationDemoService ssNetworkFaultRepairApplicationDemoService;

    /**
     * 查询网络故障保修反馈列表
     */
    @PreAuthorize("@ss.hasPermi('air:demogo:list')")
    @GetMapping("/list")
    public TableDataInfo list(SsNetworkFaultRepairApplicationDemo ssNetworkFaultRepairApplicationDemo)
    {
        startPage();
        List<SsNetworkFaultRepairApplicationDemo> list = ssNetworkFaultRepairApplicationDemoService.selectSsNetworkFaultRepairApplicationDemoList(ssNetworkFaultRepairApplicationDemo);
        return getDataTable(list);
    }

    /**
     * 导出网络故障保修反馈列表
     */
    @PreAuthorize("@ss.hasPermi('air:demogo:export')")
    @Log(title = "网络故障保修反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SsNetworkFaultRepairApplicationDemo ssNetworkFaultRepairApplicationDemo)
    {
        List<SsNetworkFaultRepairApplicationDemo> list = ssNetworkFaultRepairApplicationDemoService.selectSsNetworkFaultRepairApplicationDemoList(ssNetworkFaultRepairApplicationDemo);
        ExcelUtil<SsNetworkFaultRepairApplicationDemo> util = new ExcelUtil<SsNetworkFaultRepairApplicationDemo>(SsNetworkFaultRepairApplicationDemo.class);
        util.exportExcel(response, list, "网络故障保修反馈数据");
    }

    /**
     * 获取网络故障保修反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:demogo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ssNetworkFaultRepairApplicationDemoService.selectSsNetworkFaultRepairApplicationDemoById(id));
    }

    /**
     * 新增网络故障保修反馈
     */
    @PreAuthorize("@ss.hasPermi('air:demogo:add')")
    @Log(title = "网络故障保修反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SsNetworkFaultRepairApplicationDemo ssNetworkFaultRepairApplicationDemo)
    {
        return toAjax(ssNetworkFaultRepairApplicationDemoService.insertSsNetworkFaultRepairApplicationDemo(ssNetworkFaultRepairApplicationDemo));
    }

    /**
     * 修改网络故障保修反馈
     */
    @PreAuthorize("@ss.hasPermi('air:demogo:edit')")
    @Log(title = "网络故障保修反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SsNetworkFaultRepairApplicationDemo ssNetworkFaultRepairApplicationDemo)
    {
        return toAjax(ssNetworkFaultRepairApplicationDemoService.updateSsNetworkFaultRepairApplicationDemo(ssNetworkFaultRepairApplicationDemo));
    }

    /**
     * 删除网络故障保修反馈
     */
    @PreAuthorize("@ss.hasPermi('air:demogo:remove')")
    @Log(title = "网络故障保修反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ssNetworkFaultRepairApplicationDemoService.deleteSsNetworkFaultRepairApplicationDemoByIds(ids));
    }
}
