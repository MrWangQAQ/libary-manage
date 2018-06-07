<template>
  <el-container style="background-color: #E9EEF3">
    <el-header>
      <Headers/>
    </el-header>
    <nav_select></nav_select>
    <el-main>
      <el-card class="box-card">
        <router-view/>
      </el-card>
    </el-main>
  </el-container>
</template>

<script>
  import Headers from  './Headers'
  import nav_select from './navSelect'

  export default {
    name: 'container',
    data () {
      return {
        openMenuIndex: '1-1'
      }
    },
    components: {
      nav_select,
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

  .box-card{
    width: 80%;
    margin: auto;
    margin-top: 50px;
    border: 3px solid #409eff;
    text-align: center;
  }
</style>
