<template>
  <transition name="menu">
    <div id="app-menu">
      <router-link class="logo-wrapper" to="/" exact>药物订单管理系统</router-link>
      <ul class="menu">
        <li v-for="item in currentMenu" class="menu-item">
          <span class="menu-link"><i class="el-icon-menu"></i>&nbsp;&nbsp;{{item.label}}</span>
        </li>
      </ul>
    </div>
  </transition>
</template>
<script>
import { mapGetters } from 'vuex'
import store from '../store/index'
export default {
    data() {
        return {
            menu:{
                menu1:[{
                    label:'人员查询',
                    icon:'',

                },{
                    label:'人员查询',
                    icon:'',

                },{
                    label:'人员查询',
                    icon:'',

                }],
                menu2:[{
                    label:'药品查询',
                    icon:'',

                },{
                    label:'药品订单',
                    icon:'',

                }],
                menu3:[{
                    label:'xxx',
                    icon:'',

                },{
                    label:'sss',
                    icon:'',

                },{
                    label:'xxx',
                    icon:'',

                }]
            }
        }
    },
   computed: {
       currentMenu: function(){
           let index = "menu" + store.getters.menuIndex
           return this.menu[index]
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
