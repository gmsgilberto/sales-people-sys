package com.gms.sales.people.sys.commons.person.usecases;

import com.gms.sales.people.sys.commons.person.adapters.out.FindPersonByDocumentIdAdapter;
import com.gms.sales.people.sys.commons.person.adapters.out.InsertPersonAdapter;
import com.gms.sales.people.sys.commons.person.adapters.out.NewPersonEventSender;
import com.gms.sales.people.sys.commons.person.exceptions.DuplicateDocumentIdException;
import com.gms.sales.people.sys.commons.person.model.Person;
import com.gms.sales.people.sys.commons.person.model.StatusOfPerson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatePersonUseCase {

	private final FindPersonByDocumentIdAdapter findPersonByDocumentIdAdapter;
	private final InsertPersonAdapter insertPersonAdapter;
	private final NewPersonEventSender newPersonEventSender;
	
	
	public Person create(Person newPerson) {
	
		newPerson.setStatus(StatusOfPerson.DRAFT);
		newPerson.validate();
		
		var person = this.findPersonByDocumentIdAdapter.findByDocumentId(newPerson.getDocumentId());
		if(person != null) {
			throw new DuplicateDocumentIdException(newPerson.getDocumentId());
		}
		
		person = this.insertPersonAdapter.store(newPerson);
		this.newPersonEventSender.notify(person);
		
		return person;
	}

}
