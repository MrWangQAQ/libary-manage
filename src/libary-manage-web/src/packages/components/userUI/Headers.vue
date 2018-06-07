<template>
  <div class="header" style="background-color: #409eff">
    <el-row>
      <el-col :span="8" style="text-align: left;padding-left: 80px;">
        <router-link class="head-link head-fontSize hoverHead" to=""><i class="el-icon-menu"></i>首页</router-link>
      </el-col>
      <el-col :span="8"><span class="head-fontSize">个人中心</span></el-col>
      <el-col :span="8" style="text-align: right;padding-right: 40px;">
        <span class="head-fontSize">{{userInfo.userName}}</span>
        <span class="head-fontSize hoverHead" @click="outAcount">退出</span>
      </el-col>
    </el-row>
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
  },
  methods: {
    outAcount: function () {
      this.$store.dispatch('accountLogoutSubmit').then(() => {
        this.$router.push({path: '/login'})
      }).catch(() => {
      })
    }
  },
  watch: {}
}
</script>

<style lang="scss" scoped>
  .header {
    border-bottom: #ddd solid 1px;
  }

  .head-link{
    text-decoration: none;
  }

  .head-fontSize {
    font-size: 17px;
    color: #FFF;
    font-weight: bold;
    cursor: pointer;
  }

  .hoverHead:hover{
    color: #1e553e
  }
</style>
