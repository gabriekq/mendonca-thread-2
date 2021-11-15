package testtread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExampleCallable {

	public static void main(String[] args ) throws InterruptedException, ExecutionException {
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Printed from Runable");		
			}
		};
		
		
		
		Callable<String> c = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				System.out.println("Calable");	
				Thread.sleep(2000);
				return "valor";
			}
		};
		
		ExecutorService executorService =  Executors.newFixedThreadPool(1);
		  Future<String>  valorRet =  executorService.submit(c);
		  String retono =  valorRet.get();
		  System.out.println("jamal");
		  System.out.println(retono);
		 
		
	}
	
	
	
	
}
