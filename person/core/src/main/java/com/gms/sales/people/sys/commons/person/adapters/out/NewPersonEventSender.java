package com.gms.sales.people.sys.commons.person.adapters.out;

import com.gms.sales.people.sys.commons.person.model.Person;

public interface NewPersonEventSender {

	void notify(Person person);

}
