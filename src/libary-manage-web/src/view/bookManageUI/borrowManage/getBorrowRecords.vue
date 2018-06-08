<template>
    <div class="get-borrow-records">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>借阅记录查看</span>
        </div>
        <div class="text item">
          <el-input style="width:auto;" v-model="search" placeholder="图书编号/图书名/借阅号"></el-input>
          <el-button @click="searchData">搜 索</el-button>
          <el-table align="center"
                    :data="borrowData"
                    stripe>
            <el-table-column
              prop="bookNumber"
              label="图书编号"
              min-width="100">
            </el-table-column>
            <el-table-column
              prop="bookName"
              label="图书名称"
              min-width="150">
            </el-table-column>
            <el-table-column
              prop="author"
              label="作者"
              min-width="100">
            </el-table-column>
            <el-table-column
              prop="translator"
              label="译者"
              min-width="180">
            </el-table-column>
            <el-table-column
              prop="isbnCode"
              label="ISBN编码"
              min-width="180">
            </el-table-column>
            <el-table-column
              prop="comeupTime"
              label="出版日期"
              min-width="150">
            </el-table-column>
            <el-table-column
              prop="publishCompany"
              label="出版社"
              min-width="100">
            </el-table-column>
            <el-table-column
              label="是否借出"
              min-width="100">
              <template slot-scope="scope">
                <p v-if="status">是</p>
                <p v-else>否</p>
              </template>
            </el-table-column>
            <el-table-column
              prop="enteringMen"
              label="入库人"
              min-width="100">
            </el-table-column>
            <el-table-column
              prop="userNumber"
              label="学号"
              min-width="150">
            </el-table-column>
            <el-table-column
              prop="borrowTime"
              label="借阅日期"
              min-width="150">
            </el-table-column>
            <el-table-column
              prop="shouldTime"
              label="应还日期"
              min-width="150">
            </el-table-column>
            <el-table-column
              prop="returnTime"
              label="实还日期"
              min-width="150">
            </el-table-column>
          </el-table>
          <pagination
            :page="pagination.page"
            :pageSize="pagination.page_size"
            :totalCount="pagination.total_count"
            @handleCurrentChange="changePage"
            @handleSizeChange="changePageSize"
          ></pagination>
        </div>
      </el-card>
    </div>
</template>

<script>
  import {BorrowBookApi} from './api'
  import pagination from '@/packages/components/pagination'
  export default {
    name: "get-borrow-records",
    data() {
      return {
        search: '',
        borrowData: [],
        pagination: {
          page_size: '10', // 页面大小
          page: '1', // 当前页
          total_count: '10' // 总页数
        },
      }
    },
    components: {
      pagination
    },
    mounted() {
      this.initTableData()
    },
    methods: {
      initTableData: function () {
        let array = {}
        array.search = ''
        array.page = this.pagination.page
        array.pageSize = this.pagination.page_size
        BorrowBookApi.getAllList(array).then(res => {
          this.borrowData = res.data.data
          this.pagination.total_count = res.data.totalCount
        })
      },
      searchData: function () {
        let array = {}
        array.search = this.search
        array.page = this.pagination.page
        array.pageSize = this.pagination.page_size
        BorrowBookApi.getAllList(array).then(res => {
          this.borrowData = res.data.data
          this.pagination.total_count = res.data.totalCount
        })
      },
      changePage: function (page) {
        this.pagination.page = page
        this.initTableData()
      }
      ,
      changePageSize: function (pageSize) {
        this.pagination.page_size = pageSize
        this.initTableData()
      }
      ,
      tableOtherClick(row, type) {
        if (type === 'edit') {
          this.Edit(row)
        } else {
          this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.Delete(row)
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            })
          })
        }
      }
      ,
      Edit: function (row) {
        this.type = 'edit'
        this.dialog_title = '编辑读者'
        this.dialogVisible = true
        this.bookId = row.id
      }
      ,
      Delete: function (row) {
        BookApi.deleteBook(row.id).then(res => {
          console.log(res.data.message)
          this.initTableData()
        })
      }
      ,
      onCancel: function () {
        this.dialogVisible = false
      }
      ,
      submit: function () {
        this.dialogVisible = false
      }
      ,
      add: function () {
        this.type = 'add'
        this.dialog_title = '图书入库'
        this.dialogVisible = true
      }
    }
  }
</script>

<style scoped>

</style>
