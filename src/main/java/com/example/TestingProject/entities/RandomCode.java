package com.example.TestingProject.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.security.SecureRandom;

@Getter
@Setter
@NoArgsConstructor
public class RandomCode {


        private static final String CARACTERES = "123456789abcdefghjkmnopqrstuvwxyABCDEFGHJKLMNPQRSTUVWXY";
        private static final SecureRandom RANDOM = new SecureRandom();

        private int longitud;

        public RandomCode(int longitud) {
            this.longitud = longitud;
        }

        public String generateRandomCode() {
            StringBuilder sb = new StringBuilder(longitud);

            for (int i = 0; i < longitud; i++) {
                sb.append(CARACTERES.charAt(RANDOM.nextInt(CARACTERES.length())));
            }

            return sb.toString();
        }
    }

