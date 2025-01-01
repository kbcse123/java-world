package com.javaworld.A6_Data_Structures.A1_General;

import java.util.stream.IntStream;

import com.javaworld.A6_Data_Structures.DataStructure;

/**
 * @author shaik
 *
 */

public class A3_GenericLinkedList<E> implements DataStructure<E> {
	static class Node<E> {
		E data;
		Node<E> next;

		Node(E e) {
			data = e;
		}
	}

	private Node<E> head;

	/**
	 * 
	 */
	public A3_GenericLinkedList() {

	}

	public boolean add(E e) {
		Node<E> newNode = new Node<>(e);
		if (head == null) {
			head = newNode;
		} else {
			Node<E> itrNode = head;
			while (itrNode.next != null) {
				itrNode = itrNode.next;
			}
			itrNode.next = newNode;
		}

		return true;
	}

	public boolean addAt(E e, int position) {
		Node<E> newNode = new Node<>(e);
		if (position == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<E> itrNode = head;
			int count = 1;
			while (count != position && itrNode.next != null) {
				itrNode = itrNode.next;
				count++;
			}
			if (count == position) {
				itrNode.next = newNode;
			}
		}

		return true;
	}

	public boolean remove(E e) {
		Node<E> itrNode = head;
		if (e.equals(head.data)) {
			head = head.next;
			itrNode = null;
			System.out.println("Item removed: " + e);
			return true;
		} else {
			while (itrNode.next != null) {
				if (e.equals(itrNode.next.data)) {
					Node<E> remNode = itrNode.next;
					itrNode.next = remNode.next;
					remNode = null;
					System.out.println("Item removed: " + e);
					return true;
				} else {
					itrNode = itrNode.next;
				}
			}
		}
		System.out.println("Item " + e + " not found");
		return false;
	}

	@Override
	public String toString() {
		StringBuilder nodes = new StringBuilder();
		Node<E> start = head;
		while (start != null) {
			nodes.append("[" + start.data + "]");
			start = start.next;
			if (start != null) {
				nodes.append(" --> ");
			}
		}
		return "Items: " + nodes.toString();
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int search(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A3_GenericLinkedList<Integer> intll = new A3_GenericLinkedList<>();
		IntStream.range(1, 10).forEach(item -> {
			intll.add(item);
		});
		System.out.println(intll);
		intll.remove(1);
		System.out.println(intll);
		intll.remove(5);
		System.out.println(intll);
		intll.remove(9);
		System.out.println(intll);
		intll.addAt(5, 1);
		System.out.println(intll);
		intll.remove(6);
		System.out.println(intll);

	}

}
