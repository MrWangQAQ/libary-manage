<template>
  <div class="add-dialog">
    <el-dialog
      :title="dialog_title"
      :visible.sync="dialogVisible"
      width="620px"
      :before-close="onCancel"
      @open="initFormData">
      <el-form ref="form" :model="book" label-width="120px" :rules="rules">
        <el-form-item label="图书编号：" prop="bookNumber">
          <el-input v-model="book.bookNumber" ></el-input>
        </el-form-item>
        <el-form-item label="图书名称：" prop="bookName">
          <el-input v-model="book.bookName" ></el-input>
        </el-form-item>
        <el-form-item label="作者：" prop="author">
          <el-input v-model="book.author" ></el-input>
        </el-form-item>
        <el-form-item label="译者：">
          <el-input v-model="book.translator" ></el-input>
        </el-form-item>
        <el-form-item label="ISBM编码：" prop="isbnCode">
          <el-input v-model="book.isbnCode" ></el-input>
        </el-form-item>
        <el-form-item label="出版日期：" prop="comeupTime">
          <el-date-picker
            v-model="book.comeupTime"
            type="datetime"
            style="width:100%"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出版社：" prop="publishCompany">
          <el-input v-model="book.publishCompany" ></el-input>
        </el-form-item>
        <el-form-item v-if="type == 'edit'" label="是否借出：" style="text-align: left">
          <el-radio-group v-model="book.state" >
            <el-radio :label="true">是</el-radio>
            <el-radio :label="false">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item v-if="type == 'edit'" label="入库者：">
          <el-input v-model="book.enteringMen" disabled></el-input>
        </el-form-item>
        <el-form-item v-if="type == 'edit'" label="入库日期：">
          <el-input v-model="book.enteringDate" disabled></el-input>
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
  import {BookApi} from './api'
  import {mapState} from 'vuex'
    export default {
        name: "add-dialog",
      data () {
        return {
          book: {
            bookNumber: '',
            bookName: '',
            author: '',
            translator: '',
            isbnCode: '',
            comeupTime: '',
            publishCompany: '',
            state: false,
            enteringMen: '',
            enteringDate: ''
          },
          rules: {
            bookNumber: [
              {required: true, message: '请输入图书编号', trigger: 'blur'}
            ],
            bookName: [
              {required: true, message: '请输入图书名称', trigger: 'blur'}
            ],
            author: [
              {required: true, message: '请输入作者', trigger: 'blur'}
            ],
            isbnCode: [
              {required: true, message: '请输入ISBN编码', trigger: 'blur'}
            ],
            comeupTime: [
              {required: true, message: '请输入出版日期', trigger: 'blur'}
            ],
            publishCompany: [
              {required: true, message: '请输入出版社', trigger: 'blur'}
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
        bookId: {
          type: Number,
          default: ''
        }
      },
      computed: mapState({
        userInfo: state => {
          return state.user.userInfo
        }
      }),
      methods: {
        initFormData: function () {
          if (this.type === 'edit'){
            BookApi.selectBookById(this.bookId).then(res => {
              this.book = res.data.data
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
          array.id = this.bookId
          array.bookNumber = this.book.bookNumber
          array.bookName = this.book.bookName
          array.author = this.book.author
          array.translator = this.book.translator
          array.isbnCode = this.book.isbnCode
          array.comeupTime = this.book.comeupTime
          array.publishCompany = this.book.publishCompany
          array.state = this.book.state
          array.enteringMen = this.book.enteringMen
          array.enteringDate = this.book.enteringDate
          BookApi.editBook(array).then(res => {
            console.log(res.data.message)
            this.$parent.initTableData()
          })
        },
        Add: function () {
          let array = {}
          array.bookNumber = this.book.bookNumber
          array.bookName = this.book.bookName
          array.author = this.book.author
          array.translator = this.book.translator
          array.isbnCode = this.book.isbnCode
          array.comeupTime = this.book.comeupTime
          array.publishCompany = this.book.publishCompany
          array.state = 1
          array.enteringMen = this.userInfo.adName
          BookApi.addBook(array).then(res => {
            console.log(res.data.message)
            this.$parent.initTableData()
          })
        },
        onCancel() {
          this.$refs['form'].resetFields();
          this.$emit('onCancel')
          this.clearData()
        },
        clearData: function () {
          this.book.bookNumber = ''
          this.book.bookName = ''
          this.book.author = ''
          this.book.translator = ''
          this.book.isbnCode = ''
          this.book.comeupTime = ''
          this.book.publishCompany = ''
          this.book.state = ''
        }
      }
    }
</script>

<style scoped>

</style>
