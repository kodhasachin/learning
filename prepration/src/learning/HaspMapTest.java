package learning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HaspMapTest {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(4, 5);
		map.put(5, 2);
		map.put(6, 4);
		
		int[] arr = {1,3,1,3,2,1};
		System.out.println("Result is: "+mostFreqent(arr));
	}
	
	 // Implement your solution below.
	 public static Integer mostFreqent(int[] givenArray) {
	        Integer maxItem = null;
	        int maxCount = 0;
	        HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();
	    
	        for(int i: givenArray)
	        {
	            if(mymap.containsKey(i))
	               mymap.put(i, mymap.get(i)+1);
	            else
	               mymap.put(i,1);
	            if(mymap.get(i)>maxCount)
	            {
	            	maxItem=i;
	            	maxCount=mymap.get(i);
	            }
	        }
	        System.out.println("Map is"+mymap.toString());
	       
	        HashSet<Integer> set = new HashSet<Integer>();
	        
	        
	        return maxItem;
	    }

}
