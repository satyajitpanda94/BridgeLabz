package com.bridgelabz.datastructure;

public class Stack<T> {
	private Node<T> head;
	private int length;

	public int size() {
		return length;
	}

	public void push(T data) {
		Node<T> n = new Node<>();
		n.data = data;
		if (head == null) {
			head = n;
			length++;
		} else {
			Node<T> n1 = head;
			while (n1.next != null)
				n1 = n1.next;
			n1.next = n;
			length++;
		}
	}

	public T pop() {
		Node<T> n = head;
		Node<T> pre = head;
		while (n.next != null) {
			pre = n;
			n = n.next;
		}
		T temp1 = n.data;
		pre.next = null;
		n = null;
		length--;
		if (length == 0)
			head = null;
		return temp1;

	}

	public T peek() {
		if (head == null)
			return null;
		Node<T> n = head;
		while (n.next != null)
			n = n.next;
		return n.data;

	}

	public boolean isEmpty() {
		if (length == 0)
			return true;
		else
			return false;
	}

}
