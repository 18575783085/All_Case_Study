package JavaSE_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 流   java标准的IO操作
 * 流按照功能分为：
 * 输入流（input）：用来读入数据
 * 输出流（Output）：用来写出数据
 * 
 * 流分类：节点流和处理流
 * 节点流：节点流又称为低级流，是真实负责读写的流，是连接程序与数据源的“管道”，
 * 		负责将数据搬运。
 * 		 读写一定是基于低级流完成的。
 * 		 特点：数据源明确（知道数据从哪里来，或者数据写到哪里去）
 * 
 * 处理流：处理流不能独立存在，必须基于另一个流进行读或写，目的是通过处理流提供的读写功能
 * 		简化我们对实际读写数据的操作。
 * 
 * 文件流
 * 		用来读写文件数据的流，文件流是一对低级流
 * 		论功能与RandomAccessFile一致，都是用来读写文件数据的流，
 * 		但是区别在与实际底层的读写实现方式不同，
 * 		RandomAccessFile是基于指针进行读写的。
 * 		文件流是基于流式读写的。
 * @author OYE
 *
 */
public class File_Output_Input_Strem_Demo {

	/**
	 * 默认创建的文件输出流是：覆盖写操作
	 * 即：若该文件存在，会先将该文件所有数据清除，
	 * 然后通过该流写出的数据会作为文件数据。
	 * RandomAccessFile写出则不同，它是写出多少数据覆盖多少数据。
	 * 
	 * FileOutputStream支持另一种构造方法，要求传入两个参数，
	 * 第二个参数是一个boolean值，若该值为true，则是追加写模式，
	 * 即：通过该流写出的数据会被追加到文件末尾。
	 */
	public static void OutputDemo(){
		try {
			//创建文件写出流对象
			FileOutputStream fos = new FileOutputStream("fos.txt",true);
			
			String str = "这是一个写出数据的流";
			
			byte[] data = str.getBytes("UTF-8");
			
			fos.write(data);
			
			System.out.println("写出完毕");
			
			//关流
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 文件输入流
	 */
	public static void InputDemo(){
		try {
			//创建文件读入流对象
			FileInputStream fis = new FileInputStream("fos.txt");

			byte[] data = new byte[100];
			
			int len = -1;
			
			String str = new String(data, 0, len);
			
			System.out.println(str);
			
			//关流
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 使用文件流复制文件
	 * 使用文件输入流将原文件中的所有字节数据的
	 * 读取出来再用文件输出流写入到另一个文件中，
	 * 完成复制操作。
	 */
	public static void CopyFile(){
		try {
			//创建文件读入流
			FileInputStream fis = new FileInputStream("test.txt");
			
			//创建文件写出流
			FileOutputStream fos = new FileOutputStream("text_cp.txt");
			
			int len = -1;
			byte[] data = new byte[1024*10];
			
			while((len = fis.read(data))!=-1){
				fos.write(data, 0, len);
			}
			
			System.out.println("复制完毕");
			
			//关流
			fis.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
