/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: Watcher
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 20:01
 * Description: 消费者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaSE_DesignMode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈消费者〉
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 20:01
 * @since 1.0.0
 */
public class Watcher implements Runnable{
    private Move m;

    public Watcher(Move m) {
        this.m = m;
    }

    public void run(){
        for(int i=0;i<20;i++){
            m.watch();
        }

    }
}
