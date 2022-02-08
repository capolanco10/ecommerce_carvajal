package co.com.ecommercecarvajal.platform.infrastructure.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { 
		"co.com.ecommercecarvajal.platform.modules", 
		"co.com.ecommercecarvajal.platform.infrastructure",
		"co.com.ecommercecarvajal.platform.crosscutting"})
@EnableJpaRepositories(basePackages = { "co.com.ecommercecarvajal.platform.crosscutting.persistence.repository" })
@EntityScan(basePackages = "co.com.ecommercecarvajal.platform.crosscutting.persistence.entity")
public class EcommerceManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceManagerServiceApplication.class, args);
	}

}
