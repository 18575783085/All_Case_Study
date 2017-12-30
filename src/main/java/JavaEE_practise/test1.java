/**
 * Copyright (C), 2017-？, OYE有限公司
 * FileName: test1
 * Author:   OYE 517553812@qq.com
 * Date:     2017/12/30 21:10
 * Description: Integer与int的比较
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间        版本号            描述
 */
package JavaEE_practise;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Integer与int的比较〉
 *
 * @author OYE 517553812@qq.com
 * @create 2017/12/30 21:10
 * @since 1.0.0
 */
public class test1 {

    public static void main(String[] args){

        Integer a = 3;
        int a1 = 3;
        Integer a2 = new Integer(3);
        System.out.println(a==a1);
        System.out.println(a==a2);


        int i = 128;
        Integer i1 = 128;
        System.out.println("i==i1:"+(i==i1));

        Integer i2 = new Integer(128);
        System.out.println("i==i2:"+(i==i2));
        System.out.println("i2==i1:"+(i2==i1));
        System.out.println("i2.equals.i1:"+(i2.equals(i1)));

        Integer i3 = 128;
        System.out.println("i2==i3:"+(i2==i3));

        int i4 = 127;
        Integer i5 = 127;
        System.out.println("i4==i5:"+(i4==i5));

        Integer i6 = new Integer(127);
        System.out.println("i5==i6:"+(i5==i6));

        Integer i7 = 127;
        System.out.println("i5==i7:"+(i5==i7));
    }
}
