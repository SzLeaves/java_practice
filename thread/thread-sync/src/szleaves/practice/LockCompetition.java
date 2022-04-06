package szleaves.practice;

/*
 * 需要同步的线程可以分成两组
 * AddStudentThread和DecStudentThread
 * AddTeacherThread和DecTeacherThread
 * 组之间不存在竞争，因此，应该使用两个不同的锁:lockStuden和lockTeacher
 * */

/*
 * 使用时不必关心同步逻辑，可以允许多线程正常访问的class称之为线程安全(thread-safe)
 * 类似Math这些只提供静态方法，没有成员变量的类，也是线程安全的
 * 不变类，例如String，Integer，LocalDate, 多线程同时访问时只能读不能写，这些不变类也是线程安全的
 * */


public class LockCompetition {
	public static void main(String[] args) throws Exception {
		// var(Java10)可以自动推导后面的数据类型
		var ts = new Thread[] { new AddStudentThread(), new DecStudentThread(), new AddTeacherThread(),
				new DecTeacherThread() };
		for (var t : ts) {
			t.start();
		}
		for (var t : ts) {
			t.join();
		}
		System.out.println(LockCounter.studentCount);
		System.out.println(LockCounter.teacherCount);
	}
}

class LockCounter {
	public static final Object lockStudent = new Object();
	public static final Object lockTeacher = new Object();
	public static int studentCount = 0;
	public static int teacherCount = 0;
}

// Student锁
class AddStudentThread extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			synchronized (LockCounter.lockStudent) {
				LockCounter.studentCount += 1;
			}
		}
	}
}

class DecStudentThread extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			synchronized (LockCounter.lockStudent) {
				LockCounter.studentCount -= 1;
			}
		}
	}
}

// Teacher锁
class AddTeacherThread extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			synchronized (LockCounter.lockTeacher) {
				LockCounter.teacherCount += 1;
			}
		}
	}
}

class DecTeacherThread extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			synchronized (LockCounter.lockTeacher) {
				LockCounter.teacherCount -= 1;
			}
		}
	}
}
