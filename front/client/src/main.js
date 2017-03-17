import Vue from 'vue'
// router and store
import store from './store'
import router from './router'
import { sync } from 'vuex-router-sync'
sync(store, router)

// ui library
import Element from 'element-ui'
Vue.use(Element)

// ajax
import './http'

// main component
import App from './App'

const app = new Vue({
  router,
  store,
  ...App // Object spread copying everything from App.vue
})
// actually mount to DOM
app.$mount('#app')
