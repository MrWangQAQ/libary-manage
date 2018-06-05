<template>
  <div class="add-dialog">
    <el-dialog
      :title="dialog_title"
      :visible.sync="dialogVisible"
      width="620px"
      :before-close="onCancel"
      @open="initFormData">
      <el-form ref="form" :model="user" label-width="120px" :rules="rules">
        <el-form-item label="姓名：" prop="userName">
          <el-input v-model="user.userName" ></el-input>
        </el-form-item>
        <el-form-item label="学号：" prop="userNumber">
          <el-input v-model="user.userNumber" ></el-input>
        </el-form-item>
        <el-form-item label="学院：" prop="departments">
          <el-input v-model="user.departments" ></el-input>
        </el-form-item>
        <el-form-item label="专业：" prop="major">
          <el-input v-model="user.major" ></el-input>
        </el-form-item>
        <el-form-item label="电话：" >
          <el-input v-model="user.phone" ></el-input>
        </el-form-item>
        <el-form-item label="邮箱：" >
          <el-input v-model="user.email" ></el-input>
        </el-form-item>
        <el-form-item label="借阅上限：" prop="max">
          <el-input v-model="user.max" ></el-input>
        </el-form-item>
        <el-form-item label="借阅期限：" prop="time">
          <el-input v-model="user.time" ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button v-on:click="onCancel()">取 消</el-button>
        <el-button type="primary" @click="submit()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import {UserManageApi} from './api'
    export default {
        name: 'add-dialog',
      data () {
          return {
            user: {
              userName: '',
              userNumber: '',
              departments: '',
              major: '',
              phone: '',
              email: '',
              max: '',
              time: ''
            },
            rules: {
              userName: [
                {required: true, message: '请输入姓名', trigger: 'blur'}
              ],
              userNumber: [
                {required: true, message: '请输入学号', trigger: 'blur'}
              ],
              departments: [
                {required: true, message: '请输入学院', trigger: 'blur'}
              ],
              major: [
                {required: true, message: '请输入专业', trigger: 'blur'}
              ],
              max: [
                {required: true, message: '请输入可借最大数量', trigger: 'blur'}
              ],
              time: [
                {required: true, message: '请输入可借期限', trigger: 'blur'}
              ]
            }
          }
      },
      props: {
        dialogVisible: {
          type: Boolean,
          default () {
            return false
          }
        },
        dialog_title: {
          type: String,
          default: ''
        },
        type: {
          type: String,
          default: ''
        },
        userId: {
          type: Number,
          default: ''
        },
        userInfoId: {
          type: Number,
          default: ''
        }
      },
      methods: {
        initFormData: function () {
          if (this.type === 'edit'){
            UserManageApi.selectUserInfoById(this.userId).then(res => {
              this.user = res.data.data
            })
          }

        },
        handleClose(done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
            })
            .catch(_ => {});
        },
        submit: function () {
          this.$refs['form'].validate(valid => {
            if (valid) {
              if (this.type === 'edit'){
                this.Edit()
              }
              if (this.type === 'add'){
                this.Add()
              }
              this. onCancel()
            } else {
              return false
            }
          })
        },
        Edit: function () {
          let array = {}
          array.userId = this.userId
          array.userInfoId = this.userInfoId
          array.userName = this.user.userName
          array.userNumber = this.user.userNumber
          array.departments = this.user.departments
          array.major = this.user.major
          array.phone = this.user.phone
          array.email = this.user.email
          array.max = this.user.max
          array.time = this.user.time
          UserManageApi.editUser(array).then(res => {
            console.log(res.data.message)
            this.$parent.initTableData()
          })
        },
        Add: function () {
          let array = {}
          array.userName = this.user.userName
          array.userNumber = this.user.userNumber
          array.departments = this.user.departments
          array.major = this.user.major
          array.phone = this.user.phone
          array.email = this.user.email
          array.max = this.user.max
          array.time = this.user.time
          UserManageApi.add(array).then(res => {
            console.log(res.data.message)
            this.$parent.initTableData()
          })
        },
        onCancel(formName) {
          this.$refs['form'].resetFields();
          this.clearData()
          this.$emit('onCancel')
        },
        clearData: function () {
          this.user.userName = ''
          this.user.userNumber = ''
          this.user.departments = ''
          this.user.major = ''
          this.user.phone = ''
          this.user.email = ''
          this.user.max = ''
          this.user.time = ''
        }
      }
    }
</script>

<style scoped>

</style>
