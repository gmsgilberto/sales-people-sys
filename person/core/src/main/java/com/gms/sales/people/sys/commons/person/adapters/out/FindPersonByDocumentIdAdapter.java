package com.gms.sales.people.sys.commons.person.adapters.out;

import com.gms.sales.people.sys.commons.person.model.DocumentId;
import com.gms.sales.people.sys.commons.person.model.Person;

public interface FindPersonByDocumentIdAdapter {

	Person findByDocumentId(DocumentId documentId);

}
