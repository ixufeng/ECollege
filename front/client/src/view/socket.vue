<template>
  <div>
    <el-button>测试发送消息</el-button>
  </div>

</template>
<script>
  export default {
      data() {
          return {
            socket:null
          }
      },
      methods: {

      },
      mounted() {
        if ('WebSocket' in window) {
            this.socket = new WebSocket("ws://localhost:8082/api/ws")
        } else if ('MozWebSocket' in window) {
          this.socket = new MozWebSocket("ws://localhost:8082/api/ws")
        } else {
          //this.socket = new SockJS("http://" + path + "/ws/sockjs"+uid);
        }
        this.socket.onopen = function (event) {
            console.log("连接打开")
            console.log(event)
        }
        this.socket.onerror = function(event) {
          console.log("WebSocket:发生错误 ");
          console.log(event);
        };
        this.socket.onclose = function(event) {
          console.log("WebSocket:已关闭");
          console.log(event);
        }
        this.socket.onmessage = function(event) {

          console.log("message")

        };
        console.log(this.socket)

      }
  }
</script>
