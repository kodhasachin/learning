package learning;

import java.util.Arrays;

public class StringRotation {
	
	public static boolean is_string_rotated(String s1, String s2)
	{
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);
		System.out.println("First String is: "+String.valueOf(a1));
		System.out.println("Second String is: "+String.valueOf(a2));
		if(String.valueOf(a1).equals(String.valueOf(a2)))
				return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println("Is Strings rotated: "+is_string_rotated("waterbottle", "erbottlewat"));

	}

}
