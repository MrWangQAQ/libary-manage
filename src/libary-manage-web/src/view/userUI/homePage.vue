<template>
  <div class="home-page">
    <el-input style="width:auto;" v-model="search" placeholder="书名"></el-input>
    <el-button @click="searchData">搜 索</el-button>
    <div class="text item">
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
          prop="enteringDate"
          label="入库时间"
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
  import pagination from '@/packages/components/pagination'
  export default {
    name: "home-page",
    data () {
      return {
        bookData: [],
        pagination: {
          page_size: '10', // 页面大小
          page: '1', // 当前页
          total_count: '10' // 总页数
        },
        search: ''
      }
    },
    components: {
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
        array.bookName = this.search
        UserUIApi.getBookList(array).then(res => {
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
      searchData: function () {
        this.initTableData()
      }
    }
  }
</script>

<style scoped>

</style>
