package testtread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {

	
	private int  value = 0;
	private Lock l = new ReentrantLock();
	
	private Integer i = 10;
	
	public void increment() {
		
		try {
			Thread.sleep(20);
		}catch (InterruptedException e) {
			System.out.println(e.toString());
		}
		
		
		value++;
	}
	
	public void decrement() {value--;}
	
	public int getValue() {return value;}
	
	
	@Override
	public  void run() {
		

		  l.lock(); 
		  try { 
		  this.increment();
		  System.out.println(Thread.currentThread().getName()+" increments: "+this.getValue()); 
		  this.decrement();
		  System.out.println(Thread.currentThread().getName()+" decrements: "+this.getValue());
		  }finally { l.unlock(); }
		 
	
	}

}
