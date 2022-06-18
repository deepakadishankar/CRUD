<template>
  <div class="about">
    <AddTeacher />
  </div>
</template>
<script>
// @ is an alias to /src
// import JobCard from "@/components/JobCard.vue";
// import TeachersList from "@/components/TeachersList.vue";
import AddTeacher from "@/components/AddTeacher.vue";
export default {
  name: "HomeView",
  components: {
    AddTeacher,
  },
};
</script>
