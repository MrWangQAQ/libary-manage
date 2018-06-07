<template>
  <div class="book-manage">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>图书管理</span>
      </div>
      <router-view/>
    </el-card>
  </div>
</template>

<script>
    export default {
        name: "book-manage"
    }
</script>

<style scoped>

</style>
