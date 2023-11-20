package com.gms.sales.people.sys.commons.person.model;

import java.io.Serializable;

import lombok.Data;


@Data
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	private String firstName;
	private String lastName;
	private PersonType personType;
	private DocumentId documentId;
	private StatusOfPerson status;
	

	public boolean isBlocked() {
		return this.status == StatusOfPerson.BLOCKED;
	}


	public void validate() {
		ValidatePersonStrategy.validate(this);
	}
	
}
