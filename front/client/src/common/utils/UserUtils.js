import {getSessionUser} from '../../storage/index'
let userUtils = {}
userUtils.isTeacher = () => {
  let teacher = getSessionUser()
  if ( !teacher || !teacher.id || teacher.id!=8) {
    return false
  }
  return teacher
}
userUtils.isStudent = () => {
  let student = getSessionUser()
  if ( !student || !student.id || student.id!=10) {
    return false
  }
  return student
}
export  default  userUtils
