package com.example.spring_boot_vue_js.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequestDto {
    String name;
    String designation;
    Integer age;
    Boolean presence;
}

