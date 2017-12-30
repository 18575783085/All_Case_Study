/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: Move
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 19:57
 * Description: 生产者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaSE_DesignMode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *  共同的资源
 *      生产者消费者模式：信号灯法
 *      wait()：等待，释放锁；  sleep：不释放锁
 *      notify()/notifyAll()：唤醒
 *  与 synchronized一起使用
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 19:57
 * @since 1.0.0
 */
public class Move {
    private String pic;

    //信号灯
    /*
        flag ---> true 表示生产者生产，消费者等待，生存完成后通知消费
        flag ---> flase 表示消费者消费，生产者等待，消费完成后通知生产
     */
    private boolean flag = true;

    //播放
    public synchronized void play(String pic){
        if(!flag){ //生存者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //开始生产
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产了："+pic);
        //生产完毕
        this.pic = pic;

        //通知消费，唤醒消费者
        this.notify();

        //生产者停下
        this.flag = false;

    }

    public synchronized void watch(){
        if (flag){//消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //开始消费
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费了："+pic);

        /*
            消费完毕
            通知生产
         */
        this.notify();

        //消费停止
        this.flag = true;

    }
}
