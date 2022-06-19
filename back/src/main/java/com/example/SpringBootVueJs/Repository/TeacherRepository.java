package com.example.SpringBootVueJs.Repository;
import com.example.SpringBootVueJs.Dto.TeacherResponseDto;
import com.example.SpringBootVueJs.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
