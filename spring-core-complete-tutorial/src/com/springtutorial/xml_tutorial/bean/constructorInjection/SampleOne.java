package com.springtutorial.xml_tutorial.bean.constructorInjection;

public class SampleOne {
	
	private SampleTwo sample2;
	private SampleThree sample3;
	
	public SampleOne(SampleTwo sample2, SampleThree sample3) {
		this.sample2 = sample2;
		this.sample3 = sample3;
	}
	
}
