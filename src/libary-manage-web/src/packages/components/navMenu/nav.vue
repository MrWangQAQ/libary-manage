<template>
  <el-aside width="200px">
    <el-menu :default-openeds="['1']" :default-active="openMenuIndex"
             background-color="rgb(48, 65, 86)"
             text-color="rgb(191, 203, 217)"
             active-text-color="white">
        <el-menu-item-group>
          <router-link class="head-link" to="/admin">
            <el-menu-item index="1-1">
              <i class="el-icon-star-on"></i>
              <span slot="title">首页</span>
            </el-menu-item>
          </router-link>
          <router-link v-if="userInfo.adminName"  class="head-link" to="/admin/userManage">
            <el-menu-item index="1-2">
              <i class="el-icon-edit-outline"></i>
              <span slot="title">读者管理</span>
            </el-menu-item>
          </router-link>
          <router-link v-if="userInfo.adminName"  class="head-link" to="/admin/bookAdminManage">
            <el-menu-item index="1-3">
              <i class="el-icon-mobile-phone"></i>
              <span slot="title">图书管理员管理</span>
            </el-menu-item>
          </router-link>
          <router-link v-if="userInfo.adminName"  class="head-link" to="/admin/systemAdmin">
            <el-menu-item index="1-4">
              <i class="el-icon-mobile-phone"></i>
              <span slot="title">修改密码</span>
            </el-menu-item>
          </router-link>
        </el-menu-item-group>
    </el-menu>
  </el-aside>
</template>

<script>
  import {mapState} from 'vuex'
    export default {
      name: 'nav',
      data () {
        return {
          openMenuIndex: '1-1',
          type: ''
        }
      },
      computed: mapState({
        userInfo: state => {
          return state.user.userInfo
        }
      }),
      methods: {
        judgeType: function () {

        }
      },
      mounted () {
      }
    }
</script>
<style scoped lang="scss">
  .head-link{
    text-decoration: none;
  }
  .el-menu-item{
    text-align: left;
  }
  .el-menu{
    border: 0;
  }
  .el-menu-item:hover{
    background-color: cadetblue !important;
  }
</style>
