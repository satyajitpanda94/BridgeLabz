package com.bridgelabz.datastructure;

public class Queue<T> {
	Node<T> head;
	private int length;

	public void enqueue(T data) {
		Node<T> node = new Node<>();
		node.data = data;
		if (head == null) {
			head = node;
			length++;
		} else {
			Node<T> nodeTemp = head;
			while (nodeTemp.next != null)
				nodeTemp = nodeTemp.next;
			nodeTemp.next = node;
			length++;
		}
	}

	public T dequeue() {
		Node<T> node = head;
		head = head.next;
		node.next = null;
		T data = node.data;
		node = null;
		length--;
		return data;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int size() {
		return length;
	}

	public String toString() {
		String returnString = "[ ";
		Node<T> node = head;
		while (node.next != null) {
			returnString += (node.data + ", ");
			node = node.next;
		}
		returnString += (node.data + " ]");
		return returnString;
	}

	public T peek() {
		if (head == null)
			return null;
		return head.data;
	}
}
