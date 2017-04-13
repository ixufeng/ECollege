<template>
  <div style="width: 100%;">
      <el-row style="width: 100%;height: 120px; background: #2c333d;">
        <el-col :span="2" :offset="11">
          <div style="width: 100%;text-align: center">
            <img class="avatar-middle" style="" :src="Teacher.avatar">
          </div>
        </el-col>
      </el-row>
    <el-row style="width: 100%;background: #2c333d;padding-bottom: 30px">
      <el-col :span="10" :offset="7">
        <el-autocomplete style="width: 100%"
          v-model="suggestions"
          :fetch-suggestions="querySearchAsync"
          placeholder="Search Everything"
          @select="handleSelect"
        ></el-autocomplete>
      </el-col>
    </el-row>
  </div>


</template>
<script>
  export default {
      data() {
          return {
              Teacher: {
               avatar: "/static/co.png",
             },
            suggestions: []
          }
      },
    methods: {
      querySearchAsync() {
          return null;
      },
      handleSelect() {

      }
    }
  }
</script>
<style>

  .avatar-middle {
    width:80px;
    height:80px;
    border-radius: 40px;
  }


</style>
