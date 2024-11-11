package in.rtms.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RtmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RtmsApplication.class, args);
		System.out.println("started...");
	}

}
