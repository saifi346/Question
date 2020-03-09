
public class StackUsingLinkedList {
	
	Node root;
	 
	static class Node {
		Node next;
		int data;
		Node(int data) {
			this.data=data;
			next=null;
		}
	}
	
	public boolean isEmpty() {
		if(root==null) {
			System.out.println("Stack is Empty");
			return true;
		}
		else {
			System.out.println("Stack is not Empty");
			return false;
		}
	}
	
	public void push(int data) {
		if(root==null) {
			root = new Node(data);
		}
		else {
			Node temp = root;
			root= new Node(data);
			root.next = temp;
		}
		System.out.println("pushed to Stack : "+data);
	}
	
	public int pop() {
		int x;
		if(root==null) {
			System.out.println("Stack Underflow");
			return -1;
		}
		else {
			x = root.data;
			root = root.next;
			System.out.println("Popped element : " + x);
			
		}
		return x;
	}
	
	public int peek() {
		int x;
		if(root==null) {
			System.out.println("Stack Underflow");
			return -1;
		}
		else {
			x = root.data;
			System.out.println("Peek element : " + x);
			
		}
		return x;
	}

	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.pop();
        stack.isEmpty();
        stack.push(4);
        stack.push(9);
        stack.push(10);
        stack.peek();
        stack.pop();
        stack.pop();
	}

}
