package com.learning.dataStructures.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {
	
	private LinkedList<T> list;
	
	public Queue() {
		list = new LinkedList<T>();
	}
	
	public Queue(T firstElem) {
		offer(firstElem);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return (size()==0);
	}
	
	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Empty Queue!");
		
		return list.peekFirst();
	}
	
	public T poll() {
		if (isEmpty())
			throw new RuntimeException("Empty Queue!");
		
		return list.removeFirst();
	}
	
	public void offer(T elem) {
		list.addLast(elem);
	}
	
	public int indexOf(T elem) {
		return list.indexOf(elem);
	}
	
	public boolean contains(T elem) {
		return indexOf(elem)!=-1;
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
	
}