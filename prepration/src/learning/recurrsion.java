package learning;



public class recurrsion {
	
	public String reverse_str(String str)
	{
		return str.length()==1? str: reverse_str(str.substring(1,str.length()))+str.charAt(0);
		
	}
	
	public int fib(int n)
	{
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else
			return fib(n-2)+fib(n-1);
	}
	
	public int fact(int n)
	{
		if(n==1)
			return n;
		else
			return n*fact(n-1);
	}
	
	public int add_digit(int n)
	{
		if(n/10==0)
			return n;
		else
		{
			n=(n%10)+(n/10);
			return add_digit(n);
		}
	}
	
	public String super_reduced_string(String s) {
        if(s.length()==0)
            return "Empty String";
        char [] arr = s.toCharArray();
        for(int i=0; i<arr.length-1; i++)
        {
            if(arr[i]==arr[i+1])
            {
                String sub_str = s.substring(i,i+2);
                System.out.println(sub_str);
                s=s.replaceFirst(sub_str,"");
                return super_reduced_string(s);
            }
        }
        return s;
    }
	
	static int minimumNumber(int n, String password) {
        int u = 0;
        int d = 0;
        int s = 0;
        if(n<6)
            return 6-n;
        else
        {
             char[] arr = password.toCharArray();
             for(int i=0; i<arr.length; i++)
             {
                 if(Character.isUpperCase(password.charAt(i)))
                	 break;
                 else
                	 u++;
                     
             }
             for(int i=0; i<arr.length; i++)
             {
                 if(Character.isDigit(password.charAt(i)))
                     break;
                 else
                	 d++;
             }
             for(int i=0; i<arr.length; i++)
             {
            	
                 if(password.charAt(i)=='!' ||password.charAt(i)=='@' ||password.charAt(i)=='#' ||password.charAt(i)=='$' ||password.charAt(i)=='%' ||password.charAt(i)=='^' ||
                		 password.charAt(i)=='&' ||password.charAt(i)=='*' ||password.charAt(i)=='(' ||password.charAt(i)==')' ||password.charAt(i)=='-' ||password.charAt(i)=='+')
                     break;
                 else
                	 s++;
                 
             }
             
             if(u>0)
            	 u=1;
             if(d>0)
            	 d=1;
             if(s>0)
            	 s=1;
             
            return u+d+s;
        }
    }

	public static void main(String[] args) {
		
		recurrsion re = new recurrsion();
//		String str = "sachin";
////		System.out.println(str.substring(1,str.length())+str.charAt(0));
//		System.out.println("Reverse String is: "+ re.reverse_str(str));
//		
//		System.out.println("Fibnnaci number is:"+re.fib(2));
//		System.out.println("Factorial is:"+re.fact(5));
//		System.out.println("Digit addition:"+re.add_digit(1542));
		
//		System.out.println("Super Reduced String is: "+re.super_reduced_string("aaabccddd"));
		
//		Character c = 'A';
//		System.out.println("IS Upper: "+c.isUpperCase(c));
		
		System.out.println(re.minimumNumber(11, "#HackerRank"));
		
		
		

	}

}
