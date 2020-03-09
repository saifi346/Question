
public class BinaryTree {

	public Node root;

	static class Node {
		int value;
		Node right;
		Node left;

		Node(int value) {
			this.value = value;
			left = right = null;
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	private Node insert(Node node, int val) {
		if (node == null) {
			return new Node(val);
		}
		if (val <= node.value)
			node.left = insert(node.left, val);
		else if (val > node.value)
			node.right = insert(node.right, val);
		return node;
	}

	public void delete(int value) {
		deleteRec(root, value);
	}
	
	private Node deleteRec(Node root,int key) {
		if (root == null)
			return root;

		if (key < root.value)
			root.left = deleteRec(root.left, key);
		else if (key > root.value)
			root.right = deleteRec(root.right, key);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.value = minValue(root.right);
			root.right = deleteRec(root.right, root.value);
		}

		return root;
    } 
  
    int minValue(Node root) 
    { 
        int minv = root.value; 
        while (root.left != null) 
        { 
            minv = root.left.value; 
            root = root.left; 
        } 
        return minv; 
    } 
  
	

	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(Node r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.left);
			l += countNodes(r.right);
			return l;
		}
	}

	public boolean search(int value) {
		return search(root, value);
	}

	private boolean search(Node r, int val) {
		if (r == null)
			return false;
		if (r.value == val)
			return true;
		return val <= r.value ? search(r.left, val) : search(r.right, val);

	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node r) {
		if (r != null) {
			inorder(r.left);
			System.out.print(r.value + " ");
			inorder(r.right);
		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node r) {
		if (r != null) {
			System.out.print(r.value + " ");
			preorder(r.left);
			preorder(r.right);
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node r) {
		if (r != null) {
			postorder(r.left);
			postorder(r.right);
			System.out.print(r.value + " ");
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		System.out.println("is empty: " + bt.isEmpty());
		bt.insert(8);
		bt.insert(4);
		bt.insert(2);
		bt.insert(10);
		bt.insert(9);
		bt.insert(15);
		bt.insert(3);
		bt.insert(1);
		bt.insert(17);
		bt.insert(1);

		System.out.print("\ninorder : ");
		bt.inorder();
		System.out.print("\npreorder: ");
		bt.preorder();
		System.out.print("\npostorder: ");
		bt.postorder();

		System.out.println("\n\nsearch 2: " + bt.search(2));
		System.out.println("search 7: " + bt.search(7));

		System.out.println("\ncount nodes: " + bt.countNodes());
		
		bt.delete(1);
		System.out.print("\ninorder : ");
		bt.inorder();

	}

}
