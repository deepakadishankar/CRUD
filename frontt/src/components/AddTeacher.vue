<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="name">Name</label>
        <input
          type="text"
          class="form-control"
          id="name"
          required
          v-model="teacher.name"
          name="name"
        />
      </div>
      <div class="form-group">
        <label for="designation">Designation</label>
        <input
          class="form-control"
          id="designation"
          required
          v-model="teacher.designation"
          name="designation"
        />
      </div>
      <div class="form-group">
        <label for="age">Age</label>
        <input
          class="form-control"
          id="age"
          required
          v-model="teacher.age"
          name="age"
        />
      </div>
      <div class="form-group">
        <label for="presence">Presence</label>
        <input
          type="checkbox"
          class="form-control"
          id="presence"
          required
          v-model="teacher.presence"
          name="presence"
        />
        <!-- <b-form-group v-model="teacher.presence" id="presence" name="presence">
          <b-form-checkbox for="presence">Presence</b-form-checkbox>
        </b-form-group> -->
        <!-- </div> -->
      </div>
      <button @click="saveteacher" class="btn btn-success">Submit</button>
    </div>
    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newteacher">Add</button>
    </div>
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
<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>
