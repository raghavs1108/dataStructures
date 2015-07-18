public class Node {
	Node left;
	Node right;
	int val;
	public Node() {
		left = null;
		right = null;
	}

	public Node (int x){
		left = null;
		right = null;
		val  = x;	
	}

	public void setVal(int x) {
		val = x;
	}

	public int getVal() {
		return val;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setLeft(Node l){
		left = l;
	}

	public void setRight(Node r){
		right = r;
	}
}