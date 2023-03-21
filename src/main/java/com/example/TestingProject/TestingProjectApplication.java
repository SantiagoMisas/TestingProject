package com.example.TestingProject;

import com.example.TestingProject.entities.ValidationCharacter;
import com.example.TestingProject.services.ServiceValidationMethods;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingProjectApplication.class, args);
	}

	ServiceValidationMethods validationMethods = new ServiceValidationMethods();
	// ValidationCharacter object1=validationMethods.validationConfirmationForAlphanumeric();
	// ValidationCharacter objet2=validationMethods.validationConfirmationForPositiveNumber();
	String codeTest=validationMethods.prefabricadoGenericoParaCodigo();
	ValidationCharacter object3=validationMethods.prefabricadoGenericoParaExpresionAlfanumerica();
	ValidationCharacter object4=validationMethods.prefabricadoGenericoParaNumeroPositivo();
	ValidationCharacter object5=validationMethods.scannerlettersValidation();
	ValidationCharacter object6=validationMethods.scannerNumbersValidation();


}
