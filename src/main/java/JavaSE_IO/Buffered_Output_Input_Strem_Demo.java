package JavaSE_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流：
 * BufferedInputStream：缓冲输入流，提高读取效率
 * BufferedOutputStream：缓冲输出流，提高写出效率
 * 
 * 缓冲流内部维护着一个缓冲区（字节数组）
 * bis.read()看似读取一个字节，实际上缓冲流会一次性通过fis读取一组字节，
 * 并存入内部维护的字节数组中，然后将第一个字节返回。
 * 这样当再次调用bis.read()读取一个字节时，会直接从内部的字节数组将第二个字节返回。
 * 所以缓冲流还是通过提高一次实际读取的字节量，
 * 从而减少实际读取次数提高的效率。
 * 缓冲输出流也是类似这原理。
 * 
 * 
 * @author OYE
 *
 */
public class Buffered_Output_Input_Strem_Demo {

	
	/**
	 * 使用字节进行复制文件
	 */
	public static void BufferedCopyByte(){
		try {
			//创建文件读入流
			FileInputStream fis = new FileInputStream("demo.txt");
			//创建读入缓冲流
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			//创建文件写出流
			FileOutputStream fos = new FileOutputStream("demo_cp.txt");
			//创建写出缓冲流
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int len = -1;
			
			
			while((len = bis.read())!=-1){
				bos.write(len);
			}
			
			System.out.println("复制完毕");
			
			//关流
			bis.close();
			bos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用字节数组进行复制文件
	 */
	public static void BufferedCopyArr(){
		try {
			//创建文件读入流
			FileInputStream fis = new FileInputStream("demo.txt");
			//创建读入缓冲流
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			//创建文件写出流
			FileOutputStream fos = new FileOutputStream("demo_cp.txt");
			//创建写出缓冲流
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int len = -1;
			byte[] data = new byte[1024*10];
			
			while((len = bis.read(data))!=-1){
				bos.write(data, 0, len);
			}
			
			System.out.println("复制完毕");
			
			/*
			 * 关闭流只需要关闭最外层高级流即可。
			 */
			bis.close();
			bos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 缓冲输出流写出数据的缓冲区问题
	 */
	public static void BufferedOutput_flush(){
		try {
			FileOutputStream fos = new FileOutputStream("bos.txt");
			
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			String str = "冲刷缓冲区";
			
			byte[] data = str.getBytes("UTF-8");
			
			bos.write(data);
			/*
			 * 一次性将缓冲区中的数据写出
			 */
			bos.flush();
			
			System.out.println("写出完毕");
			
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
