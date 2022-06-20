package com.example.spring_boot_vue_js.controller;

import com.example.spring_boot_vue_js.dto.TeacherRequestDto;
import com.example.spring_boot_vue_js.mapper.TeacherMapper;
import com.example.spring_boot_vue_js.model.Teacher;
import com.example.spring_boot_vue_js.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/teachers")
    public void deleteAllTeachers(){
       service.deleteAllTeachers();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable Long id){
            service.deleteTeacher(id);
    }

}
