<template>
  <el-container>
    <el-header>
      <Headers/>
    </el-header>
    <el-container>
      <navMenu></navMenu>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import navMenu from '../components/navMenu/nav'
  import Headers from './Headers'

  export default {
    name: 'container',
    data () {
      return {
        openMenuIndex: '1-1'
      }
    },
    components: {
      navMenu,
      Headers
    },
    methods: {},
    mounted () {
    }
  }

</script>

<style scoped lang="scss">
  .el-container {
    width: 100%;
    height: 100%;
  }

  .el-header, .el-footer {
    padding: 0;
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    padding: 0;
  }
  .el-aside{
    background-color: rgb(48, 65, 86);
  }

  body > .el-container {
    margin-bottom: 40px;
  }
</style>
