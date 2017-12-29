package JavaHome_Work;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HomeWork_07 {

	/**
	 * 使用文件流复制myfile.txt文件为myfile_cp.txt
	 * @author OYE
	 *
	 */
	public static void test01() throws IOException {
		//创建文件输入流
		FileInputStream fis = new FileInputStream("myfile.txt");
		//创建文件输出流
		FileOutputStream fos = new FileOutputStream("myfile_cp.txt");

		int len = -1 ;
		while ((len = fis.read()) != len){
			fos.write(len);
		}
		System.out.println("写出完毕");

		//关闭资源
		fis.close();
		fos.close();
		
	}
	
	/**
	 * 使用缓冲流复制myfile.txt文件为myfile_cp2.txt
	 * @author OYE
	 *
	 */
	public static void test02() throws IOException {
		//创建文件输入流
		FileInputStream fis = new FileInputStream("myfile.txt");
		//创建缓冲输入流
		BufferedInputStream bis = new BufferedInputStream(fis);

		//创建文件输出流
		FileOutputStream fos = new FileOutputStream("myfile_cp.txt");
		//创建缓冲输出流
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		int len = -1 ;
		while((len = bis.read()) != -1){
			bos.write(len);
		}
		System.out.println("写出完毕");

		//关闭资源
		bis.close();
		bos.close();
		
	}
	
	/**
	 * 要求用户控制台输入想输入的员工人数（至少5个），然后依序输入员工信息，每行为
	 * 一条员工信息，格式如:张三,25,男,5000,2006-3-18
	 * 然后将该对象写入到文件<name>.obj并保存到当前项目根目录中，例如:张三.obj。
	 * @author OYE
	 *
	 */
	public static void test03() throws ParseException, IOException {
		System.out.println("请输入员工人数：");
		Scanner scanner = new Scanner(System.in);
		Integer num = Integer.parseInt(scanner.nextLine());

		ObjectOutputStream oos = null;

		for (int i=1;i<=num;i++){
			//输入员工信息
			String emp = scanner.nextLine();

			//拆分员工信息，分别赋值到emp对象的属性
			String[] empArr = emp.split(",");
			//张三,25,男,5000,2006-3-18
			String name = empArr[0];
			int age = Integer.parseInt(empArr[1]);
			String gender = empArr[2];
			int salary = Integer.parseInt(empArr[3]);
			Date hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(empArr[4]);

			Emp person = new Emp(i,name,age,gender,salary,hiredate);

			//创建文件输出流
			FileOutputStream fos = new FileOutputStream(person.getName()+".obj");
			//创建对象输出流
			 oos = new ObjectOutputStream(fos);
			//写出对象
			oos.writeObject(oos);
		}

		//关闭资源
		oos.close();
		
	}
	
	/**
	 * 读取当前项目根目录下所有后缀为.obj的文件，将这些Emp对象读取出来
	 * 并存入到一个List集合中，然后按照员工工资从多到少的顺序依次输出员工信息
	 * @author OYE
	 *
	 */
	public static void test04(){
		
	}
	
	/**
	 * 使用字符流复制当前程序的源文件到当前项目根目录下。
	 * @author OYE
	 *
	 */
	public static void test05(){

		
	}
	
	/**
	 * 记事本功能，首先要求用户输入一个文件名，并将该文件创建出来，
	 * 然后通过控制台输入的每一行字符串都按行写入到该文件中，并
	 * 使用GBK编码保存。当输入的字符串为"exit"时退出程序。
	 * @author OYE
	 *
	 */
	public static void test06() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入文件名：");
		String fileName = scanner.nextLine();

		//创建文件写出流
		FileOutputStream fos = new FileOutputStream(fileName);
		//创建字符转换流
		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
		//创建字符输出流
		PrintWriter pw = new PrintWriter(osw,true);

		System.out.println("请写点东西(输入exit则退出程序)：");
		String message = null;
		while (true){
			message = scanner.nextLine();
			if(message.equals("exit")){
				System.out.println("退出程序");
				break;
			}
			pw.println(message);
		}
		//关闭资源
		pw.close();
		
	}
	
	/**
	 * 要求用户输入一个文件，该文件应当是Test07程序生成的文件，然后将该文件中所有字符读取
	 * 出来，并以UTF-8编码写入到另一个文件中，实现文件转码工作，该文件取名格式:原文件名_utf.txt。
	 * @author OYE
	 *
	 */
	public static void test07(){
		
	}


}
