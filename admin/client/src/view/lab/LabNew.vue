<template>
  <div style="width: 100%;">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item class="e_input" label="实验室标号" prop="roomNumber">
        <el-input v-model="ruleForm.roomNumber"></el-input>
      </el-form-item>
      <el-form-item class="e_input" label="实验室类型" prop="roomType">
        <el-input v-model="ruleForm.roomType"></el-input>
      </el-form-item>
      <el-form-item class="e_input" label="实验室描述" prop="des">
        <el-input v-model="ruleForm.des"></el-input>
      </el-form-item>
      <el-form-item class="e_input" label="使用次数" prop="useCount">
        <el-input type="number" v-model="ruleForm.useCount"></el-input>
      </el-form-item>
      <el-form-item label="投入日期" required>
        <el-col :span="11">
          <el-form-item prop="beginTime">
            <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.beginTime" style="width: 100%;"></el-date-picker>
          </el-form-item>
        </el-col>
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
          roomNumber:'',
          roomType: '',
          beginTime:'',
          useCount:0,
          des: ''
        },
        rules: {
          roomNumber: [
            { required: true, message: '请输入实验室编号', trigger: 'blur' },
            { min: 3, max: 50, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          roomType: [
            { required: true, message: '请输入实验室类型', trigger: 'blur' },
            { min: 3, max: 50, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          beginTime: [
            { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
          ],
          des: [
            { required: true, message: '请填写实验室详情', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            ajaxUtils.post("/api/lab/add",this.ruleForm,result=> {
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
