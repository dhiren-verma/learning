package com.learning.dataStructures.stack;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {
	
	private LinkedList<T> list;
	
	public Stack() {
		list = new LinkedList<T>();
	}
	
	public Stack(T firstElem) {
		list = new LinkedList<>();
		push(firstElem);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return (size()==0);
	}
	
	public void push(T elem) {
		list.addLast(elem);
	}
	
	public T pop() {
		if (isEmpty())
			throw new RuntimeException("Empty Stack!");
		
		return list.removeLast();
	}
	
	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Empty Stack!");
		
		return list.getLast();
	}
	
	public int indexOf(T elem) {
		return list.indexOf(elem);
	}
	
	public boolean contains(T elem) {
		return list.contains(list);
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[ ");
		
		list.stream().forEach(elem -> sb.append(elem).append(", "));
		
		return sb.toString().substring(0, sb.toString().length()-2).concat(" ]");
	}
	
}
