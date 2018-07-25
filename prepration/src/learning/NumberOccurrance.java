package learning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NumberOccurrance {
	
	HashMap mymap = new HashMap();
	LinkedList list = new LinkedList();
	
	
	
	public void numberofoccurrance(List list)
	{
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			if(mymap.containsKey(itr.next()))
				mymap.put(itr.next(), mymap.get(itr.next()));
			else
				mymap.put(itr.next(), 1);
			
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
