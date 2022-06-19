package com.example.SpringBootVueJs.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponseDto {

    Long id;
    String name;
    String designation;
    Integer age;
    Boolean presence;
}
