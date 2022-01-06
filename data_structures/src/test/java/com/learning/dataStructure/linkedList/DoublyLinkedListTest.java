package com.learning.dataStructure.linkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.dataStructures.linkedList.DoublyLinkedList;

public class DoublyLinkedListTest {
	
	private DoublyLinkedList<String> dLinkedList = null;
	
	@BeforeEach
	public void initializeDoublyLinkedList() {
		dLinkedList = new DoublyLinkedList<>();
	}
	
	@Test
	public void checkEmptyDoublyLinkedList() {
		int expectedSize = 0;
		assertSize(expectedSize, dLinkedList.size());
		assertIsEmpty(dLinkedList);
	}
	
	@Test
	public void checkFirstElementInsertion() {
		int expectedSize = 0;
		String elem = "Doubly";
		String expectedDoublyLinkedList = "[ Doubly ]";
		
		expectedSize += addElement(dLinkedList, elem);
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsNotEmpty(dLinkedList);
		assertValue(elem, dLinkedList.peekFirst());
		assertValue(expectedDoublyLinkedList, dLinkedList.toString());
	}
	
	@Test
	public void checkInsertionAtHead() {
		int expectedSize = 0;
		String newHeadElem = "Doubly";
		String expectedDoublyLinkedList = "[ Doubly, Linked ]";
		
		expectedSize += addElement(dLinkedList, "Linked");
		expectedSize += addElementAtHead(dLinkedList, newHeadElem);
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsNotEmpty(dLinkedList);
		assertValue(newHeadElem, dLinkedList.peekFirst());
		assertValue(expectedDoublyLinkedList, dLinkedList.toString());
	}
	
	@Test
	public void checkInsertionAtTail() {
		int expectedSize = 0;
		String newTailElem = "List";
		String expectedDoublyLinkedList = "[ Doubly, Linked, List ]";
		
		expectedSize += addElement(dLinkedList, "Linked");
		expectedSize += addElementAtHead(dLinkedList, "Doubly");
		expectedSize += addElementAtTail(dLinkedList, newTailElem);
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsNotEmpty(dLinkedList);
		assertValue(newTailElem, dLinkedList.peekLast());
		assertValue(expectedDoublyLinkedList, dLinkedList.toString());
	}
	
	@Test
	public void checkHeadRemoval() {
		int expectedSize = 0;
		String headElem = "Doubly";
		
		expectedSize += addElement(dLinkedList, "Linked");
		expectedSize += addElementAtHead(dLinkedList, headElem);
		expectedSize += addElementAtTail(dLinkedList, "List");
		
		assertValue(headElem, dLinkedList.removeFirst());
		--expectedSize;
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsNotEmpty(dLinkedList);
		
		int expectedIndex = -1;
		assertIndex(expectedIndex, dLinkedList.indexOf(headElem));
		
		expectedIndex = 0;
		assertIndex(expectedIndex, dLinkedList.indexOf("Linked"));
		
		expectedIndex = 1;
		assertIndex(expectedIndex, dLinkedList.indexOf("List"));
		
	}
	
	@Test
	public void checkTailRemoval() {
		int expectedSize = 0;
		String tailElem = "List";
		
		expectedSize += addElement(dLinkedList, "Linked");
		expectedSize += addElementAtHead(dLinkedList, "Doubly");
		expectedSize += addElementAtTail(dLinkedList, tailElem);
		
		assertValue(tailElem, dLinkedList.removeLast());
		--expectedSize;
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsNotEmpty(dLinkedList);
		
		int expectedIndex = -1;
		assertIndex(expectedIndex, dLinkedList.indexOf(tailElem));

		expectedIndex = 0;
		assertIndex(expectedIndex, dLinkedList.indexOf("Doubly"));
		
		expectedIndex = 1;
		assertIndex(expectedIndex, dLinkedList.indexOf("Linked"));
		
	}
	
	@Test
	public void checkHeadRemovalEmptyList() {
		int expectedSize = 0;
		String headElem = "Doubly";
		
		expectedSize += addElementAtHead(dLinkedList, headElem);
		
		assertValue(headElem, dLinkedList.removeFirst());
		--expectedSize;
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsEmpty(dLinkedList);
	}
	
	@Test
	public void checkTailRemovalEmptyList() {
		int expectedSize = 0;
		String tailElem = "Doubly";
		
		expectedSize += addElementAtTail(dLinkedList, tailElem);
		
		assertValue(tailElem, dLinkedList.removeLast());
		--expectedSize;
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsEmpty(dLinkedList);
	}
	
	@Test
	public void removeElement() {
		int expectedSize = 0;
		String headElem = "Doubly";
		
		expectedSize += addElement(dLinkedList, "Linked");
		expectedSize += addElementAtHead(dLinkedList, headElem);
		expectedSize += addElementAtTail(dLinkedList, "List");
		
		assertIsRemoved(dLinkedList, headElem);
		--expectedSize;
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsNotEmpty(dLinkedList);
		
		int expectedIndex = -1;
		assertIndex(expectedIndex, dLinkedList.indexOf(headElem));
		
		expectedIndex = 0;
		assertIndex(expectedIndex, dLinkedList.indexOf("Linked"));
		
		expectedIndex = 1;
		assertIndex(expectedIndex, dLinkedList.indexOf("List"));
		
	}
	
	@Test
	public void removeElementToEmptyList() {
		int expectedSize = 0;
		String elem = "Doubly";
		
		expectedSize += addElementAtHead(dLinkedList, elem);
		
		assertIsRemoved(dLinkedList, elem);
		--expectedSize;
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsEmpty(dLinkedList);
	} 
	
	@Test
	public void removeFromIndex() {
		int expectedSize = 0;
		String headElem = "Doubly";
		
		expectedSize += addElement(dLinkedList, "Linked");
		expectedSize += addElementAtHead(dLinkedList, headElem);
		expectedSize += addElementAtTail(dLinkedList, "List");
		
		int index = dLinkedList.indexOf(headElem);
		
		assertValue(headElem, dLinkedList.removeAt(index));
		--expectedSize;
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsNotEmpty(dLinkedList);
		
		int expectedIndex = -1;
		assertIndex(expectedIndex, dLinkedList.indexOf(headElem));
		
		expectedIndex = 0;
		assertIndex(expectedIndex, dLinkedList.indexOf("Linked"));
		
		expectedIndex = 1;
		assertIndex(expectedIndex, dLinkedList.indexOf("List"));
		
	}

	@Test
	public void removeFromIndexToEmptyList() {
		int expectedSize = 0;
		String headElem = "Doubly";
		
		expectedSize += addElementAtHead(dLinkedList, headElem);
				
		int index = dLinkedList.indexOf(headElem);
		
		assertValue(headElem, dLinkedList.removeAt(index));
		--expectedSize;
		
		assertSize(expectedSize, dLinkedList.size());
		assertIsEmpty(dLinkedList);
	}
	
	@Test
	public void removeNonExistingElement() {
		addElement(dLinkedList, "Some");
		addElement(dLinkedList, "value");
		
		assertNotRemoved(dLinkedList, "otherValue");
	}
	
	@Test
	public void checkIfLinkedListContains() {
		String elem = "Doubly";
		
		addElement(dLinkedList, "Linked");
		addElementAtHead(dLinkedList, elem);
		addElementAtTail(dLinkedList, "List");
		
		assertTrue(dLinkedList.contains(elem));
		
	}
	
	@Test
	public void checkLinkedListIteration() {
		String[] elements = {"Doubly", "Linked", "List"};
		
		for(String element : elements) {
			addElement(dLinkedList, element);
		}
		
		int index = 0;
		Iterator<String> itr = dLinkedList.iterator();
		
		while (itr.hasNext())
			assertEquals(elements[index++], itr.next());
		
	}
	
	
	
	
	
	void assertSize(int expectedSize, int size) {
		assertEquals(expectedSize, size);
	}
	
	private void assertIsEmpty(DoublyLinkedList<String> dLinkedList) {
		assertTrue(dLinkedList.isEmpty());
	}

	private void assertIsNotEmpty(DoublyLinkedList<String> dLinkedList) {
		assertTrue(!dLinkedList.isEmpty());
	}

	private void assertValue(String expectedValue, String value) {
		assertEquals(expectedValue, value);
	}

	private void assertIndex(int expectedIndex, int index) {
		assertEquals(expectedIndex, index);
	}
	
	private int addElement(DoublyLinkedList<String> dLinkedList, String elem) {
		dLinkedList.add(elem);
		return 1;
	}
	
	private int addElementAtHead(DoublyLinkedList<String> dLinkedList, String newHeadElem) {
		dLinkedList.addFirst(newHeadElem);
		return 1;
	}
	
	private int addElementAtTail(DoublyLinkedList<String> dLinkedList, String newTailElem) {
		dLinkedList.addLast(newTailElem);
		return 1;
	}
	
	private void assertIsRemoved(DoublyLinkedList<String> dLinkedList, String element) {
		assertTrue(dLinkedList.remove(element));
	}
	
	private void assertNotRemoved(DoublyLinkedList<String> dLinkedList, String element) {
		assertTrue(!dLinkedList.remove(element));
	}
	
}