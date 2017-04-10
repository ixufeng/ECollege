<template>
  <div id="app-main">
    <div class="app-wrapper">
      <div class="app-container" :class="{active: false}">
        <router-view></router-view>
      </div>
      <n-progress parent=".app-wrapper"></n-progress>
    </div>
  </div>
</template>
<script>
import Vue from 'vue'
import XHeader from './components/Header'
import XMenu from './components/Menu'
import NProgress from './components/NProgress'
import ContentModule from './components/ContentModule'
import EFooter from './components/Footer'

Vue.component('EFooter',EFooter)
Vue.component('ContentModule', ContentModule)
export default {

  components: {
    XHeader,
    XMenu,
    NProgress
  }
}
</script>
<style lang="stylus">
@import "assets/css/variable"
@import "assets/css/animate"
@import "assets/fonts/iconfont.css"
@import "assets/css/flex"
::-webkit-scrollbar
  width 4px
  height 4px
  background-color $color-gray
::-webkit-scrollbar-button
::-webkit-scrollbar-track
  display none
::-webkit-scrollbar-thumb
  background-color $color-silver-light
::-webkit-scrollbar-thumb:hover
  background-color $color-black-exact-light

html
  font-size 16px
  font-family "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif
body
  margin 0
  padding 0
  font-size .75rem
  background-color #f0f0f0
/**
*::before
*::after
  box-sizing border-box*/
a
  text-decoration none
#app-main
  display flex
  width 100%
  height 100vh
  .app-wrapper
    flex 1
    display flex
    flex-flow column
    overflow-x hidden
    .app-container
      position relative
      flex 1
      display flex
      justify-content center
      margin 0
      padding 1rem
      background-color #fff
      overflow auto
      &.active
        margin 1rem

.el-dropdown-link
  cursor pointer
</style>
