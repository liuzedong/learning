package com.dongdongxia.my.patterns.abstractdocument.domain;

import java.util.Optional;

import com.dongdongxia.my.patterns.abstractdocument.Document;

public interface HasPrice extends Document{

	String PROPERTY = "price";
	
	default Optional<Number> getPrice() {
		return Optional.ofNullable((Number) get(PROPERTY));
	}
}
