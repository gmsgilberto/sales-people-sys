package com.gms.sales.people.sys.commons.person.usecases.tests;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gms.sales.people.sys.commons.person.adapters.out.FindPersonByDocumentIdAdapter;
import com.gms.sales.people.sys.commons.person.adapters.out.InsertPersonAdapter;
import com.gms.sales.people.sys.commons.person.adapters.out.NewPersonEventSender;
import com.gms.sales.people.sys.commons.person.exceptions.DuplicateDocumentIdException;
import com.gms.sales.people.sys.commons.person.model.IdentityDocument;
import com.gms.sales.people.sys.commons.person.model.IdentityDocumentType;
import com.gms.sales.people.sys.commons.person.model.Person;
import com.gms.sales.people.sys.commons.person.model.PersonType;
import com.gms.sales.people.sys.commons.person.model.StatusOfPerson;
import com.gms.sales.people.sys.commons.person.usecases.CreatePersonUseCase;

public class CreatePersonUseCaseTest {

	
	private CreatePersonUseCase createPersonUseCase;
	private Person duplicatePerson;
	private Person validePerson;
	
	
	@BeforeEach
	public void init() {
		var findPersonByDocumentIdAdapter = Mockito.mock(FindPersonByDocumentIdAdapter.class);
		var insertPersonAdapter = Mockito.mock(InsertPersonAdapter.class);
		var newPersonEventSender = Mockito.mock(NewPersonEventSender.class);
		this.createPersonUseCase = new CreatePersonUseCase(findPersonByDocumentIdAdapter, insertPersonAdapter, newPersonEventSender);
		
		validePerson = buildValidPerson();
		duplicatePerson = buildValidPerson();
		
		Mockito.when(findPersonByDocumentIdAdapter.findByDocumentId(duplicatePerson.getDocumentId())).thenReturn(duplicatePerson);
		Mockito.when(insertPersonAdapter.store(validePerson)).thenReturn(validePerson);
		
	}

	
	@Test
	public void testCreateSucess() {
		var person = this.createPersonUseCase.create(validePerson);
		Assertions.assertNotNull(person);
	}

	@Test
	public void testCreateDuplicate() {
		Assertions.assertThrows(DuplicateDocumentIdException.class, () -> this.createPersonUseCase.create(duplicatePerson));
	}

	public static Person buildValidPerson() {
		var person = new Person();
		var rnd = new Random();
		
		person.setDocumentId(new IdentityDocument(IdentityDocumentType.CPF, String.valueOf(rnd.nextLong(99999999999l))));
		person.setFirstName("Jose");
		person.setLastName("das Neves");
		person.setId(rnd.nextLong(999999999l));
		person.setPersonType(PersonType.NATURAL_PERSON);
		person.setStatus(StatusOfPerson.DRAFT);
		
		return person;
		
	}
	
	
	
	
}
