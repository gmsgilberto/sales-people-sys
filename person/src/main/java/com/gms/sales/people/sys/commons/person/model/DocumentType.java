package com.gms.sales.people.sys.commons.person.model;

import com.gms.sales.people.sys.commons.person.exceptions.DocumentTypeNotFoundException;

import lombok.Getter;

@Getter
public enum DocumentType {

	CPF("CPF","Cadastro de pessoal física"),
	CNPJ("CNPJ","Cadastro Nacional de Pessoal Jurídica"),
	VISA("VISA","Número da Passaporte");
	
	private final String code;
	private final String name;
	
	DocumentType(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static DocumentType get(String code) {
		
		for(DocumentType type: values()) {
			if(type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}
		
		throw new DocumentTypeNotFoundException(code);
	}
	
}
