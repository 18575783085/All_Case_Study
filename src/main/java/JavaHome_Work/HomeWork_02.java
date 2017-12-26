package JavaHome_Work;

import org.junit.Test;

import java.util.Scanner;

public class HomeWork_02 {

	/**
	 * 要求用户输入一个字符串，然后若该字符串是一个整数，则转换为整数后输出乘以10后的结果
	 * 若是小数，则转换为一个小数后输出乘以5后的结果，若不是数字则输出"不是数字"
	 * 需要使用正则表达式进行判断。
	 */
	@Test
	public void test01(){
		System.out.println("请输入一个字符串");
		Scanner scanner = new Scanner(System.in);
		String num = scanner.nextLine();
		//判断是否为数字
		if(num.matches("//d")){
			//是数字
			if(num.lastIndexOf(".")==-1){
				//没有小数
				int i = Integer.parseInt(num);
				System.out.println(i*10);
			}else{
				//是小数
				double v = Double.parseDouble(num);
				System.out.println(v*5);
			}
		}else{
			System.out.println("不是数字");
		}

	}
	
	/**
	 * 将字符串123,456,789,012根据","拆分，并输出拆分后的每一项
	 */
	@Test
	public void test02(){
		String string = "123,456,789,012";
		String[] split = string.split(",");
		for(int i = 0;i<split.length;i++){
			System.out.println(split[i]);
		}
	}
	
	/**
	 * 输入一个IP地址，然后将4段数字分别输出
	 */
	public static void test03(){
		
	}
	
	/**
	 * 将字符串"123abc456def789ghi"中的英文部分替换为"#char#"
	 */
	public static void test04(){
		
	}
	
	/**
	 * 实现文件重命名。
	 * 要求用户输入一个文件名称，例如:abc.jpg
	 * 然后对该名字进行重新命名，输出的格式为:系统时间毫秒值.jpg
	 * 例如:1465266796279.jpg
	 */
	public static void test05(){
		
	}
	
	/**
	 * 测试正则表达式，并尝试编写规则: 电话号码可能有3-4位区号，
	 * 7-8位号码:0415-5561111
	 */
	public static void test06(){
		
	}
	
	/**
	 * 输入一个数学计算表达式，如:1+2
	 * 然后输出计算后的结果:1+2=3
	 * 这里计算表达式只计算一次即可，可以使用加减乘除任意一个,可以进行小数运算。
	 */
	public static void test07(){
		
	}
	
	/**
	 * 要求用户输入若干员工信息，格式为：
	 * name,age,gender,salary;name,age,gender,salary;....
	 * 例如:
	 * 张三,25,男,5000;李四,26,女,6000;...
	 * 然后将每个员工信息解析成Person对象。并存入到一个数组中。
	 * 然后循环数组，输出每一个员工信息(输出使用toString返回的字符串)
	 */
	public static void test08(){
		
	}

}
