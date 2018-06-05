<template>
  <div class="header">
    <h1 style="margin: 0;color: white">图书管理系统</h1>
    <div></div>
  </div>
</template>

<script>
export default {
  computed: {},
  data () {
    return {
      active: {
        'color': '#00b5ad',
        'border-bottom': '1px solid #00b5ad'
      },
      path: this.$route.path.split('/')[1]
    }
  },
  mounted () {
    // todo
  },
  methods: {},
  watch: {}
}
</script>

<style lang="scss" scoped>
  .header {
    border-bottom: #ddd solid 1px;
  }

  .head-left {
    line-height: 50px;
    .head-nav {
      padding-top: 1px;
      float: left;
      padding-left: 20px;
      color: #555;
      .head-link {
        color: #555;
      }
    }
  }
</style>
