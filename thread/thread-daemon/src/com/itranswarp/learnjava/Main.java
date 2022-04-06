package com.itranswarp.learnjava;

/**
 * @author liaoxuefeng 有一个线程没有退出，JVM进程就不会退出 守护线程是指为其他线程服务的线程
 *         所有非守护线程都执行完毕后，无论有没有守护线程，JVM都会自动退出 所以守护线程不能持有任何需要关闭的资源，否则会导致数据丢失
 */
public class Main {

	public static void main(String[] args) {
		Thread t = new Thread1();
		// 如果注释下一行，观察Thread1的执行情况:
		t.setDaemon(true);
		// 注释后，t不是守护线程，此时没有其他线程来结束它，只能强制退出
		t.start();
		System.out.println("main: wait 3 sec...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main: end.");
	}

}

class Thread1 extends Thread {

	// 间隔500ms打印语句
	public void run() {
		for (;;) {
			System.out.println("Thread-1: running...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}
