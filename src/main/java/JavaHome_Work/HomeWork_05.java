package JavaHome_Work;

import org.junit.Test;

import java.util.*;



public class HomeWork_05 {

	/**
	 * 创建一个队列，存入Integer类型元素1,2,3,4,5
	 * 然后遍历队列并输出每个元素
	 * @author OYE
	 *
	 */
	@Test
	public void test01(){
		/*
		队列：先进先出
		 */
		Queue<Integer> integerQueue = new ArrayDeque<>();
		integerQueue.add(1);
		integerQueue.add(2);
		integerQueue.add(3);
		integerQueue.add(4);
		integerQueue.add(5);
		for(Integer i :integerQueue){
			System.out.println(i);
		}
		System.out.println();

		Queue<Integer> integerQueue2 = new ArrayDeque<>();
		integerQueue2.offer(1);
		integerQueue2.offer(2);
		integerQueue2.offer(3);
		integerQueue2.offer(4);
		integerQueue2.offer(5);
		for (Integer integer:integerQueue2){
			System.out.println(integer);
		}
		System.out.println("peek:"+integerQueue2.peek());
		System.out.println("poll:"+integerQueue2.poll());

	}
	
	/**
	 * 创建一个栈，存入Integer类型元素1,2,3,4,5
	 * 然后遍历队列并输出每个元素
	 * @author OYE
	 *
	 */
	@Test
	public void test02(){
		/*
		栈：先进后出
		 */
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		for (Integer integer:stack){
			System.out.println(integer);
		}
		System.out.println("----------------------");
		while (stack.size()>0){
			Integer pop = stack.pop();
			System.out.println(pop);
		}
		System.out.println(stack);
		System.out.println("----------------------");
		while (stack.size()>0){
			Integer peek = stack.peek();
			System.out.println(peek);
		}

	}
	
	/**
	 * 要求用户输入若干员工信息，格式为：
	 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
	 * 例如:
	 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
	 * 然后将每个员工信息解析成Emp对象。并存入到一个List集合中。
	 * 并对集合排序，然后输出每个员工信息。
	 * 
	 * 再根据员工的入职时间排序，入职晚的在前，早的在后并
	 * 输出每个员工的信息。
	 * @author OYE
	 *
	 */
	public static void test03(){
		
	}
	
	/**
	 *创建一个Map，保存某个学生的成绩:
	 *在控制台输入该学生成绩，格式:
	 *科目:成绩;科目:成绩;...
	 *例如:  
	 *语文:99;数学:98;英语:97;物理:96;化学:95
	 *然后输出物理的成绩。
	 *然后将化学的成绩设置为96
	 *然后删除英语这一项。
	 *然后遍历该Map分别按照遍历key，Entry，value
	 *的形式输出该Map信息。
	 * @author OYE
	 *
	 */
	public static void test04(){
		
	}
	
	/**
	 * 有下列字符串:
	 * 销售:张三;财务:李四;销售:王五;财务:赵六;程序:mike;程序:jerry;美工:jackson;前端:green;前端:nick;程序:钱七;销售:alice
	 * 分析上述字符串然后统计每个职位总共多少人?
	 * 使用Map保存统计的结果，其中key:职位,value为该职位人数
	 * 然后分别输出各职位的名称(keySet),各职位人数(entrySet)
	 * @author OYE
	 *
	 */
	@Test
	public void test05(){
		String string = "销售:张三;财务:李四;销售:王五;财务:赵六;程序:mike;程序:jerry;美工:jackson;前端:green;前端:nick;程序:钱七;销售:alice;销售:bingbang";
		String[] splitArr = string.split(";");

		Map<String,Integer> map = new HashMap<>();

		for (int i=0;i<splitArr.length;i++){
			String[] person = splitArr[i].split(":");

			//判断map集合中是否存在相同的key，有则累加，无则添加
			if(map.containsKey(person[0])){
				//存在
				map.put(person[0],map.get(person[0])+1);
			}else{
				//不存在
				map.put(person[0],1);
			}
		}

		//遍历1
		for(Map.Entry<String,Integer> entry:map.entrySet()){
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key+"="+value);
		}


	}



}
