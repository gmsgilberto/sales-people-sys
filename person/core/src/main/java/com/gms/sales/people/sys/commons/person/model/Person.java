package com.gms.sales.people.sys.commons.person.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	private String firstName;
	private String lastName;
	private PersonType personType;
	private IdentityDocument documentId;
	private StatusOfPerson status;
	

	public boolean isActive() {
		return this.status == StatusOfPerson.ACTIVE;
	}


	public void validate() {
		ValidateStrategy.validate(this);
	}
	
}
