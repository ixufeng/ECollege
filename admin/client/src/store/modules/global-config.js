import { read, save } from '../../storage'
import { STORE_KEY_CONFIG_PAGE_LIMIT } from '../../constants'

const state = {
  pageLimit: 20,
  menu:1
}

const mutations = {
     UPDATE (state, config) {
        state.pageLimit = config.pageLimit || state.pageLimit
    },
    MENU(state,index) {
        state.menu = index
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
  menuIndex(state) {
      return state.menu
  }
}

export default {
  state,
  mutations,
  actions,
  getters
}
