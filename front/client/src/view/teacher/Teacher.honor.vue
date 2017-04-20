<template>
  <div style="width: 100%;">
    <e-avatar></e-avatar>
    <el-row>

        <el-col :span="20" :offset="2">
          <center>
            <h1 class="font">个人荣誉</h1>
          </center>
          <div>
            <span style="text-align: center;padding-left: 20px;">
              <el-button size="middle" type="success">时间</el-button>
              <el-button type="warning">访问</el-button>
              <el-select v-model="values" multiple placeholder="选择荣誉类型" style="margin-left: 10px;">
                <el-option
                  v-for="item in options"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </span>
          </div>
          <el-row>
            <el-col :span="4" v-for="(o, index) in 10" :offset="0" style="margin: 20px;">
              <el-card :body-style="{ padding: '0px' }">
                <img src="/static/abt.jpg" class="image">
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    <time class="time">{{ currentDate }}</time>
                    <el-button type="text" class="button">操作按钮</el-button>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-col>
    </el-row>

  </div>
</template>
<script>
  export default{
      data() {
          return{
            currentDate: new Date(),

            options: [{
              value: '选项1',
              label: '黄金糕'
            }, {
              value: '选项2',
              label: '双皮奶'
            }, {
              value: '选项3',
              label: '蚵仔煎'
            }, {
              value: '选项4',
              label: '龙须面'
            }, {
              value: '选项5',
              label: '北京烤鸭'
            }],
            values:[]
          }
      }
  }
</script>
<style>

  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

</style>
