<template>
  <el-menu
    style="width: auto; margin: auto;font-weight: bold;margin-top: 50px;border: 1px solid #D4D5D6;margin-bottom: 50px; "
    :default-active="activeIndex"
    class="nav-select"
    mode="horizontal"
    @select="handleSelect"
    background-color="#FFF"
    text-color="#54586A"
    router="true"
    active-text-color="#409eff">
    <el-menu-item index="/userUI">基本资料</el-menu-item>
    <el-menu-item index="/userUI/changeInformation">修改资料</el-menu-item>
    <el-menu-item index="/userUI/changePassword">修改密码</el-menu-item>
    <el-menu-item index="/userUI/borrowingBook">在借图书</el-menu-item>
    <el-menu-item index="/userUI/borrowedRecord">借阅记录</el-menu-item>
  </el-menu>

</template>

<script>
    export default {
        name: "nav-select",
      data() {
        return {
          activeIndex: '/userUI',
        };
      },
    }
</script>
<style>

  .nav-select{
    display: inline-flex;
  }
</style>

<style lang="scss" scoped>
  .head-link{
    text-decoration: none;
  }
</style>
