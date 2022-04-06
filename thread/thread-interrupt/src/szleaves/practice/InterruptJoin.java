package szleaves.practice;

// 结束线程的方式一：调用interrput()

public class InterruptJoin {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new NewThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");

	}
}

class NewThread extends Thread {
	public void run() {
		Thread hello = new HelloThread();
		hello.start(); // 启动hello线程
		try {
			hello.join(); // 等待hello线程结束
		} catch (InterruptedException e) {
			System.out.println("interrupted!");
		}
		// 去掉对hello线程的中断不会导致JVM退出主进程
		// 中断当前线程不影响其他的线程运行
		hello.interrupt();
	}
}

class HelloThread extends Thread {
	public void run() {
		int n = 0;
		while (!isInterrupted()) {
			n++;
			System.out.println(n + " hello!");
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
