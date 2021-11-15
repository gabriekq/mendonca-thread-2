package testtread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceApp {

	public static void main(String[] args) {
		
		List<Thread> threads = new ArrayList<Thread>();

		 ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);	     
		 ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
	
		Runnable reporterRunnable  = () -> {
			System.out.println("running report");
			System.out.println("Active Threads : "+executorService.getActiveCount());
			System.out.println("Complete Threads : "+executorService.getCompletedTaskCount());
		
		};
	     
		scheduledExecutor.scheduleAtFixedRate(reporterRunnable, 1, 5,TimeUnit.SECONDS);
	     
	     
		
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n I can tell the nth prime number. Enter n: ");
			int n = sc.nextInt();
			
			if(n==0) {
			     break;	
			};
			
			Runnable  runnable = new Runnable() {
				
				@Override
				public void run() {
				long	number = PrimeNumberUtil.calculatePrime(n);
			    System.out.println("\n value of "+n+" th prime "+number);	
				}
			};
			
			executorService.execute(runnable);
			
			
			
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
