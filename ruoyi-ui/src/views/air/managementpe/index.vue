<template>
  <div class="app-container">

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['air:managementpe:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['air:managementpe:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['air:managementpe:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['air:managementpe:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="managementpeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="学号" align="center" prop="studentNumber" />
      <el-table-column label="专业" align="center" prop="major" />
      <el-table-column label="入学日期" align="center" prop="enrollmentDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.enrollmentDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="毕业日期" align="center" prop="graduationDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.graduationDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="毕业论文题目" align="center" prop="thesisTitle" />
      <el-table-column label="指导教师" align="center" prop="supervisor" />
      <el-table-column label="毕业成绩" align="center" prop="gpa" />
      <el-table-column label="毕业证书号码" align="center" prop="certificateNumber" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['air:managementpe:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['air:managementpe:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改准毕业生管理数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="学号" prop="studentNumber">
          <el-input v-model="form.studentNumber" placeholder="请输入学号" />
        </el-form-item>
        <el-form-item label="专业" prop="major">
          <el-input v-model="form.major" placeholder="请输入专业" />
        </el-form-item>
        <el-form-item label="入学日期" prop="enrollmentDate">
          <el-date-picker clearable
            v-model="form.enrollmentDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入学日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="毕业日期" prop="graduationDate">
          <el-date-picker clearable
            v-model="form.graduationDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择毕业日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="毕业论文题目" prop="thesisTitle">
          <el-input v-model="form.thesisTitle" placeholder="请输入毕业论文题目" />
        </el-form-item>
        <el-form-item label="指导教师" prop="supervisor">
          <el-input v-model="form.supervisor" placeholder="请输入指导教师" />
        </el-form-item>
        <el-form-item label="毕业成绩" prop="gpa">
          <el-input v-model="form.gpa" placeholder="请输入毕业成绩" />
        </el-form-item>
        <el-form-item label="毕业证书号码" prop="certificateNumber">
          <el-input v-model="form.certificateNumber" placeholder="请输入毕业证书号码" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listManagementpe, getManagementpe, delManagementpe, addManagementpe, updateManagementpe } from "@/api/air/managementpe";

export default {
  name: "Managementpe",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 准毕业生管理数据表格数据
      managementpeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询准毕业生管理数据列表 */
    getList() {
      this.loading = true;
      listManagementpe(this.queryParams).then(response => {
        this.managementpeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        studentId: null,
        name: null,
        studentNumber: null,
        major: null,
        enrollmentDate: null,
        graduationDate: null,
        thesisTitle: null,
        supervisor: null,
        gpa: null,
        certificateNumber: null,
        userId: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.studentId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加准毕业生管理数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const studentId = row.studentId || this.ids
      getManagementpe(studentId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改准毕业生管理数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.studentId != null) {
            updateManagementpe(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addManagementpe(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const studentIds = row.studentId || this.ids;
      this.$modal.confirm('是否确认删除准毕业生管理数据编号为"' + studentIds + '"的数据项？').then(function() {
        return delManagementpe(studentIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('air/managementpe/export', {
        ...this.queryParams
      }, `managementpe_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
