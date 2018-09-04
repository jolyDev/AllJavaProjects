package Turanga_Lila;

import java.util.concurrent.*;

public class Thread {	
	public static void main (String[] argc) {
		// ExecutorService exec = new ExecutorService(3);
		ExecutorService exec = Executors.newFixedThreadPool(3);
		exec.execute(func1());
		exec.execute(func2());
		exec.execute(func3());
		exec.execute(func4());
		while(true)
			System.out.println("Working");
		//[]{System.out.println("Lich");}
	// Thread tr = new Thread();
	}
	
	 public static Runnable func1() {
		 while(true)
			 System.out.println("func1");
	 }
	 
	 public static Runnable func2() {
		 while(true)
			 System.out.println("!Omega");
	 }
	 
	 public static Runnable func3() {
		 while(true)
			 System.out.println("##300");
	 }
	 public static Runnable func4() {
		 while(true)
			 System.out.println("HUY");
	 }
}
