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
import com.grade.air.domain.SsDormitoryMaintenanceWoif;
import com.grade.air.service.ISsDormitoryMaintenanceWoifService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍报修反馈Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/woifgt")
public class SsDormitoryMaintenanceWoifController extends BaseController
{
    @Autowired
    private ISsDormitoryMaintenanceWoifService ssDormitoryMaintenanceWoifService;

    /**
     * 查询宿舍报修反馈列表
     */
    @PreAuthorize("@ss.hasPermi('air:woifgt:list')")
    @GetMapping("/list")
    public TableDataInfo list(SsDormitoryMaintenanceWoif ssDormitoryMaintenanceWoif)
    {
        startPage();
        List<SsDormitoryMaintenanceWoif> list = ssDormitoryMaintenanceWoifService.selectSsDormitoryMaintenanceWoifList(ssDormitoryMaintenanceWoif);
        return getDataTable(list);
    }

    /**
     * 导出宿舍报修反馈列表
     */
    @PreAuthorize("@ss.hasPermi('air:woifgt:export')")
    @Log(title = "宿舍报修反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SsDormitoryMaintenanceWoif ssDormitoryMaintenanceWoif)
    {
        List<SsDormitoryMaintenanceWoif> list = ssDormitoryMaintenanceWoifService.selectSsDormitoryMaintenanceWoifList(ssDormitoryMaintenanceWoif);
        ExcelUtil<SsDormitoryMaintenanceWoif> util = new ExcelUtil<SsDormitoryMaintenanceWoif>(SsDormitoryMaintenanceWoif.class);
        util.exportExcel(response, list, "宿舍报修反馈数据");
    }

    /**
     * 获取宿舍报修反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:woifgt:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ssDormitoryMaintenanceWoifService.selectSsDormitoryMaintenanceWoifById(id));
    }

    /**
     * 新增宿舍报修反馈
     */
    @PreAuthorize("@ss.hasPermi('air:woifgt:add')")
    @Log(title = "宿舍报修反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SsDormitoryMaintenanceWoif ssDormitoryMaintenanceWoif)
    {
        return toAjax(ssDormitoryMaintenanceWoifService.insertSsDormitoryMaintenanceWoif(ssDormitoryMaintenanceWoif));
    }

    /**
     * 修改宿舍报修反馈
     */
    @PreAuthorize("@ss.hasPermi('air:woifgt:edit')")
    @Log(title = "宿舍报修反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SsDormitoryMaintenanceWoif ssDormitoryMaintenanceWoif)
    {
        return toAjax(ssDormitoryMaintenanceWoifService.updateSsDormitoryMaintenanceWoif(ssDormitoryMaintenanceWoif));
    }

    /**
     * 删除宿舍报修反馈
     */
    @PreAuthorize("@ss.hasPermi('air:woifgt:remove')")
    @Log(title = "宿舍报修反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ssDormitoryMaintenanceWoifService.deleteSsDormitoryMaintenanceWoifByIds(ids));
    }
}
