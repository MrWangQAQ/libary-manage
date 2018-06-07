<template>
  <el-menu
    style="width: auto; margin: auto;font-weight: bold;margin-top: 50px;border: 1px solid #D4D5D6 "
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#FFF"
    text-color="#54586A"
    active-text-color="#409eff">
    <el-menu-item index="1">基本资料</el-menu-item>
    <el-menu-item index="2">修改资料</el-menu-item>
    <el-menu-item index="3">修改密码</el-menu-item>
    <el-menu-item index="4">在借图书</el-menu-item>
    <el-menu-item index="5">借阅记录</el-menu-item>
  </el-menu>

</template>

<script>
    export default {
        name: "nav-select",
      data() {
        return {
          activeIndex: '1',
          activeIndex2: '1'
        };
      },
    }
</script>

<style scoped>

</style>
