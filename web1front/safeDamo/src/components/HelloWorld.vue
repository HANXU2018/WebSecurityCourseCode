<template>
  <div class="hello">
    <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="明文:">
      <el-input v-model="input" placeholder="请输入内容"></el-input>
    </el-form-item>

    <el-form-item label="密文:">
      <el-input
      type="textarea"
      autosize
      placeholder="加密后密文"
      v-model="key2">
    </el-input>
    </el-form-item>
    </el-form>
    <el-button  @click="open1" type="primary">生成密钥对</el-button>
    <el-button @click="RSAen" type="success">RSA加密</el-button>
    <el-button @click="RSAde" type="danger">RSA解密</el-button>
    <el-input
      type="textarea"
      autosize
      placeholder="请输入内容"
      v-model="key">
    </el-input>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      input: '输入明文',
      key: '密匙',
      key2: '密文'
    }
  },
  methods: {
    open1 () {
      let that = this
      this.$axios
        .get('/newKey')
        .then(function (response) {
          that.key = response.data
          console.log(response.data)
        })
    },
    RSAen () {
      let that = this
      this.$axios
        .post('/RSAen', {
          input: this.input
        })
        .then(function (response) {
          that.key2 = response.data
          console.log(response.data)
        })
    },
    RSAde () {
      let that = this
      this.$axios
        .post('/RSAde', {
          input: this.key2
        })
        .then(function (response) {
          that.input = response.data
          console.log(response.data)
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
