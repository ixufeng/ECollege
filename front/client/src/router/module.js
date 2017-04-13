export default [{
  path: '/index',
  component: (resolve) => {
    require(['../view/index.vue'], resolve)
  }
}, {
  path: '/users',
  component: (resolve) => {
    require(['../view/UserList.vue'], resolve)
  }
}, {
  path: '/things',
  component: (resolve) => {
    require(['../view/ThingList.vue'], resolve)
  }
}]
