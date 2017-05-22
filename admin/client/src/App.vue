
<template>
  <div id="app-main">
     <x-menu></x-menu>
    <div class="app-wrapper">
        <my-header></my-header>
      <div class="app-container" :class="{active: true}">
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
import Header from './components/Header.vue'
import MyHeader from './components/Header1.vue'



import Rate from './components/Rate.vue'


import Table0 from './components/Table0.vue'
import Table1 from './components/Table1.vue'
import Table2 from './components/Table2.vue'
import Table3 from './components/Table3.vue'
import Table4 from './components/Table4.vue'
import Table5 from './components/Table5.vue'

import GysForm from './components/GysForm.vue'

import pie1 from './components/Pie1.vue'
import pie2 from './components/Pie2.vue'
import Pie3 from './components/Pie3.vue'

import sandian from './components/sandian.vue'


Vue.component('EFooter',EFooter)
Vue.component('ContentModule', ContentModule)
Vue.component('EHeader',Header)

Vue.component('GysForm',GysForm)
Vue.component('Rate',Rate)


Vue.component('Table0',Table0)
Vue.component('Table1',Table1)
Vue.component('Table2',Table2)
Vue.component('Table3',Table3)
Vue.component('Table4',Table4)
Vue.component('Table5',Table5)


Vue.component('Pie',pie1)
Vue.component('Pie2',pie2)
Vue.component('Pie3',Pie3)

Vue.component('sandian',sandian)







export default {

  components: {
    XHeader,
    XMenu,
    NProgress,
    MyHeader
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
      padding 0rem
      background-color #fff
      overflow auto
      &.active
        margin 1rem

.el-dropdown-link
  cursor pointer
</style>
