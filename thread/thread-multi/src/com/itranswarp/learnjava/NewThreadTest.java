package com.itranswarp.learnjava;

/*
线程的6种状态
New：新创建的线程，尚未执行；
Runnable：运行中的线程，正在执行run()方法的Java代码；
Blocked：运行中的线程，因为某些操作被阻塞而挂起；
Waiting：运行中的线程，因为某些操作在等待中；
Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
Terminated：线程已终止，因为run()方法执行完毕。

只有Runnable和Blocked可以来回切换，其余状态是不可逆转的
*/

public class NewThreadTest {
	public static void main(String[] args) throws InterruptedException {
		// 创建新的线程
		Thread thread = new Thread();
		// 启动新线程（这个线程什么也没干就结束了）
		thread.start();

		// 方法一 初始化Thread子类并调用start()
		NewThread t1 = new NewThread();
		t1.start();

		// 方法二 初始化Thread并传入Runnable实例
		Thread t2 = new Thread(new NewRunnable());
		t2.start();
		// 方法二可使用lambda简写：
		Thread t3 = new Thread(() -> {
			System.out.println("This is a new thread for Runnable with lambda");
		});
		t3.start();

		// 暂停线程
		try {
			// sleep参数是毫秒
			Thread.sleep(2000); // 休眠2s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 注意输出，多个线程的执行顺序由操作系统决定，因此输出语句顺序未知
		// 对于线程启动，直接调用Thread的run()方法是无效的，并不会启动新线程

		// 一个线程可以等待另一个线程直到运行结束（join）
		Thread t4 = new Thread(() -> {
			System.out.println("This is a new thread for t4, next is join");
		});
		t4.start();
		t4.join(); // 让t4线程结束后再运行

		// 主线程输出
		System.out.println("END t4");

	}
}

// 启动新线程方法一：编写一个继承自Thread的class并重写run()
class NewThread extends Thread {
	@Override
	public void run() {
		System.out.println("This is a new thread for extend Thread");
	}
}

// 方法二：创建时传入Runnable实例
class NewRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("This is a new thread for implements Runnable");
	}
}
