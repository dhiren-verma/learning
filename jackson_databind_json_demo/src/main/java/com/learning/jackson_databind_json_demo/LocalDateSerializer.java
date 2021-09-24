package com.learning.jackson_databind_json_demo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {
	
	@Override
	public void serialize(LocalDate value, JsonGenerator gen,
			SerializerProvider serializers) throws IOException {
		if (value!=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
			gen.writeString(value.format(formatter));
		}
	}
	
}