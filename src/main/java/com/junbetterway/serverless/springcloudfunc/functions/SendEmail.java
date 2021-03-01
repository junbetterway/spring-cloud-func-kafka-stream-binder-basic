package com.junbetterway.serverless.springcloudfunc.functions;

import java.util.function.Function;

import com.junbetterway.serverless.springcloudfunc.model.Account;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SendEmail implements Function<Account, String> {
	
	@Override
	public String apply(final Account account) {
				
		log.info("Sending email to account: {}", account);
		
		return new StringBuilder()
				.append("Hi ")
				.append(account.getName())
				.append("! Thank you for opening a new account with us amounting to ")
				.append(account.getBalance())
				.append(". Please click below link to confirm your online banking account. Cheers!")
				.toString();
	}

}
