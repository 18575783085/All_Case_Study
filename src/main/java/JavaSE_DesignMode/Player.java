/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: Player
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 20:00
 * Description: 生产者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaSE_DesignMode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈生产者〉
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 20:00
 * @since 1.0.0
 */
public class Player implements Runnable{

    private Move m;

    public Player(Move m) {
        this.m = m;
    }

    public void run(){
        for(int i=0;i<20;i++){
            if(i%2==0){
                m.play("动画片");
            }else{
                m.play("爱情片");
            }
        }

    }
}
