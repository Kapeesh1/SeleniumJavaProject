
class Test implements Runnable {

	public void run(){
		System.out.println("GFG");
	System.out.println("Geeks");
	}
	public static void main(String[] args) {
	Test obj= new Test();
	Thread thread= new Thread(obj);
	thread.start();
	System.out.println("Geeks");
	try{
		thread.join();
	}
	catch(InterruptedException e){
		e.printStackTrace();
	}
	System.out.println("for");
	}
}
