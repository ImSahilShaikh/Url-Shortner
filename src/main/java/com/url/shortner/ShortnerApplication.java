package com.url.shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.system.JavaVersion;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ShortnerApplication {

	public static void main(String[] args) {
		System.out.println(JavaVersion.getJavaVersion());
		SpringApplication.run(ShortnerApplication.class, args);
	}
}
