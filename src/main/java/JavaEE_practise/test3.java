/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: test3
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 21:38
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
 * @create 2017/12/30 21:38
 * @since 1.0.0
 */
public class test3 {

    @Test
    public void t1(){
        String s = "ou";
        String s1 = "ou";
        String s2 = new String("ou");

        System.out.println(s==s1);
        System.out.println(s==s2);
    }

    @Test
    public void t2(){
        String s = "ou";
        String s1 = "ou";
        String s2 = new String("ou");

        System.out.println(s.equals(s1));
        System.out.println(s.equals(s2));
    }

    @Test
    public void t3(){
        String s = "ou";
        StringBuilder s2 = new StringBuilder(s);
        StringBuilder s3 = new StringBuilder("ou");

        System.out.println(s.equals(s2));
        System.out.println(s.equals(s3));
        System.out.println(s2.equals(s3));
        System.out.println(s2==s3);
    }

    @Test
    public void t4(){
        String s = "ou";
        StringBuffer s2 = new StringBuffer(s);
        StringBuffer s3 = new StringBuffer("ou");
//        System.out.println(s.equals(s2));
//        System.out.println(s.equals(s3));
//        System.out.println(s2.equals(s3));
        System.out.println(s2.equals(s3));
    }
}
