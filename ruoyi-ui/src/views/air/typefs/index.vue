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
          v-hasPermi="['air:typefs:add']"
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
          v-hasPermi="['air:typefs:edit']"
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
          v-hasPermi="['air:typefs:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['air:typefs:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="typefsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="课程" align="center" prop="courseName" />
      <el-table-column label="学员姓名" align="center" prop="studentName" />
      <el-table-column label="上课日期" align="center" prop="attendanceStatus" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.attendanceStatus, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="班级" align="center" prop="gradeName" />
      <el-table-column label="学院" align="center" prop="xueyuan" />
      <el-table-column label="年级" align="center" prop="nianji" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['air:typefs:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['air:typefs:remove']"
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

    <!-- 添加或修改课程信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程" prop="courseName">
          <el-input v-model="form.courseName" placeholder="请输入课程" />
        </el-form-item>
        <el-form-item label="学员姓名" prop="studentName">
          <el-input v-model="form.studentName" placeholder="请输入学员姓名" />
        </el-form-item>
        <el-form-item label="上课日期" prop="attendanceStatus">
          <el-date-picker clearable
            v-model="form.attendanceStatus"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择上课日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="班级" prop="gradeName">
          <el-input v-model="form.gradeName" placeholder="请输入班级" />
        </el-form-item>
        <el-form-item label="学院" prop="xueyuan">
          <el-input v-model="form.xueyuan" placeholder="请输入学院" />
        </el-form-item>
        <el-form-item label="年级" prop="nianji">
          <el-input v-model="form.nianji" placeholder="请输入年级" />
        </el-form-item>
        <el-form-item label="学号" prop="nianji">
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
import { listTypefs, getTypefs, delTypefs, addTypefs, updateTypefs } from "@/api/air/typefs";

export default {
  name: "Typefs",
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
      // 课程信息表格数据
      typefsList: [],
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
    /** 查询课程信息列表 */
    getList() {
      this.loading = true;
      listTypefs(this.queryParams).then(response => {
        this.typefsList = response.rows;
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
        id: null,
        courseName: null,
        studentName: null,
        attendanceStatus: null,
        gradeName: null,
        xueyuan: null,
        nianji: null,
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加课程信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTypefs(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改课程信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTypefs(this.form).then(response => {
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
            addTypefs(formWithParams).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除课程信息编号为"' + ids + '"的数据项？').then(function() {
        return delTypefs(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('air/typefs/export', {
        ...this.queryParams
      }, `typefs_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
