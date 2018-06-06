<template>
  <div class="add-dialog">
    <el-dialog
      :title="dialog_title"
      :visible.sync="dialogVisible"
      width="620px"
      :before-close="onCancel"
      @open="initFormData">
      <el-form ref="form" :model="bookAdmin" label-width="120px" :rules="rules">
        <el-form-item label="姓名：" prop="adName">
          <el-input v-model="bookAdmin.adName" ></el-input>
        </el-form-item>
        <el-form-item label="电话：" prop="adPhone">
          <el-input v-model="bookAdmin.adPhone" ></el-input>
        </el-form-item>
        <el-form-item label="邮箱：">
          <el-input v-model="bookAdmin.admail" ></el-input>
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
  import {BookAdminManageApi} from './api'
    export default {
        name: 'add-dialog',
      data () {
          return {
            bookAdmin: {
              adName: '',
              adPhone: '',
              admail: ''
            },
            rules: {
              adName: [
                {required: true, message: '请输入用户名', trigger: 'blur'}
              ],
              adPhone: [
                {required: true, message: '请输入电话号码', trigger: 'blur'}
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
        bookAdminId: {
          type: Number,
          default: ''
        }
      },
      methods: {
        initFormData: function () {
          if (this.type === 'edit'){
            BookAdminManageApi.selectById(this.bookAdminId).then(res => {
              this.bookAdmin = res.data.data
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
          array.id = this.bookAdminId
          array.adName = this.bookAdmin.adName
          array.adPhone = this.bookAdmin.adPhone
          array.admail = this.bookAdmin.admail
          BookAdminManageApi.editById(array).then(res => {
            console.log(res.data.message)
            this.$parent.initTableData()
          })
        },
        Add: function () {
          let array = {}
          array.adName = this.bookAdmin.adName
          array.adPhone = this.bookAdmin.adPhone
          array.admail = this.bookAdmin.admail
          BookAdminManageApi.addBookAdmin(array).then(res => {
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
          this.bookAdmin.adName = ''
          this.bookAdmin.adPhone = ''
          this.bookAdmin.admail = ''
        }
      }
    }
</script>

<style scoped>

</style>
