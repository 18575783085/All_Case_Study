/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: CallableTest
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 13:54
 * Description: 第三种线程接口方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaSE_Thread;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈第三种线程接口方法〉
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 13:54
 * @since 1.0.0
 */
public class CallableTest {

    /*
        Callable接口：它可以对外同时声明异常的同时也可以有返回值
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建任务调度服务,创建线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Race race = new Race("我是乌龟",1000);
        Race rabbit = new Race("我是小兔子",500);

        //获取值
        Future<Integer> future1 = executorService.submit(race);
        Future<Integer> future2 = executorService.submit(rabbit);

        Thread.sleep(2000);//延时2秒
        //停止线程体循环
        race.setFlag(false);
        rabbit.setFlag(false);

        int num1 = future1.get();
        int num2 = future2.get();

        System.out.println("乌龟:"+num1);
        System.out.println("小白兔:"+num2);

        //停止服务
        executorService.shutdown();

    }
}

class Race implements Callable<Integer>{

    private String name;
    private long time;
    private int step=0;
    private boolean flag = true;

    //构造器
    public Race(){

    }

    public Race(String name) {
        this.name = name;
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public Integer call() throws Exception {
        while (flag){
            Thread.sleep(time);
            step++;
        }
        return step;
    }
}
