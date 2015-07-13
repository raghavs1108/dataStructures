public class ListClient {
	public static void main(String[] args) {
		List list = new List();

		for(int i = 11; i<21; i++){
			list.endInsert(i);
		}
		list.print();

		for(int i = 10; i>0; i--){
			list.frontInsert(i);
		}
		list.print();

		list.frontDelete();
		list.print();
		
		list.endDelete();
		list.print();

		// System.out.println(list.length());

		int pos = 18;
		list.positionInsert(555, pos);
		list.print();

		list.positionDelete(pos);
		list.print();
	}
}