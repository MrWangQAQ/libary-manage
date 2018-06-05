<template>
  <el-pagination
    background
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
    :current-page="page"
    :page-size="pageSize"
    layout="total, sizes, prev, pager, next, jumper"
    :total="totalCount">
  </el-pagination>
</template>

<script>
  /**
   * 分页选择器
   */
  export default {
    name: 'pagination',
    data () {
      return {}
    },
    mounted () {
      // todo
    },
    props: {
      page: {
        type: Number,
        default () {
          return 1
        }
      },
      pageSize: {
        type: Number,
        default () {
          return 10
        },
      },
      totalCount: {
        type: Number,
        default () {
          return 100
        }
      }
    },
    methods: {
      /** 改变每页显示数量 */
      handleSizeChange (val) {
        this.$emit('handleSizeChange', val)
      },
      /** 改变页码 */
      handleCurrentChange (val) {
        this.$emit('handleCurrentChange', val)
      }
    }
  }
</script>

<style lang="scss" scoped>
  .content-body {
    margin-top: 30px;
  }

  .tableClassName {
    background-color: red;
  }
</style>
