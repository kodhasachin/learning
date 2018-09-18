package solutions;

import java.util.ArrayList;
import java.util.Iterator;

class MyIterator{
	int freq;
	int num;
	Iterator<Integer> itr;
	public MyIterator(Iterator<Integer> itr)
	{
		this.itr = itr;
		freq=0;
		num=0;
	}
	
	public boolean has_next()
	{
		if(freq>0)
			return true;
		else
		{
			if(itr.hasNext())
				return true;
			else
				return false;
		}
	}
	
	public int next_num()
	{
		if(freq>0)
		{
			freq--;
		}
		else
		{
			freq=itr.next();
			num=itr.next();
			freq--;
		}
		return num;
	}
}
public class IteratorWrapper {
	
	public static void main(String[] args) {
		ArrayList<Integer> inputlist = new ArrayList<Integer>();
		inputlist.add(3);
		inputlist.add(3);
		inputlist.add(2);
		inputlist.add(2);
		inputlist.add(1);
		inputlist.add(5);
		inputlist.add(4);
		inputlist.add(6);
		
		System.out.println("Input ArrayList is: "+inputlist.toString());
		Iterator<Integer> old_itr = inputlist.iterator();
		MyIterator itr = new MyIterator(old_itr);
		
		for(;itr.has_next();)
		{
			System.out.print(itr.next_num()+" ");
		}

	}

}
