package com.example.spring_boot_vue_js.mapper;

import com.example.spring_boot_vue_js.dto.TeacherRequestDto;
import com.example.spring_boot_vue_js.dto.TeacherResponseDto;
import com.example.spring_boot_vue_js.model.Teacher;
import org.springframework.stereotype.Component;

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
