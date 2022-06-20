<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="name">Name</label>
        <input
          type="text"
          minlength="5"
          class="form-control"
          id="name"
          required="true"
          v-model="teacher.name"
          name="name"
        />
        <p v-if="validatedName"></p>
      </div>
      <div class="form-group">
        <label for="designation">Designation</label>
        <input
          class="form-control"
          id="designation"
          required="required"
          v-model="teacher.designation"
          name="designation"
        />
      </div>
      <div class="form-group">
        <label for="age">Age</label>
        <input
          type="text"
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
      </div>
      <div v-if="error">
        <div class="alert alert-danger" role="alert">
          <p>Submission failed!</p>
          {{ this.errorMessage }}
        </div>
      </div>
      <button @click="saveteacher" class="btn btn-success">Submit</button>
    </div>
    <div v-else>
      <div>
        <label><strong>Name:</strong></label> {{ teacher.name }} <br />
        <label><strong>Designation:</strong></label> {{ teacher.designation }}
        <br />
        <label><strong>Age:</strong></label> {{ teacher.age }} <br />
        <label><strong>Presence:</strong></label>
        {{ teacher.presence ? "Present" : "Absent" }}
      </div>

      <div class="alert alert-success" role="alert">
        You submitted successfully!
      </div>

      <button class="btn btn-success" @click="newteacher">Add Another</button>
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
      error: false,
      errorMessage: "",
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
          this.errorMessage = e;
          this.error = !this.error;
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
