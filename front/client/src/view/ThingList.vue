<template>
  <content-module name="things">

  </content-module>
</template>
<script>
export default {
  data () {

  },
  methods: {

  },
  created () {
    //this.fetch()
  }
}
</script>
<style lang="stylus" scoped>
@import "../assets/css/variable"
.box-card
  display inline-block
  width 20rem
  height 15rem
  margin .5rem
  .icon
    float right
    margin-left .5rem
    color $color-silver
    cursor pointer
    &:hover
      color $color-primary
</style>
