package solutions;

class treenode{
	char val;
	treenode left, right;
	
	public treenode(char c)
	{
		val=c;
		left=null;
		right=null;
	}
}

public class TreeComparison {
	
	treenode root1, root2;
	
	public boolean is_tree_identical(treenode root1, treenode root2)
	{
		if(root1==null && root2==null)
			return true;
		else
		{
			if(root1.val==root2.val)
			{
				is_tree_identical(root1.left, root2.left);
			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
