package JavaCollections;

import java.util.ArrayList;

public class arrList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList as = new ArrayList();
		ArrayList<String> as = new ArrayList<String>();

//		ArrayList <Integer> ai = new ArrayList<Integer>();
	
		as.add("Dinesh");
		as.add("java");
		System.out.println(as);
		as.add(1,"selenium");
		System.out.println(as);
//		as.remove(1);
//		as.remove("java");
//		System.out.println(as);
		System.out.println(as.get(0));
		System.out.println(as.contains("javaa"));
		System.out.println(as.indexOf("java"));
		
	}

}
