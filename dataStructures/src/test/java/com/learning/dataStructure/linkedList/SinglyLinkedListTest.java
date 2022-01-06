package com.learning.dataStructure.linkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.dataStructures.linkedList.SinglyLinkedList;

public class SinglyLinkedListTest {

	private SinglyLinkedList<String> sLinkedList = null;
	
	@BeforeEach
	public void initializeDoublyLinkedList() {
		sLinkedList = new SinglyLinkedList<>();
	}
	
	@Test
	public void checkEmptyDoublyLinkedList() {
		int expectedSize = 0;
		assertSize(expectedSize, sLinkedList.size());
		assertIsEmpty(sLinkedList);
	}
	
	@Test
	public void checkFirstElementInsertion() {
		int expectedSize = 0;
		String elem = "Singly";
		String expectedDoublyLinkedList = "[ Singly ]";
		
		expectedSize += addElement(sLinkedList, elem);
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsNotEmpty(sLinkedList);
		assertValue(elem, sLinkedList.peekFirst());
		assertValue(expectedDoublyLinkedList, sLinkedList.toString());
	}
	
	@Test
	public void checkInsertionAtHead() {
		int expectedSize = 0;
		String newHeadElem = "Singly";
		String expectedDoublyLinkedList = "[ Singly, Linked ]";
		
		expectedSize += addElement(sLinkedList, "Linked");
		expectedSize += addElementAtHead(sLinkedList, newHeadElem);
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsNotEmpty(sLinkedList);
		assertValue(newHeadElem, sLinkedList.peekFirst());
		assertValue(expectedDoublyLinkedList, sLinkedList.toString());
	}
	
	@Test
	public void checkInsertionAtTail() {
		int expectedSize = 0;
		String newTailElem = "List";
		String expectedDoublyLinkedList = "[ Singly, Linked, List ]";
		
		expectedSize += addElement(sLinkedList, "Linked");
		expectedSize += addElementAtHead(sLinkedList, "Singly");
		expectedSize += addElementAtTail(sLinkedList, newTailElem);
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsNotEmpty(sLinkedList);
		assertValue(newTailElem, sLinkedList.peekLast());
		assertValue(expectedDoublyLinkedList, sLinkedList.toString());
	}
	
	@Test
	public void checkHeadRemoval() {
		int expectedSize = 0;
		String headElem = "Singly";
		
		expectedSize += addElement(sLinkedList, "Linked");
		expectedSize += addElementAtHead(sLinkedList, headElem);
		expectedSize += addElementAtTail(sLinkedList, "List");
		
		assertValue(headElem, sLinkedList.removeFirst());
		--expectedSize;
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsNotEmpty(sLinkedList);
		
		int expectedIndex = -1;
		assertIndex(expectedIndex, sLinkedList.indexOf(headElem));
		
		expectedIndex = 0;
		assertIndex(expectedIndex, sLinkedList.indexOf("Linked"));
		
		expectedIndex = 1;
		assertIndex(expectedIndex, sLinkedList.indexOf("List"));
		
	}
	
	@Test
	public void checkTailRemoval() {
		int expectedSize = 0;
		String tailElem = "List";
		
		expectedSize += addElement(sLinkedList, "Linked");
		expectedSize += addElementAtHead(sLinkedList, "Singly");
		expectedSize += addElementAtTail(sLinkedList, tailElem);
		
		assertValue(tailElem, sLinkedList.removeLast());
		--expectedSize;
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsNotEmpty(sLinkedList);
		
		int expectedIndex = -1;
		assertIndex(expectedIndex, sLinkedList.indexOf(tailElem));

		expectedIndex = 0;
		assertIndex(expectedIndex, sLinkedList.indexOf("Singly"));
		
		expectedIndex = 1;
		assertIndex(expectedIndex, sLinkedList.indexOf("Linked"));
		
	}
	
	@Test
	public void checkHeadRemovalEmptyList() {
		int expectedSize = 0;
		String headElem = "Singly";
		
		expectedSize += addElementAtHead(sLinkedList, headElem);
		
		assertValue(headElem, sLinkedList.removeFirst());
		--expectedSize;
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsEmpty(sLinkedList);
	}
	
	@Test
	public void checkTailRemovalEmptyList() {
		int expectedSize = 0;
		String tailElem = "Singly";
		
		expectedSize += addElementAtTail(sLinkedList, tailElem);
		
		assertValue(tailElem, sLinkedList.removeLast());
		--expectedSize;
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsEmpty(sLinkedList);
	}
	
	@Test
	public void removeElement() {
		int expectedSize = 0;
		String headElem = "Singly";
		
		expectedSize += addElement(sLinkedList, "Linked");
		expectedSize += addElementAtHead(sLinkedList, headElem);
		expectedSize += addElementAtTail(sLinkedList, "List");
		
		assertIsRemoved(sLinkedList, headElem);
		--expectedSize;
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsNotEmpty(sLinkedList);
		
		int expectedIndex = -1;
		assertIndex(expectedIndex, sLinkedList.indexOf(headElem));
		
		expectedIndex = 0;
		assertIndex(expectedIndex, sLinkedList.indexOf("Linked"));
		
		expectedIndex = 1;
		assertIndex(expectedIndex, sLinkedList.indexOf("List"));
		
	}
	
	@Test
	public void removeElementToEmptyList() {
		int expectedSize = 0;
		String elem = "Singly";
		
		expectedSize += addElementAtHead(sLinkedList, elem);
		
		assertIsRemoved(sLinkedList, elem);
		--expectedSize;
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsEmpty(sLinkedList);
	} 
	
	@Test
	public void removeFromIndex() {
		int expectedSize = 0;
		String headElem = "Singly";
		
		expectedSize += addElement(sLinkedList, "Linked");
		expectedSize += addElementAtHead(sLinkedList, headElem);
		expectedSize += addElementAtTail(sLinkedList, "List");
		
		int index = sLinkedList.indexOf(headElem);
		
		assertValue(headElem, sLinkedList.removeAt(index));
		--expectedSize;
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsNotEmpty(sLinkedList);
		
		int expectedIndex = -1;
		assertIndex(expectedIndex, sLinkedList.indexOf(headElem));
		
		expectedIndex = 0;
		assertIndex(expectedIndex, sLinkedList.indexOf("Linked"));
		
		expectedIndex = 1;
		assertIndex(expectedIndex, sLinkedList.indexOf("List"));
		
	}

	@Test
	public void removeFromIndexToEmptyList() {
		int expectedSize = 0;
		String headElem = "Singly";
		
		expectedSize += addElementAtHead(sLinkedList, headElem);
		
		int index = sLinkedList.indexOf(headElem);
		
		assertValue(headElem, sLinkedList.removeAt(index));
		--expectedSize;
		
		assertSize(expectedSize, sLinkedList.size());
		assertIsEmpty(sLinkedList);
	}
	
	@Test
	public void removeNonExistingElement() {
		addElement(sLinkedList, "Some");
		addElement(sLinkedList, "value");
		
		assertNotRemoved(sLinkedList, "otherValue");
	}
	
	@Test
	public void checkIfLinkedListContains() {
		String elem = "Singly";
		
		addElement(sLinkedList, "Linked");
		addElementAtHead(sLinkedList, elem);
		addElementAtTail(sLinkedList, "List");
		
		assertTrue(sLinkedList.contains(elem));
		
	}
	
	@Test
	public void checkLinkedListIteration() {
		String[] elements = {"Singly", "Linked", "List"};
		
		for(String element : elements) {
			addElement(sLinkedList, element);
		}
		
		int index = 0;
		Iterator<String> itr = sLinkedList.iterator();
		
		while (itr.hasNext())
			assertEquals(elements[index++], itr.next());
		
	}
	
	
	
	
	
	void assertSize(int expectedSize, int size) {
		assertEquals(expectedSize, size);
	}
	
	private void assertIsEmpty(SinglyLinkedList<String> dLinkedList) {
		assertTrue(dLinkedList.isEmpty());
	}

	private void assertIsNotEmpty(SinglyLinkedList<String> dLinkedList) {
		assertTrue(!dLinkedList.isEmpty());
	}

	private void assertValue(String expectedValue, String value) {
		assertEquals(expectedValue, value);
	}

	private void assertIndex(int expectedIndex, int index) {
		assertEquals(expectedIndex, index);
	}
	
	private int addElement(SinglyLinkedList<String> dLinkedList, String elem) {
		dLinkedList.add(elem);
		return 1;
	}
	
	private int addElementAtHead(SinglyLinkedList<String> dLinkedList, String newHeadElem) {
		dLinkedList.addFirst(newHeadElem);
		return 1;
	}
	
	private int addElementAtTail(SinglyLinkedList<String> dLinkedList, String newTailElem) {
		dLinkedList.addLast(newTailElem);
		return 1;
	}
	
	private void assertIsRemoved(SinglyLinkedList<String> dLinkedList, String element) {
		assertTrue(dLinkedList.remove(element));
	}
	
	private void assertNotRemoved(SinglyLinkedList<String> dLinkedList, String element) {
		assertTrue(!dLinkedList.remove(element));
	}
	
}
