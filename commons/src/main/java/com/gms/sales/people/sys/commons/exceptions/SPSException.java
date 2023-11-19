package com.gms.sales.people.sys.commons.exceptions;

import com.gms.sales.people.sys.commons.internationalization.SPSMessage;

public class SPSException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	public SPSException(Throwable cause, String label, Object...args) {
		super(SPSMessage.getInstance().toMessage(label, args), cause);
	}
	

	public SPSException(String label, Object...args) {
		super(SPSMessage.getInstance().toMessage(label, args));
	}

}
