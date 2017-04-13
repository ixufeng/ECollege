/**
 * Created by xufeng on 2017/4/12.
 */
export default [{
  path:'/teacher/data',
  component: (resolve) => {
    require(['../view/teacher/Teacher.data.vue'],resolve)
  }
},{
  path:'/class',
  component: ( resolve ) => {
    require(['../view/teacher/Teacher.class.vue'],resolve)
  }
},{
  path:'/study',
  component: (resolve) => {
    require(['../view/teacher/Teacher.study.vue'],resolve) //老师科研页面
  }
},{
  path:'/honor',
  component: (resolve) => {
    require(['../view/teacher/Teacher.honor.vue'],resolve)  //老师荣誉墙页面
  }
}]

