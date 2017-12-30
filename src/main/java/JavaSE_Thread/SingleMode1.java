/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: SingleMode
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 15:47
 * Description: 单例模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaSE_Thread;

/**
 * 〈一句话功能简述〉<br> 
 * 〈单例模式---懒汉式〉
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 15:47
 * @since 1.0.0
 */
public class SingleMode1{

    public static void main(String[] args){
//        lazyMode lazy1 = lazyMode.getInstance();
//        lazyMode lazy2 = lazyMode.getInstance();
//        System.out.println(lazy1);
//        System.out.println(lazy2);

        LazyThread lazyThread1 = new LazyThread(100);
        LazyThread lazyThread2 = new LazyThread(300);
        LazyThread lazyThread3 = new LazyThread(300);
        LazyThread lazyThread4 = new LazyThread(300);

        lazyThread1.start();
        lazyThread2.start();
        lazyThread3.start();
        lazyThread4.start();

    }

}

class LazyThread extends Thread{
    private long time;

    public LazyThread(long time){
        this.time = time;
    }

    public void run(){
       // System.out.println(Thread.currentThread().getName()+"【创建了】"+lazyMode.getInstance(time));
        //System.out.println(Thread.currentThread().getName()+"【创建了】"+lazyMode.getInstance1(time));
        //System.out.println(Thread.currentThread().getName()+"【创建了】"+lazyMode.getInstance2(time));
        System.out.println(Thread.currentThread().getName()+"【创建了】"+lazyMode.getInstance3(time));

    }
}

/**
 * 确保一个类只有一个对象
 *  懒汉式 double checking
 *      1、构造器私有化，避免外部直接创建对象
 *      2、声明一个私有的静态变量
 *      3、创建一个对外的公共的静态方法来进行访问该变量，创建该对象
 *
 */
class lazyMode {

    //声明一个私有的静态变量
    private static lazyMode instance = null;

    //构造器私有化，避免外部直接创建对象
    private lazyMode(){

    }

    public static lazyMode getInstance3(long time) {
        /*
        锁的是：字节码信息
        效率 提供已经存在对象的访问效率
         */
        if (null == instance) {
            synchronized (lazyMode.class) {
                if (null == instance) {
                    try {
                        //延时，方法发生错误的概率，平时单例模式是没有这东西的
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new lazyMode();
                    System.out.println("进来了");
                }

            }
        }
        //返回一个对象
        return instance;


    }
    public static lazyMode getInstance2(long time) {
        /*
        锁的是：字节码信息
        效率不高，存在对象也需要等待
         */
            synchronized (lazyMode.class) {
                if (null == instance) {
                    try {
                        //延时，方法发生错误的概率，平时单例模式是没有这东西的
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new lazyMode();
                }
                //返回一个对象
                return instance;
            }

    }


    public static synchronized lazyMode getInstance1(long time){
        if(null == instance){
            try {
                //延时，方法发生错误的概率，平时单例模式是没有这东西的
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new lazyMode();
        }
        //返回一个对象
        return instance;
    }

    /*
        创建一个对外的公共的静态方法访问该变量，如果变量没有对象，
       创建该对象
     */
    public static lazyMode getInstance(long time){
        if(null == instance){
            try {
                //延时，方法发生错误的概率，平时单例模式是没有这东西的
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new lazyMode();
        }
        //返回一个对象
        return instance;
    }

}
