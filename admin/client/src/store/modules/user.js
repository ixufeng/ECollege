const state = {
  isLogin: false,
  admin:{}
}


const getters = {
   loggedIn(state) {
    return state.isLogin
  }
}

export default {
  state,
  getters
}
