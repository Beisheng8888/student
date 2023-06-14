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
          v-hasPermi="['air:gerendanganat:add']"
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
          v-hasPermi="['air:gerendanganat:edit']"
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
          v-hasPermi="['air:gerendanganat:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['air:gerendanganat:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="gerendanganatList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="gender" />
      <el-table-column label="出生日期" align="center" prop="dateBirth" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dateBirth, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="身份证号" align="center" prop="idcardNumber" />
      <el-table-column label="家庭住址" align="center" prop="homeAddress" />
      <el-table-column label="联系电话" align="center" prop="contactNumber" />
      <el-table-column label="电子邮箱" align="center" prop="email" />
      <el-table-column label="存照" align="center" prop="avatar" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.avatar" :width="50" :height="50"/>
        </template>
      </el-table-column>
<!--      <el-table-column label="学制" align="center" prop="academicSystem" />-->
<!--      <el-table-column label="所属院系" align="center" prop="department" />-->
<!--      <el-table-column label="专业" align="center" prop="major" />-->
      <el-table-column label="是否存在违纪" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.wtwtw" :value="scope.row.type"/>
        </template>
      </el-table-column>
<!--      <el-table-column label="学科" align="center" prop="subject" />-->
<!--      <el-table-column label="成绩" align="center" prop="grade" />-->
<!--      <el-table-column label="绩点" align="center" prop="gpa" />-->
<!--      <el-table-column label="排名" align="center" prop="rank" />-->
      <el-table-column label="学分" align="center" prop="credits" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['air:gerendanganat:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['air:gerendanganat:remove']"
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

    <!-- 添加或修改学生档案维护对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="用户性别">
          <el-select v-model="form.sex" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期" prop="dateBirth">
          <el-date-picker clearable
            v-model="form.dateBirth"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="身份证号" prop="idcardNumber">
          <el-input v-model="form.idcardNumber" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="家庭住址" prop="homeAddress">
          <el-input v-model="form.homeAddress" placeholder="请输入家庭住址" />
        </el-form-item>
        <el-form-item label="联系电话" prop="contactNumber">
          <el-input v-model="form.contactNumber" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="电子邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入电子邮箱" />
        </el-form-item>
        <el-form-item label="存照" prop="avatar">
          <image-upload v-model="form.avatar"/>
        </el-form-item>
<!--        <el-form-item label="学制" prop="academicSystem">-->
<!--          <el-input v-model="form.academicSystem" placeholder="请输入学制" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="所属院系" prop="department">-->
<!--          <el-input v-model="form.department" placeholder="请输入所属院系" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="专业" prop="major">-->
<!--          <el-input v-model="form.major" placeholder="请输入专业" />-->
<!--        </el-form-item>-->
        <el-form-item label="是否存在违纪" prop="type">
          <el-select v-model="form.type" placeholder="请选择是否存在违纪">
            <el-option
              v-for="dict in dict.type.wtwtw"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学科" prop="subject">
          <el-input v-model="form.subject" placeholder="请输入学科" />
        </el-form-item>
        <el-form-item label="成绩" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入成绩" />
        </el-form-item>
        <el-form-item label="绩点" prop="gpa">
          <el-input v-model="form.gpa" placeholder="请输入绩点" />
        </el-form-item>
<!--        <el-form-item label="排名" prop="rank">-->
<!--          <el-input v-model="form.rank" placeholder="请输入排名" />-->
<!--        </el-form-item>-->
        <el-form-item label="学分" prop="credits">
          <el-input v-model="form.credits" placeholder="请输入学分" />
        </el-form-item>
        <el-form-item label="学号" prop="credits">
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
import { listGerendanganat, getGerendanganat, delGerendanganat, addGerendanganat, updateGerendanganat } from "@/api/air/gerendanganat";

export default {
  name: "Gerendanganat",
  dicts: ['wtwtw','sys_user_sex'],
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
      // 学生档案维护表格数据
      gerendanganatList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
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
    /** 查询学生档案维护列表 */
    getList() {
      this.loading = true;
      listGerendanganat(this.queryParams).then(response => {
        this.gerendanganatList = response.rows;
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
        name: null,
        gender: null,
        dateBirth: null,
        idcardNumber: null,
        homeAddress: null,
        contactNumber: null,
        email: null,
        avatar: null,
        academicSystem: null,
        department: null,
        major: null,
        type: null,
        subject: null,
        grade: null,
        gpa: null,
        rank: null,
        credits: null,
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
      this.title = "添加学生档案维护";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getGerendanganat(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学生档案维护";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateGerendanganat(this.form).then(response => {
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
            addGerendanganat(formWithParams).then(response => {

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
      this.$modal.confirm('是否确认删除学生档案维护编号为"' + ids + '"的数据项？').then(function() {
        return delGerendanganat(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('air/gerendanganat/export', {
        ...this.queryParams
      }, `gerendanganat_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
