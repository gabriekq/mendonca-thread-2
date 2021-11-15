package testtread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeCompletableFuture {

	public static void main(String[] args)  throws InterruptedException, ExecutionException{
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n I can tell the nth prime number. Enter n: ");
			int n = sc.nextInt();
			
			if(n==0) {
			     break;	
			}
			
	           CompletableFuture.supplyAsync(() -> PrimeNumberUtil.calculatePrime(n),executorService)
	           .thenAccept((Integer retun) -> System.out.println(retun));
			

			
		}

	}
	
}
