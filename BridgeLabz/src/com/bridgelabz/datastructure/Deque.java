package com.bridgelabz.datastructure;

public class Deque<T> {
	Node<T> head;
	private int size;

	public void addRear(T data) {
		Node<T> node = new Node<>();
		node.data = data;
		if (head == null) {
			head = node;
			size++;
		} else {
			Node<T> nodeTemp = head;
			while (nodeTemp.next != null)
				nodeTemp = nodeTemp.next;
			nodeTemp.next = node;
			size++;
		}
	}

	public T removeFront() {
		Node<T> node = head;
		head = head.next;
		node.next = null;
		T data = node.data;
		node = null;
		size--;
		return data;
	}

	public T removeRear() {
		Node<T> node = head;
		Node<T> prevousNode = head;
		while (node.next != null) {
			prevousNode = node;
			node = node.next;
		}
		T temp = node.data;
		prevousNode.next = null;
		node = null;
		size--;
		if (size == 0)
			head = null;
		return temp;
	}

	public int size() {
		return size;
	}
}
