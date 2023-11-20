package com.gms.sales.people.sys.commons.person.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.gms.sales.people.sys.commons.person.exceptions.DocumentTypeNotFoundException;
import com.gms.sales.people.sys.commons.person.model.IdentityDocumentType;
import com.gms.sales.people.sys.commons.person.model.PersonType;

public class DocumentTypeTest {

	
	@Test
	public void testEnum() {
		for(IdentityDocumentType type : IdentityDocumentType.values()){
			Assertions.assertNotNull(IdentityDocumentType.get(type.getCode()));
			Assertions.assertNotNull(IdentityDocumentType.get(type.getCode()).getCode());
			Assertions.assertNotNull(IdentityDocumentType.get(type.getCode()).getName());
		}
		
		Assertions.assertThrows(DocumentTypeNotFoundException.class, () -> IdentityDocumentType.get("bla bla 123"));
	}
	
	
	@Test
	public void testCompatible() {
		Assertions.assertTrue(IdentityDocumentType.CNPJ.isValid(PersonType.LEGAL_PERSON));
		Assertions.assertFalse(IdentityDocumentType.CNPJ.isValid(PersonType.NATURAL_PERSON));
		
		
		Assertions.assertTrue(IdentityDocumentType.CPF.isValid(PersonType.NATURAL_PERSON));
		Assertions.assertFalse(IdentityDocumentType.CPF.isValid(PersonType.LEGAL_PERSON));

		Assertions.assertTrue(IdentityDocumentType.VISA.isValid(PersonType.NATURAL_PERSON));
		Assertions.assertFalse(IdentityDocumentType.VISA.isValid(PersonType.LEGAL_PERSON));
		
	}
	

}
