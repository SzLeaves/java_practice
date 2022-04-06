package szleaves.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 使用synchronized处理多线程竞争（保证数据一致性）
 * 使用wait和notify完成多线程协调（保证多个线程的运行顺序）
 * 
 * 多线程协调运行的原则就是：当条件不满足时，线程进入等待状态；当条件满足时，线程被唤醒，继续执行任务
 * */

public class Main {
	public static void main(String[] args) throws InterruptedException {
		var q = new TaskQueue();
		var ts = new ArrayList<Thread>();
		for (int i = 0; i < 5; i++) {
			var t = new Thread() {
				public void run() {
					// 执行task:
					while (true) {
						try {
							String s = q.getTask();
							System.out.println("execute task: " + s);
						} catch (InterruptedException e) {
							return;
						}
					}
				}
			};
			t.start();
			ts.add(t);
		}
		var add = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				// 放入task:
				String s = "t-" + Math.random();
				System.out.println("add task: " + s);
				q.addTask(s);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		});
		add.start();
		add.join();
		Thread.sleep(100);
		for (var t : ts) {
			t.interrupt();
		}
	}
}

// 创建队列任务：一个线程监听队列是否为空，有任务入队时返回入队元素; 一个线程负责入队
class TaskQueue {
	Queue<String> queue = new LinkedList<>();

	public synchronized void addTask(String s) {
		this.queue.add(s);
		// 让等待的线程被重新唤醒，然后从wait()方法返回
		this.notify(); // 唤醒在this锁等待的线程
	}

	public synchronized String getTask() throws InterruptedException {
		while (queue.isEmpty()) {
			// 只能在锁对象（这里的锁对象是this）上调用wait()方法
			this.wait();
			// 当一个线程在this.wait()等待时，它就会释放锁，从而使得其他线程能够在addTask()方法获得锁
		}

		// 返回入队的对象
		return queue.remove();
	}
}
