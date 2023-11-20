/**
 * 
 */
package com.gms.sales.people.sys.commons.person.model;

import java.io.Serializable;

import com.gms.sales.people.sys.commons.text.TextUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class IdentityDocument implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final IdentityDocumentType documentType;
	private final String documentId;
	
	
	public boolean isValid() {
		return !TextUtil.isBlank(getDocumentId()) && getDocumentType() != null;
	}
	

}
