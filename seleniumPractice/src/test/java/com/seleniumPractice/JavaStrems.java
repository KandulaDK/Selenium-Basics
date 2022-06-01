package com.seleniumPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.annotations.Test;



public class JavaStrems {
	
//	@Test
	public void regular(){
		ArrayList<String> names = new ArrayList<String>();
		names.add("Akhil");
		names.add("Dinesh");
		names.add("Alekhya");
		names.add("Ram");
		names.add("Lav");
		names.add("Anamika");
		
		int count = 0;
		for(int i=0;i<names.size();i++) {
			String actual = names.get(i);
			if(actual.startsWith("A")){
				count++;
			}
		}
		System.out.println(count);
	}
	
//	@Test
	public void javaFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Akhil");
		names.add("Dinesh");
		names.add("Alekhya");
		names.add("Ram");
		names.add("Lav");
		names.add("Anamika");
		
	// there is no life for intermediate op if there is no terminal op
	// terminal operation will execute only if inter op(filter)returns true
	//we can create stream
	// how to use filter in Stream API
		
		//count the num of names starts with A -- stream() converts ArrayList to stream
		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("c: "+c);
		
		//we can directly create stream by using Stream.of() and we can convert to list
		long d = Stream.of("Akhil","Dinesh","Alekhya","Srikanth","Navya","Akshay").filter(s->
		{
			s.endsWith("a");
			return true;
		}).count();
		System.out.println("d: "+d);
		
		names.stream().filter(s->s.length()>5).forEach(s->System.out.println("s: "+s));
		
	}
	
//	@Test
	public void StreamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("KillBill");
		names.add("Dinnu");
		names.add("Harika");
		names.add("Rama");
		names.add("Lavu");
		names.add("Sinamika");
		
		//print whose length > 4 in UPPERCASE
//		Stream.of("Akhil","Dinesh","Alekhya","Srikanth","Navya","Akshay").filter(s->s.endsWith("h")).map(s->s.toUpperCase())
//		.forEach(s->System.out.println(s));
		
		//print names which start with "A" with uppercase and sorted
		List<String> names1 = Arrays.asList("Azhil","Dinesh","Alekhya","Srikanth","Navya","Akshay");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase());
	
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.limit(2).forEach(s->System.out.println(s));
//		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("lvu"));
//		Assert.assertTrue(flag);
	}
	@Test
	public void StreamCollect() {
		
		List<String> ls = Stream.of("Akhil","Dinesh","Alekhya","Srikanth","Navya","Akshay").filter(s->s.startsWith("A")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls);
		
		//print uniqe numbers from the list and print as list
		List<Integer> numList = Arrays.asList(1,9,2,2,3,4,5,7,3,6,3,8,3,7,8,8,9); 
		List<Integer> sortedUniqNum = numList.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedUniqNum);
	}
	

}
