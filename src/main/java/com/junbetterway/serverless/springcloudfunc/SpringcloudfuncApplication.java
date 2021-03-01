package com.junbetterway.serverless.springcloudfunc;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import com.junbetterway.serverless.springcloudfunc.functions.CreateAccount;
import com.junbetterway.serverless.springcloudfunc.functions.SendEmail;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class SpringcloudfuncApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudfuncApplication.class, args); 
	}

	@Bean
	public Function<Message<String>, String> greeter() {
		return (input) -> {
			log.info("Hello {}", input.getPayload());
			return "Hello " + input.getPayload();
		};
	}
	
	@Bean
	public CreateAccount createAccount() {
		return new CreateAccount();
	}
	
	@Bean
	public SendEmail sendEmail() {
		return new SendEmail();
	}

}
