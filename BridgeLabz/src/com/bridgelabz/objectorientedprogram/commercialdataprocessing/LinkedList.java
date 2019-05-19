package com.bridgelabz.objectorientedprogram.commercialdataprocessing;

public class LinkedList<T> {
	Node<T> head;
	int length;

	public void add(T data) {
		Node<T> n = new Node<>();
		n.data = data;
		if (length == 0) {
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

	public void remove(int index) {
		Node<T> n = head;
		Node<T> pre = n;
		for (int i = 0; i < index; i++) {
			pre = n;
			n = n.next;
		}
		if (index==0) {
			head = head.next;
			n.next=null;
			n = null;
			length--;
		} else {
			pre.next = n.next;
			n.next = null;
			n=null;
			length--;
		}

	}

	public boolean checkTheWord(String text) {
		Node<T> n = head;
		for (int i = 0; i < length; i++) {
			if (text.equals(n.data))
				return true;
			n = n.next;
		}
		return false;
	}

	public void printList() {
		if (length == 0)
			System.out.println("List is empty.");
		else {
			Node<T> n = head;
			System.out.print("[ ");
			while (n.next != null) {
				System.out.print(n.data + ", ");
				n = n.next;
			}
			System.out.print(n.data + " ]\n");
		}

	}

	public T get(int index) {
		Node<T> n = head;
		for (int i = 0; i < index; i++)
			n = n.next;
		return n.data;
	}


}
