package cn.tigers;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FireBootApplication {

	public static void main(String[] args) {
//		SpringApplication.run(FireBootApplication.class, args);

		SpringApplication application = new SpringApplication(FireBootApplication.class);
//		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
