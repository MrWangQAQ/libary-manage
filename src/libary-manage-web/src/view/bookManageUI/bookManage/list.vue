<template>
    <div class="bookManageList">
      <div class="text item">
        <el-button style="float: left;" type="primary" @click="add()">新增</el-button>
        <el-table align="center"
                  :data="bookData"
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
            min-width="100">
          </el-table-column>
          <el-table-column
            prop="publishCompany"
            label="出版社"
            min-width="100">
          </el-table-column>
          <el-table-column
            prop="state"
            label="是否借出"
            min-width="100">
          </el-table-column>
          <el-table-column
            prop="enteringMen"
            label="入库人"
            min-width="100">
          </el-table-column>
          <el-table-column
            prop="enteringDate"
            label="入库时间"
            min-width="100">
          </el-table-column>
          <el-table-column label="操作" min-width="200">
            <template slot-scope="scope">
              <el-button size="mini"
                         @click="tableOtherClick(scope.row, 'edit')" type="text">编辑</el-button>
              <el-button size="mini"
                         @click="tableOtherClick(scope.row, 'delete')" type="text" style="color: red">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <pagination
          :page="pagination.page"
          :pageSize="pagination.page_size"
          :totalCount="pagination.total_count"
          @handleCurrentChange="changePage"
          @handleSizeChange="changePageSize"
        ></pagination>
        <book_manage_dialog
          :dialog_title="dialog_title"
          :dialogVisible="dialogVisible"
          :type="type"
          :userId="bookId"
          @onCancel="onCancel"
          @submit="submit"
        ></book_manage_dialog>
      </div>
    </div>
</template>

<script>
  import {BookApi} from './api'
  import book_manage_dialog from './add-dialog'
  import pagination from '@/packages/components/pagination'
    export default {
        name: "bookManageList",
      data () {
        return {
          bookData: [],
          pagination: {
            page_size: '10', // 页面大小
            page: '1', // 当前页
            total_count: '10' // 总页数
          },
          /** 弹窗开关 */
          dialogVisible: false,
          dialog_title: '编辑',
          type: '',
          bookId: ''
        }
      },
      components: {
        book_manage_dialog,
        pagination
      },
      mounted () {
        this.initTableData()
      },
      methods: {
        initTableData: function () {
          let array = {}
          array.page = this.pagination.page
          array.pageSize = this.pagination.page_size
          BookApi.getList(array).then(res => {
            this.bookData = res.data.data
            this.pagination.total_count = res.data.totalCount
          })
        },
        changePage: function (page) {
          this.pagination.page = page
          this.initTableData()
        },
        changePageSize: function (pageSize) {
          this.pagination.page_size = pageSize
          this.initTableData()
        },
        tableOtherClick (row, type) {
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
        },
        Edit: function (row) {
          this.type = 'edit'
          this.dialog_title = '编辑读者'
          this.dialogVisible = true
          this.bookId = row.id
        },
        Delete: function (row) {
          BookApi.deleteBook(row.id).then(res => {
            console.log(res.data.message)
            this.initTableData()
          })
        },
        onCancel: function () {
          this.dialogVisible = false
        },
        submit: function () {
          this.dialogVisible = false
        },
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
