package com.example.SpringBootVueJs.Mapper;

import com.example.SpringBootVueJs.Dto.TeacherRequestDto;
import com.example.SpringBootVueJs.Dto.TeacherResponseDto;
import com.example.SpringBootVueJs.Model.Teacher;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class TeacherMapper {
    public Teacher mapTeacherRequestDtoToTeacher(TeacherRequestDto requestDto){
        Teacher teacher = new Teacher();
       // teacher.setId(UUID.randomUUID());
        teacher.setName(requestDto.getName());
        teacher.setDesignation(requestDto.getDesignation());
        teacher.setAge(requestDto.getAge());
        teacher.setPresence(requestDto.getPresence());
        return teacher;
    }

    public TeacherResponseDto mapTeacherToResponseDto(Teacher teacher){
        TeacherResponseDto responseDto = new TeacherResponseDto();
        responseDto.setId(teacher.getId());
        responseDto.setName(teacher.getName());
        responseDto.setDesignation(teacher.getDesignation());
        responseDto.setAge(teacher.getAge());
        responseDto.setPresence(teacher.getPresence());
        return responseDto;
    }
}
