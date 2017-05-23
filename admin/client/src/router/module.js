export default [{
  path: '/dashboard',
  component: (resolve) => {
    require(['../view/Dashboard.vue'], resolve)
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
},{
  path: '/asset_list',
  component: (resolve) => {
    require(['../view/AssetList.vue'], resolve)
  }
},{
  path: '/lab_list',
  component: (resolve) => {
    require(['../view/LabList.vue'], resolve)
  }
},{
  path: '/course_list',
  component: (resolve) => {
    require(['../view/CourseList.vue'], resolve)
  }
}]
