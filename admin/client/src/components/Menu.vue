<template>
  <transition name="menu">
    <div id="app-menu">
      <router-link class="logo-wrapper" to="/" exact>学院信息后台管理</router-link>
      <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" theme="dark">
        <template v-for="item in menu">
          <el-submenu  v-if="item.hasChild" :index="item.index">
            <template slot="title">{{item.label}}</template>
              <el-menu-item v-for="child in item.child" :index="child.index">{{child.label}}</el-menu-item>
          </el-submenu>
          <el-menu-item v-if="!item.hasChild" :index="item.index">{{item.label}}</el-menu-item>
        </template>
      </el-menu>
    </div>
  </transition>
</template>
<script>
import { mapGetters } from 'vuex'
import store from '../store/index'
export default {
    data() {
        return {
            menu:[{
                label:'资产管理',
                icon:'',
                index:'1',
                child: [{
                  index:'1-0',
                  label:'资产总览',
                  link:'asset_list',
                },{
                    index:'1-1',
                    label:'申请审核',
                    link:'',
                },{
                    index:'1-2',
                    label:'新增资产',
                    link:''
                }],
                hasChild:true
            },{
                index:'2',
                label:'实验室管理',
                icon:'',
                hasChild:true,
                child:[{
                    index:'2-0',
                    label:'实验室总览',
                    link:'/lab_list'
                },{
                    index:'2-1',
                    label:'申请审核',
                    link:''
                },{
                    index:'2-2',
                    label:'实验室设置',
                    link:''
                },{
                  index:'2-3',
                  label:'新增实验室',
                  link:''
                }],
            },{
                index:3,
                label:'课程管理',
                icon:'',
                hasChild:true,
                child:[{
                    label:'课程总览',
                    index:'3-0',
                    link:'/course_list'
                },{
                  label:'新增课程',
                  index:'3-1',
                  link:''
                },{
                  label:'课程更改',
                  index:'3-2',
                  link:''
                }]
            },{
                index:4,
                label:'用户设置',
                icon:'',
                link:''
            }]
        }
    },

}
</script>
<style lang="stylus">
@import "../assets/css/variable"
.menu-enter-active
.menu-leave-active
  transition all .5s
.menu-enter
.menu-leave-active
  margin-left -($menu-width)
#app-menu
  width $menu-width
  min-width @width
  background-color $color-black-light
  overflow auto
  .logo-wrapper
    display block
    padding-left 1rem
    height $header-height
    line-height @height
    color #fff
    font-size 1.25rem
    background-color #435065
  > .menu
    margin 0
    padding 0
    list-style none
    .menu-item
      display block
      height 3.5rem
      line-height @height
      .menu-link
        display block
        padding-left 1.25rem
        color $color-silver-exact-light
        &:hover
          background-color $color-black-exact-light
        &.active
          color $color-primary
</style>
