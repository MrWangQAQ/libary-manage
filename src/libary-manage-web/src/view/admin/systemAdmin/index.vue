<template>
  <div class="systemAdmin">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>修改密码</span>
      </div>
      <el-form :model="passwordForm" :rules="rules" ref="passwordForm" label-width="100px" class="demo-ruleForm" style="width: 40%;margin: 0 auto">
        <el-form-item label="手机号码" >
          <el-input v-if="judgeChange" v-model="passwordForm.adminPhone"></el-input>
          <el-input v-else v-model="passwordForm.adminPhone" disabled></el-input>
        </el-form-item>
        <el-form-item label="邮箱" >
          <el-input  v-if="judgeChange" v-model="passwordForm.adminEmail"></el-input>
          <el-input v-else v-model="passwordForm.adminEmail" disabled></el-input>
        </el-form-item>
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
          <el-button type="info" @click="chanageSystemAdmin()" style="text-align: left">{{buttonType}}</el-button>
          <el-button v-if="!judgeChange" type="primary" @click="submitForm()">确认修改</el-button>
          <el-button v-else  type="primary" @click="changeData()">确认</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
  import {SysAdminManageApi} from './api'
  import {mapState} from 'vuex'
    export default {
        name: "systemAdmin",
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
          judgeChange: false,
          buttonType: '修改资料',
          passwordForm: {
            adminPhone: '',
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
      mounted: function(){
        this.initData()
      },
      methods: {
          initData: function () {
            SysAdminManageApi.getDataById(this.userInfo.id).then(res => {
              this.passwordForm.adminPhone = res.data.data.adminPhone
              this.passwordForm.adminEmail = res.data.data.adminEmail
            })
          },
          chanageSystemAdmin: function () {
            this.judgeChange = !this.judgeChange
            if(this.buttonType === "取消"){
              this.buttonType = "修改资料"
            } else {
              this.buttonType = "取消"
              this.$refs['passwordForm'].resetFields();
            }

          },
          changeData: function () {
            let array = {}
            array.id = this.userInfo.id
            array.adminPhone = this.passwordForm.adminPhone
            array.adminEmail = this.passwordForm.adminEmail
            SysAdminManageApi.editData(array).then(res => {
              if (res.data.status) {
                this.$message({
                  message: res.data.message,
                  type: 'success'
                })
              } else {
                this.$message.info(res.data.message)
                return false
              }
              this.chanageSystemAdmin()
            })
          },
          submitForm: function () {
            this.$refs['passwordForm'].validate(valid => {
              if (valid) {
                let array = {}
                array.id = this.userInfo.id
                for (var key in this.userInfo)
                {
                  if(key.search("assword") != -1){
                    array.truePassword = this.userInfo[key]
                  }
                }
                array.password = this.passwordForm.password
                array.newPassword = this.passwordForm.newPassword
                SysAdminManageApi.changePassword(array).then(res => {
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
          },
      }
    }
</script>

<style scoped>

</style>
