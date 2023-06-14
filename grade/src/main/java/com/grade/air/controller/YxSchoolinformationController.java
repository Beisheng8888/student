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
import com.grade.air.domain.YxSchoolinformation;
import com.grade.air.service.IYxSchoolinformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学校信息Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/schoolinformationdf")
public class YxSchoolinformationController extends BaseController
{
    @Autowired
    private IYxSchoolinformationService yxSchoolinformationService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询学校信息列表
     */
    @PreAuthorize("@ss.hasPermi('air:schoolinformationdf:list')")
    @GetMapping("/list")
    public TableDataInfo list(YxSchoolinformation yxSchoolinformation)
    {
        startPage();
        List<YxSchoolinformation> list = yxSchoolinformationService.selectYxSchoolinformationList(yxSchoolinformation);
        return getDataTable(list);
    }

    /**
     * 导出学校信息列表
     */
    @PreAuthorize("@ss.hasPermi('air:schoolinformationdf:export')")
    @Log(title = "学校信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YxSchoolinformation yxSchoolinformation)
    {
        List<YxSchoolinformation> list = yxSchoolinformationService.selectYxSchoolinformationList(yxSchoolinformation);
        ExcelUtil<YxSchoolinformation> util = new ExcelUtil<YxSchoolinformation>(YxSchoolinformation.class);
        util.exportExcel(response, list, "学校信息数据");
    }

    /**
     * 获取学校信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:schoolinformationdf:query')")
    @GetMapping(value = "/{informationID}")
    public AjaxResult getInfo(@PathVariable("informationID") Long informationID)
    {
        return success(yxSchoolinformationService.selectYxSchoolinformationByInformationID(informationID));
    }

    /**
     * 新增学校信息
     */
    @PreAuthorize("@ss.hasPermi('air:schoolinformationdf:add')")
    @Log(title = "学校信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YxSchoolinformation yxSchoolinformation)
    {
        SysUser sysUser = userService.selectUserByNickName(yxSchoolinformation.getStudentName());
        return toAjax(yxSchoolinformationService.insertYxSchoolinformation(yxSchoolinformation));
    }

    /**
     * 修改学校信息
     */
    @PreAuthorize("@ss.hasPermi('air:schoolinformationdf:edit')")
    @Log(title = "学校信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YxSchoolinformation yxSchoolinformation)
    {
        return toAjax(yxSchoolinformationService.updateYxSchoolinformation(yxSchoolinformation));
    }

    /**
     * 删除学校信息
     */
    @PreAuthorize("@ss.hasPermi('air:schoolinformationdf:remove')")
    @Log(title = "学校信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{informationIDs}")
    public AjaxResult remove(@PathVariable Long[] informationIDs)
    {
        return toAjax(yxSchoolinformationService.deleteYxSchoolinformationByInformationIDs(informationIDs));
    }
}
