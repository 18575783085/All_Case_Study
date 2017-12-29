package JavaHome_Work;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		Scanner scanner = new Scanner(System.in);
		String ipAddress = scanner.next();
		//先截取每一段地址
		String[] ipSplit = ipAddress.split(".");

		for (int i=0;i<ipSplit.length;i++){
			//判断是否是一个正确的IP地址
			if(!ipSplit[i].matches("\\d")){
				System.out.println("不是数字");
				break;
			}else {
				if(!ipSplit[i].matches("[0-2]{1}+[0-5]{2}")){
					System.out.println("ip地址格式不正确");
					break;
				}else {
					System.out.print(ipSplit[i]);
				}
			}

		}

	}
	
	/**
	 * 将字符串"123abc456def789ghi"中的英文部分替换为"#char#"
	 */
	@Test
	public void test04(){
		String string  = "123abc456def789ghi";
		String replaceString = string.replaceAll("\\D", "#char#");
		System.out.println(replaceString);

	}
	
	/**
	 * 实现文件重命名。
	 * 要求用户输入一个文件名称，例如:abc.jpg
	 * 然后对该名字进行重新命名，输出的格式为:系统时间毫秒值.jpg
	 * 例如:1465266796279.jpg
	 */
	@Test
	public void test05(){
		Scanner scanner = new Scanner(System.in);
		String fileName = "fjfj.jpg";
		if(fileName.lastIndexOf(".")<=0){
			System.out.println("不是一个正确的文件名称");
		}else {
			//截取后缀名
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = System.currentTimeMillis()+suffix;
			System.out.println(newFileName);
		}
		
	}
	
	/**
	 * 测试正则表达式，并尝试编写规则: 电话号码可能有3-4位区号，
	 * 7-8位号码:0415-5561111
	 */
	@Test
	public void test06(){
		String number = "0757-88283182";

		if(number.replaceFirst("-","").indexOf("-")>0){
			System.out.println("不是一个正确的电话号码格式");
		}else {
			//判断是否是正确的区号
			String quhao = number.substring(0, number.indexOf("-"));
			if(!quhao.matches("[0-9]{3,4}")){
				System.out.println("区号格式错误");
			}else {
				String phone = number.substring(number.indexOf("-") + 1);
				if(!phone.matches("[0-9]{7,8}")){
					System.out.println("号码错误");
				}else {
					System.out.println("电话号码正确");
				}
			}

		}

	}
	
	/**
	 * 输入一个数学计算表达式，如:1+2
	 * 然后输出计算后的结果:1+2=3
	 * 这里计算表达式只计算一次即可，可以使用加减乘除任意一个,可以进行小数运算。
	 */
	@Test
	public void test07(){
		String mathExpression = "1+1.1";
		//1.先判断是否是一个正确的表达式
		if(mathExpression.indexOf("+")>0){
			//判断是否有小数
			if(mathExpression.indexOf(".")>0){
				double num1 = Double.parseDouble(mathExpression.substring(0,mathExpression.indexOf("+")));
				double num2 = Double.parseDouble(mathExpression.substring(mathExpression.indexOf("+")+1));
				System.out.println(num1+"+"+num2+"="+(num1+num2));
			}
			int num1 = Integer.parseInt(mathExpression.substring(0,mathExpression.indexOf("+")));
			int num2 = Integer.parseInt(mathExpression.substring(mathExpression.indexOf("+")+1));
			System.out.println(num1+"+"+num2+"="+(num1+num2));
		}
		//其余减乘除，都类似，但是要记住除法的时候，除数不能为0，例：5/0
	}
	
	/**
	 * 要求用户输入若干员工信息，格式为：
	 * name,age,gender,salary;name,age,gender,salary;....
	 * 例如:
	 * 张三,25,男,5000;李四,26,女,6000;...
	 * 然后将每个员工信息解析成Person对象。并存入到一个数组中。
	 * 然后循环数组，输出每一个员工信息(输出使用toString返回的字符串)
	 */
	public static void test08() throws ParseException {
		String emp = "张三,25,男,5000,2016-09-09;李四,25,男,5000,2016-09-09";
		//拆分员工信息
		String[] empArr = emp.split(";");
		for (int i=0;i<empArr.length;i++){
			String[] empInfoArr = empArr[i].split(",");
			//赋值给每一个属性
			String name = empArr[0];
			int age = Integer.parseInt(empArr[1]);
			String gender = empArr[2];
			int salary = Integer.parseInt(empArr[3]);
			Date hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(empArr[4]);
			Emp person = new Emp(1,name,age,gender,salary,hiredate);
			//打印员工信息
			System.out.println(person);
		}

	}

}
