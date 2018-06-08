<template>
  <div class="borrow-book">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>读者借书</span>
      </div>
      <el-form ref="form" :model="search" label-width="120px">
        <el-form-item label="学号：" >
          <el-input v-model="search.userNumber" ></el-input>
          <span style="color: green" v-if="this.userInfo.userNumber">验证成功</span>
          <span style="color: red" v-else>验证失败</span>
        </el-form-item>
        <el-form-item label="图书编号：" prop="bookNumber">
          <el-input v-model="search.bookNumber" ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button  type="primary" @click="judgeUserNumber()">验证学号</el-button>
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
        <el-form-item label="学号：" v-if="book.state">
          <el-input v-model="book.userNumber" disabled></el-input>
        </el-form-item>
        <el-form-item label="是否借出：">
          <el-input v-if="book.state" value="否" disabled></el-input>
          <el-input v-else value="是" disabled></el-input>
        </el-form-item>
        <el-form-item>
          <el-button v-on:click="cancel()">取 消</el-button>
          <el-button v-if="book.state && judgeState" type="primary" @click="submit()">借 阅</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
  import {BorrowBookApi} from './api'
    export default {
      name: "borrow-book",
      data() {
        return {
          search: {
            bookNumber: '',
            userNumber: ''
          },
          userInfo: {},
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
          },
          judgeState: false
        }
      },

      methods: {
        judgeBookNumber: function () {
          if(this.search.bookNumber != ''){
            let array = {}
            array.bookNumber = this.search.bookNumber
            BorrowBookApi.getBook(array).then(res => {
              if(res.data.data != null){
                this.book = res.data.data
                this.book.userNumber = this.userInfo.userNumber
              }
            })
          }

        },
        judgeUserNumber: function () {
          if(this.search.userNumber != '') {
            let array = {}
            array.userNumber = this.search.userNumber
            array.state = '1'
            BorrowBookApi.judgeUser(array).then(res => {
              this.userInfo = res.data.data
              this.book.userNumber = res.data.data.userNumber
              if(res.data.data.max == res.data.totalCount){
                this.$message({
                  message: "此用户已达到最大借书量",
                  type: 'info'
                })
                this.judgeState = false
              } else{
                this.judgeState = true
              }
            })
          }
        },
        submit: function () {
          let date = new Date();//获取当前时间
          let array = {}
          array.userId = this.userInfo.userId
          array.bookId = this.book.id
          array.borrowTime = this.getCountTime(date, 0)
          array.shouldTime = this.getCountTime(date, this.userInfo.max)
          BorrowBookApi.borrowBook(array).then( res =>{
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
          this.search.userNumber = ''
          this.search.bookNumber = ''
          this.userInfo = {}
          this.book.id = ''
        },
        getCountTime: function(date, day){
          date.setDate(date.getDate()-day);//设置天数 -1 天
          let time = this.formatDate(date, "yyyy-MM-dd hh:mm:ss")
          return time
        },
        formatDate(date, fmt){
          if (/(y+)/.test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
               }
            let o = {
                  'M+': date.getMonth() + 1,
                  'd+': date.getDate(),
                  'h+': date.getHours(),
                  'm+': date.getMinutes(),
                  's+': date.getSeconds()
             }
             for (let k in o) {
                 if (new RegExp(`(${k})`).test(fmt)) {
                     let str = o[k] + ''
                    fmt = fmt.replace(RegExp.$1, RegExp.$1.length === 1 ? str : this.padLeftZero(str))
                   }
               }
             return fmt
        },
        padLeftZero (str) {
          return ('00' + str).substr(str.length);
        }
  }
  }
</script>

<style scoped>

</style>
