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
import com.grade.air.domain.GzStudenthealth;
import com.grade.air.service.IGzStudenthealthService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学员健康Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/studenthealther")
public class GzStudenthealthController extends BaseController
{
    @Autowired
    private IGzStudenthealthService gzStudenthealthService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询学员健康列表
     */
    @PreAuthorize("@ss.hasPermi('air:studenthealther:list')")
    @GetMapping("/list")
    public TableDataInfo list(GzStudenthealth gzStudenthealth)
    {
        startPage();
        List<GzStudenthealth> list = gzStudenthealthService.selectGzStudenthealthList(gzStudenthealth);
        return getDataTable(list);
    }

    /**
     * 导出学员健康列表
     */
    @PreAuthorize("@ss.hasPermi('air:studenthealther:export')")
    @Log(title = "学员健康", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GzStudenthealth gzStudenthealth)
    {
        List<GzStudenthealth> list = gzStudenthealthService.selectGzStudenthealthList(gzStudenthealth);
        ExcelUtil<GzStudenthealth> util = new ExcelUtil<GzStudenthealth>(GzStudenthealth.class);
        util.exportExcel(response, list, "学员健康数据");
    }

    /**
     * 获取学员健康详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:studenthealther:query')")
    @GetMapping(value = "/{recordID}")
    public AjaxResult getInfo(@PathVariable("recordID") Long recordID)
    {
        return success(gzStudenthealthService.selectGzStudenthealthByRecordID(recordID));
    }

    /**
     * 新增学员健康
     */
    @PreAuthorize("@ss.hasPermi('air:studenthealther:add')")
    @Log(title = "学员健康", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GzStudenthealth gzStudenthealth)
    {
        SysUser sysUser = userService.selectUserByNickName(String.valueOf(gzStudenthealth.getUserId()));
        gzStudenthealth.setUserId(sysUser.getUserId());
        return toAjax(gzStudenthealthService.insertGzStudenthealth(gzStudenthealth));
    }

    /**
     * 修改学员健康
     */
    @PreAuthorize("@ss.hasPermi('air:studenthealther:edit')")
    @Log(title = "学员健康", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GzStudenthealth gzStudenthealth)
    {
        return toAjax(gzStudenthealthService.updateGzStudenthealth(gzStudenthealth));
    }

    /**
     * 删除学员健康
     */
    @PreAuthorize("@ss.hasPermi('air:studenthealther:remove')")
    @Log(title = "学员健康", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIDs}")
    public AjaxResult remove(@PathVariable Long[] recordIDs)
    {
        return toAjax(gzStudenthealthService.deleteGzStudenthealthByRecordIDs(recordIDs));
    }
}
