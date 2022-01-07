package learning.instantiationWays;

import java.io.Serializable;

public class MyClass implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8633963630649293531L;
	private int intVal;
	private String stringVal;

	public MyClass() {
		intVal = 10;
		stringVal = "Hello";
	}

	public MyClass(int intVal, String stringVal) {
		this.intVal = intVal;
		this.stringVal = stringVal;
	}

	@Override
	public String toString() {
		return "MyClass [intVal=" + intVal + ", stringVal=" + stringVal + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
