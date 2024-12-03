package br.com.gestaologistica.api_gestaologistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ApiGestaologisticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGestaologisticaApplication.class, args);
	}

}
