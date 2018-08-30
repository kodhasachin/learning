package solutions;

import java.util.Stack;

public class JsonValidator {
	
	public static boolean is_valid_json(String json)
	{
		if(json.charAt(0)!='{' ||json.charAt(json.length()-1)!='}')
			return false;
		else
		{
			String input = json.substring(1, json.length()-1).trim();
			if(input.contains(","))
			{
				String[] input_array = json.split(",");
				for(String str: input_array)
				{
					if(str.contains(":"))
					{
						String[] input_subarray = str.split(":");
						if(input_subarray.length>2)
							return false;
						else
						{
							char tmp1 = input_subarray[0].charAt(0);
							char tmp2 = input_subarray[0].charAt(input_subarray.length-1);
							if(tmp1 != '\'' || tmp1!='\"')
								return false;
							else if(tmp2 != '\'' || tmp2!='\"')
								return false;
							else
							{
								
							}
								
							
						}
						for(String sub_str:input_subarray)
						{
							if(sub_str.charAt(0)!='\'' || sub_str.charAt(sub_str.length()-1)!='\"')
								return false;
							else{
								
							}
						}
					}
					else
						return false;
				}
			}
			System.out.println("Resultant String is:"+input);
		}
		return true;
	}

	public static void main(String[] args) {
		String input_json = "{'id':'file' }";
		System.out.println("Input JSON: "+input_json);
		System.out.println("Is input JSON valid: "+is_valid_json(input_json));
	}

}
