package com.gms.sales.people.sys.commons.person.adapters.out;

import com.gms.sales.people.sys.commons.person.model.IdentityDocument;
import com.gms.sales.people.sys.commons.person.model.Person;

public interface FindPersonByDocumentIdAdapter {

	Person findByDocumentId(IdentityDocument documentId);

}
