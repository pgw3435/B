package Project;

import java.util.*;


class Person
{
	private int age;
	private String name, atr;
	
	public Person(int a, String n, String at)
	{
		age = a;
		name = n;
		atr = at;
	}
	
	public String print()
	{
		return ('\t' + age + '\t' + name + '\t' + atr);
	}
}


class GUI
{
	static Scanner scn = new Scanner(System.in);
	public GUI()
	{
		HashMap<Integer, Person> h = new HashMap<Integer, Person>();
		run(h);
	}
	
	private void run(HashMap<Integer, Person> h)
	{
		System.out.println("놀이공원 예약관리 프로그램");
		
		while(true)
		{
			System.out.println(" 1. 예약, 2. 예약취소, 3. 대기인원 안내, 4. 추첨, 5. 종료");
			int i = scn.nextInt();
			
			switch(i)
			{
			case 1:
				Management.reservation(h);
				break;
			case 2:
				Management.cancel(h);
				break;
			case 3:
				Management.count(h);
				break;
			case 4:
				Management.event(h);
				break;
			case 5:
				h.clear();
				return;
			}
			System.out.println('\n' + "예약번호" + '\t' + "나이" + '\t' + "이름" + '\t' + "놀이기구" );
			/*
			Set<Integer> keys = h.keySet();
			Iterator<Integer> it = keys.iterator();
			while(it.hasNext())
			{
				Integer key = it.next();
				Person p = h.get(key);
				System.out.println(key.toString() + p.print());
			}
			System.out.println();
			*/
			int n = 1;
			while(n < Management.i)
			{
				if(h.containsKey(n))
					System.out.println(n + h.get(n).print());
				++n;
			}
			System.out.println();
		}
	}
}


class Management
{
	static Scanner scn = new Scanner(System.in);
	static int i = 1; // 예약번호
	
	public static void reservation(HashMap<Integer, Person> h)
	{
		
		System.out.println("나이 입력 >> ");		
		int age = scn.nextInt();		
		System.out.println("이름 입력 >> ");
		String name = scn.next();
		System.out.println("놀이기구 입력 >> ");
		String atr = scn.next();
		
		h.put(i++, new Person(age, name, atr));
	}
	
	public static void cancel(HashMap<Integer, Person> h)
	{
		System.out.println("취소할 예약번호 입력 >> ");
		int i = scn.nextInt();
		
		if(h.containsKey(i))
			h.remove(i);
		else
			System.out.println("없는 예약번호입니다.");
	}
	
	public static void count(HashMap<Integer, Person> h)
	{
		System.out.print("대기인원을 확인할 예약번호 입력 >> ");
		int j = scn.nextInt();
		
		if(!h.containsKey(j))
		{
			System.out.println("예약번호 오류");
			return;
		}
		int n = 1, count = 0;
		while(n < i)
		{
			if(h.containsKey(n))
			{
				if(h.get(j).equals(h.get(n)))
					++count;
			}
			++n;
		}
		System.out.println(count + "명의 인원이 대기중입니다.");
	}
	
	public static void event(HashMap<Integer, Person> h)
	{
		
	}
}

public class M 
{
	public static void main(String[] args) 
	{
		GUI g = new GUI();
	}	
}
