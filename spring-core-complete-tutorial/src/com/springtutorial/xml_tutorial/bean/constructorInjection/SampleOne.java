package com.springtutorial.xml_tutorial.bean.constructorInjection;

public class SampleOne {
	
	private SampleTwo sample2;
	private SampleThree sample3;
	
	public SampleOne(SampleTwo sample2, SampleThree sample3) {
		this.sample2 = sample2;
		this.sample3 = sample3;
	}

	public SampleTwo getSample2() {
		return sample2;
	}

	public void setSample2(SampleTwo sample2) {
		this.sample2 = sample2;
	}
	
	public SampleThree getSample3() {
		return sample3;
	}
	
	public void setSample3(SampleThree sample3) {
		this.sample3 = sample3;
	}
	
}