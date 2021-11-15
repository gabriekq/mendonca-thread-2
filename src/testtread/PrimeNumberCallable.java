package testtread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeNumberCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(24);
		List<Future<Integer>> futures = new ArrayList<>();
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n I can tell the nth prime number. Enter n: ");
			int n = sc.nextInt();
			
			if(n==0) {
				
			     break;	
			};
			
		
			Callable<Integer> c = new Callable<Integer>() {
				
				@Override
				public Integer call() throws Exception {
					
					return PrimeNumberUtil.calculatePrime(n);
				}
			};
			
			
			
		    Future<Integer>  primeNumber =	executorService.submit(c);
			futures.add(primeNumber);
		    Iterator<Future<Integer>> interator = futures.iterator();
			
			while (interator.hasNext()) {
				Future<Integer> f = interator.next();
				   if(f.isDone()) {
					   System.out.println(f.get());
					   interator.remove();
				   }		
			}	
		}

	}

}
