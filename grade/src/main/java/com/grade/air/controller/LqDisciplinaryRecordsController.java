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
import com.grade.air.domain.LqDisciplinaryRecords;
import com.grade.air.service.ILqDisciplinaryRecordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人违纪处分Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/recordsad")
public class LqDisciplinaryRecordsController extends BaseController
{
    @Autowired
    private ILqDisciplinaryRecordsService lqDisciplinaryRecordsService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询个人违纪处分列表
     */
    @PreAuthorize("@ss.hasPermi('air:recordsad:list')")
    @GetMapping("/list")
    public TableDataInfo list(LqDisciplinaryRecords lqDisciplinaryRecords)
    {
        startPage();
        List<LqDisciplinaryRecords> list = lqDisciplinaryRecordsService.selectLqDisciplinaryRecordsList(lqDisciplinaryRecords);
        return getDataTable(list);
    }

    /**
     * 导出个人违纪处分列表
     */
    @PreAuthorize("@ss.hasPermi('air:recordsad:export')")
    @Log(title = "个人违纪处分", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LqDisciplinaryRecords lqDisciplinaryRecords)
    {
        List<LqDisciplinaryRecords> list = lqDisciplinaryRecordsService.selectLqDisciplinaryRecordsList(lqDisciplinaryRecords);
        ExcelUtil<LqDisciplinaryRecords> util = new ExcelUtil<LqDisciplinaryRecords>(LqDisciplinaryRecords.class);
        util.exportExcel(response, list, "个人违纪处分数据");
    }

    /**
     * 获取个人违纪处分详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:recordsad:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(lqDisciplinaryRecordsService.selectLqDisciplinaryRecordsByRecordId(recordId));
    }

    /**
     * 新增个人违纪处分
     */
    @PreAuthorize("@ss.hasPermi('air:recordsad:add')")
    @Log(title = "个人违纪处分", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LqDisciplinaryRecords lqDisciplinaryRecords)
    {
        SysUser sysUser = userService.selectUserByNickName(lqDisciplinaryRecords.getStudentName());
        lqDisciplinaryRecords.setUserId(sysUser.getUserId());
        return toAjax(lqDisciplinaryRecordsService.insertLqDisciplinaryRecords(lqDisciplinaryRecords));
    }

    /**
     * 修改个人违纪处分
     */
    @PreAuthorize("@ss.hasPermi('air:recordsad:edit')")
    @Log(title = "个人违纪处分", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LqDisciplinaryRecords lqDisciplinaryRecords)
    {
        return toAjax(lqDisciplinaryRecordsService.updateLqDisciplinaryRecords(lqDisciplinaryRecords));
    }

    /**
     * 删除个人违纪处分
     */
    @PreAuthorize("@ss.hasPermi('air:recordsad:remove')")
    @Log(title = "个人违纪处分", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(lqDisciplinaryRecordsService.deleteLqDisciplinaryRecordsByRecordIds(recordIds));
    }
}
