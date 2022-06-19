package com.example.SpringBootVueJs.Controller;

import com.example.SpringBootVueJs.Dto.TeacherRequestDto;
import com.example.SpringBootVueJs.Mapper.TeacherMapper;
import com.example.SpringBootVueJs.Model.Teacher;
import com.example.SpringBootVueJs.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
//@RequestMapping("/api")
public class TeacherController {
@Autowired
    TeacherMapper mapper;
@Autowired
    TeacherService service;

    @PostMapping("/teachers")
    public Teacher createTeacher(@RequestBody TeacherRequestDto requestDto){
        Teacher teacher = mapper.mapTeacherRequestDtoToTeacher(requestDto);
        service.createTeacher(teacher);
        return teacher;
    }
    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        return ResponseEntity.ok().body(service.getAllTeachers());
    }
    @GetMapping("/teachers/{id}")
    public ResponseEntity<Optional<Teacher>> getTeacher(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getTeacher(id));
    }
    @PutMapping("teachers/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id,@RequestBody Teacher teacher){
        return ResponseEntity.ok().body(service.updateTeacher(id, teacher));
    }
    @DeleteMapping("/teachers")
    public void deleteAllTeachers(){
       service.deleteAllTeachers();
    }
    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable Long id){
            service.deleteTeacher(id);
    }

}
