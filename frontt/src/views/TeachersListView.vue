<template>
  <b-container>
    <b-row>
      <TeachersList />
    </b-row>
  </b-container>
</template>
<script>
import TeachersList from "@/components/TeachersList.vue";
export default {
  name: "TeacherListView",
  components: {
    // JobCard,
    TeachersList,
  },
};
</script>
