package com.learning.dataStructures.queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class CodedQueue<T> implements Iterable<T> {
	
	private int size;
	private Node<T> head;
	private Node<T> tail;
	private volatile int modCount;
	
	@SuppressWarnings("hiding")
	private class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	public CodedQueue() {
		size = 0;
		head = null;
		tail = null;
		modCount = 0;
	}
	
	public CodedQueue(T firstElem) {
		size = 0;
		head = null;
		tail = null;
		modCount = 0;
		
		offer(firstElem);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Empty Queue!");
		
		return head.data;
	}
	
	//Remove First:
	public T poll() {
		if (isEmpty())
			throw new RuntimeException("Empty Queue!");
		
		T data = head.data; 
		
		//Remove the Head & make Next Node the New Head:
		if (head.next!=null) {
			//There are more elements in the Queue:
			Node<T> removalNode = head;
			head = head.next;
			
			removalNode.data = null;
			removalNode.next = null;
		} else {
			//This is the Last Element in the Queue
			head.data = null;
			head.next = null;
			head = tail = null;
		}
		
		modCount++;
		--size;
		
		return data;
	}
	
	//Add at Last:
	public void offer(T elem) {
		Node<T> newTail = new Node<T>(elem, null);
		
		if (isEmpty()) {
			//This element will represent Both Head & Tail:
			head = tail = newTail;
		} else {
			tail.next = newTail;
			tail = newTail;
		}
		
		modCount++;
		size++;
	}
	
	public int indexOf(T elem) {
		if (isEmpty())
			return -1;
		
		int index = 0;
		Node<T> trav;
		
		if (elem == null) {
			for (trav=head; trav!=null; trav = trav.next, index++) {
				if (trav.data == null)
					return index;
				
			}
		} else {
			for (trav=head; trav!=null; trav = trav.next, index++) {
				if (elem.equals(trav.data))
					return index;
				
			}
		}
		
		return -1;
	}
	
	public boolean contains(T elem) {
		return indexOf(elem)!=-1;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int expectedModCount = modCount;
			Node<T> trav = head;
			
			@Override
			public boolean hasNext() {
				checkForComodification();
				return trav!=null;
			}
			
			@Override
			public T next() {
				checkForComodification();
				
				T data = trav.data;
				trav = trav.next;
				return data;
			}
			
			private void checkForComodification() {
				if (expectedModCount!=modCount)
					throw new ConcurrentModificationException();
				
			}
			
		};
	}

}
