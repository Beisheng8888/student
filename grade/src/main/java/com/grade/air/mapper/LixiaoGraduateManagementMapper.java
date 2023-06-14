package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.LixiaoGraduateManagement;

/**
 * 准毕业生管理数据Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface LixiaoGraduateManagementMapper 
{
    /**
     * 查询准毕业生管理数据
     * 
     * @param studentId 准毕业生管理数据主键
     * @return 准毕业生管理数据
     */
    public LixiaoGraduateManagement selectLixiaoGraduateManagementByStudentId(Long studentId);

    /**
     * 查询准毕业生管理数据列表
     * 
     * @param lixiaoGraduateManagement 准毕业生管理数据
     * @return 准毕业生管理数据集合
     */
    public List<LixiaoGraduateManagement> selectLixiaoGraduateManagementList(LixiaoGraduateManagement lixiaoGraduateManagement);

    /**
     * 新增准毕业生管理数据
     * 
     * @param lixiaoGraduateManagement 准毕业生管理数据
     * @return 结果
     */
    public int insertLixiaoGraduateManagement(LixiaoGraduateManagement lixiaoGraduateManagement);

    /**
     * 修改准毕业生管理数据
     * 
     * @param lixiaoGraduateManagement 准毕业生管理数据
     * @return 结果
     */
    public int updateLixiaoGraduateManagement(LixiaoGraduateManagement lixiaoGraduateManagement);

    /**
     * 删除准毕业生管理数据
     * 
     * @param studentId 准毕业生管理数据主键
     * @return 结果
     */
    public int deleteLixiaoGraduateManagementByStudentId(Long studentId);

    /**
     * 批量删除准毕业生管理数据
     * 
     * @param studentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLixiaoGraduateManagementByStudentIds(Long[] studentIds);
}
