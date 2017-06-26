package yt.codingoffer;


public class N_02_Singleton {
	
}

/**
 * 利用虚拟机自动加锁机制
 * @author yangtong
 */
class Singleton_1 {
	private static Singleton_1 instance = new Singleton_1();
	
	private Singleton_1() {
		
	}
	
	public static Singleton_1 getInstance() {
		return instance;
	}
}

/**
 * 进行加锁检查
 * @author yangtong
 */
class Singleton_2 {
	private static Singleton_2 instance = null;
	
	public static Singleton_2 getInstance() {
		if (instance == null) {
			synchronized (Singleton_2.class) {
				if (instance == null) {
					instance = new Singleton_2();
				}
			}
		}
		return instance;
	}
}

/**
 * 单例模式，最推荐
 * @author yangtong
 */
enum Singleton {
	INSTANCE;
	private Singleton_3 instance;
	private Singleton() {
		instance = new Singleton_3();
	}
	public Singleton_3 getInstance() {
		return instance;
	}
}

class Singleton_3 {
	public static Singleton_3 getInstance() {
		return Singleton.INSTANCE.getInstance();
	}
}
