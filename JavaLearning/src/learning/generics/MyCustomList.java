package learning.generics;

import java.util.ArrayList;
import java.util.List;

public class MyCustomList<T> {
	
	private List<T> list = new ArrayList<>();
	
	public void addElement(T element) {
		list.add(element);
	}
	
	public void removeElement(T element) {
		list.remove(element);
	}
	
	public T get(int index) {
		return list.get(index);
	}
	
	public String toString() {
		return list.toString();
	}
	
}
