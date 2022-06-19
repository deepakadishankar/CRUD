<template>
  <b-container>
    <b-row>
      <EditTeacher />
    </b-row>
  </b-container>
</template>
<script>
import EditTeacher from "@/components/EditTeacher.vue";

export default {
  name: "EditTeacherView",
  components: {
    EditTeacher,
  },
};
</script>
