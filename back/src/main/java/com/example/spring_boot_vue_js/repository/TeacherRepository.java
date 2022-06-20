package com.example.spring_boot_vue_js.repository;
import com.example.spring_boot_vue_js.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
