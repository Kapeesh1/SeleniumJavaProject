package exceptionhandling;

public class ExceptionHandling_demo {
	
	public static void main(String[] args) {
		try {
			demo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void demo() throws Exception{
		System.out.println("Hello World");
		int i= 1/0;
		System.out.println("completed");
	}
}
