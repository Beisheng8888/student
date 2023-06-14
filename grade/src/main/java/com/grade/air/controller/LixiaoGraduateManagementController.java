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
import com.grade.air.domain.LixiaoGraduateManagement;
import com.grade.air.service.ILixiaoGraduateManagementService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 准毕业生管理数据Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/managementpe")
public class LixiaoGraduateManagementController extends BaseController
{
    @Autowired
    private ILixiaoGraduateManagementService lixiaoGraduateManagementService;

    /**
     * 查询准毕业生管理数据列表
     */
    @PreAuthorize("@ss.hasPermi('air:managementpe:list')")
    @GetMapping("/list")
    public TableDataInfo list(LixiaoGraduateManagement lixiaoGraduateManagement)
    {
        startPage();
        List<LixiaoGraduateManagement> list = lixiaoGraduateManagementService.selectLixiaoGraduateManagementList(lixiaoGraduateManagement);
        return getDataTable(list);
    }

    /**
     * 导出准毕业生管理数据列表
     */
    @PreAuthorize("@ss.hasPermi('air:managementpe:export')")
    @Log(title = "准毕业生管理数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LixiaoGraduateManagement lixiaoGraduateManagement)
    {
        List<LixiaoGraduateManagement> list = lixiaoGraduateManagementService.selectLixiaoGraduateManagementList(lixiaoGraduateManagement);
        ExcelUtil<LixiaoGraduateManagement> util = new ExcelUtil<LixiaoGraduateManagement>(LixiaoGraduateManagement.class);
        util.exportExcel(response, list, "准毕业生管理数据数据");
    }

    /**
     * 获取准毕业生管理数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:managementpe:query')")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(lixiaoGraduateManagementService.selectLixiaoGraduateManagementByStudentId(studentId));
    }

    /**
     * 新增准毕业生管理数据
     */
    @PreAuthorize("@ss.hasPermi('air:managementpe:add')")
    @Log(title = "准毕业生管理数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LixiaoGraduateManagement lixiaoGraduateManagement)
    {
        return toAjax(lixiaoGraduateManagementService.insertLixiaoGraduateManagement(lixiaoGraduateManagement));
    }

    /**
     * 修改准毕业生管理数据
     */
    @PreAuthorize("@ss.hasPermi('air:managementpe:edit')")
    @Log(title = "准毕业生管理数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LixiaoGraduateManagement lixiaoGraduateManagement)
    {
        return toAjax(lixiaoGraduateManagementService.updateLixiaoGraduateManagement(lixiaoGraduateManagement));
    }

    /**
     * 删除准毕业生管理数据
     */
    @PreAuthorize("@ss.hasPermi('air:managementpe:remove')")
    @Log(title = "准毕业生管理数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(lixiaoGraduateManagementService.deleteLixiaoGraduateManagementByStudentIds(studentIds));
    }
}
