package JavaHome_Work;

public class HomeWork_06 {


	/**
	 * 通过File输出当前项目目录下的文件"myfile.txt"的名字，大小，最后修改时间。
	 * 最后修改时间格式如:2016-03-23 14:22:16
	 * @author OYE
	 *
	 */
	public static void test01(){
		
	}
	
	/**
	 * 要求用户输入一个文件名并使用File在当前目录下创建出来。
	 * 若该文件已经存在，则提示用户该文件已经存在。并创建该文件副本：
	 * 例如:用户输入"test.txt".若该文件已存在，提示用户存在后，创建名为：test_副本1.txt 的文件
	 * 若该文件也存在了，则创建名为:test_副本2.txt 的文件，以此类推
	 * @author OYE
	 *
	 */
	public static void test02(){
		
	}
	
	/**
	 * 要求用户输入一个目录名并使用File在当前目录下创建出来。
	 * 若该目录已经存在，则提示用户该目录已经存在。并创建副本，原则与第二题一致。
	 * @author OYE
	 *
	 */
	public static void test03(){
		
	}
	
	/**
	 * 获取并输出当前目录下的所有文件和目录的名字
	 * @author OYE
	 *
	 */
	public static void test04(){
		
	}
	
	/**
	 * 要求用户输入一个文件或目录名，并删除当前目录下的该文件或目录。
	 * 可自行手动先在当前项目目录中创建一个要删除的文件或目录，若是目录，还可以
	 * 在该目录中继续创建若干级目录和文件。
	 * @author OYE
	 *
	 */
	public static void test05(){
		
	}
	
	/**
	 * 获取并输出当前目录下所有文件的名字
	 * @author OYE
	 *
	 */
	public static void test06(){
		
	}
	
	/**
	 * 要求用户输入一个文件名，并复制当前目录中该文件，并取名为"原文件名_copy.后缀名"
	 * 定义两个方法分别使用单字节形式复制，以及字节数组形式复制
	 * @author OYE
	 *
	 */
	public static void test07(){
		
	}
	
	/**
	 * 创建一个"raf.dat"的文件，并在其中写出一个int的最大值，long的最大值，
	 * 然后将其分别读取出来并输出
	 * @author OYE
	 *
	 */
	public static void test08(){
		
	}
	
	/**
	 * 创建一个文件"note.txt",然后通过控制台输入的每一行字符串都按行写入到
	 * note.txt中。当输入的字符串为"exit"时退出程序。
	 * @author OYE
	 *
	 */
	public static void test09(){
		
	}
	
	/**
	 * 要求用户输入一个员工信息，格式为：
	 * name,age,gender,salary,hiredate
	 * 例如:
	 * 张三,25,男,5000,2006-02-15
	 * 然后将输入的员工信息解析成Emp对象。
	 * 然后将该Emp对象的toString返回的字符串写入到文件中，该文件的
	 * 名字为:name.emp,以上面的例子，那么该文件名为:张三.emp
	 * 至少运行5次该程序，输入五个员工信息，并生成5个文件。
	 * @author OYE
	 *
	 */
	public static void test10(){
		
	}
	
	/**
	 * 编写一个程序，将当前目录下所有员工文件进行读取，并解析出所有员工为Emp
	 * 对象并存入集合。然后排序该集合，按照员工的年龄排序，年龄大的靠前，年龄小
	 * 的靠后。排序完毕后输出结果。
	 * @author OYE
	 *
	 */
	public static void test11(){
		
	}
	
	/**
	 * 编写一个程序，将当前目录下所有的员工文件进行读取，并解析出所有员工为Emp
	 * 对象并存入Map。其中key为该员工的名字，value为该员工的emp对象。
	 * 然后，要求用户输入一个员工名字，若该员工存在，则输出该员工的名字，年龄，工资，以及入职20周年的纪念日当周的周六的日期。
	 * 即:输入名字"张三"
	 * 若该员工存在，则输出如下格式:
	 * 张三,25,5000,2006-02-14
	 * 入职20周年纪念日派对日期: 2026-02-14  （注:若入职日期为:2006-02-14）
	 * 若该员工不存在，则输出:"查无此人"
	 * @author OYE
	 *
	 */
	public static void test12(){
		
	}
	
	/**
	 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
	 * 集合，然后输出该集合中每个员工信息。
	 * 该文件800字节，每80个字节为一个员工的信息。
	 * 其中:
	 * 	 name为字符串，长度为32个字节，编码为:UTF-8
	 *   age为int,长度为4个字节
	 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
	 * 	 salary为int,长度为4个字节
	 * 	 hiredate为字符串，格式"yyyy-MM-dd"，长度为30个字节，编码为:UTF-8
	 * 格式可参考当前包中emp.jpg图
	 * 提示:
	 * 使用RandomAccessFile读取字符串时，例如name,可以先读取32个字节，再按照UTF-8
	 * 转换为字符串，读取age时可以直接使用readInt方法。依次类推。
	 * @author OYE
	 *
	 */
	public static void test13(){
		
	}
}
