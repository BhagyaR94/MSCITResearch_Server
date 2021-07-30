package com.bhagya.research;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bhagya.research.core.repository.RefreshTokenRepository;
import com.bhagya.research.dashboard.user.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, RefreshTokenRepository.class})
public class ResearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResearchApplication.class, args);
	}

}
