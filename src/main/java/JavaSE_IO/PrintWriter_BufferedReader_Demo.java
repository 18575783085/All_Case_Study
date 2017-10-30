package JavaSE_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 缓冲字符流
 * 	PrintWriter、BufferedReader
 * @author OYE
 *
 */
public class PrintWriter_BufferedReader_Demo {

	/**
	 * java.io.PrintWriter
	 * 缓冲字符输出流
	 * 特点：可以按行写出字符串，由于有缓冲，写出字符串效率高
	 * 
	 * 实际上PrintWriter自身的最大特点是支持“自动行刷新”功能，
	 * 而缓冲功能是靠其内嵌的BufferedWriter实现的。
	 * 因为实例化PrintWriter时，它总会内部实例化BufferedWriter并与其连接。
	 * 
	 */
	public static void printWriter(){
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("pw.txt","UTF-8");
			/*
			 * PrintWriter提供了很多构造方法，其中有直接对文件写操作的构造方法：
			 * PrintWriter(String path)
			 * PrintWriter(File file)
			 * 
			 * 可以使用重载构造方法指定字符集
			 * PrintWriter(String path,String charsetName)
			 * PrintWriter(File file,String charsetName)
			 */
			pw.println("我是字符缓冲流");
			pw.println("我实现了BufferedWriter，同时自带很多方法供程序员使用");
			pw.println("我还能自动换行呢呢");
			
			System.out.println("写出完毕");
			// 以防关流失败导致一部分数据死在缓冲区中
			pw.flush();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}finally {
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * 在流连接使用
	 */
	public static void printDemo(){
		// 需要把流对象外置定义
		PrintWriter pw = null;
		try {
			//创建文件输出流
			FileOutputStream fos = new FileOutputStream("text.txt");
			//创建字符转换流
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			//创建字符缓冲流
			pw = new PrintWriter(osw);
			
			pw.println("终于快写完io阶段的代码了");
			pw.println("加油，骚年");
			
			System.out.println("写出完毕");
			
			// 以防关流失败导致一部分数据死在缓冲区中
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}finally {
			//需要判断流对象是否初始化成功
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * java.io.BufferedReader
	 * 缓冲字符输入流
	 * 可以按行读取字符串
	 */
	public static void bufferedReader(){
		/*
		 * 将当前源代码输出到控制台
		 */
		BufferedReader br = null;
		try {
			//创建文件输入流
			FileInputStream fis = new FileInputStream("."+File.separator+ 
											"src"+File.separator+"JavaSE_IO"+File.separator+
											"PrintWriter_BufferedReader_Demo.java");
			//创建字节转换流
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			//创建缓冲字符输入流
			 br = new BufferedReader(isr);
			
			/*
			 * BufferedReader()提供了读取一行字符串的方法：
			 * String readLine()
			 * 该方法会顺序读取若干字符，直到读取了换行符为之，
			 * 然后将换行符之前的所有字符依一个字符串形式返回。
			 * 若返回值为null，则表示文件末尾
			 */
			
			String line = null;
			while((line = br.readLine())!=null){
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 需要判断流对象是否初始化成功
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					// 如果关流失败，强制回收流对象来释放文件
					// 如果关流成功，释放内存
					br = null;
				}
			}
		}
		
		
	}
}
