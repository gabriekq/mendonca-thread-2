package testtread;


public class App {

	public static void main(String[] args) {
		Counter  counter = new Counter();
		
		new Thread(counter,"One").start();
		new Thread(counter,"two").start();
		new Thread(counter,"three").start();
		new Thread(counter,"four").start();
		Counter  counter2 = new Counter();
		new Thread(counter2,"counter2").start();
	

	}

}
