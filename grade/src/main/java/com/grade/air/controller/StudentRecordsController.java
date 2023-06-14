package com.grade.air.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.grade.air.domain.StudentRecords;
import com.ruoyi.common.core.domain.entity.SysUser;
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
import com.grade.air.service.IStudentRecordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 档案查询Controller
 * 
 * @author l
 * @date 2023-06-05
 */
@RestController
@RequestMapping("/air/records")
public class StudentRecordsController extends BaseController
{
    @Autowired
    private IStudentRecordsService studentRecordsService;

    /**
     * 查询档案查询列表
     */
    @PreAuthorize("@ss.hasPermi('air:records:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentRecords studentRecords)
    {
        startPage();
        List<StudentRecords> list = studentRecordsService.selectStudentRecordsList(studentRecords);
        return getDataTable(list);
    }

    /**
     * 导出档案查询列表
     */
    @PreAuthorize("@ss.hasPermi('air:records:export')")
    @Log(title = "档案查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentRecords studentRecords)
    {
        List<StudentRecords> list = studentRecordsService.selectStudentRecordsList(studentRecords);
        ExcelUtil<StudentRecords> util = new ExcelUtil<StudentRecords>(StudentRecords.class);
        util.exportExcel(response, list, "档案查询数据");
    }

    /**
     * 获取档案查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('air:records:query')")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(studentRecordsService.selectStudentRecordsByStudentId(studentId));
    }

    /**
     * 新增档案查询
     */
    @PreAuthorize("@ss.hasPermi('air:records:add')")
    @Log(title = "档案查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentRecords studentRecords)
    {
        return toAjax(studentRecordsService.insertStudentRecords(studentRecords));
    }

    /**
     * 修改档案查询
     */
    @PreAuthorize("@ss.hasPermi('air:records:edit')")
    @Log(title = "档案查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentRecords studentRecords)
    {
        return toAjax(studentRecordsService.updateStudentRecords(studentRecords));
    }

    /**
     * 删除档案查询
     */
    @PreAuthorize("@ss.hasPermi('air:records:remove')")
    @Log(title = "档案查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(studentRecordsService.deleteStudentRecordsByStudentIds(studentIds));
    }
    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<StudentRecords> util = new ExcelUtil<StudentRecords>(StudentRecords.class);
        List<StudentRecords> userList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = studentRecordsService.importUser(userList, updateSupport, operName);
        return success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<StudentRecords> util = new ExcelUtil<StudentRecords>(StudentRecords.class);
        util.importTemplateExcel(response, "用户数据");
    }

}
