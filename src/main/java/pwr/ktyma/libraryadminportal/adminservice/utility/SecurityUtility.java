package pwr.ktyma.libraryadminportal.adminservice.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Random;

public class SecurityUtility {

    private static final String SALT = "salt";

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }
    @Bean
    public static String randomPassword() {
        final String SALT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        while(password.length() < 10) {
            int index = (int) (random.nextFloat()*SALT_CHARS.length());
            password.append(SALT_CHARS.charAt(index));
        }

        return password.toString();
    }
}