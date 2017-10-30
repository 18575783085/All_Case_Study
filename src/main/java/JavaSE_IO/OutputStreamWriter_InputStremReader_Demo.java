package JavaSE_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 字符流
 * 		字符流与字节流的区别在于读写单位是：字符
 * 	但是字符流底层本质还是读写字节，只是字符与字节
 * 	的转换工作交给了字符流来完成。
 * 
 * Reader：是所有字符输入流的父类，规定了读取字符的相关方法
 * Writer：是所有字符输出流的父类，规定了写出字符的相关方法
 * 
 * 
 * 转换流：
 * InputStreamReader、OutputStreamWriter
 * 它们是字符流的一对常见的实现类
 * @author OYE
 *
 */
public class OutputStreamWriter_InputStremReader_Demo {

	/**
	 * 字符输出转换流
	 */
	public static void Output_writer(){
		try {
			FileOutputStream fos = new FileOutputStream("osw.txt");
			
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			
			osw.write("我是一个字符转换输入流");
			osw.write("是把字符转换字节写出到文件里面");
			
			System.out.println("写出完毕");
			
			//关流
			osw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 字节输入转换流：InputSteamReader
	 * 把字节转换为字符
	 */
	public static void Input_reader(){
		try {
			FileInputStream fis = new FileInputStream("osw.txt");
			
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			
			int len = -1;
			
			while((len = isr.read())!=-1){
				System.out.println((char)len);
			}
			//关流
			isr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
