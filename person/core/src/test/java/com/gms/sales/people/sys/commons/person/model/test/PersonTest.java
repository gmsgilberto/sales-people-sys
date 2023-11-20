package com.gms.sales.people.sys.commons.person.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.gms.sales.people.sys.commons.person.exceptions.InvalidaPersonFieldsException;
import com.gms.sales.people.sys.commons.person.model.IdentityDocument;
import com.gms.sales.people.sys.commons.person.model.IdentityDocumentType;
import com.gms.sales.people.sys.commons.person.model.Person;
import com.gms.sales.people.sys.commons.person.model.PersonType;
import com.gms.sales.people.sys.commons.person.model.StatusOfPerson;

public class PersonTest {
	
	@Test
	public void testBuildValidPerson() {
		
		var person = new Person();

		Assertions.assertThrows(InvalidaPersonFieldsException.class, () -> person.validate());
		
		person.setFirstName("");
		Assertions.assertThrows(InvalidaPersonFieldsException.class, () -> person.validate());
		

		person.setFirstName("Jose");
		Assertions.assertThrows(InvalidaPersonFieldsException.class, () -> person.validate());


		person.setLastName("");
		Assertions.assertThrows(InvalidaPersonFieldsException.class, () -> person.validate());


		person.setLastName("das Neves");
		Assertions.assertThrows(InvalidaPersonFieldsException.class, () -> person.validate());
		

		person.setStatus(StatusOfPerson.DRAFT);
		Assertions.assertThrows(InvalidaPersonFieldsException.class, () -> person.validate());


		person.setPersonType(PersonType.NATURAL_PERSON);
		Assertions.assertThrows(InvalidaPersonFieldsException.class, () -> person.validate());


		var documentId = new IdentityDocument(IdentityDocumentType.CNPJ, "123456123456");
		person.setDocumentId(documentId);
		Assertions.assertThrows(InvalidaPersonFieldsException.class, () -> person.validate());
		

		documentId = new IdentityDocument(IdentityDocumentType.CNPJ, "");
		person.setDocumentId(documentId);
		Assertions.assertThrows(InvalidaPersonFieldsException.class, () -> person.validate());
		
		documentId = new IdentityDocument(null, "0121345");
		person.setDocumentId(documentId);
		Assertions.assertThrows(InvalidaPersonFieldsException.class, () -> person.validate());


		
		documentId = new IdentityDocument(IdentityDocumentType.CPF, "123456123456");
		person.setDocumentId(documentId);
		person.validate();

		
		Assertions.assertFalse(person.isActive());
		person.setStatus(StatusOfPerson.ACTIVE);
		Assertions.assertTrue(person.isActive());

		person.setId(10l);
		Assertions.assertEquals(10l,person.getId());
		
	}
	

}
