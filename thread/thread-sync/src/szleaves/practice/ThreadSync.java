package szleaves.practice;

/* 对共享变量进行读写时，必须保证一组指令以原子方式执行
 * 即某一个线程执行时，其他线程必须等待
 * 
 * 使用synchronized关键字对一个对象进行加锁, 保证了代码块在任意时刻最多只有一个线程能执行
 * 这种加锁和解锁之间的代码块称之为临界区（Critical Section）
 * 任何时候临界区最多只有一个线程能执行
 * 保证一段代码的原子性就是通过加锁和解锁实现的
 * */

public class ThreadSync {
	public static void main(String[] args) throws Exception {
		var add = new SyncAddThread();
		var dec = new SyncDecThread();
		add.start();
		dec.start();
		add.join();
		dec.join();
		System.out.println(NewCounter.count);
	}
}

class NewCounter {
	// 创建lock
	public static final Object lock = new Object();
	public static int count = 0;
}

/*
找出修改共享变量的线程代码块；
选择一个共享实例（比如这里的NewCounter）作为锁(NewCounter.lock)；
使用synchronized(lockObject) { ... }
 * */

class SyncAddThread extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			// 加锁区
			synchronized (NewCounter.lock) {
				Counter.count += 1;
			}
		}
	}
}

class SyncDecThread extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			// 加锁区
			synchronized (NewCounter.lock) {
				Counter.count -= 1;
			}
		}
	}
}
