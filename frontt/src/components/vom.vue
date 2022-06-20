<template>
  <div>
    <form>
      <label for="name">First name:</label><br />
      <input type="text" id="name" name="name" v-model="teacher.name" /><br />
      <label for="designation">Designation:</label><br />
      <input
        type="text"
        id="designation"
        name="designation"
        v-model="teacher.designation"
      /><br />
      <label for="age">Age:</label><br />
      <input type="text" id="age" name="age" v-model="teacher.age" /><br />
      <input
        type="checkbox"
        id="presence"
        name="vehicle1"
        v-model="teacher.presence"
      />
      <label for="presence">Check the box if present</label><br />
    </form>
  
  </div>
</template>
<script>
import TeacherDataService from "../services/TeacherDataService";
export default {
  name: "addTeacher",
  data() {
    return {
      teacher: {
        id: null,
        name: "",
        designation: "",
        age: "",
        presence: false,
      },
      submitted: false,
    };
  },
  methods: {
    saveteacher() {
      var data = {
        name: this.teacher.name,
        designation: this.teacher.designation,
        age: this.teacher.age,
        presence: this.teacher.presence,
      };
      TeacherDataService.create(data)
        .then((response) => {
          this.teacher.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch((e) => {
          console.log(e);
        });
    },

    newteacher() {
      this.submitted = false;
      this.teacher = {};
    },
  },
};
</script>
