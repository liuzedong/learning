package com.dongdongxia.my.patterns.abstractdocument.domain;

import java.util.Optional;

import com.dongdongxia.my.patterns.abstractdocument.Document;

public interface HasType extends Document{

	String PROPERTY = "type";
	
	default Optional<String> getType() {
		return Optional.ofNullable((String) get(PROPERTY));
	}
	
}
