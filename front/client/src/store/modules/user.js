
const state = {
  showLogin:false
}

const mutations = {
  SHOW_LOGIN(state,flag) {
      state.showLogin = !!flag
  }
}

const getters = {
  showLogin(state) {
    return state.showLogin
  }
}

export default {
  state,
  mutations,
  getters
}
