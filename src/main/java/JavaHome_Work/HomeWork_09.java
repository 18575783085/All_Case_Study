package JavaHome_Work;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeWork_09 {

	/*
		junit不支持多线程测试
	 */

	/**
	 * 使用线程方式一创建两个线程:分别输出1000次，你好和再见
	 * @author OYE
	 *
	 */
	@Test
	public void test01(){
		Thread t1 = new Mythread1();
		Thread t2 = new Mythread2();

		//启动线程
		t1.start();
		t2.start();
	}
	
	/**
	 * 使用线程方式二创建两个线程:分别输出1000次，你好和再见
	 * @author OYE
	 *
	 */
	public static void test02(){

		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable1();

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();
	}
	
	/**
	 * 使用匿名内部类方式创建两个线程:分别输出1000次，你好和再见
	 * @author OYE
	 *
	 */
	public static void test03(){
		Thread t1 = new Thread(){
			@Override
			public void run(){
				for (int i=1;i<100;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
			}
		};


		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=1;i<100;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
			}
		});

		t1.start();
		t2.start();

	}
	
	/**
	 * 创建一个线程，每秒输出一次当前系统时间:yyyy-MM-dd HH:mm:ss
	 * @author OYE
	 *
	 */
	public static void test04(){
		Thread t1 = new Thread(){
			@Override
			public void run(){
				Date date = new Date();
				while (true){
					System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		};
		
	}


}
/*
第一种创建线程方法：继承线程父类
 */
class Mythread1 extends Thread{
	@Override
	public void run(){
		for (int i = 0;i<1000;i++ ){
			System.out.println(Thread.currentThread().getName()+"："+i);
		}
	}
}

class Mythread2 extends Thread{
	@Override
	public void run(){
		for (int i = 0;i<1000;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}

/*
第二种方法：实现接口
 */
class MyRunnable1 implements Runnable{

	@Override
	public void run(){
		for (int i=1;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
class MyRunnable2 implements Runnable{
	@Override
	public void run(){
		for (int i=1;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
