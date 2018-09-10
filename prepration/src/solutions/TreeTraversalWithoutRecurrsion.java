package solutions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class node1{
	int val;
	node1 left;
	node1 right;
	public node1(int c)
	{
		val=c;
		left=null;
		right=null;
	}
}

public class TreeTraversalWithoutRecurrsion {
	
	node1 head;
	
	public TreeTraversalWithoutRecurrsion()
	{
		head=null;
	}
	
	
	public static void inorder_without_recurrsion(node1 root)
	{
		Stack<node1> mystack = new Stack<node1>();
		node1 current = root;
		
		while(current!=null || mystack.size()>0)
		{
			
			while(current!=null)
			{
				mystack.push(current);
				current=current.left;
			}
			current=mystack.pop();
			System.out.print(current.val+" ");
			current=current.right;
		}
		
	}
	
	public static void preorder_without_recurrsion(node1 root)
	{
		Stack<node1> mystack = new Stack<node1>();
		node1 current = root;
		
		while(current!=null || mystack.size()>0)
		{
			
			while(current!=null)
			{
				System.out.print(current.val+" ");
				mystack.push(current);
				current=current.left;
			}
			current=mystack.pop();
			current=current.right;
			
		}
		
	}
	
	public static void breadth_first_search_without_recurrsion(node1 root)
	{
		Queue<node1> temp_queue = new ArrayDeque<node1>();
		temp_queue.add(root);
		while(!temp_queue.isEmpty())
		{
			node1 temp = temp_queue.poll();
			System.out.print(temp.val+" ");
			if(temp.left!=null)
				temp_queue.add(temp.left);
			if(temp.right!=null)
				temp_queue.add(temp.right);
		}
		
	}
	
	public static void postorder_without_recurrsion(node1 root)
	{
		Stack<node1> mystack1 = new Stack<node1>();
		Stack<node1> mystack2 = new Stack<node1>();
		
		mystack1.push(root);
		while(!mystack1.isEmpty())
		{
			node1 temp = mystack1.pop();
			mystack2.push(temp);
			
			if(temp.left!=null)
				mystack1.push(temp.left);
			
			if(temp.right!=null)
				mystack1.push(temp.right);
		}
		
		while(!mystack2.isEmpty())
		{
			node1 current=mystack2.pop();
			System.out.print(current.val+" ");
		}
			
		
	}

	public static void main(String[] args) {
		TreeTraversalWithoutRecurrsion tree = new TreeTraversalWithoutRecurrsion();
		tree.head = new node1(1);
		tree.head.left = new node1(2);
		tree.head.right = new node1(3);
		tree.head.left.left = new node1(4);
        tree.head.left.right = new node1(5);
        tree.head.right.left = new node1(6);
        tree.head.right.right = new node1(7);
        
		
		System.out.print("Inorder: ");
		inorder_without_recurrsion(tree.head);
		System.out.print("\nPreorder: ");
		preorder_without_recurrsion(tree.head);
		System.out.print("\nPostorder: ");
		postorder_without_recurrsion(tree.head);
		System.out.print("\nBFS: ");
		breadth_first_search_without_recurrsion(tree.head);
	}

}
