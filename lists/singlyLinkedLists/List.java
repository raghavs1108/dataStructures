public class List {
	private Node l;
	
	public List () {
		l = null;
	}

	public void frontInsert (int x) {
		Node n = new Node(x);
		if(l == null){
			l = n;
		}
		else{
			n.setNext(l);
			l = n;
		}
	}

	public void endInsert (int x) {
		Node n = new Node(x);
		if(l == null){
			l = n;
		}
		else{
			Node temp = l;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(n);
		}
	}

	public void positionInsert (int x, int pos) {
		Node n = new Node(x);
		if (pos == 0){
			frontInsert(x);
		}
		else if(pos > 0 && pos < length()){
			Node temp = l;
			Node prev = temp;
			int i = 0;
			while(temp != null && i < pos){
				prev = temp;
				temp = temp.getNext();
				i++;
			}

			if(i == pos){
				n.setNext(prev.getNext());
				prev.setNext(n);
			}
		}
		else if( pos == length() ){
				endInsert(x);
		}
	}

	public int frontDelete () {
		if(l != null){
			l = l.getNext();
			return 0;
		}
		return -1;
	}

	public int endDelete () {
		if (l == null){
			return -1;
		}
		else if(l.getNext() == null){
			l = null;
			return 0;
		}
		else{
			Node temp = l;
			while(temp.getNext().getNext() != null)
				temp = temp.getNext();
			temp.setNext(null);
			return 0;
		}
	}

	public int positionDelete (int pos) {
		if(pos == 0){
			frontDelete();
			return 0;
		}
		else if (pos == length()){
			endDelete();
			return 0;
		}
		else if (pos > 0 && pos < length()){
			Node temp = l;
			Node prev = null;
			int i = 0;
			while(i < pos && temp.getNext() != null){
				prev = temp;
				temp = temp.getNext();
				i++;
			}
			if(i == pos){
				prev.setNext(prev.getNext().getNext());
			}
			return 0;
		}
		return -1;
	}

	public int getMiddleElementValue(){
		if(l != null){
			Node fastNode = l;
			Node slowNode = l;

			while(fastNode.getNext() != null && fastNode.getNext().getNext() != null){
				fastNode = fastNode.getNext().getNext();
				slowNode = slowNode.getNext();
			}
			return slowNode.getVal();
		}
		return -1000000;
	}

	public int getElementFromBehindValue(int n){
		if(l != null){
			int i = 0;
			Node temp = l;
			while(i++ < n && temp != null){
				temp = temp.getNext();
			}
			if(temp == null){
				return -100000;
			}
			else{
				Node prev = l;
				while(temp != null){
					temp = temp.getNext();
					prev = prev.getNext();
				}
				return prev.getVal();
			}
		}
		return -100000;
	}

	public boolean contains(int x) {
		Node temp = l;
		while(temp != null) {
			if(temp.getVal() == x){
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	public  boolean recursiveContains(int x) {
		return recursiveContains(l, x);
	}
	private boolean recursiveContains(Node root, int x) {
		if(root != null){
			if(root.getVal() == x){
				return true;
			}
			else{
				return recursiveContains(root.getNext(), x);
			}
		}
		return false;
	}

	public void reverse() {
		Node cur = l;
		Node prev = null;
		Node temp = l;
		while(cur != null){
			temp = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = temp;
		}
		l = prev;
	}

	public void reverseGroupSize(int n){
		Node cur = l;
		Node temp;
		int count = 0;
		Node prev = null;
		int i = 0;
		while(cur != null){
			temp = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = temp;
			i++;
		}
		l = prev;
	}

	public boolean hasLoop() {
		/*
			Solution 1: Store the addresses visited in a list and check each time a new node is traversed whether that node exists in that list.

			Solution 2: Have another field called "visited" in each node, and mark it as you traverse.

			Solutuon 3: If you want it in place, use the hare and tortoise solution to detect if some time the slow and fast Node have the same addresses.
		*/
			return false;
	}

	public boolean isPalindrome() {
		/*
			Solution 1: Stack.
			Solution 2: reverse the whole lis and compare.
		*/
		return false;
	}

	public void insertSorted (int x){
		Node n = new Node(x);
		if(l != null){
			if(x < l.getVal()){
				n.setNext(n);
				l = n;
			}
			else{
				Node temp = l;
				Node prev = null;

				while(temp.getNext() != null){
					if(temp.getVal() > x){
						n.setNext(temp);
						prev.setNext(n);
						break;
					}
					else {
						prev = temp;
						temp = temp.getNext();
					}
				}
			}
		}
	}
	public void removeDuplicate() {
		// condition: should already be sorted.
		if(l != null){
			Node temp = l.getNext();
			Node prev = null;
			Node currentNode = l;
			while(temp != null){
				if(temp.getVal() == currentNode.getVal()){
					temp = temp.getNext();
				}
				else{
					currentNode.setNext(temp);
					currentNode = temp;
					temp = temp.getNext();
				}
			}
		}
	}

	public void mergeSort() {
		mergeSort(l);
	}

	private Node mergeSort (Node l){
		if(length(l) > 1){
			if(true){
				Node [] lists = getSplitLists(l);
				Node l1 = lists[0];
				Node l2 = lists[1];
				print(l2);
				// print(l2.getNext());
				l2 = mergeSort(l2);
				print(l1);
				l1 = mergeSort(l1);
				l = merge(l1, l2);
				print(l);
				return l;
			}
			return l;
		}
		return null;
	}

	private Node merge(Node l1, Node l2){
		Node l = null;
		Node temp = l;
		while(l1 != null && l2 != null){
			if(l1.getVal() < l2.getVal()){
				if(temp == null){
					temp = l1;
				}
				else{
					temp.setNext(l1);
				}
				l1 = l1.getNext();
			}
			else{
				if(temp == null){
					temp = l2;
				}
				else{
					temp.setNext(l2);
				}
				l2 = l2.getNext();
			}
		}
		while(l1 != null){
			temp.setNext(l1);
		}
		while(l2 != null){
			temp.setNext(l2);
		}
		return l;
	}

	private Node[] getSplitLists(Node l) {
		Node [] lists = {null, null};
		if(l != null){
			Node fast = l;
			Node slow = l;
			while (fast != null && fast.getNext() != null) {
				fast = fast.getNext().getNext();
				slow = slow.getNext();
			}
			lists[1] = slow.getNext();
			slow.setNext(null);
			lists[0] = l;
		}
		return lists;
	}

	public void print() {
		Node temp = l;
		while(temp != null){
			System.out.print(temp.getVal()+ " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public void print(Node l) {
		if(l == null){
			System.out.print("L: null");
		}
		Node temp = l;
		while(temp != null){
			System.out.print(temp.getVal()+ " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public int length() {
		Node temp = l;
		int l = 0;
		while(temp != null){
			l++;
			temp = temp.getNext();
		}
		return l;
	}

	public int length(Node l) {
		Node temp = l;
		int len = 0;
		while(temp != null){
			len++;
			temp = temp.getNext();
		}
		return len;
	}
}