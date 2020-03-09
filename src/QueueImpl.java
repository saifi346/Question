
public class QueueImpl {

	Node front, rear;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public QueueImpl() {
		this.front = this.rear = null;
	}

	public void Enqueue(int data) {
		Node temp = new Node(data);
		if (this.rear == null) {
			this.rear = this.front = temp;
			System.out.println("Element inserted : "+data);
			return;
		}

		this.rear.next = temp;
		this.rear = temp;
		System.out.println("Element inserted : "+data);
	}

	public int Dequeue() {
		if (this.front == null)
			return -1;
		Node temp = this.front;
		this.front=this.front.next;
		
		if(this.front==null)
			this.rear=null;
		
		System.out.println("Element removed : "+temp.data);
		return 1;
	}
	
	public boolean isEmpty() {
		return this.front==null;
	}

	public static void main(String[] args) {
		QueueImpl queue = new QueueImpl();
		System.out.println("isEmpty: "+queue.isEmpty());
		queue.Enqueue(5);
		queue.Enqueue(9);
		queue.Enqueue(10);
		queue.Dequeue();
		queue.Enqueue(3);
		queue.Dequeue();
		System.out.println("isEmpty: "+queue.isEmpty());
		
	}

}
