<template>
    <div class="userManageList">
      <div class="text item">
        <el-button style="float: left;" type="primary" @click="add()">新增</el-button>
        <el-table align="center"
                  :data="userData"
                  stripe>
          <el-table-column
            prop="userName"
            label="用户名"
            min-width="100">
          </el-table-column>
          <el-table-column
            prop="departments"
            label="学院"
            min-width="150">
          </el-table-column>
          <el-table-column
            prop="major"
            label="专业"
            min-width="100">
          </el-table-column>
          <el-table-column
            prop="phone"
            label="电话"
            min-width="180">
          </el-table-column>
          <el-table-column
            prop="email"
            label="邮箱"
            min-width="180">
          </el-table-column>
          <el-table-column
            prop="max"
            label="借阅上限"
            min-width="100">
          </el-table-column>
          <el-table-column
            prop="time"
            label="借阅期限"
            min-width="100">
          </el-table-column>
          <el-table-column
            prop="lendedNum"
            label="在借数量"
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
        <el-pagination class="page" style="margin-top:20px"
                       layout="prev, pager, next"
                       background
                       @current-change="changePage"
                       prev-text="上一页"
                       next-text="下一页"
                       :page-size="parseInt(pagination.page_size)"
                       :current-page="parseInt(pagination.page)"
                       :total="parseInt(pagination.total_count)">
        </el-pagination>
        <user_manage_dialog
          :dialog_title="dialog_title"
          :dialogVisible="dialogVisible"
          :type="type"
          :userId="userId"
          :userInfoId="userInfoId"
          @onCancel="onCancel"
          @submit="submit"
        ></user_manage_dialog>
      </div>
    </div>
</template>

<script>
  import {UserManageApi} from './api'
  import user_manage_dialog from './add-dialog'
    export default {
        name: 'userManageList',
      data () {
          return {
            userData: [],
            pagination: {
              page_size: '10', // 页面大小
              page: '1', // 当前页
              total_count: '10' // 总页数
            },
            /** 弹窗开关 */
            dialogVisible: false,
            dialog_title: '编辑版块',
            type: '',
            userId: '',
            userInfoId: ''
          }
      },
      components: {
        user_manage_dialog
      },
      mounted () {
        this.initTableData()
        this.initListTotal()
      },
      methods: {
        initTableData: function () {
          let array = {}
          array.page = '1'
          array.pageSize = '10'
          UserManageApi.getList(array).then(res => {
            this.userData = res.data.data
          })
        },
        initListTotal: function () {

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
          this.userId = row.userId
          this.userInfoId = row.id
        },
        Delete: function (row) {
          let array = {}
          array.userId = row.userId
          array.userInfoId = row.id
          UserManageApi.deleteUser(array).then(res => {
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
