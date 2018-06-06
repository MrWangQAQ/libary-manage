<template>
  <div class="bookAdminManageList">
    <div class="text item">
      <el-button style="float: left;" type="primary" @click="add()">新增</el-button>
      <el-table align="center"
                :data="tableData"
                stripe>
        <el-table-column
          prop="adName"
          label="用户名"
          min-width="100">
        </el-table-column>
        <el-table-column
          prop="adPhone"
          label="电话"
          min-width="180">
        </el-table-column>
        <el-table-column
          prop="admail"
          label="邮箱"
          min-width="180">
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
      <book_admin_dialog
        :dialog_title="dialog_title"
        :dialogVisible="dialogVisible"
        :bookAdminId="bookAdminId"
        :type="type"
        @onCancel="onCancel"
        @submit="submit"
      ></book_admin_dialog>
    </div>
  </div>
</template>

<script>
  import {BookAdminManageApi} from './api'
  import book_admin_dialog from './add-dialog'
  import pagination from '@/packages/components/pagination'
    export default {
        name: "bookAdminManageList",
      data () {
        return {
          tableData: [],
          pagination: {
            page_size: '10', // 页面大小
            page: '1', // 当前页
            total_count: '10' // 总页数
          },
          /** 弹窗开关 */
          dialogVisible: false,
          dialog_title: '编辑',
          type: 'add',
          bookAdminId: ''
        }
      },
      components: {
        book_admin_dialog,
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
          BookAdminManageApi.getList(array).then(res => {
            this.tableData = res.data.data
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
          this.bookAdminId = row.id
        },
        Delete: function (row) {
          let array = {}
          array.id = row.id
          BookAdminManageApi.deleteById(array).then(res => {
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
          this.dialog_title = '新增读者'
          this.dialogVisible = true
        }
      }
    }
</script>

<style scoped>

</style>
