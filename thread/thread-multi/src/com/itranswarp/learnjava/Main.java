package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 * Thread1, Thread2线程和main进程各自执行5次循环输出，每次休眠1秒
 */
public class Main {

	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();
		for (int i = 0; i < 5; i++) {
			System.out.println("main: running...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Thread1 extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread-1: running...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Thread2 extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread-2: running...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
