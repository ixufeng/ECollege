const storage = window.localStorage
const session = window.sessionStorage
const USER_KEY = "collegeUser"
export function save (key, value) {
  storage.setItem(key, value)
}
export function setSessionUser(obj) {
  let str = JSON.stringify(obj)
  session.setItem(USER_KEY,str);
}

export function  getSessionUser() {
  let obj = session.getItem(USER_KEY);
  console.log(obj)
  if (obj!=null && obj!="undefined" && typeof obj != "undefined") {

    return JSON.parse(obj)
  }
  return null
}

export function saveMulti (datas) {
  datas.forEach(data => save(data.key, data.value))
}

export function read (key) {
  return storage.getItem(key)
}

export function readMulti (keys) {
  return keys.map(key => read(key))
}

export function clear (key, clearAll = false) {
  if (clearAll) {
    storage.clear()
  } else {
    storage.removeItem(key)
  }
}

export function clearMulti (keys) {
  keys.forEach(key => clear(key))
}
