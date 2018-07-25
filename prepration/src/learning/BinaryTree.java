package learning;

public class BinaryTree {
	
    Node root;
	
	class Node{
		int data;
		Node left;
		Node right;
		Node(int c)
		{
			data = c;
			left = null;
			right = null;
		}
		
	}
	
	private Node add_node(Node curr, int c)
	{
		if(curr == null)
			return new Node(c);
		if(curr.data>c)
			curr.left = add_node(curr.left, c);
		else if(curr.data<c)
			curr.right = add_node(curr.right, c);
		else
			return curr;
		return curr;
	}
	
	private boolean find_a_value(Node curr, int c)
	{
		if(curr == null)
			return false;
		if(curr.data == c)
			return true;
		else
			return curr.data>c ? find_a_value(curr.left, c):find_a_value(curr.right, c);
	}
	public boolean conatins_a_node(int i)
	{
		return find_a_value(root, i);
	}
	
	public void add(int c)
	{
		root = add_node(root, c);
	}
	
	public void inorder_traversal(Node root)
	{
       while(root!=null)
       {
    	   inorder_traversal(root.left);
    	   System.out.println(" "+root.data);
    	   inorder_traversal(root.right);
       }
	}
	
	

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(6);
		bt.add(4);
		bt.add(3);
		bt.add(5);
		bt.add(8);
		bt.add(7);
		bt.add(9);
		
		System.out.println("Binary tree is:");
		bt.inorder_traversal(bt.root);
	}

}
