package com.gms.sales.people.sys.commons.person.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.gms.sales.people.sys.commons.person.exceptions.PersonTypeNotFoundException;
import com.gms.sales.people.sys.commons.person.model.PersonType;

public class PersonTypeTest {

	
	@Test
	public void testEnum() {
		
		Assertions.assertNotNull(PersonType.get("PF"));
		Assertions.assertNotNull(PersonType.get("PF").getCode());
		Assertions.assertNotNull(PersonType.get("PF").getName());
		Assertions.assertNotNull(PersonType.get("PJ").getCode());
		Assertions.assertNotNull(PersonType.get("PJ").getName());
		Assertions.assertThrows(PersonTypeNotFoundException.class, () -> PersonType.get("bla bla 123"));
		
	}
	

}
