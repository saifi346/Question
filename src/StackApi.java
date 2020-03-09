
public class StackApi {

	public final static int MAX = 100;

	int top;

	int[] a = new int[MAX];

	StackApi() {
		top = -1;
	}

	boolean isEmpty() {
		return (top < 0);
	}

	public void push(int val) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack OverFlow");
		} else {
			a[++top] = val;
			System.out.println("Element Pushed: "+val);
		}
	}

	public int pop() {
		if (top < 0) {
			System.out.println("Stack underFlow");
			return -1;
		} else {
			int x = a[top--];
			System.out.println("Pop: "+x);
			return x;
		}
	}

	public int peek() {
		if (top < 0) {
			System.out.println("Stack underFlow");
			return -1;
		} else {
			int x = a[top];
			System.out.println("Peek: "+x);
			return x;
		}
	}

	public static void main(String[] args) {
        StackApi stack = new StackApi();
        stack.pop();
        stack.push(4);
        stack.push(9);
        stack.push(10);
        stack.peek();
        stack.pop();
        stack.pop();
	}

}
