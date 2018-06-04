<template>
  <div class="header">
    <h1 style="margin: 0;">图书管理系统</h1>
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

  .head-right {
    line-height: 50px;
    .head-nav-login {
      padding-top: 1px;
      padding-left: 30px;
      float: right;
    }
  }

  .icon {
    text-decoration: none;
    font-weight: bold;
    font-size: 25px;
    text-align: left;
  }

  .bg-purple-dark {
    background: #fff;
  }

  .grid-content {
    min-height: 50px;
  }

  .this-login {
    color: #555;
    font-weight: 600;
  }

  .this-login:hover {
    color: #00b5ad;
    border-bottom: 2px solid #00b5ad;
    margin-bottom: -2px;
  }

  .search-input {
    background-repeat: no-repeat;
    background-position: 9px;
    background-color: #f1f1f1;
    padding-left: 25px;
    border: 0px solid #c6c6c6;
    box-shadow: none;
    transition: all 0.15s ease-in 0.1s;
    margin-top: 1px;
    height: 35px;
    width: 200px;
    border-radius: 100px;
  }

  .search-input:focus,
  .search-input:hover,
  .search-input:active {
    border-radius: 100px;
    box-shadow: none;
    border: 0px solid #c6c6c6;
    background: no-repeat 0 0 scroll #f1f1f1;
    border: none;
    outline: medium;
  }

  .dropbtn {
    float: right;
    color: #555;
    font-size: 16px;
    font-weight: bold;
    border: none;
    cursor: pointer;
    padding-left: 50px;
  }

  .dropdown {
    padding-left: 20px;
    float: right;
    position: relative;
    display: inline-block;
  }

  .dropdown-content {
    z-index: 1;
    margin-top: 50px;
    font-size: 15px;
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 4px 8px 0px rgba(0, 0, 0, 0.2);
  }

  .dropdown-content a {
    padding-left: 30px;
    color: black;
    text-decoration: none;
    display: block;
    border: 1px solid #eee;
  }

  .dropdown-content a:hover {
    cursor: pointer;
    background-color: #f1f1f1;
    color: #00b5ad;
  }

  .dropdown:hover .dropdown-content {
    display: block;
  }

  .dropdown:hover .dropbtn {
    background-color: #fff;
  }

  img {
    position: absolute;
    width: 40px;
    border: 1px solid #aaa;
    border-radius: 100px;
    margin-top: 5px;
  }

  #btn-topic {
    background-color: tomato;
    font-size: 16px;
    padding: 10px 20px 10px 20px;
    border-radius: 100px;
    color: #fff;
    border: 1px solid tomato;
  }

  #btn-topic:hover {
    color: #00b5ad;
    background-color: #fff;
    border-radius: 4px;
    border: 1px solid #00b5ad;
    box-shadow: none;
    text-decoration: none;
  }

  .label-warning {
    margin-right: 20px;
  }

  .notification {
    color: tomato;
  }
</style>
