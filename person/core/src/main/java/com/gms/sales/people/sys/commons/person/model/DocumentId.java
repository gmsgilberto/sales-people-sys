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
public class DocumentId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DocumentType documentType;
	private String documentId;
	public boolean validate() {
		return !TextUtil.isBlank(documentId) && documentType != null;
	}
	

}
