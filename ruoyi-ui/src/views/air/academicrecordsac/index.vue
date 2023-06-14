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
          v-hasPermi="['air:academicrecordsac:add']"
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
          v-hasPermi="['air:academicrecordsac:edit']"
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
          v-hasPermi="['air:academicrecordsac:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['air:academicrecordsac:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="academicrecordsacList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学科" align="center" prop="subject" />
      <el-table-column label="成绩" align="center" prop="grade" />
      <el-table-column label="绩点" align="center" prop="gpa" />
      <el-table-column label="排名" align="center" prop="rank" />
      <el-table-column label="学分" align="center" prop="credits" />
      <el-table-column label="学生姓名" align="center" prop="studentName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['air:academicrecordsac:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['air:academicrecordsac:remove']"
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

    <!-- 添加或修改学习情况对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学科" prop="subject">
          <el-input v-model="form.subject" placeholder="请输入学科" />
        </el-form-item>
        <el-form-item label="成绩" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入成绩" />
        </el-form-item>
        <el-form-item label="绩点" prop="gpa">
          <el-input v-model="form.gpa" placeholder="请输入绩点" />
        </el-form-item>
        <el-form-item label="排名" prop="rank">
          <el-input v-model="form.rank" placeholder="请输入排名" />
        </el-form-item>
        <el-form-item label="学分" prop="credits">
          <el-input v-model="form.credits" placeholder="请输入学分" />
        </el-form-item>
        <el-form-item label="学生姓名" prop="studentName">
          <el-input v-model="form.studentName" placeholder="请输入学生姓名" />
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
import { listAcademicrecordsac, getAcademicrecordsac, delAcademicrecordsac, addAcademicrecordsac, updateAcademicrecordsac } from "@/api/air/academicrecordsac";

export default {
  name: "Academicrecordsac",
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
      // 学习情况表格数据
      academicrecordsacList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentName: null
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
    /** 查询学习情况列表 */
    getList() {
      this.loading = true;
      listAcademicrecordsac(this.queryParams).then(response => {
        this.academicrecordsacList = response.rows;
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
        studentID: null,
        subject: null,
        grade: null,
        gpa: null,
        rank: null,
        credits: null,
        userId: null,
        studentName: null
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
      this.ids = selection.map(item => item.studentID)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学习情况";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const studentID = row.studentID || this.ids
      getAcademicrecordsac(studentID).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学习情况";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.studentID != null) {
            updateAcademicrecordsac(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAcademicrecordsac(this.form).then(response => {
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
      const studentIDs = row.studentID || this.ids;
      this.$modal.confirm('是否确认删除学习情况编号为"' + studentIDs + '"的数据项？').then(function() {
        return delAcademicrecordsac(studentIDs);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('air/academicrecordsac/export', {
        ...this.queryParams
      }, `academicrecordsac_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
