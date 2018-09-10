package solutions;

import java.util.Arrays;

public class ReconstructionOfTree {
	
	public static char reconstruct_tree(char[] preorder, char[] inorder)
	{
		if(preorder.length==1 && inorder.length==1)
			return preorder[0];
		char root = preorder[0];
		int root_index=0;
		for(root_index=0; root_index<inorder.length; root_index++)
		{
			if(inorder[root_index]==root)
				break;
		}
		//System.out.println("root_index: "+root_index);
		char[] left_preorder = new char[root_index];
		for(int i=0; i<left_preorder.length; i++)
		{
			left_preorder[i]=preorder[1+i];
		}
		//System.out.println("left_preorder: "+Arrays.toString(left_preorder));
		
		char[] right_preorder = new char[preorder.length-root_index-1];
		for(int i=0; i<right_preorder.length; i++)
		{
			right_preorder[i]=preorder[1+i+root_index];
		}
		//System.out.println("right_preorder: "+Arrays.toString(right_preorder));
		
		char[] left_inorder = new char[root_index];
		for(int i=0; i<left_inorder.length; i++)
		{
			left_inorder[i]=inorder[i];
		}
		//System.out.println("left_inorder: "+Arrays.toString(left_inorder));
		
		char[] right_inorder = new char[inorder.length-root_index-1];
		for(int i=0; i<right_inorder.length; i++)
		{
			right_inorder[i]=inorder[1+i+root_index];
		}
		//System.out.println("right_inorder: "+Arrays.toString(right_inorder));
		char root_left = reconstruct_tree(left_preorder, left_inorder);
		char root_right = reconstruct_tree(right_preorder, right_inorder);
		
		System.out.print(" \nleft_root: "+root_left);
		System.out.print(" \nright_root: "+root_right);
		
		return root;
		
	}

	public static void main(String[] args) {
		
		char[] preorder = {'a', 'b', 'd', 'e', 'c', 'f', 'g'};
		char[] inorder = {'d', 'b', 'e', 'a', 'f', 'c', 'g'};
		
		System.out.println("Preorder array is: "+Arrays.toString(preorder));
		System.out.println("Inorder array is: "+Arrays.toString(inorder));
		
		System.out.println("\nReconstructed Tree is: "+reconstruct_tree(preorder, inorder));

	}

}
