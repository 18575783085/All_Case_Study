/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: SynchronizedTest
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 15:10
 * Description: 同步线程锁
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaSE_Thread;

/**
 * 〈一句话功能简述〉<br> 
 * 〈同步线程锁〉
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 15:10
 * @since 1.0.0
 */
public class SynchronizedTest {

    /*
    小总结：
        凡是线程安全的，性能较低
     */

    public static void main(String[] args){

        //真实对象
        MySynchronized mySynchronized1 = new MySynchronized();

        //代理
        Thread thread1 = new Thread(mySynchronized1,"超人");
        Thread thread2 = new Thread(mySynchronized1,"蝙蝠侠");
        Thread thread3 = new Thread(mySynchronized1,"钢铁侠");

        //启动线程
        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class MySynchronized implements Runnable{
    //自定义一个增长数
    private int num = 30;

    //开关
    private boolean flag = true;

    public void run(){
        while(flag){
            //test1();
            //test2();
            //test3();
            //test4();
           // test5();
            //test6();
        }
    }

    /*
    锁定范围不正确
     */
    public void test6(){

            if (num <= 0) {
                flag = false;
                return;
            }

        synchronized (this) {
            try {
                //模拟延迟
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "【抢到了】" + num--);

        }
    }

    /*
    锁定“资源”不正确
     */
    public void test5(){
        synchronized ((Integer)num) {
            if (num <= 0) {
                flag = false;
                return;
            }
        }

        try {
            //模拟延迟
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"【抢到了】"+num--);


    }

    /*
    锁定范围不正确
     */
    public void test4(){
        synchronized (this) {
            if (num <= 0) {
                flag = false;
                return;
            }
        }

            try {
                //模拟延迟
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"【抢到了】"+num--);


    }

    /*
    线程安全的，锁定正确
     */
    public void test3(){
        /*
        锁的对象：当前调用方法的对象
         */
        synchronized (this){
            if(num<=0){
                flag = false;
                return;
            }

            try {
                Thread.sleep(500);//模拟延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"【抢到了】"+num--);
        }

    }

    /*
       锁的是：方法
        */
    public synchronized void test2(){
        if(num<=0){
            flag = false;
            return;
        }

        try {
            Thread.sleep(500);//模拟延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"【抢到了】"+num--);
    }

    public void test1(){
        if(num<=0){
            flag = false;
            return;
        }

        try {
            Thread.sleep(500);//模拟延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"【抢到了】"+num--);
    }

}

