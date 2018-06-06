import java.util.LinkedList;
  
     /*Sorted Binary Search Tree based on BST class*/
public class SortedBST<T> extends BST<Integer> {
	Node root;
	int size = 0;
	LinkedList<Node> list = new LinkedList<Node>();
	int temp ;


	
	public SortedBST() 
	{
		size=0;
		temp=1;
		
	}
	public void SetSize(int t) 
	{
		size=size+t;
		for (int i = 0; i <= size; i++) {
			Node node = new Node(i);
			list.add(node);
		}
		this.insert();
	}
	
	protected class Node {
		Node left;
		Node right;
		int info;
		int start;
		int end;

		public Node(int t) {
			left = null;
			right = null;
			info = t;
			start=0;
			end=0;
		}

		protected int setleft() {
			Node node = list.get((this.info + this.start) / 2);
			this.left = node;
			this.left.start = this.start;
			this.left.end = this.info;
			return (this.info + this.start) / 2;
		}

		protected int setright() {
			Node node = list.get((this.info + this.end) / 2);
			this.right = node;
			this.right.start = this.info;
			this.right.end = this.end;
			return (this.info + this.end) / 2;
		}

		protected int getleft() {
			return this.left.info;
		}

		protected int getright() {
			return this.right.info;
		}

		protected void setinfo(int t) {
			this.info = t;
		}

		protected void setchildren() {

			if (this.info != this.start && this.info != this.end) {
				int m = this.setleft();
				int n = this.setright();
				list.get(m).setchildren();
				list.get(n).setchildren();
			}
		}

		protected int search(int t) {
			
			
			if (this.info == t) {
				return temp;
			}
			if (this.info > t) {
				temp++;
				this.left.search(t);
			}
			if (this.info < t) {
				temp++;
				this.right.search(t);
			}
			return temp;

		}
	}

	protected int search(int t) {
		if (root != null) {
			return root.search(t);
		} else
			return 0;
	}

	protected void insert() /*According to the size of BST, implement the tree with index number automatically*/
	{
		this.root = list.get(size/2);
		root.start = 0;
		root.end = size;
		root.setchildren();
	}

}
