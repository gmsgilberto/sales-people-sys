package com.gms.sales.people.sys.commons.internationalization;

import java.util.Properties;

import lombok.Getter;

class SPSMessageFactory {
	
	
	@Getter
	private static final SPSMessageFactory instance = new SPSMessageFactory();
	

	public SPSMessage build() {
		final var fileName = "sps-messages.properties";
		
		try {
			var properties = new Properties();
			properties.load(SPSMessageFactory.class.getClassLoader().getResourceAsStream(fileName));
			return new SPSMessage(properties);
		} catch (Exception e) {
			throw new RuntimeException("Não foi possivel encontrar o arquivo de mensagens do sistema: " + fileName,e);
		}
	}

}
