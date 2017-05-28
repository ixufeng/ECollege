<template>
    <div style="width: 100%;">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="资产名称" prop="name">
          <el-input class="e_input" v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item class="e_input" label="资产编号" prop="id">
          <el-input v-model="ruleForm.id"></el-input>
        </el-form-item>
        <el-form-item class="e_input" label="资产类型" prop="type">
          <el-input v-model="ruleForm.type"></el-input>
        </el-form-item>
        <el-form-item class="e_input" label="资产模型" prop="model">
          <el-input v-model="ruleForm.model"></el-input>
        </el-form-item>
        <el-form-item class="e_input" label="厂家" prop="factoryName">
          <el-input v-model="ruleForm.factoryName"></el-input>
        </el-form-item>
        <el-form-item class="e_input" label="价格" prop="price">
          <el-input type="number" v-model="ruleForm.price"></el-input>
        </el-form-item>
        <el-form-item label="国籍" prop="region">
          <el-select v-model="ruleForm.nation" placeholder="请选择活动区域">
            <el-option label="中国" value="中国"></el-option>
            <el-option label="美国" value="美国"></el-option>
            <el-option label="日本" value="日本"></el-option>
            <el-option label="西班牙" value="西班牙"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="购买时间" required>
          <el-col :span="11">
            <el-form-item prop="buyTime">
              <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.buyTime" style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="出厂日期" required>
          <el-col :span="11">
            <el-form-item prop="incoming">
              <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.incoming" style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="入库" prop="delivery">
          <el-switch on-text="" off-text="" v-model="ruleForm.delivery"></el-switch>
        </el-form-item>
        <el-form-item label="资产描述" prop="des">
          <el-input class="e_input" type="textarea" v-model="ruleForm.des"></el-input>
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
          id:'',
          name: '',
          model:'',
          nation: '',
          buyTime: '',
          incoming:'',
          price:0,
          factoryName:'',
          delivery: false,
          type:'',
          resource: '',
          des: ''
        },
        rules: {
          name: [
            { required: true, message: '请输入活动名称', trigger: 'blur' },
            { min: 3, max: 50, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          id: [
            { required: true, message: '请输入活动名称', trigger: 'blur' },
            { min: 3, max: 50, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          model: [
            { required: true, message: '请输入活动名称', trigger: 'blur' },
            { min: 3, max: 50, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '请输入活动名称', trigger: 'blur' },
            { min: 3, max: 50, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          nation: [
            { required: true, message: '请选择国籍', trigger: 'change' }
          ],
          buyTime: [
            { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
          ],
          incoming: [
            { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
          ],
          des: [
            { required: true, message: '请填写活动形式', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
              ajaxUtils.post("/api/asset/add",this.ruleForm,result=> {
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
