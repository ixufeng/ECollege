/**
 * Created by xufeng on 2017/4/12.
 */
export default [{
  path:'/teacher',
  component: (resolve) => {
    require(['../view/teacher/Teacher.vue'],resolve)
  }
},{
  path:'/teacher/data',
  component: (resolve) => {
    require(['../view/teacher/Teacher.data.vue'],resolve) //老师个人资料
  }
},{
  path:'/teacher/class',
  component: ( resolve ) => {
    require(['../view/teacher/Teacher.class.vue'],resolve) //老师历史课程
  }
},{
  path:'/teacher/study',
  component: (resolve) => {
    require(['../view/teacher/Teacher.study.vue'],resolve) //老师科研页面
  }
},{
  path:'/teacher/honor',
  component: (resolve) => {
    require(['../view/teacher/Teacher.honor.vue'],resolve)  //老师荣誉墙页面
  }
}]
