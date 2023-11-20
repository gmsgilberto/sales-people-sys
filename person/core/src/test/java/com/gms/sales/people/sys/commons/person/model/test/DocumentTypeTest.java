package com.gms.sales.people.sys.commons.person.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.gms.sales.people.sys.commons.person.exceptions.DocumentTypeNotFoundException;
import com.gms.sales.people.sys.commons.person.model.DocumentType;
import com.gms.sales.people.sys.commons.person.model.PersonType;

public class DocumentTypeTest {

	
	@Test
	public void testEnum() {
		for(DocumentType type : DocumentType.values()){
			Assertions.assertNotNull(DocumentType.get(type.getCode()));
			Assertions.assertNotNull(DocumentType.get(type.getCode()).getCode());
			Assertions.assertNotNull(DocumentType.get(type.getCode()).getName());
		}
		
		Assertions.assertThrows(DocumentTypeNotFoundException.class, () -> DocumentType.get("bla bla 123"));
	}
	
	
	@Test
	public void testCompatible() {
		Assertions.assertTrue(DocumentType.CNPJ.isValid(PersonType.LEGAL_PERSON));
		Assertions.assertFalse(DocumentType.CNPJ.isValid(PersonType.NATURAL_PERSON));
		
		
		Assertions.assertTrue(DocumentType.CPF.isValid(PersonType.NATURAL_PERSON));
		Assertions.assertFalse(DocumentType.CPF.isValid(PersonType.LEGAL_PERSON));

		Assertions.assertTrue(DocumentType.VISA.isValid(PersonType.NATURAL_PERSON));
		Assertions.assertFalse(DocumentType.VISA.isValid(PersonType.LEGAL_PERSON));
		
	}
	

}
