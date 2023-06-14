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
import com.grade.air.domain.GzRewardspunishments;
import com.grade.air.service.IGzRewardspunishmentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学员奖惩Controller
 * 
 * @author l
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/air/rewardspunishmentseb")
public class GzRewardspunishmentsController extends BaseController
{
    @Autowired
    private IGzRewardspunishmentsService gzRewardspunishmentsService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询学员奖惩列表
     */
    @PreAuthorize("@ss.hasPermi('air:rewardspunishmentseb:list')")
    @GetMapping("/list")
    public TableDataInfo list(GzRewardspunishments gzRewardspunishments)
    {
        startPage();
        List<GzRewardspunishments> list = gzRewardspunishmentsService.selectGzRewardspunishmentsList(gzRewardspunishments);
        return getDataTable(list);
    }

    /**
     * 导出学员奖惩列表
     */
    @PreAuthorize("@ss.hasPermi('air:rewardspunishmentseb:export')")
    @Log(title = "学员奖惩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GzRewardspunishments gzRewardspunishments)
    {
        List<GzRewardspunishments> list = gzRewardspunishmentsService.selectGzRewardspunishmentsList(gzRewardspunishments);
        ExcelUtil<GzRewardspunishments> util = new ExcelUtil<GzRewardspunishments>(GzRewardspunishments.class);
        util.exportExcel(response, list, "学员奖惩数据");
    }

    /**
     * 获取学员奖惩详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:rewardspunishmentseb:query')")
    @GetMapping(value = "/{recordID}")
    public AjaxResult getInfo(@PathVariable("recordID") Long recordID)
    {
        return success(gzRewardspunishmentsService.selectGzRewardspunishmentsByRecordID(recordID));
    }

    /**
     * 新增学员奖惩
     */
    @PreAuthorize("@ss.hasPermi('air:rewardspunishmentseb:add')")
    @Log(title = "学员奖惩", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GzRewardspunishments gzRewardspunishments)
    {
        SysUser sysUser = userService.selectUserByNickName(gzRewardspunishments.getStudentName());
        gzRewardspunishments.setUserId(sysUser.getUserId());
        return toAjax(gzRewardspunishmentsService.insertGzRewardspunishments(gzRewardspunishments));
    }

    /**
     * 修改学员奖惩
     */
    @PreAuthorize("@ss.hasPermi('air:rewardspunishmentseb:edit')")
    @Log(title = "学员奖惩", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GzRewardspunishments gzRewardspunishments)
    {
        return toAjax(gzRewardspunishmentsService.updateGzRewardspunishments(gzRewardspunishments));
    }

    /**
     * 删除学员奖惩
     */
    @PreAuthorize("@ss.hasPermi('air:rewardspunishmentseb:remove')")
    @Log(title = "学员奖惩", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIDs}")
    public AjaxResult remove(@PathVariable Long[] recordIDs)
    {
        return toAjax(gzRewardspunishmentsService.deleteGzRewardspunishmentsByRecordIDs(recordIDs));
    }
}
