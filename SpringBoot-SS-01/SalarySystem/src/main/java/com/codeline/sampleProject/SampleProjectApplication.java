package com.codeline.sampleProject;
import com.codeline.sampleProject.Controller.AccountController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
//@ComponentScan(basePackages = "com.codeline.sampleProject.Models")
public class SampleProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SampleProjectApplication.class, args);
	}
}