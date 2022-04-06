package szleaves.practice;

public class InterruptThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new MyThread();
		t.start();
		Thread.sleep(1); // 暂停1毫秒
		t.interrupt(); // 中断t线程
		System.out.println("interrupt");
		t.join(); // 等待t线程结束
		System.out.println("end");
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		int n = 0;
		// 当线程状态没有中断时运行
		while (!isInterrupted()) {
			n++;
			System.out.println(n + " hello!");
		}
	}
}
