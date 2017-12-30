/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: Application
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 20:06
 * Description: 测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaSE_DesignMode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试〉
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 20:06
 * @since 1.0.0
 */
public class Application {

    public static void main(String[] args){
        //共同资源
        Move move = new Move();

        //多线程
        Player player = new Player(move);
        Watcher watcher = new Watcher(move);

        //启动线程
        new Thread(player).start();
        new Thread(watcher).start();
    }
}
