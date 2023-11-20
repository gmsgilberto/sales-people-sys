package com.gms.sales.people.sys.commons.person.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.gms.sales.people.sys.commons.person.model.IdentityDocument;
import com.gms.sales.people.sys.commons.person.model.IdentityDocumentType;

public class IdentityDocumentTest {

	
	@Test
	public void testDocumentId() {
		
		var documentId = new IdentityDocument(null,null);
		Assertions.assertFalse(documentId.isValid());
		
		documentId = new IdentityDocument(null,"0011014");
		Assertions.assertFalse(documentId.isValid());
		
		documentId = new IdentityDocument(IdentityDocumentType.CNPJ,"012345678910");
		Assertions.assertTrue(documentId.isValid());
		

		documentId = new IdentityDocument(IdentityDocumentType.CNPJ,"");
		Assertions.assertFalse(documentId.isValid());

		documentId = new IdentityDocument(IdentityDocumentType.CNPJ," ");
		Assertions.assertFalse(documentId.isValid());
		
	}
	
}
