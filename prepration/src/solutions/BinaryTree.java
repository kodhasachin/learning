package solutions;

class Node{
	int key;
	Node left;
	Node right;
	
	public Node(int item)
	{
		key=item;
		left=right=null;
	}
}
public class BinaryTree {
	
	Node root;
	public BinaryTree()
	{
		root = null;
	}
	
	public static void printInorder(Node root)
	{
		if(root == null)
			return;
		
		printInorder(root.left);
		System.out.print(root.key+" ");
		printInorder(root.right);
	}
	
	public static void printPostorder(Node root)
	{
		if(root==null)
			return;
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.key+" ");
	}
	
	public static void printPreorder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.key+" ");
		printPreorder(root.left);
		printPreorder(root.right);
		
	}
	
	public static void printLevelOrder(Node root)
	{
		int tree_height = height_of_tree(root);
		for(int i=1; i<=tree_height; i++)
		{
			printGivenLevelTree(root, i);
		}
	}
	public static void printGivenLevelTree(Node root, int level)
	{
		if(root == null)
			return;
		if(level==1)
			System.out.print(root.key+" ");
		else
		{
			printGivenLevelTree(root.left, level-1);
			printGivenLevelTree(root.right, level-1);
		}
	}
	public static int height_of_tree(Node root)
	{
		if(root==null)
			return 0;
		else
		{
			int left_tree_height = height_of_tree(root.left);
			int right_tree_height = height_of_tree(root.right);
			if(left_tree_height>right_tree_height)
				return left_tree_height+1;
			else
				return right_tree_height+1;
		}
	}

	public static void main(String[] args) {
		BinaryTree mytree = new BinaryTree();
		mytree.root = new Node(1);
		mytree.root.left=new Node(2);
		mytree.root.left.left=new Node(4);
		mytree.root.left.right=new Node(5);
		mytree.root.right=new Node(3);
		
		System.out.print("Inorder Traversal: ");
		printInorder(mytree.root);
		System.out.print("\n");
		
		System.out.print("Preorder Traversal: ");
		printPreorder(mytree.root);
		System.out.print("\n");
		
		System.out.print("Postorder Traversal: ");
		printPostorder(mytree.root);
		System.out.print("\n");
		
		System.out.print("Level Order Traversal: ");
		printLevelOrder(mytree.root);
		System.out.print("\n");

	}

}
