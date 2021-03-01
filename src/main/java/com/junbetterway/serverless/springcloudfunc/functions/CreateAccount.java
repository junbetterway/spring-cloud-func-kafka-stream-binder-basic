package com.junbetterway.serverless.springcloudfunc.functions;

import java.util.function.Function;

import org.springframework.messaging.Message;

import com.junbetterway.serverless.springcloudfunc.model.Account;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CreateAccount implements Function<Message<Account>, Account> {
	
	@Override
	public Account apply(final Message<Account> msg) {
				
		log.info("Creating account with payload: {}", msg.getPayload());
		
		Account newAccount = Account.builder()
				.id(Long.valueOf(1))
				.name(msg.getPayload().getName())
				.balance(msg.getPayload().getBalance())
				.build();
		
		return newAccount;
		
	}

}
