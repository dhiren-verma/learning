package com.learning.dataStructures.linkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import com.learning.dataStructures.exceptions.IndexOutOfBoundsException;

public class DoublyLinkedList<T> implements Iterable<T> {
	
	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;
	private volatile int modCount = 0;
	
	@SuppressWarnings("hiding")
	private class Node<T> {
		T data;
		Node<T> prev;
		Node<T> next;
		
		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	//Empty this Linked List, O(n)
	public void clear() {
		Node<T> trav = head;
		
		while (trav != null) {
			Node<T> next = trav.next;
			trav.prev = trav.next = null;
			trav.data = null;
			trav = next;
		}
		
		modCount++;
		head = tail = trav = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	//Add the Element to the Tail of the Linked List, O(1)
	public void add(T elem) {
		addLast(elem);
	}
	
	//Add the Element to the Head of the Linked List, O(1)
	public void addFirst(T elem) {
		//Linked List id empty:
		if (isEmpty()) {
			head = tail = new Node<T>(elem, null, null);
		} else {
			head.prev = new Node<T>(elem, null, head);
			head = head.prev;
		}
		
		modCount++;
		size++;
	}
	
	//Add the Element to the Tail of the Linked List, O(1)
	public void addLast(T data) {
		if (isEmpty()) {
			head = tail = new Node<T>(data, null, null);
		} else {
			tail.next = new Node<T>(data, tail, null);
			tail = tail.next;
		}
		
		modCount++;
		size++;
	}
	
	//Check the value of the First Node if it exists, O(1)
	public T peekFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty List!");
		
		return head.data;
	}
	
	//Check the value of the Last Node if it exists, O(1) 
	public T peekLast() {
		if (isEmpty())
			throw new RuntimeException("Empty List!");
		
		return tail.data;
	}
	
	//Remove the Element at the Head of the Linked List, O(1)
	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty List!");
		
		T data = head.data;
		head = head.next;
		modCount++;
		--size;
		
		//If the List is now Empty, set the Tail to null as well:
		if (isEmpty())
			tail = null;
		//Do a memory cleanup of the previous Node:
		else
			head.prev = null;
		
		return data;
	}
	
	//Remove the Element at the Tail of the Linked List, O(1)
	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("Empty List!");
		
		T data = tail.data;
		tail = tail.prev;
		modCount++;
		--size;
		
		//If the List is now Empty, set the Head to null as well:
		if (isEmpty())
			head = null;
		//Do a memory cleanup of the next Node: 
		else
			tail.next = null;
		
		return data;
			
	}
	
	//Remove an arbitrary Node from the Linked List, O(1)
	private T remove(Node<T> node) {
		//If the Node to be removed is either at the Head or Tail, then handle
		//that independently:
		if (node.prev==null)
			return removeFirst();
		
		if (node.next==null)
			return removeLast();
		
		//Make the pointers of adjacent Nodes skip over this Node:
		node.next.prev = node.prev;
		node.prev.next = node.next;
		
		//Temporarily store the Data that we want to return;
		T data = node.data;
		
		//Memory Cleanup:
		node.data = null;
		node = node.next = node.prev = null;
		
		modCount++;
		--size;
		
		//Return the data at the Node we just removed:
		return data;
	}
	
	//Remove a Node at a particular index, O(n)
	public T removeAt(int index) {
		if (index<0 || index >=size)
			throw new IndexOutOfBoundsException();
		
		if (isEmpty())
			throw new RuntimeException("Empty List!");
		
		int i;
		Node<T> trav;
		
		//Search from the Front from the List:
		if (index<size/2) {
			for (i=0, trav = head; i!=index; i++)
				trav = trav.next;
			
		}
		//Search from the Back of the List:
		else {
			for (i=size-1, trav=tail; i!=index; i--)
				trav = trav.prev;
			
		}
		
		return remove(trav);
	}
	
	//Remove an Element from the Linked List, O(n)
	public boolean remove(T elem) {
		Node<T> trav;
		
		//Support searching for null:
		if (elem==null) {
			for (trav=head; trav!=null; trav = trav.next) {
				if (trav.data == null) {
					remove(trav);
					return true;
				}
			}
		}
		//Search for Non-Null Object:
		else {
			for (trav=head; trav!=null; trav = trav.next) {
				if (elem.equals(trav.data)) {
					remove(trav);
					return true;
				}
			}
		}
		
		return false;
	}
	
	//Find the Index of a particular Element in the Linked List, O(n)
	public int indexOf(T elem) {
		int index = 0;
		Node<T> trav;
		
		//Support searching for Null:
		if (elem == null) {
			for (trav=head; trav!=null; trav = trav.next, index++) {
				if (trav.data==null)
					return index;
				
			}
		}
		//Search for Non-Null Object:
		else {
			for (trav=head; trav!=null; trav = trav.next, index++) {
				if (elem.equals(trav.data))
					return index;
				
			}
		}
		
		return -1;
	}
	
	public boolean contains(T elem) {
		return (indexOf(elem) != -1);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			private Node<T> trav = head;
			int expectedModCount = modCount;
			
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
		
		while (trav!=null) {
			sb.append(trav.data).append(", ");
			trav = trav.next;
		}
		
		return sb.toString().substring(0, sb.toString().length()-2).concat(" ]");
		
//		sb.append(" ]");
//		
//		return sb.toString();
	}
	
}