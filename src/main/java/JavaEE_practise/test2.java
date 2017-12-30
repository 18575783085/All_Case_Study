/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: test2
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 21:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaEE_practise;

import org.junit.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 21:30
 * @since 1.0.0
 */
public class test2 {

    @Test
    public void t1(){
        Integer a = 127;
        int a1 = 127;
        Integer a2 = 127;
        Integer a3 = new Integer(127);

        System.out.println(a==a1);
        System.out.println(a==a2);
        System.out.println(a==a3);


    }

    @Test
    public void t2(){
        Integer i = 128;
        int i1 = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);

        System.out.println(i==i1);
        System.out.println(i==i2);
        System.out.println(i==i3);
    }
}
