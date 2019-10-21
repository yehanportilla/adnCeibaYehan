package co.com.ceibaparqueadero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"co.com.ceibaparqueadero.infraestructura.persistencia.entidades"})
public class YehanCeibaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YehanCeibaApplication.class, args);
	}

}
