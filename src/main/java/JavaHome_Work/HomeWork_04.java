package JavaHome_Work;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HomeWork_04 {

	/**
	 * 创建一个集合c1，存放元素"one","two","three"
	 * 再创建一个集合c2，存放元素"four","five","six"
	 * 然后将c2元素全部存入c1集合
	 * 然后在创建集合c3,存放元素"one,five"
	 * 然后输出集合c1是否包含集合c3的所有元素
	 * 然后将c1集合中的"two"删除后再输出c1集合
	 *
	 */
	@Test
	public void test01(){
		List<String> list1 = new ArrayList<String>();
		list1.add("one");
		list1.add("two");
		list1.add("three");

		List<String> list2 = new ArrayList<String>();
		list2.add("four");
		list2.add("five");
		list2.add("six");

		list1.addAll(list2);

		List<String> list3 = new ArrayList<String>();
		list3.add("one");
		list3.add("five");

		System.out.println("集合c1是否包含集合c3的所有元素:"+list1.containsAll(list3));

		list1.remove("two");
		System.out.println(list1);
	}
	
	/**
	 * 创建一个集合，存放元素"1","$","2","$","3","$","4"
	 *   使用迭代器遍历集合，并在过程中删除所有的"$"，
	 *   最后再将删除元素后的集合使用新循环遍历，并输出每一个元素。
	 *
	 */
	@Test
	public void test02(){
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("$");
		list1.add("2");
		list1.add("$");
		list1.add("3");
		list1.add("$");
		list1.add("4");
		System.out.println(list1);

		Iterator<String> iterator = list1.iterator();

		while (iterator.hasNext()){
			String next = iterator.next();
			//找出与“$”匹配的字符
			if ("$".equals(next)){
				//移除
				iterator.remove();
			}
		}
		System.out.println(list1);

		for(String s:list1){
			System.out.println(s);
		}

	}
	
	/**
	 * 创建一个List集合(ArrayList,LinkedList均可)
	 * 存放元素"one","two","three","four"。
	 * 获取集合第二个元素并输出。
	 * 将集合第三个元素设置为"3"
	 * 在集合第二个位置上插入元素"2"
	 * 删除集合第三个元素。
	 * @author OYE
	 *
	 */
	@Test
	public void test03(){
		//ArrayList
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");

		System.out.println("集合第二个元素："+list.get(1));
		list.set(2,"3");
		System.out.println(list);

		list.add(1,"2");
		System.out.println(list);

		System.out.println(list.remove(2));

		//LinkedList
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("one");
		linkedList.add("two");
		linkedList.add("three");
		linkedList.add("four");
		System.out.println(linkedList);

		System.out.println("集合第二个元素："+linkedList.get(1));
		linkedList.set(2,"3");
		System.out.println(linkedList);

		linkedList.add(1,"2");
		System.out.println(linkedList);

		String remove = linkedList.remove(2);
		System.out.println(remove);
	}
	
	/**
	 * 创建一个List集合并添加元素0-9
	 * 然后获取子集[3,4,5,6]
	 * 然后将子集元素扩大10倍
	 * 然后输出原集合。
	 * 之后删除集合中的[7,8,9]
	 * @author OYE
	 *
	 */
	@Test
	public void test04(){
		List<Integer> list  = new ArrayList<Integer>();
		for (int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);

		List<Integer> subList = list.subList(3, 7);
		System.out.println(subList);

		for (int i=0;i<subList.size();i++){
			Integer integer = subList.get(i);
			subList.set(i,integer*10);
		}
		System.out.println(subList);
		System.out.println(list);
		list.removeAll(list.subList(7,10));
		System.out.println(list);


	}
	
	/**
	 * 创建一个List集合，并添加元素0-9
	 * 将集合转换为一个Integer数组并输出数组每一个元素
	 * @author OYE
	 *
	 */
	@Test
	public void test05(){
		List<Integer> list = new ArrayList<Integer>();
		for (int i =0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);

		//集合转数组
		Integer[] integerArr = list.toArray(new Integer[list.size()]);
		for (Integer integer:integerArr){
			System.out.println(integer);
		}


	}
	
	/**
	 * 创建一个字符串数组:{"one","two","three"}
	 * 然后将该数组转换为一个List集合
	 * @author OYE
	 *
	 */
	@Test
	public void test06(){
		String[] stringArr = new String[]{"one","two","three"};

		List<String> stringList = Arrays.asList(stringArr);
		System.out.println(stringList);

	}
	
	/**
	 * 创建一个List集合，并存放10个随机数，然后排序该集合
	 * 后输出
	 * @author OYE
	 *
	 */
	@Test
	public void test07(){
		List<Integer> integerList = new ArrayList<>();
		for (int i=0;i<10;i++){
			integerList.add((int)(Math.random()*100));
		}
		System.out.println(integerList);
		Collections.sort(integerList);
		System.out.println("默认从小到大："+integerList);

		//从写sort方法
		Collections.sort(integerList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		System.out.println("从大到小："+integerList);

		Collections.sort(integerList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(integerList);

	}
	
	/**
	 * 通过控制台输入3个日期(yyyy-MM-dd格式)，然后转换为Date对象后存入
	 * 集合，然后对该集合排序后输出所有日期。
	 * @author OYE
	 *
	 */
	@Test
	public void test08() throws ParseException {
		List<Date> dateList = new ArrayList<>();
		dateList.add(new SimpleDateFormat("yyyy-MM-dd").parse("2017-10-01"));
		dateList.add(new SimpleDateFormat("yyyy-MM-dd").parse("2016-10-10"));
		dateList.add(new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-01"));

		Collections.sort(dateList);
		/*
			sort方法对日期的排序不是按我们生活中的排序来进行排，而是单纯的根据数字的大小来进行从小到大排序
		 */
		System.out.println("从小到大："+dateList);
	}
	
	/**
	 * 要求用户输入若干员工信息，格式为：
	 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
	 * 例如:
	 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
	 * 然后将每个员工信息解析成Emp对象。并存入到一个集合中。
	 * 然后循环集合，输出每一个员工信息(输出使用toString返回的字符串)
	 * 然后输出每个员工的转正仪式日期。
	 * 转正仪式日期为:入职3个月的当周周五
	 * 
	 * @author OYE
	 *
	 */
	public static void test09(){
		
	}


}
