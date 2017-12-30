/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: SingleHungryMode
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 17:03
 * Description: 单例模式--饿汉式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaSE_Thread;

/**
 * 〈一句话功能简述〉<br> 
 * 〈单例模式--饿汉式&&懒汉式〉
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 17:03
 * @since 1.0.0
 */
public class SingleHungryMode {
    /*
    懒汉式
    1、声明私有化的静态属性
    2、构造器私有化
    3、对外提供访问属性的静态方法，确保该对象存在
     */

    private static SingleHungryMode singleHungryMode = null;

    private SingleHungryMode(){

    }

    public static SingleHungryMode getInstance(){
        if(null == singleHungryMode){//如果有对象就不用再进入方法创建获取对象，可以直接返回对象，大大的提高性能
            synchronized (SingleHungryMode.class){

                if(singleHungryMode == null){//为了安全
                    singleHungryMode = new SingleHungryMode();
                }


            }
        }
        return singleHungryMode;
    }


}

/*
饿汉式
1、声明私有的静态属性，同时创建该对象
2、构造器私有化
3、对外提供访问属性的静态方法
 */
class HungryMode{

    /*
    线程安全的，静态变量，类加载的时候只加载一次
    使用这个类的时候才会去加载
     */
    private static HungryMode hungryMode = new HungryMode();

    private HungryMode(){

    }

    public static HungryMode getInstance(){
        return hungryMode;
    }


}

class HungryMode2{
    private static class Single{
        private static HungryMode2 hungryMode = new HungryMode2();
    }


    private HungryMode2(){

    }

    public static HungryMode2 getInstance(){
        return Single.hungryMode;
    }
}
