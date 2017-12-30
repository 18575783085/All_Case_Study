/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: SynchronizedDead
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 17:26
 * Description: 死锁
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaSE_Thread;

/**
 * 〈一句话功能简述〉<br> 
 * 〈死锁〉
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 17:26
 * @since 1.0.0
 */
public class SynchronizedDead {
/*
过多的同步方法可能造成死锁

解决思路：生产者消费者模式
 */
    public static void main(String[] args){
        Object goods = new Object();
        Object money = new Object();

        Test test = new Test(goods,money);
        Test2 test2 = new Test2(goods,money);

        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test2);

        t1.start();
        t2.start();
    }
}

class Test implements Runnable{

    Object goods;
    Object money;

    public Test(Object goods,Object money){
        this.goods = goods;
        this.money = money;
    }

    public void run(){
        while (true){
            test();
        }
    }
    public void test(){
        synchronized (goods){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (money){

            }
        }
        System.out.println("一手给钱");
    }
}

class Test2 implements Runnable{

    Object goods;
    Object money;

    public Test2(Object goods,Object money){
        this.goods = goods;
        this.money = money;
    }

    public void run(){
        while (true){
            test();
        }
    }
    public void test(){
        synchronized (money){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (goods){

            }
        }
        System.out.println("一手交货");
    }
}