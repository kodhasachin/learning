package practice;

import java.util.Arrays;

public class LexicographicOrder {

	public static void main(String[] args) {
		String[] input = {"ABCDEF", "AA", "BEF", "A", "AABB"};
		Arrays.sort(input);
		System.out.println("Lexicographic Order is: "+Arrays.toString(input));

	}

}
