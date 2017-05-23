<template>
    <div class="">
        <el-row>
            <el-col>
                <el-menu theme="dark" style="padding-left:30px;" :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
                  <el-menu-item index="1" @click="selectMenu(1)"> <router-link class="menu-link" to="/users"><i class="el-icon-menu"></i>&nbsp;&nbsp;资产管理</router-link></el-menu-item>
                  <el-menu-item index="2" @click="selectMenu(2)"> <router-link class="menu-link" to="/things"><i class="el-icon-menu"></i>&nbsp;&nbsp;实验室管理</router-link></el-menu-item>
                  <el-menu-item index="3" @click="selectMenu(3)"> <router-link class="menu-link" to="/things1"><i class="el-icon-menu"></i>&nbsp;&nbsp;课程管理</router-link></el-menu-item>
                  <el-menu-item index="4" @click="selectMenu(3)"> <router-link class="menu-link" to="/things2"><i class="el-icon-menu"></i>&nbsp;&nbsp;联系我们</router-link></el-menu-item>
                </el-menu>
                <div class="line"></div>
            </el-col>
        </el-row>
    </div>

</template>

<script>
import store from '../store/index'
export default {
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
  },
  selectMenu(index){
      store.commit('MENU',index)
  }
  }
}
</script>
