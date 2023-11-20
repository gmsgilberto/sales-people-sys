package com.gms.sales.people.sys.commons.person.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.gms.sales.people.sys.commons.person.exceptions.StatusNotFoundException;
import com.gms.sales.people.sys.commons.person.model.StatusOfPerson;

public class StatusOfPersonTest {

	
	@Test
	public void testEnum() {
		
		
		for(StatusOfPerson type : StatusOfPerson.values()){
			Assertions.assertNotNull(StatusOfPerson.get(type.getCode()));
			Assertions.assertNotNull(StatusOfPerson.get(type.getCode()).getCode());
			Assertions.assertNotNull(StatusOfPerson.get(type.getCode()).getName());
		}
		
		
		
		Assertions.assertThrows(StatusNotFoundException.class, () -> StatusOfPerson.get("bla bla 123"));
		
	}
	

}
