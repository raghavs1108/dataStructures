public class Test {
	public static void main(String[] args) {
		System.out.println(foo());
	}
	public static int foo() {
		try {
			int a = 12;
			int b = 24;
			int c = b/a;
			return c;
		}
		catch (Exception e){

		}
		finally {
			System.out.println("In finally");
		}
		return 0;
	}
}