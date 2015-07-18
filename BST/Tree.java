public class Tree {
	Node t;
	public Tree() {
		t = null;
	}

	public void insert(int x){
		Node n = new Node(x);
		// recursiveInsert(t, n);
		iterativeInsert(t, n);
	}

	private void iterativeInsert(Node root, Node n){
		if(root == null){
			t = n;
		}
		else{
			Node temp = root;
			boolean assigned = false;
			while(!assigned){
				if(n.getVal() < root.getVal()){
					if(root.getLeft() == null){
						root.setLeft(n);
						assigned = true;
					}
					else{
						root = root.getLeft();
					}
				}
				else{
					if(root.getRight() == null){
						root.setRight(n);
						assigned = true;
					}
					else{
						root = root.getRight();
					}
				}
			}
		}
	}

	private void recursiveInsert(Node root, Node n){
		// System.out.println("in recursiveInsert.");
		if(root == null){
			System.out.println("in null condition..");
			t = n;
		}
		else{
			if(n.getVal() < root.getVal()){
				if(root.getLeft() != null) {
					recursiveInsert(root.getLeft(), n);
				}
				else{
					root.setLeft(n);
				}
			}
			else{
				if(root.getRight() != null) {
					recursiveInsert(root.getRight(), n);
				}
				else{
					root.setRight(n);
				}
			}
		}
	}

	public void inOrder(){
		inOrder(t);
		System.out.println();
	}

	public void preOrder(){
		preOrder(t);
	}

	public void postOrder(){
		postOrder(t);
	}

	private void inOrder(Node root) {
		// System.out.println("in inOrder.");
		if(root != null){
			inOrder(root.getLeft());
			System.out.print(root.getVal() + "  ");
			inOrder(root.getRight());
		}
	}

	private void preOrder(Node root) {
		if(root != null){
			System.out.print(root.getVal() + "  ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	private void postOrder(Node root) {
		if(root != null){
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getVal() + "  ");
		}
	}

	public int leafCount() {
		return leafCount(t);
	}

	private int leafCount(Node root){
		if(root != null) {
			if(root.getLeft() == null && root.getRight() == null){
				return 1;
			}
			else{
				return leafCount(root.getLeft()) + leafCount(root.getRight());
			}
		}
		return 0;
	}

	public int nodeCount() {
		return nodeCount(t);
	}

	private int nodeCount(Node root){
		if(root != null){
			return nodeCount(root.getLeft()) + nodeCount(root.getRight()) + 1;
		}
		return 0;
	}
	
}