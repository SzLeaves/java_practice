package szleaves.practice;

/*
 * 线程之间不同步的问题
 * 一个加10000次，一个减10000次，最后结果应该是0
 * 但是，每次运行，结果实际上都是不一样
 * 
 * 对共享变量进行读写时，必须保证一组指令以原子方式执行
 * 即某一个线程执行时，其他线程必须等待
 * */

public class ThreadNotSync {
	public static void main(String[] args) throws Exception {
		var add = new AddThread();
		var dec = new DecThread();
		// 启动线程
		add.start();
		dec.start();
		// 等待结束
		add.join();
		dec.join();
		System.out.println(Counter.count);
	}
}

class Counter {
	public static int count = 0;
}

// 加法运算
class AddThread extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			Counter.count += 1;
		}
	}
}

// 减法运算
class DecThread extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			Counter.count -= 1;
		}
	}
}
