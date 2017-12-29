package JavaHome_Work;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HomeWork_03 {

	
	/**
	 * 使用Date输出当前系统时间，以及3天后这一刻的时间
	 */
	@Test
	public void test01(){
		Date date = new Date();
		System.out.println("当前时间："+date);
		System.out.println("当前时间："+new SimpleDateFormat("yy-MM-dd").format(date));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR,3);
		System.out.println(calendar.getTime());
		System.out.println(new SimpleDateFormat("yy-MM-dd").format(calendar.getTime()));

	}
	
	/**
	 * 将当前系统时间以"yyyy-MM-dd HH:mm:ss"格式输出
	 *
	 */
	@Test
	public void test02(){
		Date date = new Date();
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		System.out.println(format);
	}
	
	/**
	 * 输入某人生日，格式为"yyyy-MM-dd"，输出到现在为止经过了多少周。
	 *
	 */
	@Test
	public void test03() throws ParseException {
		String birthday = "2017-12-10";
		Date parseBirth = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		Date now = new Date();

		long time = now.getTime() - parseBirth.getTime();
		long week = time / 1000 / 60 / 60 / 24 / 7;
		System.out.println(week);


	}
	
	/**
	 * 输入一个生产日期格式"yyyy-MM-dd",再输入一个数字(保质期的天数)。
	 * 然后经过计算输出促销日期，促销日期为:该商品过期日前2周的周三
	 */
	public static void test04(){
		
	}
	
	/**
	 * 实现时间的计算: 要求用户输入身份证号，若格式有误，要求其重新输入。然后根据身份证号码输出20岁生日
	 * 所在周的周三的日期。
	 * 例如:
	 * 出生日期:1992-07-15。
	 * 20岁生日:2012-07-15
	 * 当周的周三为:2012-07-18
	 *
	 */
	@Test
	public void test05() throws ParseException {
		String idCard = "440684199409080417";
		String regex1 = "[1-9]{1}[0-9]{16}[0-9xX]{1}";
		if(!idCard.matches(regex1)){
			System.out.println("格式有误");
		}else{
			//截取出生日期
			String birth = idCard.substring(6,14);
			Date birthDate = new SimpleDateFormat("yyyyMMdd").parse(birth);
			System.out.println("出生日期："+new SimpleDateFormat("yyyy-MM-dd").format(birthDate));
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(birthDate);
			calendar.add(Calendar.YEAR,20);
			calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
			System.out.println("出生日期："+new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
		}
		
	}
	
	/**
	 * 创建一个集合，存放字符串"one","two"，"three"
	 * 然后输出该集合的元素个数。
	 * 然后输出该集合是否包含字符串"four"
	 * 然后输出集合是否不含有任何元素
	 * 然后清空集合
	 * 然后输出该集合的元素个数
	 * 然后输出集合是否不含有任何元素
	 *
	 */
	@Test
	public void test06(){
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println("元素个数："+list.size());
		System.out.println("是否包含字符串\"four\":"+list.contains("fout"));
		System.out.println("集合是否不含有任何元素:"+list.isEmpty());
		list.clear();
		System.out.println("元素个数："+list.size());
		System.out.println("集合是否不含有任何元素:"+list.isEmpty());
	}
	
	/**
	 * 要求用户首先输入员工数量，然后输入相应员工信息，格式为：
	 * name,age,gender,salary,hiredate
	 * 例如:
	 * 张三,25,男,5000,2006-02-15
	 * 每一行为一个员工信息，然后将每个员工信息解析成Emp对象。并存入到一个集合中。
	 * 在解析成Emp对象后要先查看当前集合是否包含该员工，若包含则提示该用于已存在，
	 * 否则才存入集合。
	 * 然后输出集合查看每个员工信息.
	 */
	public static void test07() throws ParseException {
		String empInfo = "张三,25,男,5000,2006-02-15;李四,25,男,5000,2006-02-15";
		String[] empArr = empInfo.split(";");
		List<Emp> empList = new ArrayList<Emp>();
		for(int i=0;i<empArr.length;i++){
			String[] empInfoArr = empArr[i].split(",");
			String name = empInfoArr[0];
			int age = Integer.parseInt(empInfoArr[1]);
			String gender = empInfoArr[2];
			int salary = Integer.parseInt(empInfoArr[3]);
			Date hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(empInfoArr[4]);

			Emp emp = new Emp(i,name,age,gender,salary,hiredate);
			//判断该员工是否已存在
			if(empList.contains(emp)){
				System.out.println("该员工已经存在");
				continue;
			}
			empList.add(emp);
		}

	}

}
