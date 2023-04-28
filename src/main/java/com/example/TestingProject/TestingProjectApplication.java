package com.example.TestingProject;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.TestingProject.entities.ThreeDES;
import com.example.TestingProject.entities.ValidationCharacter;
import com.example.TestingProject.services.ServiceValidationMethods;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

@SpringBootApplication
public class TestingProjectApplication {

	public TestingProjectApplication() throws Exception {
	}

	public static void main(String[] args) {
		SpringApplication.run(TestingProjectApplication.class, args);
	}

	ServiceValidationMethods validationMethods = new ServiceValidationMethods();
	// ValidationCharacter object1=validationMethods.validationConfirmationForAlphanumeric();
	// ValidationCharacter objet2=validationMethods.validationConfirmationForPositiveNumber();
	//String codeTest=validationMethods.prefabricadoGenericoParaCodigo();
	//ValidationCharacter object3=validationMethods.prefabricadoGenericoParaExpresionAlfanumerica();
	//ValidationCharacter object4=validationMethods.prefabricadoGenericoParaNumeroPositivo();
	//ValidationCharacter object5=validationMethods.scannerlettersValidation();
	//ValidationCharacter object6=validationMethods.scannerNumbersValidation();

 String prueba1=validationMethods.callEncryptted();

}