package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class ntreenode{
	int data;
	ArrayList<ntreenode> nodes;
	
	public ntreenode(int val)
	{
		data=val;
		nodes = new ArrayList<ntreenode>();
		
	}
}

public class TreeWithNChilds {
	
	public static void print_tree(ntreenode root)
	{
		if(root==null)
			return;
		else
		{
			System.out.print(root.data+" ");
			if(root.nodes!=null)
			{
				for(int i=0; i<root.nodes.size(); i++)
					print_tree(root.nodes.get(i));
			}
		}
	}
	
	public static void level_order_sum(ntreenode root)
	{
		Queue<ntreenode> queue = new ArrayDeque<ntreenode>();
		//int sum = 0;
		queue.add(root);
		while(!queue.isEmpty())
		{
			int sum = 0;
			ntreenode curr = queue.poll();
			System.out.print(curr.data+" ");
			for(int i=0; i<curr.nodes.size(); i++)	
			{
				queue.add(curr.nodes.get(i));
				sum = sum+curr.nodes.get(i).data;
			}
			System.out.print("\nLevel order sum is: "+sum);
			
		}
	}

	public static void main(String[] args) {
		
		ntreenode root = new ntreenode(1);
		for(int i=0; i<5; i++)
		{
			root.nodes.add(new ntreenode(i+2));
		}
		root.nodes.get(1).nodes.add(new ntreenode(7));
		root.nodes.get(4).nodes.add(new ntreenode(8));
		
		System.out.print("Input tree is: ");
        print_tree(root);
        
        System.out.print("\nLevel order values are: ");
        level_order_sum(root);
	}

}
