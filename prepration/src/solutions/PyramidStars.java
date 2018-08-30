package solutions;

public class PyramidStars {
	
	public static void print_stars_pyramid_structure(int n)
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n-i-1; j++)
				System.out.print(" ");
			for(int j=0; j<=i; j++)
				System.out.print("* ");
			System.out.println("");
			
		}
	}
	
	public static void printTriagle(int n)
    {
        // number of spaces
        int k = 2*n - 2;
  
        // outer loop to handle number of rows
        //  n in this case
        for (int i=0; i<n; i++)
        {
 
            // inner loop to handle number spaces
            // values changing acc. to requirement
            for (int j=0; j<k; j++)
            {
                // printing spaces
                System.out.print(" ");
            }
  
            // decrementing k after each loop
            k = k - 1;
  
            //  inner loop to handle number of columns
            //  values changing acc. to outer loop
            for (int j=0; j<=i; j++ )
            {
                // printing stars
                System.out.print("* ");
            }
  
            // ending line after each row
            System.out.println();
        }
    }
     

	public static void main(String[] args) {
		int lines = 5;
		print_stars_pyramid_structure(lines);
		//printTriagle(lines);

	}

}
