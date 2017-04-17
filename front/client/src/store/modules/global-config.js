import { STORE_KEY_CONFIG_PAGE_LIMIT } from '../../constants'

const state = {
  pageLimit: 20,
  showHeader:true,
  showFooter:true
}

const mutations = {
  UPDATE (state, config) {
    state.pageLimit = config.pageLimit || state.pageLimit
  },
  SHOW_HEADER (state,flag){
    state.showHeader = !!flag
  },
  SHOW_FOOTER (state,flag) {
    state.showFooter = !!flag
  },
  LOGIN_PAGE(state,flag) {
    state.showFooter = !!flag
    state.showHeader = !!flag
  }

}

const actions = {
  initGlobalConfig ({ commit, dispatch, state }) {
    commit('UPDATE', {
      pageLimit: +read(STORE_KEY_CONFIG_PAGE_LIMIT)
    })
  },
  updateGlobalConfig ({ commit, state, dispatch }, config) {
    commit('UPDATE', config)
    save(STORE_KEY_CONFIG_PAGE_LIMIT, state.pageLimit)
  }
}

const getters = {
  globalConfig (state) {
    return state
  },
  showHeader (state) {
    return state.showHeader
  },
  showFooter (state) {
    return state.showFooter
  }
}

export default {
  state,
  mutations,
  actions,
  getters
}
