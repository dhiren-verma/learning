package com.springtutorial.xml_tutorial.bean.instantiation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class OuterClass {
	
	private int id;
	private String field;
	
	@Getter
	@Setter
	@NoArgsConstructor
	@ToString
	public static class StaticInnerClass {
		
		private int innerId;
		private String innerField;
		
	}
	
}