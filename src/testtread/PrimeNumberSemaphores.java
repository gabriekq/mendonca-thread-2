package testtread;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class PrimeNumberSemaphores {

	public static void main(String[] args) throws  InterruptedException, Exception{
		
		Semaphore semaphore  = new Semaphore(3);
		
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
				try {
				semaphore.acquire();
				System.out.println("Now calculating ");
				long	number = PrimeNumberUtil.calculatePrime(n);
			    System.out.println("\n value of "+n+" th prime "+number);	
				}catch(InterruptedException e) {
					System.out.println(e.toString());
				}finally {
					semaphore.release();
				}
			    
				}
			};
			Thread thread = new Thread(runnable);
			thread.setDaemon(true);

			thread.start();		
			
		}

	}

}
