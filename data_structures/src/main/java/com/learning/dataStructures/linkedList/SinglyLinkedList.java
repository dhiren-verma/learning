package com.learning.dataStructures.linkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import com.learning.dataStructures.exceptions.IndexOutOfBoundsException;

public class SinglyLinkedList<T> implements Iterable<T> {
	
	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;
	private volatile int modCount = 0;
	
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
	

	//Insertion at Beginning, at End & after Specified Node:
	//Deletion at Beginning, at End, after Specified Node:
	//Searching
	//Traversing
	
	
	//Empty the Linked List: O(n)
	public void clear() {
		Node<T> trav = head;
		
		while(trav!=null) {
			Node<T> next = trav;
			trav.data = null;
			trav.next = null;
			
			head = next;
		}
		
		modCount++;
		head = tail = trav = null;
		size = 0;
	}
	
	//size
	public int size() {
		return size;
	}
	
	//isEmpty
	public boolean isEmpty() {
		return size()==0;
	}
	
	//add, O(1)
	public void add(T elem) {
		addLast(elem);
	}
	
	//addFirst, O(1):
	public void addFirst(T elem) {
		if (isEmpty())
			head = tail = new Node<T>(elem, null);
		else
			head = new Node<T>(elem, head);
		
		modCount++;
		size++;
	}
	
	//addLast, O(1):
	public void addLast(T elem) {
		if (isEmpty())
			head = tail = new Node<T>(elem, null);
		else {
			Node<T> newTail = new Node<T>(elem, null);
			
			tail.next = newTail;
			tail = newTail;
		}
		
		modCount++;
		size++;
	}
	
	//peekFirst, O(1):
	public T peekFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty List!");
		
		return head.data;
	}
	
	//peekLast, O(1)
	public T peekLast() {
		if (isEmpty())
			throw new RuntimeException("Empty List!");
		
		return tail.data;
	}
	
	//removeFirst, O(1):
	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty List!");
		
		T data = head.data;
		head = head.next;
		
		modCount++;
		--size;
		
		if (isEmpty())
			tail = null;
		
		return data;
	}
	
	//removeLast, O(n):
	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("Empty List!");
		
		T data = tail.data;
		
		Node<T> trav = head;
		Node<T> nextTrav = head.next;
		
		while (trav.next!=null && nextTrav.next!=null) {
			trav = trav.next;
			nextTrav = nextTrav.next;
		}
		
		trav.next = null;
		tail = trav;
		
		modCount++;
		--size;
		
		if (isEmpty())
			head = null;
		
		return data;
	}
	
	//Remove Node at a particular index, O(n):
	public T removeAt(int index) {
		if (index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		
		if (isEmpty())
			throw new RuntimeException("Empty List!");
		
		if (index == 0)
			return removeFirst();
		else if (index == size-1)
			return removeLast();
		else {
			int i;
			Node<T> trav;
			Node<T> nextTrav;
			
			for (i=1, trav = head, nextTrav = head.next; i!=index; i++) {
				trav = trav.next;
				nextTrav = nextTrav.next;
			}
			
			T data = nextTrav.data;
			
			trav.next = nextTrav.next;
			nextTrav.data = null;
			nextTrav = nextTrav.next = null;
			
			modCount++;
			--size;
			
			return data;
		}
	}
	
	//Remove Node containing this Data, O(n):
	public boolean remove(T elem) {
		if (isEmpty())
			return false;
		else {
			Node<T> trav;
			
			if (elem==null) {
				if (head.data==null) {
					removeFirst();
					return true;
				} else {
					for (trav=head; trav!=null && trav.next!=null; trav=trav.next) {
						if (trav.next.data == null) {
							if (trav.next.next==null) {
								//trav.next was the Tail:
								removeLast();
								return true;
							} else {
								//There are more elements after trav.next;
								//Remove trav.next:
								Node<T> removalNode = trav.next;
								
								trav.next = trav.next.next;
								
								removalNode.next = null;
								
								modCount++;
								--size;
								
								return true;
							}
						}
					}
				}
			} else {
				if (elem.equals(head.data)) {
					removeFirst();
					return true;
				} else {
					for (trav=head; trav.next!=null && trav.next.next!=null; trav=trav.next) {
						if (elem.equals(trav.next.data)) {
							if (trav.next.next==null) {
								//trav.next was the Tail:
								removeLast();
								return true;
							} else {
								//There are more elements after trav.next;
								//Remove trav.next:
								Node<T> removalNode = trav.next;
								
								trav.next = trav.next.next;
								
								removalNode.data = null;
								removalNode.next = null;
								
								modCount++;
								--size;
								
								return true;
							}
						}
					}
				}
			}
			
			return false;
		}
	}
	
	//indexOf
	public int indexOf(T elem) {
		int index = 0;
		Node<T> trav;
		
		if (elem == null) {
			for (trav=head; trav!=null; trav = trav.next, index++) {
				if (trav.data==null)
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
	
	//contains
	public boolean contains(T elem) {
		return indexOf(elem)!=-1;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			private Node<T> trav;
			private int expectedModCount = modCount;
			
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
	
	//toString
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append("[ ");
		
		Node<T> trav = head;
		
		while(trav!=null) {
			sb.append(trav.data).append(", ");
			
			trav = trav.next;
		}
		
		return sb.toString().substring(0, sb.toString().length()-2).concat(" ]");
		
//		sb.append(" ]");
//		
//		return sb.toString();
	}
	
}