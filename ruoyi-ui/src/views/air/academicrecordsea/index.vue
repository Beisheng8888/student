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
          v-hasPermi="['air:academicrecordsea:add']"
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
          v-hasPermi="['air:academicrecordsea:edit']"
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
          v-hasPermi="['air:academicrecordsea:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['air:academicrecordsea:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="academicrecordseaList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学生姓名" align="center" prop="studentName" />
      <el-table-column label="课程姓名" align="center" prop="courseName" />
      <el-table-column label="成绩" align="center " prop="grade" />
      <el-table-column label="班级排名" align="center" prop="classRank" />
      <el-table-column label="绩点" align="center" prop="gpa" />
      <el-table-column label="班级" align="center" prop="aclass" />
      <el-table-column label="用户编号" align="center" prop="userId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['air:academicrecordsea:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['air:academicrecordsea:remove']"
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

    <!-- 添加或修改学籍成绩对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">

        <el-form-item label="账号" prop="studentName">
          <el-input v-model="form.userId" placeholder="请输入学生账号" />
        </el-form-item>
        <el-form-item label="课程姓名" prop="courseName">
          <el-input v-model="form.courseName" placeholder="请输入课程姓名" />
        </el-form-item>
        <el-form-item label="成绩" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入成绩" />
        </el-form-item>
        <el-form-item label="班级排名" prop="classRank">
          <el-input v-model="form.classRank" placeholder="请输入班级排名" />
        </el-form-item>
        <el-form-item label="绩点" prop="gpa">
          <el-input v-model="form.gpa" placeholder="请输入绩点" />

        </el-form-item>
        <el-form-item label="班级" prop="aclss">
          <el-input v-model="form.aclass" placeholder="请输入班级" />
        </el-form-item>
        <el-form-item label="姓名" prop="aclss">
          <el-input v-model="form.name" placeholder="请输入姓名" />
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
import { listAcademicrecordsea, getAcademicrecordsea, delAcademicrecordsea, addAcademicrecordsea, updateAcademicrecordsea } from "@/api/air/academicrecordsea";

export default {
  name: "Academicrecordsea",
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
      // 学籍成绩表格数据
      academicrecordseaList: [],
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
    /** 查询学籍成绩列表 */
    getList() {

      this.loading = true;
      listAcademicrecordsea(this.queryParams).then(response => {

        this.academicrecordseaList = response.rows;
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
        courseName: null,
        grade: null,
        classRank: null,
        gpa: null,
        userId: null,
        aclass: null
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
      this.title = "添加学籍成绩";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recordID = row.recordID || this.ids
      getAcademicrecordsea(recordID).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学籍成绩";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.recordID != null) {
            updateAcademicrecordsea(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAcademicrecordsea(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除学籍成绩编号为"' + recordIDs + '"的数据项？').then(function() {
        return delAcademicrecordsea(recordIDs);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('air/academicrecordsea/export', {
        ...this.queryParams
      }, `academicrecordsea_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
