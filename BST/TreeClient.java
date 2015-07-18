public class TreeClient {
	public static void main(String[] args) {
		Tree t = new Tree();

		t.insert(10);
		t.insert(20);
		t.insert(0);
		t.insert(-10);
		t.insert(-20);
		t.insert(30);
		t.insert(15);

		t.inOrder();

		int nodeCount = t.nodeCount();
		int leafCount = t.leafCount();
		
		System.out.println("nodeCount: " + nodeCount);
		System.out.println("leafCount: " + leafCount);
	}
}