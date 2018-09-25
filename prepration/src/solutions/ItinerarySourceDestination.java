package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ItinerarySourceDestination {
	
	public static String itinerary_stops(ArrayList<String[]> tkt_list)
	{
		String stops = "";
		String source="";
		HashMap<String, String> map = new HashMap<String, String>();
		for(String[] arr: tkt_list)
		{
			map.put(arr[0], arr[1]);
		}
		for(String tmp:map.keySet())
		{
			if(!map.values().contains(tmp))
				source=tmp;
		}
		while(source!=null)
		{
			stops=stops+"->"+source;
			source = map.get(source);
		}
		
		return stops;
	}

	public static void main(String[] args) {
		ArrayList<String[]> ticketlist = new ArrayList<String[]>();
		String[] tkt1 = {"s","s2"};
		String[] tkt2 = {"s2","s3"};
		String[] tkt3 = {"s3","s4"};
		String[] tkt4 = {"s4","s5"};
		String[] tkt5 = {"s5","d"};
		
		ticketlist.add(tkt4);
		ticketlist.add(tkt3);
		ticketlist.add(tkt5);
		ticketlist.add(tkt1);
		ticketlist.add(tkt2);
		
		System.out.print("\nItinerary Tickets list is: ");
		for(String[] str_arr:ticketlist)
			System.out.print(Arrays.toString(str_arr)+" ");
		
		System.out.println("Itinerary stops in order is as: "+itinerary_stops(ticketlist));
		
		

	}

}
