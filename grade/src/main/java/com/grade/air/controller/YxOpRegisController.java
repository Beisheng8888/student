package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.grade.air.domain.YxOpRegistrationProcess;
import com.grade.air.service.IYxOpRegistrationProcessService;
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
import com.grade.air.domain.YxOpRegis;
import com.grade.air.service.IYxOpRegisService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 行政报到Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/regisbb")
public class YxOpRegisController extends BaseController
{
    @Autowired
    private IYxOpRegisService yxOpRegisService;

    @Autowired
    private IYxOpRegistrationProcessService yxOpRegistrationProcessService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询行政报到列表
     */
    @PreAuthorize("@ss.hasPermi('air:regisbb:list')")
    @GetMapping("/list")
    public TableDataInfo list(YxOpRegis yxOpRegis)
    {
        startPage();
        List<YxOpRegis> list = yxOpRegisService.selectYxOpRegisList(yxOpRegis);
        return getDataTable(list);
    }

    /**
     * 导出行政报到列表
     */
    @PreAuthorize("@ss.hasPermi('air:regisbb:export')")
    @Log(title = "行政报到", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YxOpRegis yxOpRegis)
    {
        List<YxOpRegis> list = yxOpRegisService.selectYxOpRegisList(yxOpRegis);
        ExcelUtil<YxOpRegis> util = new ExcelUtil<YxOpRegis>(YxOpRegis.class);
        util.exportExcel(response, list, "行政报到数据");
    }

    /**
     * 获取行政报到详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:regisbb:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(yxOpRegisService.selectYxOpRegisById(id));
    }

    /**
     * 新增行政报到
     */
    @PreAuthorize("@ss.hasPermi('air:regisbb:add')")
    @Log(title = "行政报到", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YxOpRegis yxOpRegis)
    {
        SysUser sysUser = userService.selectUserByNickName(yxOpRegis.getName());
        yxOpRegis.setUserId(sysUser.getUserId());
        YxOpRegistrationProcess yx=new YxOpRegistrationProcess();
        yx.setName(yxOpRegis.getName());
        yx.setStudentNumber(yxOpRegis.getStudentNumber());
        yx.setSubmissionTime(yxOpRegis.getSubmissionTime());
        yx.setArrivalTime(yxOpRegis.getArrivalTime());
        yx.setArrivalLocation(yxOpRegis.getArrivalLocation());
        yxOpRegistrationProcessService.insertYxOpRegistrationProcess(yx);
        return toAjax(yxOpRegisService.insertYxOpRegis(yxOpRegis));
    }

    /**
     * 修改行政报到
     */
    @PreAuthorize("@ss.hasPermi('air:regisbb:edit')")
    @Log(title = "行政报到", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YxOpRegis yxOpRegis)
    {
        return toAjax(yxOpRegisService.updateYxOpRegis(yxOpRegis));
    }

    /**
     * 删除行政报到
     */
    @PreAuthorize("@ss.hasPermi('air:regisbb:remove')")
    @Log(title = "行政报到", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(yxOpRegisService.deleteYxOpRegisByIds(ids));
    }
}
