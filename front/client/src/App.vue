<template>
  <div id="app-main">
    <div class="app-wrapper">
      <e-header></e-header>
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

import EHeader from './components/Header1.vue'

Vue.component('EFooter',EFooter)
Vue.component('ContentModule', ContentModule)
Vue.component('EHeader',EHeader)
export default {

  components: {
    XHeader,
    XMenu,
    NProgress
  }
}
</script>
<style lang="stylus">
@import "assets/css/variable.styl";
@import "assets/css/animate.styl";
@import "assets/fonts/iconfont.css";
@import "assets/css/flex.styl";
@import "//at.alicdn.com/t/font_czxhzytwhnxqd7vi.css";

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
  height 100%
  .app-wrapper
    flex 1
    display flex
    flex-flow column
    overflow-x hidden
    min-width 1000px;
    .app-container
      position relative
      flex 1
      display flex
      justify-content center
      margin 0
      padding 0rem
      background-color #fff
      overflow auto
      &.active
        margin 1rem

.el-dropdown-link
  cursor pointer
</style>
