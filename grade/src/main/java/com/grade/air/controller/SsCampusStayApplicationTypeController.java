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
import com.grade.air.domain.SsCampusStayApplicationType;
import com.grade.air.service.ISsCampusStayApplicationTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 假期留校申请反馈Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/typegb")
public class SsCampusStayApplicationTypeController extends BaseController
{
    @Autowired
    private ISsCampusStayApplicationTypeService ssCampusStayApplicationTypeService;

    /**
     * 查询假期留校申请反馈列表
     */
    @PreAuthorize("@ss.hasPermi('air:typegb:list')")
    @GetMapping("/list")
    public TableDataInfo list(SsCampusStayApplicationType ssCampusStayApplicationType)
    {
        startPage();
        List<SsCampusStayApplicationType> list = ssCampusStayApplicationTypeService.selectSsCampusStayApplicationTypeList(ssCampusStayApplicationType);
        return getDataTable(list);
    }

    /**
     * 导出假期留校申请反馈列表
     */
    @PreAuthorize("@ss.hasPermi('air:typegb:export')")
    @Log(title = "假期留校申请反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SsCampusStayApplicationType ssCampusStayApplicationType)
    {
        List<SsCampusStayApplicationType> list = ssCampusStayApplicationTypeService.selectSsCampusStayApplicationTypeList(ssCampusStayApplicationType);
        ExcelUtil<SsCampusStayApplicationType> util = new ExcelUtil<SsCampusStayApplicationType>(SsCampusStayApplicationType.class);
        util.exportExcel(response, list, "假期留校申请反馈数据");
    }

    /**
     * 获取假期留校申请反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:typegb:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ssCampusStayApplicationTypeService.selectSsCampusStayApplicationTypeById(id));
    }

    /**
     * 新增假期留校申请反馈
     */
    @PreAuthorize("@ss.hasPermi('air:typegb:add')")
    @Log(title = "假期留校申请反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SsCampusStayApplicationType ssCampusStayApplicationType)
    {
        return toAjax(ssCampusStayApplicationTypeService.insertSsCampusStayApplicationType(ssCampusStayApplicationType));
    }

    /**
     * 修改假期留校申请反馈
     */
    @PreAuthorize("@ss.hasPermi('air:typegb:edit')")
    @Log(title = "假期留校申请反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SsCampusStayApplicationType ssCampusStayApplicationType)
    {
        return toAjax(ssCampusStayApplicationTypeService.updateSsCampusStayApplicationType(ssCampusStayApplicationType));
    }

    /**
     * 删除假期留校申请反馈
     */
    @PreAuthorize("@ss.hasPermi('air:typegb:remove')")
    @Log(title = "假期留校申请反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ssCampusStayApplicationTypeService.deleteSsCampusStayApplicationTypeByIds(ids));
    }
}
