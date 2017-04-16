const state = {
  login: false,
  user:{

  }
}

const mutations = {
  LOGIN (state, user) {
   state.login = true
    state.user = user
  },
  UN_LOGIN (state) {
    state.login = false
    state.user = null;
  }
}

const actions = {
  changeRouteLoading ({ commit }, status) {
    commit('CHANGE', status)
  }
}

const getters = {
 isLogin(state) {
   return state.login
 },
 getUser(state) {
   if (state.login) {
     return null
   }
   return state.user
 }
}

export default {
  state,
  mutations,
  actions,
  getters
}
