package JavaHome_Work;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class HomeWork_01 {


	/**
	 * 1:输出字符串"HelloWorld"的字符串长度
	 * 2:输出"HelloWorld"中"o"的位置
	 * 3:输出"HelloWorld"中从下标5出开始第一次出现"o"的位置
	 * 4:截取"HelloWorld"中的"Hello"并输出
	 * 5:截取"HelloWorld"中的"World"并输出
	 * 6:将字符串"  Hello   "中两边的空白去除后输出
	 * 7:输出"HelloWorld"中第6个字符"W"
	 * 8:输出"HelloWorld"是否是以"h"开头和"ld"结尾的。
	 * 9:将"HelloWorld"分别转换为全大写和全小写并输出。
	 */
	@Test
	public void test01(){
		String string = "HelloWorld";
		//1.
		int len = string.length();
		System.out.println("字符串的长度："+len);
		//2.
		int index = string.indexOf("o");
		System.out.println("o的位置："+index);
		//3.
		int indexOf = string.indexOf("o", 5);
		System.out.println("从下标5出开始第一次出现\"o\"的位置"+indexOf);
		//4.
		String substring = string.substring(0, 5);
		System.out.println(substring);
		//5.
		String substring1 = string.substring(5);
		System.out.println(substring1);
		//6.将字符串"  Hello   "中两边的空白去除后输出
		String trim = "  Hello   ".trim();
		System.out.println(trim);
		//7.输出"HelloWorld"中第6个字符"W"
		char charAt = string.charAt(6);
		System.out.println(charAt);
		//8.输出"HelloWorld"是否是以"h"开头和"ld"结尾的。
		System.out.println(string.startsWith("h"));
		System.out.println(string.endsWith("ld"));
		//9.将"HelloWorld"分别转换为全大写和全小写并输出。
		System.out.println("大写："+string.toUpperCase());
		System.out.println("小写："+string.toLowerCase());

	}
	
	
	/**
	 * 将"大家好!"修改为:"大家好!我是程序员!"并输出。
	 * 然后将"大家好!我是程序员!"修改为:"大家好!我是优秀的程序员!"并输出
	 * 然后再修改为:"大家好!我是牛牛的程序员!"并输出
	 * 然后在修改为:"我是牛牛的程序员!"并输出
	 */
	public static void test02(){

		StringBuilder stringBuilder = new StringBuilder("大家好!");
		//1.
		StringBuilder append = stringBuilder.append("我是程序员！");
		System.out.println(append);
		//2.
		StringBuilder insert = stringBuilder.insert(6, 9);
		System.out.println(insert);
		//3.
		StringBuilder replace = stringBuilder.replace(6, 8, "牛牛");
		System.out.println(replace);
		//4.
		StringBuilder delete = stringBuilder.delete(0, 3);
		System.out.println(delete);

	}
	
	
	/**
	 * 检查一个字符串是否为回文
	 * 回文:正着念与反着念一样，例如:上海自来水来自海上
	 * 编写一个回文字符串，然后调用check方法检查
	 * 该字符串是否为回文，然后输出检查结果。
	 * 若是回文则输出:是回文
	 * 否则输出:不是回文
	 */
	@Test
	public void test03(){
		String string = "上海自来水来自海上";
		StringBuilder stringBuilder = new StringBuilder(string);
		System.out.println(stringBuilder.reverse());
		if (stringBuilder.reverse().toString().equals(string)){
			System.out.println("是回文");
		}else{
			System.out.println("不是回文");
		}

		for(int i = 0;i < string.length()/2;i++){
			if(string.charAt(i)!=string.charAt(string.length()-1-i)){
				System.out.println("不是回文");
			}
		}
		System.out.println("是回文");


	}
	
	
	/**
	 * 要求用户从控制台输入一个email地址，然后获取该email的用户名(@之前的内容)
	 */
	public static void test04(){
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		//获取该email的用户名(@之前的内容)
		String substring = string.substring(0, string.indexOf("@"));
		System.out.println(substring);

	}
	
	/**
	 * 随机生成一个5位的英文字母验证码(大小写混搭)
	 * 然后将该验证码输出给用户，然后要求用户输入该验证码，大小写不限制。
	 * 然后判定用户输入的验证码是否有效(无论用户输入大小写，只要字母都正确即可)。
	 */
	public static void test05(){
		String yanzhengma = "";
		//随机生成一个英文字符验证码
		for (int i=0;i<5;i++){
			yanzhengma += 1 == (int)(Math.random()*2)?(Math.random()*27+'A'):(Math.random()*27+'a') ;
		}

		Scanner scanner = new Scanner(System.in);
		String quess = scanner.next();
		if(quess.toLowerCase().equals(yanzhengma)){
			System.out.println("输入正确");
		}else {
			System.out.println("输入错误");
		}
		
	}
	
	/**
	 * 要求用户输入一个计算表达式，可以使用加减乘除。
	 * 只处理一次运算的，不要有连续加减乘除的表达式,且不做小数计算。(例:1+2+3)
	 * 例如:
	 * 1+2
	 * 然后经过处理计算结果并输出:1+2=3
	 */
	public static void test06(){

		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();

		int index = -1;
		//获取符号判断是加减乘除
		if(string.indexOf("+")!=index){
			int num1 = Integer.parseInt(string.substring(0,string.indexOf("+")));
			int num2 = Integer.parseInt(string.substring(string.indexOf("+")+1));
			System.out.println(num1+"+"+num2+"="+(num1+num2));
		}
		
	}
}
