<template>
    <div class="back-book">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>读者还书</span>
        </div>
        <el-form ref="form" :model="search" label-width="120px">
          <el-form-item label="图书编号：" prop="bookNumber">
            <el-input v-model="search.bookNumber" ></el-input>
            <span style="color: green" v-if="this.book.id">验证成功</span>
            <span style="color: red" v-else>验证失败</span>
          </el-form-item>
          <el-form-item>
            <el-button  type="primary" @click="judgeBookNumber()">验证图书编号</el-button>
          </el-form-item>
        </el-form>
        <el-form v-if="book.id" ref="form" :model="book" label-width="120px">
          <el-form-item label="图书编号：">
            <el-input v-model="book.bookNumber" disabled></el-input>
          </el-form-item>
          <el-form-item label="图书名称：">
            <el-input v-model="book.bookName" disabled></el-input>
          </el-form-item>
          <el-form-item label="作者：">
            <el-input v-model="book.author" disabled></el-input>
          </el-form-item>
          <el-form-item label="译者：">
            <el-input v-model="book.translator" disabled></el-input>
          </el-form-item>
          <el-form-item label="ISBM编码：">
            <el-input v-model="book.isbnCode" disabled></el-input>
          </el-form-item>
          <el-form-item label="出库社">
            <el-input v-model="book.publishCompany" disabled></el-input>
          </el-form-item>
          <el-form-item label="出版日期：">
            <el-input v-model="book.comeupTime" disabled></el-input>
          </el-form-item>
          <el-form-item label="入库者：">
            <el-input v-model="book.enteringMen" disabled></el-input>
          </el-form-item>
          <el-form-item label="是否借出：">
            <el-input v-if="book.state" value="否" disabled></el-input>
            <el-input v-else value="是" disabled></el-input>
          </el-form-item>
          <el-form-item>
            <el-button v-on:click="cancel()">取 消</el-button>
            <el-button v-if="!this.book.state" type="primary" @click="submit()">归 还</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </div>
</template>

<script>
  import {BorrowBookApi} from './api'
    export default {
        name: "back-book",
      data() {
        return {
          search: {
            bookNumber: ''
          },
          book: {
            id: '',
            bookNumber: '',
            bookName: '',
            author: '',
            translator: '',
            isbnCode: '',
            comeupTime: '',
            publishCompany: '',
            enteringMen: '',
            userNumber: ''
          }
        }
      },

      methods: {
        judgeBookNumber: function () {
          if (this.search.bookNumber != '') {
            let array = {}
            array.bookNumber = this.search.bookNumber
            BorrowBookApi.getBook(array).then(res => {
              if (res.data.data != null) {
                this.book = res.data.data
              }
            })
          }

        },
        submit: function () {
          let array = {}
          array.bookId = this.book.id
          BorrowBookApi.backBook(array).then(res => {
            if (res.data.status) {
              this.$message({
                message: res.data.message,
                type: 'success'
              })
              this.cancel()
            } else {
              this.$message.error(res.data.message)
              return false
            }
          })
        },
        cancel: function () {
          this.search.bookNumber = ''
          this.book.id = ''
        }
      }
    }
</script>

<style scoped>

</style>
