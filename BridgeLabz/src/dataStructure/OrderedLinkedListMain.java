package dataStructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderedLinkedListMain {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(
				new File("/home/admin1/eclipse-workspace/BridgeLabz/src/dataStructure/OrderedLinkedListTextInputFile"));
		String s = sc.nextLine() + ",";
		OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();
		int start = 0, end = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ',') {
				start = end + 1;
				end = i;
				oll.add(Integer.parseInt(s.substring(start, end)));
			}
		}
		oll.printList();
		Scanner sca = new Scanner(System.in);
		System.out.println("Enter Number :");
		int num;
		while (true) {
			try {
				num = sca.nextInt();
				if (oll.checkNumber(num))
					oll.remove(num);
				else
					oll.add(num);
				oll.printList();
				oll.addlistToFile();
				sc.close();
				sca.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("You Entered Different Input Type, so Re-enter.");
				sca.nextLine();
			}
		}

	}
}

class Node<T> {
	T data;
	Node<T> next;
}

class OrderedLinkedList<T extends Comparable<T>> {
	private Node<T> head;
	int length;

	public void add(T data) {
		Node<T> n = new Node<>();
		n.data = data;

		if (length == 0) {
			head = n;
			length++;
		} else {
			Node<T> n1 = head;
			Node<T> pre = null;
			while (n1 != null) {
				if (data.compareTo(n1.data) < 0) {
					break;
				}
				pre = n1;
				n1 = n1.next;
			}
			if (n1 == head) {
				head = n;
				n.next = n1;
				length++;
			} else {
				pre.next = n;
				n.next = n1;
				length++;
			}
		}

	}

	public T get(int i) {
		Node<T> n = head;
		for (int j = 0; j < i; j++) {
			n = n.next;
		}
		return n.data;
	}

	public void remove(T num) {
		Node<T> n = head;
		Node<T> pre = null;
		int z = 0;
		for (int i = 0; i < length; i++) {
			if (num.compareTo(n.data) == 0) {
				z = i;
				break;
			}
			pre = n;
			n = n.next;
		}
		if (z == 0) {
			head = head.next;
			n = null;
			length--;
		} else {
			pre.next = n.next;
			n = null;
			length--;
		}

	}

	public boolean checkNumber(T num) {
		Node<T> n = head;
		for (int i = 0; i < length; i++) {
			if (n.data.compareTo(num) == 0)
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

	public void addlistToFile() {
		try {
			FileWriter fw = new FileWriter(
					"/home/admin1/eclipse-workspace/BridgeLabz/src/dataStructure/OrderedLinkedListTextOutputFile");
			int l = length;
			for (int i = 0; i < l; i++) {
				fw.write(get(i) + " ");
			}
			System.out.println("List is added to file.");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
