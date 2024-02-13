package com.zpay.zpay;

import com.zpay.zpay.domain.Role;
import com.zpay.zpay.domain.User;
import com.zpay.zpay.repository.RoleRepo;
import com.zpay.zpay.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ZPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZPayApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder passwordEncoder){
		return args -> {
			if (roleRepo.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepo.save(new Role("ADMIN"));
			roleRepo.save(new com.zpay.zpay.domain.Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			User admin = new User(1, "Edmand", "Siziba", "Sizybar", "drsizy@gmail.com", passwordEncoder.encode("password"), roles);
			userRepo.save(admin);
		};
	}

	/*@Bean
	public FilterRegistrationBean corsFilter(){
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
		corsConfiguration.setExposedHeaders(Arrays.asList("*"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(urlBasedCorsConfigurationSource));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}*/

}
