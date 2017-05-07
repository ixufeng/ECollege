export default [{
  path:'/student',
  component: (resolve) => {
    require(['../view/student/student.vue'],resolve)
  }
}]
