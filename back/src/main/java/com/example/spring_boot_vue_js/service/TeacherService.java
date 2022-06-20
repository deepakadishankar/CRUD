package com.example.spring_boot_vue_js.service;

import com.example.spring_boot_vue_js.errorhandling.NotFoundException;
import com.example.spring_boot_vue_js.model.Teacher;
import com.example.spring_boot_vue_js.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacher(Long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            return optionalTeacher;
        } else throw new NotFoundException("id:" + id);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher selectedTeacher = optionalTeacher.get();
//            Teacher updatedTeacher = Teacher.get();
            selectedTeacher.setId(teacher.getId());
            selectedTeacher.setName(teacher.getName());
            selectedTeacher.setDesignation(teacher.getDesignation());
            selectedTeacher.setAge(teacher.getAge());
            selectedTeacher.setPresence(teacher.getPresence());
            return teacherRepository.saveAndFlush(selectedTeacher);
        } else {
            throw new NotFoundException("id:" + id);
        }
    }

    public void deleteAllTeachers() {
        teacherRepository.deleteAll();
    }

    public void deleteTeacher(Long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            teacherRepository.deleteById(id);
        } else throw new NotFoundException("id:" + id);

    }
}
