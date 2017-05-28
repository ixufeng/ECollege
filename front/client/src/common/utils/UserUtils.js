import {getSessionUser} from '../../storage/index'
let userUtils = {}
userUtils.isTeacher = () => {
  let teacher = getSessionUser()
  if ( !teacher || !teacher.id ||teacher.id.length != 8) {
    return false
  }
  return teacher
}
userUtils.isStudent = () => {
  let student = getSessionUser()
  if ( !student || !student.id || student.id.length != 10) {
    return false
  }
  return student
}
userUtils.isLogin = ()=> {
    return userUtils.isTeacher()?userUtils.isTeacher():userUtils.isStudent()
}
export  default  userUtils
