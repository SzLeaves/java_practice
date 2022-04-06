package szleaves.practice;

// 结束线程的方式二：设置running为false

public class InterruptFlag {
	public static void main(String[] args)  throws InterruptedException {
        ThreadFlagTest t = new ThreadFlagTest();
        t.start();
        Thread.sleep(100);
        t.running = false; // 标志位置为false
        
        // running被设置成false后线程被终止
    }
}

class ThreadFlagTest extends Thread {
	// 线程间共享变量需要使用volatile关键字
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}