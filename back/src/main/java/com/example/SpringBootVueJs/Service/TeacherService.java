package com.example.SpringBootVueJs.Service;

import com.example.SpringBootVueJs.ErrorHandling.NotFound;
import com.example.SpringBootVueJs.Model.Teacher;
import com.example.SpringBootVueJs.Repository.TeacherRepository;
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
        return teacherRepository.findById(id);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
       // System.out.println("popassda");
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
            throw new NotFound("id:" + id);
        }
    }

    public void deleteAllTeachers() {
        teacherRepository.deleteAll();
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
