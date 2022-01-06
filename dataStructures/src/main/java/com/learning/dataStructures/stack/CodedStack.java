package com.learning.dataStructures.stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class CodedStack<T> implements Iterable<T> {

	private int size;
	private Node<T> head;
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
	
	public CodedStack() {
		size = 0;
		head = null;
		modCount = 0;
	}
	
	public CodedStack(T firstElem) {
		size = 0;
		head = null;
		modCount = 0;
		push(firstElem);
	}
	
	public void clear() {
		Node<T> trav = head;
		
		while(trav!=null) {
			Node<T> next = trav.next;
						
			trav.data = null;
			trav.next = null;
			
			trav = next; 
		}
		
		modCount++;
		head = trav = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size()==0);
	}
	
	public void push(T elem) {
		Node<T> newHead = new Node<T>(elem, head);
		
		head = newHead;
		
		modCount++;
		size++;
	}
	
	public T pop() {
		if (isEmpty())
			throw new RuntimeException("Empty Stack!");
		
		T data = head.data;
		
		Node<T> removalNode = head;
		
		head = head.next;
		
		removalNode.data = null;
		removalNode.next = null;
		
		modCount++;
		size--;
		
		return data;
	}
	
	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Empty Stack!");
		
		return head.data;
	}
	
	public int indexOf(T elem) {
		if (isEmpty())
			return -1;
		
		int index = 0;
		Node<T> trav;
		
		if (elem==null) {
			for (trav = head; trav!=null; trav = trav.next, index++) {
				if (trav.data==null)
					return index;
				
			}
		} else {
			for (trav = head; trav!=null; trav = trav.next, index++) {
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
			private int expectedModCount = modCount;
			private Node<T> trav = head;
			
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
			
	        final void checkForComodification() {
	            if (modCount != expectedModCount)
	                throw new ConcurrentModificationException();
	            
	        }
	        
		};
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[ ");
		
		Node<T> trav = head;
		
		while(trav!=null) {
			sb.append(trav.data).append(", ");
			trav = trav.next;
		}
		
		return sb.toString().substring(0, sb.toString().length()-2).concat(" ]");
	}
	
}