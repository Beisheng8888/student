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
          v-hasPermi="['air:studentdisciplineef:add']"
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
          v-hasPermi="['air:studentdisciplineef:edit']"
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
          v-hasPermi="['air:studentdisciplineef:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['air:studentdisciplineef:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="studentdisciplineefList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学生姓名" align="center" prop="studentName" />
      <el-table-column label="违纪日期" align="center" prop="violationDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.violationDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="违纪内容" align="center" prop="violationContent" />
      <el-table-column label="处分措施" align="center" prop="disciplinaryAction" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['air:studentdisciplineef:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['air:studentdisciplineef:remove']"
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

    <!-- 添加或修改学员通报对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生姓名" prop="studentName">
          <el-input v-model="form.studentName" placeholder="请输入学生姓名" />
        </el-form-item>
        <el-form-item label="违纪日期" prop="violationDate">
          <el-date-picker clearable
            v-model="form.violationDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择违纪日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="违纪内容" prop="violationContent">
          <el-input v-model="form.violationContent" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="处分措施" prop="disciplinaryAction">
          <el-input v-model="form.disciplinaryAction" placeholder="请输入处分措施" />
        </el-form-item>
        <el-form-item label="学号" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入学号" />
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
import { listStudentdisciplineef, getStudentdisciplineef, delStudentdisciplineef, addStudentdisciplineef, updateStudentdisciplineef } from "@/api/air/studentdisciplineef";

export default {
  name: "Studentdisciplineef",
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
      // 学员通报表格数据
      studentdisciplineefList: [],
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
    /** 查询学员通报列表 */
    getList() {
      this.loading = true;
      listStudentdisciplineef(this.queryParams).then(response => {
        this.studentdisciplineefList = response.rows;
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
        recordID: null,
        studentName: null,
        violationDate: null,
        violationContent: null,
        disciplinaryAction: null,
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
      this.ids = selection.map(item => item.recordID)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学员通报";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recordID = row.recordID || this.ids
      getStudentdisciplineef(recordID).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学员通报";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.recordID != null) {
            updateStudentdisciplineef(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            let userId = null;
            if (this.form.userId) {
              userId = this.form.userId;
            }

            const formWithParams = { ...this.form, userId: userId };
            console.log(formWithParams);
            addStudentdisciplineef(formWithParams).then(response => {
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
      const recordIDs = row.recordID || this.ids;
      this.$modal.confirm('是否确认删除学员通报编号为"' + recordIDs + '"的数据项？').then(function() {
        return delStudentdisciplineef(recordIDs);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('air/studentdisciplineef/export', {
        ...this.queryParams
      }, `studentdisciplineef_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
