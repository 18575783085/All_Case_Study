package JavaSE_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 对象流是一对高级流，作用是方便读写java中的对象。
 * 
 * java.io.ObjectOutputStream
 * 对象输出流，可以将给定的对象转换为一组字节，然后通过其处理的流将这组字节写出
 * @author OYE
 *
 */
public class Object_Output_Input_Strem_Demo {

	/**
	 * 对象输出流提供方便写出对象的方法：
	 * writeObject(Object o)
	 * 该方法可以将给定的对象按照其结构转换为一组对应的字节，
	 * 然后通过对象输出流连接的流将该组字节写出
	 * 
	 * 将一个对象通过对象列转换为字节后并写入文件的操作涉及两个专业名词:
	 * 1；对象序列化
	 * 		对象序列化就是将一个java中的对象按照其结构转化为一组字节的过程（对象输出流完成）
	 * 
	 * 2：持久化
	 * 		将一组字节写入文件（硬盘上）过程成为持久化
	 * 
	 */
	public static void writeObjectDemo(){
		try {
			person p = new person();
			p.setName("测试对象");
			p.setAge(18);
			p.setGender("男");
			
			List<String> otherInfo = new ArrayList<String>();
			otherInfo.add("热爱编码");
			otherInfo.add("忠于java语言");
			otherInfo.add("努力成为大牛");
			p.setOtherList(otherInfo);
			//创建用于文件中写出字节的文件输出流
			FileOutputStream fos = new FileOutputStream("person.obj");
			//创建用于写出对象的对象输出流并连接到文件输出流上
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(p);
			
			System.out.println("写出完毕");
			oos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 对象输入流
	 * 用于反序列化对象
	 */
	public static void readObjectDemo(){
		try {
			//创建文件输入流
			FileInputStream fis = new FileInputStream("person.obj");
			//创建对象输入流
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			person p = (person) ois.readObject();
			
			System.out.println(p.toString());
			
			//关流
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}

/**
 * 用于测试对象流进行对象的读写操作
 * 如果一个类的实例希望被对象流进行读写，那么该类必须实现Serializable接口
 * @author OYE
 *
 */
class person implements Serializable{
	
	/**
	 * 当一个类实现了序列化接口后，就应当定义一个常量：serialVersionUID:序列化版本号
	 * 序列化版本号决定反序列化操作是否成功。
	 * 
	 * 当对象输入流在将一组字节进行反序列化时会对该对象与其对应的类进行版本号比较，
	 * 若一致则反序列化，若不一致则抛出版本号不一致的异常
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * 被transient修饰的属性在进行对象序列化时，
	 * 其值会被忽略。
	 * 将可有可无的属性忽略可以达到对象序列化“瘦身”的效果
	 */
	private transient List<String> otherList;
	
	
	public person(){}
	public person(String name, int age, String gender, List<String> otherList) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherList = otherList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getOtherList() {
		return otherList;
	}
	public void setOtherList(List<String> otherList) {
		this.otherList = otherList;
	}
	
	
	@Override
	public String toString() {
		return "person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	
}