/**
 * App router config
 */
import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store'
import teacher from './teacher'

Vue.use(VueRouter)

const routes = [{
  path: '/',
  component: (resolve) => {
    require(['../view/index.vue'], resolve)
  },
  meta: {
    skipAuth: true
  }
},{
  path:'/index',
  component: (resolve) => {
    require(['../view/index.vue'], resolve)
  }
},...teacher,{
  path: '*',
    component: {
    render (h) {
      return h('div', { staticClass: 'flex flex-main-center', attrs: { style: 'width:100%;font-size:32px' }}, 'Page not found')
    }
  }
}]

const router = new VueRouter({
  mode: 'history',
  linkActiveClass: 'active',
  scrollBehavior: () => ({ y: 0 }),
  routes
})

// router

router.beforeEach((to, from, next) => {
  // 确保用户身份信息已获取
    store.dispatch('changeRouteLoading', true).then(() => {
      if (!to.meta.skipAuth) {
        if (!store.getters.isLogin) {
            store.commit("SHOW_LOGIN",true)
        } else {
          next()
        }
      } else {
        next()
      }
    })
})

router.afterEach(() => {
  store.dispatch('changeRouteLoading', false)
})

export default router
