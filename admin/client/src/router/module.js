export default [{
  path: '/dashboard',
  component: (resolve) => {
    require(['../view/Dashboard.vue'], resolve)
  }
}, {
  path: '/asset_list',
  component: (resolve) => {
    require(['../view/asset/AssetList.vue'], resolve)
  }
}, {
  path: '/asset_apply',
  component: (resolve) => {
    require(['../view/asset/AssetApply.vue'], resolve)
  }
},{
  path: '/asset_add',
  component: (resolve) => {
    require(['../view/asset/AssetNew.vue'], resolve)
  }
},{
  path: '/lab_list',
  component: (resolve) => {
    require(['../view/lab/LabList.vue'], resolve)
  }
},{
  path: '/lab_apply',
  component: (resolve) => {
    require(['../view/lab/LabApply.vue'], resolve)
  }
},{
  path: '/lab_add',
  component: (resolve) => {
    require(['../view/lab/LabNew.vue'], resolve)
  }
},{
  path: '/course_list',
  component: (resolve) => {
    require(['../view/course/CourseList.vue'], resolve)
  }
},{
  path: '/course_add',
  component: (resolve) => {
    require(['../view/course/CourseAdd.vue'], resolve)
  }
}]
