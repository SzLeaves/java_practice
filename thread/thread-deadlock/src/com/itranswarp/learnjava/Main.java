package com.itranswarp.learnjava;

/**
 * JVM允许同一个线程重复获取同一个锁，这种能被同一个线程反复获取的锁，就叫做可重入锁
 * Java的线程锁是可重入锁
 * 获取锁的时候，不但要判断是否是第一次获取，还要记录这是第几次获取
 * 每获取一次锁，记录+1，每退出synchronized块，记录-1，减到0的时候，才会真正释放锁 
 * 但在获取多个锁的时候，不同线程获取多个不同对象的锁可能导致死锁
 * 
 * 避免死锁：线程获取锁的顺序要一致，即严格按照先获取lockA，再获取lockB的顺序
 */

// 注意观察输出
// 抢占式多线程：谁先拿到锁谁执行，另外一个就等待先拿到锁的把锁释放后才执行
public class Main {

	static final Object LOCK_A = new Object();
	static final Object LOCK_B = new Object();

	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();
	}

	static void sleep1s() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Thread1 extends Thread {

	public void run() {
		System.out.println("Thread-1: try get lock A...");
		synchronized (Main.LOCK_A) {
			System.out.println("Thread-1: lock A got.");
			Main.sleep1s();
			System.out.println("Thread-1: try get lock B...");
			synchronized (Main.LOCK_B) {
				System.out.println("Thread-1: lock B got.");
				Main.sleep1s();
			}
			System.out.println("Thread-1: lock B released.");
		}
		System.out.println("Thread-1: lock A released.");
	}
}

class Thread2 extends Thread {

	public void run() {
		System.out.println("Thread-2: try get lock A...");
		synchronized (Main.LOCK_A) {
			System.out.println("Thread-2: lock A got.");
			Main.sleep1s();
			System.out.println("Thread-2: try get lock B...");
			synchronized (Main.LOCK_B) {
				System.out.println("Thread-2: lock B got.");
				Main.sleep1s();
			}
			System.out.println("Thread-2: lock B released.");
		}
		System.out.println("Thread-2: lock A released.");
	}
}
