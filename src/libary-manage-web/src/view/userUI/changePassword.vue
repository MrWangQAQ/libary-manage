<template>
  <div class="change-password">
    <el-form label-width="100px" :model="passwordForm" :rules="rules" ref="passwordForm" class="demo-ruleForm" style="width: 40%;margin: 0 auto">
      <el-form-item label="原密码" prop="password">
        <el-input v-if="judgeChange" type="password" v-model="passwordForm.password" disabled></el-input>
        <el-input v-else  type="password" v-model="passwordForm.password"></el-input>
      </el-form-item>
      <el-form-item label="新密码" prop="newPassword">
        <el-input v-if="judgeChange" type="password" v-model="passwordForm.newPassword" disabled></el-input>
        <el-input v-else type="password" v-model="passwordForm.newPassword"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="confirmPassword">
        <el-input v-if="judgeChange" type="password" v-model="passwordForm.confirmPassword" disabled></el-input>
        <el-input v-else type="password" v-model="passwordForm.confirmPassword"></el-input>
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
        name: "change-password",
      data() {
        let validatePass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'));
          } else if (value !== this.passwordForm.newPassword) {
            callback(new Error('两次输入密码不一致!'));
          } else {
            callback();
          }
        }
        return {
          passwordForm: {
            password: '',
            newPassword: '',
            passwordForm: ''
          },
          rules: {
            password: [
              {required: true, message: '请输入原密码', trigger: 'blur'}
            ],
            newPassword: [
              {required: true, message: '请输入新密码', trigger: 'blur'}
            ],
            confirmPassword: [
              {required: true,validator: validatePass, trigger: 'blur'}
            ]
          }
        }
      },
      computed: mapState({
        userInfo: state => {
          return state.user.userInfo
        }
      }),
      methods: {
        submitForm: function () {
          this.$refs['passwordForm'].validate(valid => {
            if (valid) {
              let array = {}
              array.id = this.userInfo.id
              array.truePassword = this.userInfo.password
              array.password = this.passwordForm.password
              array.newPassword = this.passwordForm.newPassword
              UserUIApi.changePassword(array).then(res => {
                if (res.data.status) {
                  this.$message({
                    message: res.data.message,
                    type: 'success'
                  })
                  this.$store.dispatch('accountLogoutSubmit').then(() => {
                    this.$router.push({path: '/login'})
                  }).catch(() => {
                  })
                } else {
                  this.$message.error(res.data.message)
                  return false
                }
              })
            } else {
              return false
            }
          })
        }
      }
    }
</script>

<style scoped>

</style>
