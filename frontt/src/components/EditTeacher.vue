<template>
  <div v-if="!submitted" class="edit-form">
    <h4>Teacher</h4>
    <h1>{{ currentTeacher.id }}</h1>
    <form>
      <div class="form-group">
        <label for="name">Name</label>
        <input
          type="text"
          class="form-control"
          id="name"
          v-model="currentTeacher.name"
        />
      </div>
      <div class="form-group">
        <label for="designation">Designation</label>
        <input
          type="text"
          class="form-control"
          id="designation"
          v-model="currentTeacher.designation"
        />
      </div>

      <div class="form-group">
        <label for="age">Age</label>
        <input
          type="number"
          class="form-control"
          id="age"
          v-model="currentTeacher.age"
        />
      </div>

      <div class="form-group">
        <label for="presence">Presence</label>
        <input
          type="checkbox"
          class="form-control"
          id="presence"
          required
          v-model="currentTeacher.presence"
          name="presence"
        />
      </div>

      <!-- <div class="form-group">
        <label><strong>Presence:</strong></label>
        {{ currentTeacher.presence ? "Present" : "Absent" }}
      </div> -->
    </form>

    <!-- <button
      class="badge badge-primary mr-2"
      v-if="currentTeacher.presence"
      @click="updatePresence(false)"
    >
      UnPublish
    </button> -->
    <!-- <button
      v-else
      class="badge badge-primary mr-2"
      @click="updatePresence(true)"
    >
      Publish
    </button> -->

    <button class="badge badge-danger mr-2" @click="deleteTeacher">
      Delete
    </button>

    <button type="submit" class="badge badge-success" @click="updateTeacher">
      Update
    </button>
  </div>

  <div v-else class="edit-form">
    <div>
      <label><strong>Name:</strong></label> {{ currentTeacher.name }} <br />
      <label><strong>Designation:</strong></label>
      {{ currentTeacher.designation }}
      <br />
      <label><strong>Age:</strong></label> {{ currentTeacher.age }} <br />
      <label><strong>Presence:</strong></label>
      {{ currentTeacher.presence ? "Present" : "Absent" }}
    </div>
    <h4>{{ message }}</h4>
  </div>
</template>

<script>
import TeacherDataService from "../services/TeacherDataService";
export default {
  name: "EditTeacher",
  data() {
    return {
      currentTeacher: null,
      message: "",
      submitted: false,
    };
  },
  methods: {
    getTutorial(id) {
      TeacherDataService.get(id)
        .then((response) => {
          this.currentTeacher = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    updatePresence(status) {
      var data = {
        id: this.currentTeacher.id,
        name: this.currentTeacher.name,
        designation: this.currentTeacher.designation,
        presence: status,
      };
      TeacherDataService.update(this.currentTeacher.id, data)
        .then((response) => {
          console.log(response.data);
          this.currentTeacher.published = status;
          this.message = "The status was updated successfully!";
        })
        .catch((e) => {
          console.log(e);
        });
    },
    updateTeacher() {
      TeacherDataService.update(this.currentTeacher.id, this.currentTeacher)
        .then((response) => {
          console.log(response.data);
          this.submitted = !this.submitted;
          this.message = "The Teacher was updated successfully!";
        })
        .catch((e) => {
          console.log(e);
        });
    },
    deleteTeacher() {
      TeacherDataService.delete(this.currentTeacher.id)
        .then((response) => {
          console.log(response.data);
          this.submitted = !this.submitted;
          this.message = "The Teacher was deleted successfully!";
          // this.$router.push({ name: "tutorials" });
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  mounted() {
    this.message = "";
    this.getTutorial(this.$route.params.id);
  },
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>
