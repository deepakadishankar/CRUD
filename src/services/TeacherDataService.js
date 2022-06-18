import http from "../http-common";
class TeacherDataService {
  getAll() {
    return http.get("/api/teachers");
  }
  get(id) {
    return http.get(`/api/teachers/${id}`);
  }
  create(data) {
    return http.post("/api/teachers", data);
  }
  deleteAll() {
    return http.delete("/api/teachers");
  }
  update(id, data) {
    return http.put(`/api/teachers/${id}`, data);
  }
  delete(id) {
    return http.delete(`/api/teachers/${id}`);
  }
}
export default new TeacherDataService();
