public class ListClient {
	public static void main(String[] args) {
		List list = new List();

		/*
		for(int i = 11; i<=21; i++){
			list.endInsert(i);
		}
		list.print();
		*/

		/*
		for(int i = 10; i>0; i--){
			list.frontInsert(i);
		}
		list.print();
		*/

		for(int i = 1; i <= 2; i++){
			list.frontInsert(i);
		}
		list.print();

		/*
		list.frontDelete();
		list.print();
		*/

		/*
		list.endDelete();
		list.print();
		*/

		/*
		int middle = list.getMiddleElementValue();
		System.out.println("middle: " + middle);
		*/

		/*
		int pos = 18;
		list.positionInsert(555, pos);
		list.print();

		list.positionDelete(pos);
		list.print();
		*/
		
		/*
		boolean contained = list.recursiveContains(10);
		System.out.println("CONTAINED: "+ String.valueOf(contained));
		*/
		
		
		list.reverse();
		list.print();
		
		
		/*
		list.insertSorted(6);
		list.insertSorted(2);
		list.insertSorted(4);
		list.removeDuplicate();
		list.print();
		*/
		
		/*
		list.mergeSort();
		list.print();
		*/
	}
}