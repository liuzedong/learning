package com.dongdongxia.my.patterns.abstractdocument.domain;

import java.util.stream.Stream;

import com.dongdongxia.my.patterns.abstractdocument.Document;

public interface HasParts extends Document {

	String PROPERTY = "parts";
 	
	default Stream<Part> getParts() {
		return children(PROPERTY, Part::new);
	}
}
