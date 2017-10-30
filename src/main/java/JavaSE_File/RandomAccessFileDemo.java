package JavaSE_File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * RandomAccessFile:用来读写文件数据的。
 * 其基于指针进行读写，总是在指针当前位置读写字节，并且读写完毕后指针自动后移。
 * @author Administrator
 *
 */
public class RandomAccessFileDemo {
	
	
	/**
	 * RandomAccessFile有两种常见的创建模式：
	 * 1：只读模式，进读取文件数据
	 * 2：读写模式
	 * 
	 * RandomAccessFile提供了相应的构造方法
	 * RandomAccessFile(File file,String mode)
	 * RandomAccessFile(String path,String mode)
	 * 第一个参数指定要读写的文件，
	 * 第二个参数为字符串，常用的两个：
	 * 1：“rw”：读写模式
	 * 2：“r”：只读模式
	 */
	public static void rafWrite(){
		
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("test.dat", "rw");
			
			/*
			 * void write(int d)
			 * 将给定的int值所表示的2进制的"低8位"这个
			 * 字节写入文件
			 *                            VVVVVVVV
			 * 00000000 00000000 00000000 00000001
			 * 11111111 11111111 11111111 11111111
			 * 00000000 00000000 00000001 00000001
			 */
			raf.write(257);
			System.out.println("写出完毕！");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件找不到",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读写文件失败", e);
		} finally {
			if(raf != null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					raf = null;
				}
			}
		}
		
	}
	
	/**
	 * 读取文件数据
	 */
	public static void rafRead(){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("test.dat", "r");
			
			/*
			 * int read()
			 * 读取一个字节，并将该字节存到一个int值中
			 * 然后返回该int值，若返回的int值为-1,则表示
			 * 本次读取时发现是在文件的末尾。
			 *                            vvvvvvvv
			 * 00000000 00000000 00000000 00000001
			 */
			int d = raf.read();
			System.out.println(d);
			
			d = raf.read();//第二次读取时是文件末尾
			System.out.println(d);//-1
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件找不到",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读写文件失败", e);
		} finally {
			if(raf != null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					raf = null;
				}
			}
		}
		
	}
	
	/**
	 * 单字节形式复制：通过读写模式来复制文件
	 */
	public static void copyDemo1(){
		RandomAccessFile src = null;
		RandomAccessFile desc = null;
		try {
			//主文件
			src = new RandomAccessFile("eclipse.zip", "r");
			
			//文件副本
			desc = new RandomAccessFile("eclipse_cp.zip", "rw");
			
			int len = -1;//记录每次读取到的字节
			
			while((len = src.read()) != -1){
				desc.write(len);
			}
			
			System.out.println("复制完毕！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件找不到",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读写文件失败", e);
		} finally {
			if(src != null){
				try {
					src.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					src = null;
				}
			}
			if(desc != null){
				try {
					desc.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					desc = null;
				}
			}
		}
	}
	
	/**
	 * 随机读写效率差，块读写效率高
	 * 所以若希望提高读写效率，
	 * 可以通过提高每次读写的数据量来减少读写次数来达到。
	 * --字节数组形式复制--
	 */
	public static void copyDemo2(){
		RandomAccessFile src = null;
		RandomAccessFile desc = null;
		try {
			src = new RandomAccessFile("eclipse.zip", "r");
			
			desc = new RandomAccessFile("eclipse_cp.zip", "rw");
			
			/*
			 * RandomAccessFile提供了一次读写一组字节的方法：
			 * 
			 * int read(byte[] data)
			 * 一次性读取给定字节数组length的字节量，
			 * 并存入到该数组中，返回值为实际读取到的字节量，
			 * 若返回值为 -1 表示本次没有读到任何字节，是文件的末尾。
			 * 
			 * void write(byte[] data)
			 * 将给定的字节数组中所有字节一次性写出
			 * 
			 * void write(byte[] data,int offset,int len)
			 * 将给定字节数组从下标offset处的字节开始的连续
			 * len个一次性写出
			 * 
			 */
			//相当于自己"制造一个缓冲区"
			byte[] data = new byte[1024*10];//缓冲区空间为10kb
			int len = -1;//记录每次读取到的字节量
			
			while((len = src.read(data)) != -1){
				desc.write(data, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件找不到",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读写文件失败", e);
		} finally {
			if(src != null){
				try {
					src.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					src = null;
				}
			}
			if(desc != null){
				try {
					desc.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					desc = null;
				}
			}
		}
		
	}
	
	/**
	 * 使用 RandomAccessFile 读写基本类型数据，以及 RandomAccessFile对指针的操作
	 */
	public static void demo1(){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("raf.dat", "rw");
			
			/*
			 * long getFilePointer()
			 * 获取RandomAccessFile当前指针位置
			 */
			//创建出来时，指针在文件开始
			long pos = raf.getFilePointer();
			System.out.println("pos："+pos);
			
			int imax = Integer.MAX_VALUE;//int的最大值
			/*
			 *                            vvvvvvvv
			 * 01111111 11111111 11111111 11111111
			 */
			//模拟WriteInt()底层运算
			raf.write(imax >>> 24);//将最高8位移动到最低8位
			System.out.println("pos："+raf.getFilePointer());
			raf.write(imax >>> 16);
			raf.write(imax >>> 8);
			raf.write(imax);
			System.out.println("pos："+raf.getFilePointer());
			
			/*
			 * void writeInt(int d)
			 * 将int值对应的4个字节一次性写出
			 */
			raf.writeInt(imax);
			System.out.println("pos："+raf.getFilePointer());
			
			raf.writeLong(123L);
			System.out.println("pos:"+raf.getFilePointer());
			
			raf.writeDouble(123.123);
			System.out.println("pos:"+raf.getFilePointer());
			
			/*
			 * void seek(long pos)
			 * 移动指针到指定位置
			 */
			raf.seek(0);
			System.out.println("pos："+raf.getFilePointer());
			
			/*
			 * 连续读取4个字节，并返回对应的int值 
			 * EOF  end of file
			 */
			int d = raf.readInt();
			System.out.println("imax:"+d);//int最大值
			System.out.println("pos:"+raf.getFilePointer());
			
			//读取long
			//1：先将指针移动到long值的起始位置
			raf.seek(8);
			long l = raf.readLong();
			System.out.println("long:"+l);
			
			System.out.println("pos:"+raf.getFilePointer());
			
			//读取double
			double dou = raf.readDouble();
			System.out.println("double:"+dou);
			
			System.out.println("pos:"+raf.getFilePointer());
			
			System.out.println("写出完毕!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件找不到",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读写文件失败", e);
		} finally {
			if(raf != null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					raf = null;
				}
			}
		}
	}
	
	/**
	 * 写字符串
	 */
	public static void demo2(){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("raf.txt", "rw");
			
			String str = "简单点，说话的方式简单点！";
			
			/*
			 * byte[] getBytes()
			 * 将当前字符串按照系统默认字符集转换为一组字节
			 * 
			 * byte[] getBytes(String csn)
			 * 将当前字符串按照给定字符集转换为一组对应的字节
			 * csn：charset name
			 * 常用的字符集：
			 * GBK、UTF-8、ISO-8859-1（欧洲编码，不支持中文）
			 */
			byte[] data = str.getBytes("UTF-8");
			raf.write(data);
			
			System.out.println("写出完毕！");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件找不到",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读写文件失败", e);
		} finally {
			if(raf != null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					raf = null;
				}
			}
		}
	}
	
	/**
	 * 读取字符串
	 */
	public static void demo3(){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("raf.txt", "r");
			
			byte[] data = new byte[100];
			int len = raf.read(data);
			
			/*
			 * String(byte[] data)
			 * 将给定字节数组中所有字节按照当前系统默认字符集转换为对应的字符串
			 * 
			 * String(byte[] data,int offset,int len)
			 * 将给定字节数组从下标offset处开始的连续len个字节，
			 * 按照系统默认字符集转换为字符串
			 * 
			 * String(byte[] data,int offset,int len，String csn)
			 * 将给定字节数组从下标offset处开始的连续len个字节
			 * 按照指定字符集转换为字符串
			 */
			String str = new String(data,0,len,"UTF-8");
			System.out.println(str);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件找不到",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读写文件失败", e);
		} finally {
			if(raf != null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					raf = null;
				}
			}
		}
	}

}
