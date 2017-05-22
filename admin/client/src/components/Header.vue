<template>
  <transition name="header">
    <header id="header">
      <h1></h1>
      <div class="nav">
        <el-dropdown trigger="click">
          <span class="el-dropdown-link">
            {{user.name}}&nbsp;<i class="el-icon-caret-bottom el-icon-right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="showConfig">用户设置</el-dropdown-item>
            <el-dropdown-item @click.native="password.visible=true">修改密码</el-dropdown-item>
            <el-dropdown-item @click.native="doLogout">退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
      <!-- user settings -->
      <el-dialog title="用户设置" v-model="config.visible" size="small"
        top="4%" @close="cancelConfig">
        <el-form class="noline" ref="config" label-position="top"
          :model="config.form" :rules="config.rules">
          <el-form-item label="语言" prop="locale">
            <el-select v-model="config.form.locale">
              <el-option label="简体中文(zh_CN)" value="zh_CN"></el-option>
              <el-option label="English(en_US)" value="en_US"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="每页条目数" prop="pageLimit">
            <el-slider v-model="config.form.pageLimit" :min="1" :max="100" show-input></el-slider>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click.native="config.visible=false">确 定</el-button>
          <el-button type="primary" @click.native="saveConfig">确 定</el-button>
        </span>
      </el-dialog>
      <!-- change password -->
      <el-dialog title="修改密码" v-model="password.visible" size="small" @close="cancelPassword">
        <el-form label-position="top" :model="password.form"
          :rules="password.rules" ref="password">
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="旧密码" prop="oldPassword">
                <el-input type="password" v-model="password.form.oldPassword"/>
              </el-form-item>
              <el-form-item label="新密码" prop="password">
                <el-input type="password" v-model="password.form.password"/>
              </el-form-item>
              <el-form-item label="确认新密码" prop="confirmPassword">
                <el-input type="password" v-model="password.form.confirmPassword"/>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="描述">
                <div>修改你的密码。强烈建议您选择一个复杂密码。</div>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click.native="password.visible=false">取 消</el-button>
          <el-button type="primary" @click.native="changePassword">确 定</el-button>
        </span>
      </el-dialog>
    </header>
  </transition>
</template>
<script>
import { merge } from 'lodash'
import { mapGetters, mapActions } from 'vuex'
export default {
  data () {
    return {
      config: {
        visible: false,
        form: {
          locale: '',
          pageLimit: 10
        },
        rules: {
          locale: [{ required: true }],
          pageLimit: [{ type: 'number', required: true }]
        }
      },
      password: {
        visible: false,
        form: {
          oldPassword: '',
          password: '',
          confirmPassword: ''
        },
        rules: {
          oldPassword: [{
            required: true, message: '请输入旧密码', trigger: 'blur'
          }],
          password: [{
            required: true, message: '请输入新密码', trigger: 'blur'
          }],
          confirmPassword: [{
            required: true, message: '请再次确认新密码', trigger: 'blur'
          }, {
            trigger: 'blur', message: '两次输入的新密码不一致', validator: (rule, value, callback) => {
              if (value !== this.password.form.password) {
                callback(new Error(rule.message))
              } else {
                callback()
              }
            }
          }]
        }
      }
    }
  },

  methods: {
    doLogout () {
      this.logout().then(() => {
        this.$router.push('/login')
      })
    },
    showConfig () {
      this.config.visible = true
    },
    cancelConfig () {
      this.config.form.locale = this.globalConfig.locale
      this.config.form.pageLimit = this.globalConfig.pageLimit
      this.config.visible = false
    },
    saveConfig () {
      this.updateGlobalConfig(this.config.form)
      this.config.visible = false
      this.$message.success('已保存！')
    },
    cancelPassword () {
      this.$refs.password.resetFields()
      merge(this.password.form, {
        oldPassword: '',
        password: '',
        confirmPassword: ''
      })
      this.password.visible = false
    },
    changePassword () {

    }
  },
  computed:{
     ...mapGetters([
         'user'
     ])

  },
  created () {
      console.log(this.$store.state.name)
  }
}
</script>
<style lang="stylus">
@import "../assets/css/variable"
.header-enter-active
.header-leave-active
  transition all .5s
.header-enter
.header-leave-active
  margin-top -($header-height)
#header
  display flex
  flex-direction row
  align-items center
  justify-content space-between
  padding 0 1rem
  background-color $color-white
  h1
    float left
    height $header-height
    line-height @height
    margin 0
    font-weight normal
    > a
      color #fff
  .nav
    float right
    margin 0
    padding 0
</style>
