package learning;

import java.util.Arrays;

public class CoinChange {
	
	public static int coin_change(int []deno, int val)
	{
		int[][] res = new int[val+1][val+1];
		
			res[0][0]=1;
		for(int i=1; i<deno.length; i++)
		{
			for(int j=0; j<=val; j++)
			{
				
				
					if(deno[i]>j)
					{
						res[deno[i]][j]=res[deno[i]-1][j];
					}
					else
					{
						
							res[deno[i]][j]=res[deno[i]-1][j]+res[deno[i]][j-i];
						
						
					}
				
			}
		}
		int out=0;
		System.out.println(Arrays.deepToString(res));
		for(int d:deno)
		{
			System.out.println("For denomination-"+d+": "+"Ways: "+res[d][val]);
			out = out+res[d][val];
		}
		return out;
		
	}
	
	public static void coin_change_alt(int[] deno, int val)
	{
		int[] res = new int[val+1];
		res[0]=1;
//		for(int i=0; i<=val; i++)
//			res[i]=1;
		
		for(int d:deno)
		{
			for(int i=0; i<=val; i++)
			{
				if(d>=i)
				{
					res[d]=res[d]+res[d-i];
					
				}
			}
			System.out.println(d+": "+res[d]);
		}
		
		
	}

	public static void main(String[] args) {
		int [] coin_denomination = {1,2,5};
		int value = 12;
		System.out.println("Coin possible ways: "+coin_change(coin_denomination, value));
        
        System.out.println("Coin possible ways: ");
        coin_change_alt(coin_denomination, value);
	}

}
