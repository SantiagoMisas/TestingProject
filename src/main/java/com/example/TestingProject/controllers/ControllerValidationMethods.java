package com.example.TestingProject.controllers;

import com.example.TestingProject.entities.ValidationCharacter;
import com.example.TestingProject.services.ServiceValidationMethods;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/test")
@CrossOrigin
public class ControllerValidationMethods {
    @Autowired
    ServiceValidationMethods serviceValidationMethods;


    @GetMapping("/controller")
    public String setTest(){

      /* Scanner inputScanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre: ");
        String name = inputScanner.nextLine();

        System.out.println("Ingrese el número: ");
        String number = inputScanner.nextLine();

        System.out.println("Ingrese la cadena: ");
        String cadena = inputScanner.nextLine();


        serviceValidationMethods.setInformation();*/

        return "Prueba Desde controlador";
    }


    @PostMapping("/name")
    public String test1(@Valid @RequestBody ValidationCharacter validationCharacter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        return "The field is successfully validated" + validationCharacter.getName();
    }
    @GetMapping("/name2")
    public String test1v2(@Valid ValidationCharacter validationCharacter){
        LocalDate localDate = LocalDate.now();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Error de validacion", "Error en datos");
        String message = localDate+""+headers+"El campo debe ser rellenado solamente con letras";
        return message;

    }


    @PostMapping("/number")
    public String test2(@Valid @RequestBody ValidationCharacter validationCharacter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        return "The field is successfully validated" + validationCharacter.getNumber();
    }


    @GetMapping("/validate/alphanumeric")
    public String validateAlphanumeric(@RequestParam String expression) {
        if (serviceValidationMethods.alphanumericValidation(expression)) {
            return "La cadena es alfanumérica.";
        } else {
            return "La cadena no es alfanumérica.";
        }
    }

    @GetMapping("/validate/positive-number")
    public String validatePositiveNumber(@RequestParam String number) {
        if (serviceValidationMethods.positiveNumbersValidation(number)) {
            return "El numero es positivo.";
        } else {
            return "El numero no es positivo.";
        }
    }
    @PostMapping("/pruebaAlfanumerico")
    public String alphanumericTest(@Valid @RequestBody ValidationCharacter validationCharacter, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }

        return "The field is successfully validated" +validationCharacter.getCadena();
    }
}











