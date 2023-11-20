package com.gms.sales.people.sys.commons.person.model;

import com.gms.sales.people.sys.commons.person.exceptions.DocumentTypeNotFoundException;

import lombok.Getter;


public enum IdentityDocumentType {

	CPF("CPF","Cadastro de pessoal física", PersonType.NATURAL_PERSON),
	CNPJ("CNPJ","Cadastro Nacional de Pessoal Jurídica",PersonType.LEGAL_PERSON),
	VISA("VISA","Número da Passaporte",PersonType.NATURAL_PERSON);

	@Getter
	private final String code;
	
	@Getter
	private final String name;
	
	
	private PersonType[] validaPersonTypes;
	
	IdentityDocumentType(String code, String name, PersonType...validaPersonTypes){
		this.code = code;
		this.name = name;
		this.validaPersonTypes = validaPersonTypes;
	}
	
	public static IdentityDocumentType get(String code) {
		
		for(IdentityDocumentType type: values()) {
			if(type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}
		
		throw new DocumentTypeNotFoundException(code);
	}

	public boolean isValid(PersonType personType) {
		
		for(PersonType type : validaPersonTypes) {
			if(type == personType) {
				return true;
			}
		}
		
		return false;
	}
	
}
