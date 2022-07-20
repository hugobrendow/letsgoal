package br.com.letscode.letsgoal;

import br.com.letscode.letsgoal.config.ProductServiceInterceptor;
import br.com.letscode.letsgoal.model.Patrocinador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.MappedInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
public class LetsgoalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetsgoalApplication.class, args);
	}

	@Bean
	public org.springframework.web.servlet.handler.MappedInterceptor myInterceptor() {
		return new MappedInterceptor(
				new String[]{"/**"},  // null => maps to any repository/path
				new ProductServiceInterceptor()
		);
	}
}
