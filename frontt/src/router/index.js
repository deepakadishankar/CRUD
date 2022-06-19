import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import AddTeacherView from "../views/AddTeacherView.vue";
import TeacherListtVue from "@/components/TeacherListt.vue";
import EditTeacherView from "@/views/EditTeacherView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/teachers",
    name: "teachers",
    component: TeacherListtVue,
  },
  {
    path: "/addTeachers",
    name: "addTeachers",
    component: AddTeacherView,
  },
  {
    path: "/teachers/:id",
    name: "editTeachers",
    component: EditTeacherView,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
