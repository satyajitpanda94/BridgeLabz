package com.bridgelabz.datastructure;

import java.io.FileWriter;
import java.io.IOException;

public class UnorderedList<T> {
	private Node<T> head;
	static int length;

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

	public void remove(String text) {
		Node<T> n = head;
		Node<T> pre = null;
		int k = 0;
		for (int i = 0; i < length; i++) {

			if (text.equals(n.data)) {
				k = i;
				break;
			}
			pre = n;
			n = n.next;

		}
		if (k == 0) {
			head = head.next;
			n = null;
			length--;
		} else {
			pre.next = n.next;
			n = null;
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

	public void addlistToFile() {
		try {
			FileWriter fw = new FileWriter(
					"/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/datastructure/UnorderedLinkListOutputFile");
			int l = length;
			for (int i = 0; i < l; i++) {
				fw.write(this.get(i) + " ");
			}
			System.out.println("List is added to file.");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
