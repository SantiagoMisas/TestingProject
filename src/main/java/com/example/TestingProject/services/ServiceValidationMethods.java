package com.example.TestingProject.services;

import com.example.TestingProject.entities.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
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

public String callEncryptted() throws Exception {
    Scanner read=new Scanner(System.in);
    System.out.println("Ingrese Contraseña: ");
    String pw=format2(read.next());
    ThreeDES threeDES=new ThreeDES();
    threeDES.encrypt(pw);
    System.out.println(pw);
    return pw;
}

//Metodo para Recrear Formato Json Solicitado Se crean y modifican los DTO, y retornan objeto modificado de clase contenedora de las variables objetos
public EntityToJsonFormat setJsonFormat(){
    EntityToJsonFormat entityToJsonFormat=new EntityToJsonFormat();
    Gson gson=new GsonBuilder().setPrettyPrinting().create();
    J1 j1=new J1();
    j1.setId("Espacio para coger el campo");
    J2 j2=new J2();
    j2.setName("Espacio para coger el campo");
    entityToJsonFormat.setJ1(j1);
    entityToJsonFormat.setJ2(j2);
    String json=gson.toJson(entityToJsonFormat);

    //Se realiza prueba imprimiendo en un archivo JSON en la carpeta target
        /*
        try
            (PrintWriter print=new PrintWriter(("jsonTestRequest.json"))){
            print.write(json);
        } catch (Exception e){
            e.printStackTrace();
        }
         */
    return entityToJsonFormat;
}
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
    //Metodo para mappear un dto a otra clase usando Model Mapper
    public Dto setDto(EntityForDTO entityForDTO){
        ModelMapper modelMapper=new ModelMapper();
        Dto dto=modelMapper.map(entityForDTO, Dto.class);
        return dto;
    }
    //Lectura de cadena por posicion
    public static  ReadingQrCode readByPosition (String string){
        ReadingQrCode readingQrCode =new ReadingQrCode();
        String firstPosition = string.substring(0, 15);
        String secondPosition = string.substring(16, 31);
        String thirdPosition = string.substring(32);
        readingQrCode.setFirstPosition(firstPosition);
        readingQrCode.setSecondPosition(secondPosition);
        readingQrCode.setThirdPosition(thirdPosition);

        return readingQrCode;
    }
    //Completar con ceros para el formato de password
    public static String passwordFormat(String pw) {
        int longitud = pw.length();
        if (longitud < 24) {
            return String.format("%s%0" + (24 - longitud) + "d", pw, 0);
        } else {
            return pw;
        }
    }

    public static String format2(String pw) {
        int length = pw.length();
        int paddingLength = 24 - length;
        StringBuilder sb = new StringBuilder(pw);
        for (int i = 0; i < paddingLength; i++) {
            sb.append('\0');
        }
        return sb.toString();
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
