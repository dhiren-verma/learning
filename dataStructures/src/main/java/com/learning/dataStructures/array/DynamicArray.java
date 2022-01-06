package com.learning.dataStructures.array;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {
	
	private T [] arr;
	private int len = 0;	
	private int capacity = 0;
	private volatile int modCount = 0;
	
	public DynamicArray() {
		this(16);
	}
	
	public DynamicArray(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: "+capacity);
		
		this.capacity = capacity;
		
		arr = (T[]) new Object[capacity];
	}
	
	public int size() {
		return len;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public T get(int index) {
		if (index<0 || index>len-1)
			throw new IndexOutOfBoundsException();
		
		return arr[index];
	}
	
	public void set(int index, T elem) {
		if (index<0 || index>len-1)
			throw new IndexOutOfBoundsException();
		
		modCount++;
		arr[index] = elem;
	}
	
	public void clear() {
		for (int i=0; i<capacity; i++)
			arr[i] = null;
		
		modCount++;
		len = 0;
	}
	
	public void add(T elem) {
		if (len+1 >= capacity) {
			//Resize the underlying Array:
			if (capacity==0)
				capacity = 1;
			else
				capacity *= 2;
			
			T[] new_arr = (T[]) new Object[capacity];
			
			for (int i=0; i<len; i++)
				new_arr[i] = arr[i];
			
			arr = new_arr;
		}
		
		modCount++;
		arr[len++] = elem;
	}
	
	public T remove(int rm_index) {
		if (rm_index < 0 || rm_index>=len)
			throw new IndexOutOfBoundsException();
		
		modCount++;
		T data = arr[rm_index];
		
		T[] new_arr = (T[]) new Object[len-1];
		
		for (int i=0, j=0; i<len; i++, j++) {
			if (i==rm_index)	//Skip over rm_index by fixing j temporarily
				j--;
			else
				new_arr[j] = arr[i];
		}
		
		arr = new_arr;
		capacity = --len;
		
		return data;
	}
	
	public boolean remove(T elem) {
		for (int i=0; i<len; i++) {
			if (arr[i].equals(elem)) {
				remove(i);
				return true;
			}
				
		}
		
		return false;
	}
	
	public int indexOf(T elem) {
		for(int i=0; i<len; i++) {
			if (arr[i].equals(elem))
				return i;
		}
		
		return -1;
	}
	
	public boolean contains(T elem) {
		return indexOf(elem) != -1;
	}
	
	//Iterator is fast but not as fast a Iterative For Loop:
	//Could have also enabled Fail-Fast behavior:
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index = 0;
			int expectedModCount = modCount;
			
			@Override
			public boolean hasNext() {
				checkForComodification();
				
				return index<len;
			}
			
			@Override
			public T next() {
				checkForComodification();
				
				return arr[index++];
			}
			
	        final void checkForComodification() {
	            if (modCount != expectedModCount)
	                throw new ConcurrentModificationException();
	            
	        }
		};
		
	}
	
	@Override
	public String toString() {
		if (len==0)
			return "[]";
		else {
			StringBuilder sb = new StringBuilder(len).append("[ ");
			
			for (int i=0; i<len-1; i++)
				sb.append(arr[i]).append(", ");
			
			return sb.append(arr[len-1]).append(" ]").toString();
		}
	}
	
}
