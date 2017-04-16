<template>
    <el-tabs type="border-card">
      <el-tab-pane>
        <span slot="label"><i class="iconfont icon-guanliyuan"></i> 登陆</span>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="活动名称">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-from-item>
            <el-input v-model="form.password"></el-input>
          </el-from-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane>
        <span slot="label"><i class="iconfont icon-guanliyuan"></i>找回密码</span>
      </el-tab-pane>
    </el-tabs>
</template>
<script>
  export default {
      data() {
          return {
              form: {
                  name:'',
                  password:'',
                  checkWord:''
              }
          }
      }
  }

</script>

<style>

</style>
