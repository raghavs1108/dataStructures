public class Node {
	private int val;
	private Node next;

	public Node(){
		val = 0;
		next = null;
	}
	public Node(int x){
		val = x;
		next = null;
	}

	public Node(int x, Node n){
		val = x;
		next = n;
	}

	public int getVal(){
		return val;
	}

	public void setVal(int x){
		val = x;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node n) {
		next = n;
	}
}