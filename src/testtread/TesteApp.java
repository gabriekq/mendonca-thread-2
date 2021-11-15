package testtread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteApp {

	public static void main(String[] args)  {
		
		List<Thread> threads = new ArrayList<Thread>();

		Runnable statusReporter = ()->{
			
		try {
			while(true) {
			    Thread.sleep(5000);	    
			    printThreads(threads);
			}
			
		  }catch (InterruptedException e) {
			System.out.println("Status report thread interrupt");
		  }
		};
		Thread reporterThread = new Thread(statusReporter);
		reporterThread.setDaemon(true);
		reporterThread.start();
		
		
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n I can tell the nth prime number. Enter n: ");
			int n = sc.nextInt();
			
			if(n==0) {
				reporterThread.interrupt();
				try {
			     System.out.println("Waiting for all threads to finish");
			     waitForThreads(threads);
			     System.out.println("Done "+threads.size()+" primes calculate ");
				}catch (Exception e) {
					System.out.println("Got interrupted");
				}
			     break;	
			};
			
			Runnable  runnable = new Runnable() {
				
				@Override
				public void run() {
				long	number = PrimeNumberUtil.calculatePrime(n);
			    System.out.println("\n value of "+n+" th prime "+number);	
				}
			};
			Thread thread = new Thread(runnable);
			thread.setDaemon(true);
			threads.add(thread);
			thread.start();		
			
		}
		
	}

	private static void waitForThreads(List<Thread> threads)  throws InterruptedException{
		for(int index=0;index < threads.size();index++) {
			       threads.get(index).join();		
		}
		
	}

	private static void printThreads(List<Thread> threads) {
		System.out.println("Threads status");
		threads.forEach(thread ->{
			System.out.print(thread.getState()+" ");
		});	
	}

}
