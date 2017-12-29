package JavaHome_Work;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HomeWork_08 {

	/**
	 * 对myfile.txt文件进行复制操作，要求使用异常捕获
	 * 机制对流的异常进行捕获和处理，finally中
	 * 要将流关闭
	 * @author OYE
	 *
	 */
	public static void test01(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			//创建文件输入流
			 fis = new FileInputStream("myfile.text");
			//创建文件写出流
			 fos = new FileOutputStream("myfile_cp.txt");

			int len = -1;
			byte[] data = new byte[10*1024];

			while ((len = fis.read(data)) != -1){
				fos.write(data,0,len);
			}
			System.out.println("复制完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis !=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					fis = null;
				}
			}
			if (fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					fos = null;
				}
			}
		}

	}
	
	/**
	 * 使用异常捕获完成下述操作
	 * 将控制台输入的每一行字符串使用缓冲字符输出流PrintWriter
	 * 按行以GBK编码写入到文件note.txt中
	 * @author OYE
	 *
	 */
	public static void test02(){
		
	}
	
	/**
	 * 使用异常捕获机制完成下述读取操作。
	 * 使用缓冲流读取note.txt文件，并将每行字符串输出到控制台上
	 * @author OYE
	 *
	 */
	public static void test03(){
		
	}
	
	/**
	 * 使用异常捕获机制完成下述读取操作
	 * 读取emp.txt文件，并将每个员工信息读取出来，以一个Emp实例保存，然后将
	 * 这些Emp实例存入到一个Map集合中。其中key为字符串，是该员工名字，而value
	 * 是该Emp实例。
	 * 存入后，要求用户输入一个员工的名字,如:张三
	 * 若该员工存在则输出该员工所有信息(Emp的toString方法返回的字符串)
	 * 输入的员工名若是英文，不要求区分大小写。
	 * 若输入的员工名字不存在，则显示"查无此人"
	 * 
	 * @author OYE
	 *
	 */
	public static void test04(){
		
	}
	
	/**
	 * 使用异常捕获机制完成下述读取操作，并在finally中有关闭RandomAccessFile操作。
	 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
	 * 集合，然后按照员工入职从晚到早的顺序依次输出员工信息。
	 * 
	 * 该文件560字节，每56个字节为一个员工的信息。
	 * 其中:
	 * 	 name为字符串，长度为32个字节，编码为:UTF-8
	 *   age为short,长度为2个字节
	 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
	 * 	 salary为int,长度为4个字节
	 * 	 hiredate为long，长度为8个字节
	 * 格式可参考当前包中emp.jpg图
	 * @author OYE
	 *
	 */
	public static void test05(){
		
	}
	
	/**
	 * 使用异常捕获机制完成下述IO操作
	 * 编写程序，要求下面的类实现功能:
	 * 添加新员工
	 * 要求用户输入一个员工信息，格式如下:
	 * jackson,25,男,5000,2008-12-22
	 * 用户输入后需要做下述验证:
	 * 要求用户名长度在1-20个字符之间且必须是英文
	 * 年龄在0-100之间的整数
	 * 性别只能是:"男"或"女"
	 * 当发现用户输入有不符合规定时，提醒用户
	 * 相关内容输入不符合要求，并要求重新输入。
	 * 都输入正确后，将该员工添加到emp.txt文件
	 * 的最后一行。
	 * 
	 * @author OYE
	 *
	 */
	public static void test06(){
		
	}


}
