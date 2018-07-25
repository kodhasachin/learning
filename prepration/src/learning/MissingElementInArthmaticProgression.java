package learning;

public class MissingElementInArthmaticProgression {
	
	public static int missing_element(int [] arr)
	{
		int diff = (arr[arr.length-1]-arr[0])/arr.length;
		int res=0;
		for(int i=0; i<arr.length-1; i++)
		{
			if(arr[i]+diff!=arr[i+1])
			{
				res= arr[i]+diff;
				break;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		int[] arr = {2, 4, 8, 10, 12, 14};
		System.out.println("Missing element is: "+missing_element(arr));
	}

}
