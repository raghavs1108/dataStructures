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

	public void print() {
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
}