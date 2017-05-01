<template>
  <content-module name="dashboard">
      <header-nav></header-nav>
      <car-picture></car-picture>
      <lab-part></lab-part>
  </content-module>
</template>
<script>
  import CarPicture from '../components/carousel.vue'
  import HeaderNav from '../components/Header.nav.vue'
  import LabPart from './laboratory/LabPart.vue'
export default {
    components: {
        CarPicture,
        HeaderNav,
        LabPart
    },
    methods: {

    }

}
</script>
