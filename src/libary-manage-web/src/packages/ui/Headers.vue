<template>
  <div class="header">
    <h1 style="float: left;margin:0 200px">图书管理系统</h1>
    <el-dropdown @menu-item-click="click" style="float: right;margin-right: 50px">
      <span class="el-dropdown-link" style="font-size: 20px;color: white">{{userName}}<i class="el-icon-setting"></i></span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="out">退出登陆</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
export default {
  computed: {},
  data () {
    return {
      active: {
        'color': '#00b5ad',
        'border-bottom': '1px solid #00b5ad'
      },
      path: this.$route.path.split('/')[1],
      user: this.$store.getters.userInfo,
      userName: ''
    }
  },
  computed: mapState({
    userInfo: state => {
      return state.user.userInfo
    }
  }),
  mounted () {
    // todo
    this.judgeType()
  },
  methods: {
    judgeType: function () {
      for (var key in this.userInfo) {
        if (key.search("Name") != -1 || key.search("name") != -1) {
          this.userName = this.userInfo[key]
        }

      }
    },
    click (type) {
      if (type === 'out') {
        this.$store.dispatch('accountLogoutSubmit').then(() => {
          this.$router.push({path: '/login'})
        }).catch(() => {
        })
      }
    }
  },
  watch: {}
}
</script>

<style lang="scss" scoped>
  .header {
    border-bottom: #ddd solid 1px;
  }

  .head-left {
    line-height: 50px;
    .head-nav {
      padding-top: 1px;
      float: left;
      padding-left: 20px;
      color: #555;
      .head-link {
        color: #555;
      }
    }
  }
</style>
