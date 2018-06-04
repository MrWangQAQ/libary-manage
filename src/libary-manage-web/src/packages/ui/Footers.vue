<template>
  <div class="footer">
    <el-row>
      <el-col :span="14" :offset="5">
        <div style="border-bottom: 1px solid #ddd; padding-top: 70px"></div>
        <el-row>
          <el-col :span="8">
            <p style="text-align: left">*******</p>
          </el-col>
          <el-col :span="8">
            <p style="text-align: center">&copy; 2300-2318
            </p>
          </el-col>
          <el-col :span="8">
            <p style="text-align: right">
              <a href="javascript: scroll(0, 0)">TOP</a>
            </p>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>

</script>

<style scoped>
.footer {
  padding-bottom: 50px;
}

p {
  margin-top: 30px;
  font-size: 14px;
  color: #999;
}

a {
  color: #00b5ad;
}
</style>
