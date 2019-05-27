package br.com.unip.pim.frota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestaoFrotaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoFrotaApplication.class, args);
	}

}
