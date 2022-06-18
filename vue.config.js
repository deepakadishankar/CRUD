const bootstrapSassAbstractsImports = require("vue-cli-plugin-bootstrap-vue/sassAbstractsImports.js");

const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  devServer: {
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        pathRewrite: { "^/api": "" },
      },
    },
  },  
  transpileDependencies: true,
});
css: {
  loaderOptions: {
    sass: {
      additionalData: bootstrapSassAbstractsImports.join("\n");
    }
    scss: {
      additionalData: [...bootstrapSassAbstractsImports, ""].join(";\n");
    }
  }
}
