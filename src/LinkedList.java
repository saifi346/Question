
public class LinkedList {
	Node head;
	static class Node {
		Node next;
		int data;
		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void insert(LinkedList list, int data) {
		Node new_node = new Node(data);
		if (list.head == null) {
			list.head = new_node;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new_node;
		}
	}

	public static void insertAtPos(LinkedList list, int pos, int data) {
		Node new_node = new Node(data);
		if (pos < 0) {
			System.out.println("pos out of range:" + pos);
			return;
		}
		if (list.head == null) {
			if (pos == 0) {
				list.head = new_node;
				System.out.println("elem inserted at pos: " + pos);
			}
			return;
		}
		Node curr = list.head;
		Node prev = null;
		int count = 0;
		while (count < pos) {
			prev = curr;
			curr = curr.next;
			count++;
			if (curr == null) {
				break;
			}
		}
		if (count != pos) {
			System.out.println("pos out of range:" + pos);
			return;
		}
		System.out.println("elem inserted at pos: " + pos);
		prev.next = new_node;
		new_node.next = curr;
	}

	public static void deleteAtPos(LinkedList list, int pos) {
		Node curr = list.head;
		Node prev = null;
		if (pos < 0) {
			System.out.println("pos out of range :" + pos);
		}
		if (pos == 0 && curr != null) {
			list.head = curr.next;
			System.out.println("elem deleted from pos: " + pos);
			return;
		}
		int count = 0;
		while (curr != null) {
			if (count == pos) {
				prev.next = curr.next;
				System.out.println("elem deleted from pos: " + pos);
				break;
			} else {
				prev = curr;
				curr = curr.next;
				count++;
			}
		}
		if (curr == null)
			System.out.println("elem not found:" + pos);
	}

	public static void printList(LinkedList list) {
		Node currNode = list.head;
		System.out.print("Linked List : ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		insert(list, 4);
		insert(list, 5);
		insert(list, 0);
		insert(list, 1);
		insert(list, 12);
		insert(list, 8);
		insert(list, 3);

		printList(list);

		insertAtPos(list, 4, 6);
		printList(list);

		insertAtPos(list, 11, 7);
		insertAtPos(list, -1, 14);

		deleteAtPos(list, 4);
		printList(list);

		deleteAtPos(list, 14);
		printList(list);

		deleteAtPos(list, 0);
		printList(list);

	}
}
