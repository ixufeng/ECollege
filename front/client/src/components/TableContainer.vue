<template>
    <div id="table" style="width: 100%;height: 100%;">
        <div id="table-header">
          <slot name="header"></slot>
        </div>
        <div id="table-body">
            <slot name="table-body"></slot>
        </div>
    </div>
</template>
<script>

</script>
<style>
  #table{
    border:1px solid #999;
  }
  #table-header{
    height: 30px;
    border: 0px;
  }
  #table-body{
    border-top: 1px solid #999;
  }
</style>
