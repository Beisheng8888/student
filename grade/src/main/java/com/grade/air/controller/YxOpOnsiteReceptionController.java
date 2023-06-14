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
import com.grade.air.domain.YxOpOnsiteReception;
import com.grade.air.service.IYxOpOnsiteReceptionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 现场接待数据Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/receptionba")
public class YxOpOnsiteReceptionController extends BaseController
{
    @Autowired
    private IYxOpOnsiteReceptionService yxOpOnsiteReceptionService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询现场接待数据列表
     */
    @PreAuthorize("@ss.hasPermi('air:receptionba:list')")
    @GetMapping("/list")
    public TableDataInfo list(YxOpOnsiteReception yxOpOnsiteReception)
    {
        startPage();
        List<YxOpOnsiteReception> list = yxOpOnsiteReceptionService.selectYxOpOnsiteReceptionList(yxOpOnsiteReception);
        return getDataTable(list);
    }

    /**
     * 导出现场接待数据列表
     */
    @PreAuthorize("@ss.hasPermi('air:receptionba:export')")
    @Log(title = "现场接待数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YxOpOnsiteReception yxOpOnsiteReception)
    {
        List<YxOpOnsiteReception> list = yxOpOnsiteReceptionService.selectYxOpOnsiteReceptionList(yxOpOnsiteReception);
        ExcelUtil<YxOpOnsiteReception> util = new ExcelUtil<YxOpOnsiteReception>(YxOpOnsiteReception.class);
        util.exportExcel(response, list, "现场接待数据数据");
    }

    /**
     * 获取现场接待数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:receptionba:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(yxOpOnsiteReceptionService.selectYxOpOnsiteReceptionByRecordId(recordId));
    }

    /**
     * 新增现场接待数据
     */
    @PreAuthorize("@ss.hasPermi('air:receptionba:add')")
    @Log(title = "现场接待数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YxOpOnsiteReception yxOpOnsiteReception)
    {
        SysUser sysUser = userService.selectUserByNickName(yxOpOnsiteReception.getStudentName());
        yxOpOnsiteReception.setUserId(sysUser.getUserId());
        return toAjax(yxOpOnsiteReceptionService.insertYxOpOnsiteReception(yxOpOnsiteReception));
    }

    /**
     * 修改现场接待数据
     */
    @PreAuthorize("@ss.hasPermi('air:receptionba:edit')")
    @Log(title = "现场接待数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YxOpOnsiteReception yxOpOnsiteReception)
    {
        return toAjax(yxOpOnsiteReceptionService.updateYxOpOnsiteReception(yxOpOnsiteReception));
    }

    /**
     * 删除现场接待数据
     */
    @PreAuthorize("@ss.hasPermi('air:receptionba:remove')")
    @Log(title = "现场接待数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(yxOpOnsiteReceptionService.deleteYxOpOnsiteReceptionByRecordIds(recordIds));
    }
}
