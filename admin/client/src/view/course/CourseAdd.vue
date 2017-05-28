<template>
  <div style="width: 100%;">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item class="e_input" label="课程编号" prop="courseId">
        <el-input v-model="ruleForm.courseId"></el-input>
      </el-form-item>
      <el-form-item class="e_input" label="课程名称" prop="courseName">
        <el-input v-model="ruleForm.courseName"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  export default {
    data() {
      return {
        ruleForm: {
          courseName:'',
          courseId: '',
        },
        rules: {
          courseId: [
            { required: true, message: '请输入课程编号', trigger: 'blur' },
            { min: 3, max: 50, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          courseName: [
            { required: true, message: '请输入课程类型', trigger: 'blur' },
            { min: 3, max: 50, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            ajaxUtils.post("/api/course/add",this.ruleForm,result=> {
              if (result.code == 200) {
                this.$message.success("添加成功")
              }else {
                this.$message.error(result.message)
              }
            })
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>
<style>
  .e_input{
    width:900px;
  }
  .demo-ruleForm {
    margin-top: 30px;;
    margin-left: 50px;

  }


</style>
