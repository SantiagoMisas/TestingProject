package com.example.TestingProject.entities;

import com.example.TestingProject.annotations.Alphanumeric;
import com.example.TestingProject.annotations.Letters;
import com.example.TestingProject.annotations.Numbers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationCharacter {


    @Letters
    private String name;
    @Numbers
    private String number;
    @Alphanumeric
    private String cadena;
}
