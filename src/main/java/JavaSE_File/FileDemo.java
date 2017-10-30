package JavaSE_File;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.naming.directory.DirContext;

/**
 * java.io.File
 * File的每一个实例用于表示文件系统中的一个文件或目录
 * 
 * 使用File可以：
 * 1：访问该文件或目录的属性信息（名字、大小、修改日期等）
 * 2：操作文件或目录（创建、删除）
 * 3：若表示的是目录，可以查看该目录中的子项信息
 * 
 * 注意：但是不能访问一个文件中的数据
 * @author Administrator
 *
 */
public class FileDemo {
	
	
	/**
	 * 在java程序中使用路径时，尽量使用相对路径
	 * 这样可以避免平台差异性
	 * 
	 * “.”：表示当前目录，在eclipse中当前目录指的是
	 * 		当前类所在项目的跟目录
	 * 
	 * File提供了一个常量：separator
	 * 它表示一个受系统支持的目录层级分割
	 */
	public static void demo1(){
		File file = new File("."+File.separator+"demo.txt");
		
		String name = file.getName();
		System.out.println("文件名字："+name);
		
		long length = file.length();
		System.out.println("文件大小："+length+"字节");
		
		/*
		 * boolean canRead()
		 * boolean canWrite()
		 * boolean isHidden()
		 */
		boolean cr = file.canRead();
		System.out.println("文件是否可读："+cr);
		
		boolean cw = file.canWrite();
		System.out.println("文件是否可写："+cw);
		
		boolean ih = file.isHidden();
		System.out.println("文件是否隐藏："+ih);
		
		long time = file.lastModified();
		System.out.println("文件最后修改的时间："+new SimpleDateFormat("yyyy年MM月dd日，HH:mm:ss").format(time));
		
	}
	
	/**
	 * 使用File创建一个文件
	 */
	public static void demo2(){
		/*
		 * 在当前目录下创建一个文件：test.txt
		 */
		File file = new File("."+File.separator+"text.txt");
		
		/*
		 * boolean exists()
		 * 判断当前File表示的文件或目录是否真实存在
		 */
		if(file.exists()){
			System.out.println("该文件已存在！");
		}else {
			//不存在，创建文件
			try {
				file.createNewFile();
				System.out.println("创建完毕！");
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("创建文件失败",e);
			}
			
		}
	}
	
	/**
	 * delete():删除一个文件
	 */
	public static void demo3(){
		/*
		 * 将当前目录中的test.txt文件删除
		 */
		File file = new File("."+File.separator+"test.txt");
		
		if(file.exists()){
			//文件存在，删除指定文件
			file.delete();
			System.out.println("该文件已删除！");
		}else{
			System.out.println("该文件不存在！");
		}
	}
	
	/**
	 * mkdir():创建一个目录
	 */
	public static void demo4(){
		/*
		 * 在当前目录中创建目录demo
		 */
		File dir = new File("."+File.separator+"demo");
		
		if(dir.exists()){
			System.out.println("该目录已存在！");
		}else {
			//不存在，创建该目录
			dir.mkdir();
			System.out.println("目录创建完毕！");
		}
	}
	
	/**
	 * mkdirs():创建一个多级目录
	 */
	public static void demo5(){
		/*
		 * 在当前目录下创建目录：a/b/c/d/e/f
		 */
		File dir = new File(
				"a"+File.separator+
				"b"+File.separator+
				"c"+File.separator+
				"d"+File.separator+
				"e"+File.separator+
				"f");
		
		if(dir.exists()){
			System.out.println("该目录已存在！");
			
		}else{
			/*
			 * mkdirs的会将要创建的目录创建出来的
			 * 同时将所有不存在的父目录一同创建出来；
			 * 而mkdir方法在创建目录时要求父目录必须存在，
			 * 否则创建不成功。
			 */
			dir.mkdirs();
			System.out.println("目录创建完毕！");
		}
	}
	
	/**
	 * 删除一个目录
	 */
	public static void demo6(){
		/*
		 * 将当前目录下的dmeo目录删除
		 * 直接指定文件名或目录名，那么该文件或目录默认是在当前目录中
		 * 即：File dir = new File("demo");
		 * 等同：File dir = new File("./demo");
		 * 
		 * 删除一个目录的前提条件是该目录必须是一个空目录才可以将其删除
		 */
		File dir = new File("demo");
		if(dir.exists()){
			dir.delete();
			System.out.println("删除目录完毕！");
		}else {
			System.out.println("该目录不存在！");
		}
	}
	
	/**
	 * 获取一个目录中的所有子项
	 */
	public static void demo7(){
		/*
		 * 查看当前目录中的所有子项
		 */
		File dir = new File(".");
		
		/*
		 * boolean isFile()
		 * 判断当前File表示的是否是一个文件
		 * 
		 * boolean isDirectory()
		 * 判断当前File表示的是否为一个目录
		 */
		if(dir.isDirectory()){//判断是否为一个目录
			//获取该目录中的所有子项
			File[] subs = dir.listFiles();
			System.out.println("当前目录有："+subs.length+"个子项");
			
			//遍历目录下的子文件和子目录
			for(File sub : subs){
				if(sub.isFile()){
					System.out.println("文件：");
				}
				if(sub.isDirectory()){
					System.out.println("目录：");
				}
				System.out.println(sub.getName());
			}
			
		}
	}
	
	/**
	 * File提供了一个重载的listFiles方法，
	 * 该方法可以指定一个文件过滤器，这样可以将该目录中所有满足过滤器要求的子项获取到。
	 */
	public static void demo8(){
		File dir = new File(".");
		
		/*
		 * 获取当前目录中的所有文件
		 */
		File[] subs = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				String name = file.getName();
				System.out.println("正在过滤："+name);
				//判断是否为文件
				return file.isFile();
			}
		});
		
		//遍历子文件
		for(File sub : subs){
			System.out.println(sub.getName());
		}
		
	}
	
	/**
	 * 递归调用：
	 * 	方法内部调用自己方法的现象称为递归调用。
	 * 	递归现象允许程序执行到某个阶段时整体重新来过。
	 * 使用递归需要注意：
	 * 1：方法内部调用自己方法不能 100% 成功，否则是死循环。
	 * 2：递归层次尽量少，因为递归消耗内存可观，运行效率差。
	 * 
	 * 删除给定的文件或目录
	 * 模拟场景：一个主目录里面有多个子文件和多个子目录，然后子目录里面又有多个子子文件和多个子子目录
	 */
	public static void demo9(){
		File file = new File("a");
		delete(file);
		
	}
	/*
	 * 将给定的File表示的文件或目录删除
	 */
	public static void delete(File file){
		if(file.isDirectory()){
			//先将该目录清空
			File[] subs = file.listFiles();
			for(File sub : subs){
				delete(sub);//递归调用
			}
		}
		file.delete();
	}

}
