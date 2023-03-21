package com.example.TestingProject.services;

import com.example.TestingProject.entities.RandomCode;
import com.example.TestingProject.entities.ValidationCharacter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@Getter
@Setter
@NoArgsConstructor
public class ServiceValidationMethods {


private int longitud;
    public ValidationCharacter setInformation() {
        ValidationCharacter testObject = new ValidationCharacter();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre:");
        String name = scanner.nextLine();
        testObject.setName(name);

        System.out.println("Ingrese el número:");
        String number = scanner.nextLine();
        testObject.setNumber(number);

        System.out.println("Ingrese la cadena:");
        String cadena = scanner.nextLine();
        testObject.setCadena(cadena);

        return testObject;
    }



    public static boolean alphanumericValidation(String expression) {
        if (expression == null) return false;
        String validationExpression = "^[a-zA-Z0-9]+$";
        Pattern p = Pattern.compile(validationExpression);
        Matcher m = p.matcher(expression);

        return m.matches();
    }

    public static boolean positiveNumbersValidation(String number) {
        if(number == null) return true;
        // expresión regular para permitir solo el uso de numeros positivos
        String regex = "^[1-9]\\d*$";
        return number.matches(regex);
    }

    public static boolean lettersValidation(String word) {
        if(word == null) return true;
        // expresión regular para permitir solo el uso de letras
        String pattern = "[a-zA-Z]+";
        return  word.matches(pattern);
    }
    public static boolean numbersValidation(String number) {
        if(number == null) return true;
        // expresión regular para permitir solo números enteros
        String pattern = "\\d+";
        return number.matches(pattern);
    }

    public ValidationCharacter validationConfirmationForAlphanumeric() {
        ValidationCharacter alphanumericTestObject = new ValidationCharacter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la expresion para validar el método:");
        String word = scanner.nextLine();
        if (alphanumericValidation(word)) {
            System.out.println(word+" La expresión anterior es alfanumérica.");
        } else {
            System.out.println(word+" La expresión anterior no es alfanumérica.");
        }

        return alphanumericTestObject;
    }
    public ValidationCharacter prefabricadoGenericoParaExpresionAlfanumerica() {
        ValidationCharacter alphanumericTestObject = new ValidationCharacter();
        Scanner scanner = new Scanner(System.in);
        String validationExpression = "^[a-zA-Z0-9]+$";
        System.out.println("Ingrese la expresion para validar el método:");
        String expression = scanner.nextLine();
        Pattern p = Pattern.compile(validationExpression);
        Matcher m = p.matcher(expression);
        if (expression.matches(validationExpression)) {
            System.out.println(expression+" La expresión anterior es alfanumérica.");
        } else {
            System.out.println(expression+" La expresión anterior no es alfanumérica.");
        }

        return alphanumericTestObject;
    }
    //Metodo para validar numero positivo
    public ValidationCharacter validationConfirmationForPositiveNumber() {
        Scanner scanner = new Scanner(System.in);
        ValidationCharacter positiveNumberTestObject = new ValidationCharacter();
        System.out.println("Ingrese el número para validar el método:");
        String number = scanner.nextLine();

        if (positiveNumbersValidation(number)) {
            System.out.println(number+" El número anterior es positivo.");
        } else {
            System.out.println(number+" El número anterior no es positivo.");
        }
        return positiveNumberTestObject;
    }

        //Metodo para validar numero positivo con lectura de dato por Scanner
        public ValidationCharacter prefabricadoGenericoParaNumeroPositivo() {
        Scanner scanner = new Scanner(System.in);
        String regex = "^[1-9]\\d*$";
        ValidationCharacter positiveNumberTestObject = new ValidationCharacter();
        System.out.println("Ingrese el número para validar el método:");
        String number = scanner.nextLine();
        if (number.matches(regex)) {
            System.out.println(number+" El número anterior es positivo.");
        } else {
            System.out.println(number+" El número anterior no es positivo.");
        }
        return positiveNumberTestObject;
    }
    // Metodo para validar solo numeros con lectura de dato por Scanner
    public ValidationCharacter scannerNumbersValidation() {
        Scanner scanner = new Scanner(System.in);
        // expresión regular para permitir solo números enteros
        String pattern = "\\d+";
        ValidationCharacter numberTestObject = new ValidationCharacter();
        System.out.println("Ingrese el número para validar el método:");
        String number = scanner.nextLine();
        if (number.matches(pattern)) {
            System.out.println(number+", se aprueba el uso de los numeros anteriores");
        } else {
            System.out.println(number+", La expresión anterior no se aprueba contiene caracteres especiales o letras.");
        }
        return numberTestObject;
    }

    // Metodo para validar que el campo solo pueda tener letras con lectura de dato por Scanner
    public ValidationCharacter scannerlettersValidation() {
        Scanner scanner = new Scanner(System.in);
        // expresión regular para permitir solo el uso de letras
        String pattern = "[a-zA-Z]+";
        ValidationCharacter lettersTestObject = new ValidationCharacter();
        System.out.println("Ingrese la palabra para validar el método:");
        String word = scanner.next();
        if (word.matches(pattern)) {
            System.out.println(word+", La expresión anterior es valida; Solo contiene letras.");
        } else {
            System.out.println(word+", La expresión anterior no es valida; Contiene caracteres especiales o números.");
        }
        return lettersTestObject;
    }

    public String showGeneratedCode() {
        RandomCode code = new RandomCode();
        String codigoAleatorio = code.generateRandomCode();
        System.out.println(codigoAleatorio);
        return codigoAleatorio;
    }

    //El metodo crea un codigo alfanumerico con longitud definida por lectura de dato por Scanner
        public String prefabricadoGenericoParaCodigo() {
        Scanner scanner = new Scanner(System.in);
        ServiceValidationMethods serviceTestCodeObject=new ServiceValidationMethods();
        String CARACTERES = "23456789ABCDEFGHJKLMNPQRSTUVWXY";
        SecureRandom RANDOM = new SecureRandom();
        StringBuilder sb = new StringBuilder(longitud);
        System.out.println("Ingrese la longitud para generar el codigo: ");
        longitud = scanner.nextInt();
        serviceTestCodeObject.setLongitud(longitud);


            for (int i = 0; i < longitud; i++) {
                sb.append(CARACTERES.charAt(RANDOM.nextInt(CARACTERES.length())));
            }
            System.out.println("El codigo generado es el siguiente: "+sb);
            return sb.toString();
        }

}
