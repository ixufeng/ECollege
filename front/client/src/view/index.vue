<template>
  <content-module name="dashboard">
      <header-nav></header-nav>
      <car-picture></car-picture>
  </content-module>
</template>
<script>
  import CarPicture from '../components/carousel.vue'
  import HeaderNav from '../components/Header.nav.vue'
export default {

    components: {
        CarPicture,
        HeaderNav
    },
    methods: {

    }

}
</script>
