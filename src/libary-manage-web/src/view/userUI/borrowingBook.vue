<template>
  <div class="borrowing-book">
    <div class="flagSign">已借: <span>{{max}}</span>本 剩余可借:
      <span>{{parseInt(max)-parseInt(pagination.total_count)}}</span>本</div>
    <div class="text item">
      <el-table align="center"
                :data="borrowData"
                stripe>
        <el-table-column
          prop="userNumber"
          label="学号"
          min-width="150">
        </el-table-column>
        <el-table-column
          prop="bookName"
          label="图书名称"
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
      </el-table>
      <pagination
        :page="pagination.page"
        :pageSize="pagination.page_size"
        :totalCount="pagination.total_count"
        @handleCurrentChange="changePage"
        @handleSizeChange="changePageSize"
      ></pagination>
    </div>
  </div>
</template>

<script>
  import {UserUIApi} from './api'
  import {mapState} from 'vuex'
  import pagination from '@/packages/components/pagination'
  export default {
    name: "borrowing-book",
    data() {
      return {
        borrowData: [],
        pagination: {
          page_size: '10', // 页面大小
          page: '1', // 当前页
          total_count: '10' // 总页数
        },
        max: ''
      }
    },
    components: {
      pagination
    },
    mounted() {
      this.initTableData()
      this.getUserInfo()
    },
    computed: mapState({
      userInfo: state => {
        return state.user.userInfo
      }
    }),
    methods: {
      initTableData: function () {
        let array = {}
        array.state = 1
        array.userNumber = this.userInfo.userNumber
        array.page = this.pagination.page
        array.pageSize = this.pagination.page_size
        UserUIApi.getBookByNumber(array).then(res => {
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
      },
      getUserInfo: function () {
        UserUIApi.selectUserInfoById(this.userInfo.id).then(res => {
          this.max = res.data.data.max
        })
      }
    }
  }
</script>

<style lang="scss" scoped>
  .flagSign{
    text-align: left;
    font-size: 17px;
    font-weight: bold;
    padding-bottom: 20px;
    span{
      color: rgb(64, 158, 255)
    }
  }
</style>
