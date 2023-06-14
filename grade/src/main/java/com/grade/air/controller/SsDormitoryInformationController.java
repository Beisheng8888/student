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
import com.grade.air.domain.SsDormitoryInformation;
import com.grade.air.service.ISsDormitoryInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍信息Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/informationgc")
public class SsDormitoryInformationController extends BaseController
{
    @Autowired
    private ISsDormitoryInformationService ssDormitoryInformationService;
    @Autowired
    private ISysUserService userService;

    /**
     * 查询宿舍信息列表
     */
    @PreAuthorize("@ss.hasPermi('air:informationgc:list')")
    @GetMapping("/list")
    public TableDataInfo list(SsDormitoryInformation ssDormitoryInformation)
    {
        startPage();
        List<SsDormitoryInformation> list = ssDormitoryInformationService.selectSsDormitoryInformationList(ssDormitoryInformation);
        return getDataTable(list);
    }

    /**
     * 导出宿舍信息列表
     */
    @PreAuthorize("@ss.hasPermi('air:informationgc:export')")
    @Log(title = "宿舍信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SsDormitoryInformation ssDormitoryInformation)
    {
        List<SsDormitoryInformation> list = ssDormitoryInformationService.selectSsDormitoryInformationList(ssDormitoryInformation);
        ExcelUtil<SsDormitoryInformation> util = new ExcelUtil<SsDormitoryInformation>(SsDormitoryInformation.class);
        util.exportExcel(response, list, "宿舍信息数据");
    }

    /**
     * 获取宿舍信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:informationgc:query')")
    @GetMapping(value = "/{dormitoryId}")
    public AjaxResult getInfo(@PathVariable("dormitoryId") Long dormitoryId)
    {
        return success(ssDormitoryInformationService.selectSsDormitoryInformationByDormitoryId(dormitoryId));
    }

    /**
     * 新增宿舍信息
     */
    @PreAuthorize("@ss.hasPermi('air:informationgc:add')")
    @Log(title = "宿舍信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SsDormitoryInformation ssDormitoryInformation)
    {
        SysUser sysUser=userService.selectUserByNickName(String.valueOf(ssDormitoryInformation.getUserId()));
        ssDormitoryInformation.setUserId(sysUser.getUserId());
        return toAjax(ssDormitoryInformationService.insertSsDormitoryInformation(ssDormitoryInformation));
    }

    /**
     * 修改宿舍信息
     */
    @PreAuthorize("@ss.hasPermi('air:informationgc:edit')")
    @Log(title = "宿舍信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SsDormitoryInformation ssDormitoryInformation)
    {
        return toAjax(ssDormitoryInformationService.updateSsDormitoryInformation(ssDormitoryInformation));
    }

    /**
     * 删除宿舍信息
     */
    @PreAuthorize("@ss.hasPermi('air:informationgc:remove')")
    @Log(title = "宿舍信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dormitoryIds}")
    public AjaxResult remove(@PathVariable Long[] dormitoryIds)
    {
        return toAjax(ssDormitoryInformationService.deleteSsDormitoryInformationByDormitoryIds(dormitoryIds));
    }
}
