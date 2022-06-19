<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <router-link to="/" class="navbar-brand">BASE</router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/teachers" class="nav-link">Teachers</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/addTeachers" class="nav-link"
            >Add Teacher</router-link
          >
        </li>
      </div>
    </nav>
    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>
<script>
// import TopHeader from "./components/TopHeader.vue";
export default {
  components: {},
};
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
