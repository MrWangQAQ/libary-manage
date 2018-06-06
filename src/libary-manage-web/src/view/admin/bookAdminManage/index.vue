<template>
  <div class="bookAdminManage">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>图书管理员管理</span>
      </div>
      <router-view/>
    </el-card>
  </div>
</template>

<script>
    export default {
        name: "bookAdminManage"
    }
</script>

<style scoped>

</style>
