/**
 * Created by xufeng on 2017/4/12.
 */
export default [{
  path: '/teacher',
  component: (resolve) => {
    require(['../view/teacher/Teacher.vue'], resolve)
  }
}]
