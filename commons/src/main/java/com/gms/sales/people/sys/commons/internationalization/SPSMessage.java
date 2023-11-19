package com.gms.sales.people.sys.commons.internationalization;

import java.util.Properties;

import lombok.Getter;

public class SPSMessage {

	@Getter
	private static final SPSMessage instance = SPSMessageFactory.getInstance().build();
	
	private final Properties messages;
	
	SPSMessage(final Properties messages) {
		super();
		this.messages = messages;
	}

	public String toMessage(String label, Object... args ) {
		
		var message = this.messages.getProperty(label);
		if(message != null) {
			message = String.format(message, args); 
		}
		
		return message;
	}
	
}
