<template>
  <div class="list row">
    <div class="col-md-12">
      <h4>Teachers List</h4>
      <p v-if="teachers.length == 0">No Teacher entires to show</p>
      <ul class="list-group">
        <li
          class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(teacher, index) in teachers"
          :key="index"
          @click="setActiveTeacher(teacher, index)"
        >
          {{ teacher.name }}
        </li>
      </ul>
      <button class="m-3 btn btn-sm btn-danger" @click="removeAllTeachers">
        Remove All
      </button>
    </div>
  </div>
</template>
<script>
import TeacherDataService from "@/services/TeacherDataService";
export default {
  name: "TeacherListt",
  data() {
    return {
      teachers: [],
      currentTeacher: null,
      currentIndex: -1,
    };
  },
  methods: {
    retrieveTeachers() {
      TeacherDataService.getAll()
        .then((response) => {
          this.teachers = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveTeachers();
      this.currentTeacher = null;
      this.currentIndex = -1;
    },
    removeAllTeachers() {
      TeacherDataService.deleteAll()
        .then((response) => {
          console.log(response.data);
          this.refreshList();
        })
        .catch((e) => {
          console.log(e);
        });
    },
    setActiveTeacher(teacher, index) {
      this.currentTeacher = teacher;
      this.currentIndex = teacher ? index : -1;
    },
  },
  mounted() {
    this.retrieveTeachers();
  },
};
</script>
