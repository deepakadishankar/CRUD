<template>
  <b-container>
    <b-row>
      <AddTeacher />
    </b-row>
  </b-container>
</template>
<script>
import AddTeacher from "@/components/AddTeacher.vue";
export default {
  name: "AddTeacherView",
  components: {
    AddTeacher,
  },
};
</script>
