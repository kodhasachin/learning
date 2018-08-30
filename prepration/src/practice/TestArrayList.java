package practice;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<String> mylist = new ArrayList<String>();
		mylist.add("sachin");
		mylist.add("kodha");
		
		System.out.println("Mylist is: "+mylist.toString());
		System.out.println("first: "+mylist.get(1));
		
//		String str = "city,zip,2012,2013,2014";
//		String[] tmp = str.split(",");
//		System.out.println("tmp[2]: "+tmp[2]);
//		System.out.println("tmp[3]: "+tmp[3]);
//		System.out.println("tmp[4]: "+tmp[4]);
		
	   String str1 = "sachin.kodha";
	   System.out.println("Flag:"+str1.contains("."));
	   System.out.println("List element: "+mylist.get(1));

	}

}
