package com.learning.jackson_databind_json_demo.moreAnnotations;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)	//to Ignore unknown Values in De-serialization
//@JsonIgnoreProperties("id")	//to Ignore particular Property/Filed during Serialization
@JsonPropertyOrder({ "someStr" , "name" })	//specify the order of properties on serialization.
public class ExtendableBean {
	
//	@JsonIgnoreType - this can be used to mark all Properties of annotated type to be ignored,
	//Like lest say we marked this on a Custom Class Address, then that whole class will be
	//ignored in Serialization.
	
	@JsonIgnore		//to mark any property to be ignored during Serialization at the Field Level
	private int id;
	private String name;
	private Map<String, String> properties;
//	@JsonRawValue	//instruct Jackson to serialize a property exactly as is.
	private String someStr;
	
	public ExtendableBean() {
		id = 0;
		name = "";
		properties = new HashMap<>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonGetter("name")	//an alternative to the @JsonProperty annotation, which marks a method as a getter method
	public String getBeanName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonAnyGetter	//allows for the flexibility of using a Map field as standard properties.
	public Map<String, String> getProperties() {
		return properties;
	}
	
	@JsonAnySetter	//allows us the flexibility of using a Map as standard properties
	public void add(String key, String value) {
		properties.put(key, value);
	}
	
	public String getSomeStr() {
		return someStr;
	}
	
	public void setSomeStr(String someStr) {
		this.someStr = someStr;
	}
	
	@Override
	public String toString() {
		return "ExtendableBean [id="+id+", name=" + name + ", properties=" + properties + ", someStr="+someStr+"]";
	}
	
}
