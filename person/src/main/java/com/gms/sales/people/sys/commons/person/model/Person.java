package com.gms.sales.people.sys.commons.person.model;

import java.io.Serializable;
import java.util.Date;


import lombok.Data;


@Data
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	private String firtName;
	private String lastName;
	private PersonType type;
	private Date birthDate;
	private DocumentType documentType;
	private String documentId;
	

}
