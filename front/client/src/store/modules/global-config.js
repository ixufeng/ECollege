import { read, save } from '../../storage'
import { STORE_KEY_CONFIG_PAGE_LIMIT } from '../../constants'

const state = {
  pageLimit: 20
}

const mutations = {
  UPDATE (state, config) {
    state.pageLimit = config.pageLimit || state.pageLimit
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
  }
}

export default {
  state,
  mutations,
  actions,
  getters
}
