<template>
    <div class="change-information">
      <el-form :model="user" ref="user" label-width="100px" class="demo-ruleForm" style="width: 40%;margin: 0 auto">
        <el-form-item label="电话">
          <el-input  v-model="user.phone"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="user.email"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm()">确认修改</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
  import {UserUIApi} from './api'
  import {mapState} from 'vuex'
    export default {
        name: "change-information",
      data() {
        return {
          user: {
            phone: '',
            email: '',
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
        },
        submitForm: function () {
          let array = {}
          array.id = this.userInfo.id
          array.phone = this.user.phone
          array.email = this.user.email
          UserUIApi.changeInformation(array).then(res =>{
            if (res.data.status) {
              this.$message({
                message: res.data.message,
                type: 'success'
              })
            } else {
              this.$message.info(res.data.message)
              return false
            }
          })
        }
      }
    }
</script>

<style scoped>

</style>
