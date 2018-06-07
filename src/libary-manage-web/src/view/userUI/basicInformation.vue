<template>
    <div class="basic-information">
      <el-form :model="user" ref="user" label-width="100px" class="demo-ruleForm" style="width: 40%;margin: 0 auto">
        <el-form-item label="学号" >
          <el-input v-model="user.userNumber" disabled></el-input>
        </el-form-item>
        <el-form-item label="姓名" >
          <el-input v-model="user.userName" disabled></el-input>
        </el-form-item>
        <el-form-item label="学院">
          <el-input v-model="user.departments" disabled></el-input>
        </el-form-item>
        <el-form-item label="专业">
          <el-input  v-model="user.major" disabled></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input  v-model="user.phone" disabled></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="user.email" disabled></el-input>
        </el-form-item>
        <el-form-item label="借阅上限" >
          <el-input  v-model="user.max" disabled></el-input>
        </el-form-item>
        <el-form-item label="借阅期限">
          <el-input  v-model="user.time" disabled></el-input>
        </el-form-item>
        <el-form-item label="已借数量">
          <el-input v-model="user.lendedNum" disabled></el-input>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
  import {UserUIApi} from './api'
  import {mapState} from 'vuex'
    export default {
        name: "basic-information",
      data() {
          return {
            user: {
              userName: '',
              userNumber: '',
              departments: '',
              major: '',
              phone: '',
              email: '',
              max: '',
              time: '',
              lendedNum: ''
            }
          }
      },
      computed: mapState({
        userInfo: state => {
          return state.user.userInfo
        }
      }),
      mounted: function(){
        this.initData()
      },
      methods: {
        initData: function () {
          UserUIApi.selectUserInfoById(this.userInfo.id).then(res =>{
            this.user = res.data.data
          })
        }
      }
    }
</script>

<style scoped>

</style>
