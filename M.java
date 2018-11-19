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
		}
	}
}


class Management
{
	static Scanner scn = new Scanner(System.in);
	static int i = 1; // 예약번호
	
	public static void reservation(HashMap<Integer, Person> h)
	{
		
		System.out.println("나이 이름 놀이기구 입력 >> ");
		
		int age = 0;
		String name = null, atr = null;
		
		age = scn.nextInt();		
		name = scn.next();
		atr = scn.next();
		
		h.put(i++, new Person(age, name, atr));
		
		scn.close();
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
