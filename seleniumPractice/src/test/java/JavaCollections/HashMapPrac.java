package JavaCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hm  = new HashMap<Integer, String>();
		hm.put(1, "Hello");
		hm.put(2, "GoodBye");
		hm.put(42, "Java");
		System.out.println(hm);
		System.out.println(hm.get(42));
		
		
		Set ss = hm.entrySet();
		Iterator i =  ss.iterator();
		//hashtable - pass table set collections
		while(i.hasNext()) {
//			System.out.println(i.next());
			Map.Entry mp = (Map.Entry)i.next();
			System.out.println(mp);
			System.out.print(mp.getKey() + " : ");
			System.out.println(mp.getValue());
		}
		
		
		
		
		
		
//		ArrayList<HashMap<Integer,String>> arL = new ArrayList<HashMap<Integer,String>>();
//		arL.add(hm);
//		System.out.println(arL);
//		Object[][] ob = new Object[2][1];
//		ob[1][0] = arL;
//		@SuppressWarnings("unchecked")
//		HashMap<Integer,String> h =  (HashMap<Integer, String>) ob[1][0];
//		System.out.println(h);
		
		
		
		
	}

}
