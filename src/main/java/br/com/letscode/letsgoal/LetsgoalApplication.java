package br.com.letscode.letsgoal;

import br.com.letscode.letsgoal.model.Patrocinador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LetsgoalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetsgoalApplication.class, args);
		System.out.printf(new BCryptPasswordEncoder().encode("senha123"));
	}

}
