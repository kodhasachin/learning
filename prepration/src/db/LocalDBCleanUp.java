package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public class LocalDBCleanUp {



public static Set<String> fetching_gatewaydsn_zibinding()
{
	Set<String> result = new HashSet<String>();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/zig_db","root","sK021dh@");  
		
		Statement stmt=con.createStatement();  
	    ResultSet rs=stmt.executeQuery("select distinct gateway_dsn from z_bindings"); 
	    while(rs.next())
	    	result.add(rs.getString(1));
	    con.close();
		
	}
	catch(Exception e){ System.out.println(e);}  
	 
	return result;
}

public static Set<String> fetching_dsn_device()
{
	Set<String> result = new HashSet<String>();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sampledatabase","root","sK021dh@");  
		
		Statement stmt=con.createStatement();  
	    ResultSet rs=stmt.executeQuery("select distinct gateway_dsn from device"); 
	    while(rs.next())
	    	result.add(rs.getString(1));
	    con.close();
	}
	catch(Exception e){ System.out.println(e);}  
	 
	return result;
}

public static Set<String> fetching_distinct_values(String dbname, String table)
{
	Set<String> result = new HashSet<String>();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/"+dbname,"root","sK021dh@");  
		Statement stmt=con.createStatement();  
	    ResultSet rs=stmt.executeQuery("select distinct gateway_dsn from "+table); 
	    while(rs.next())
	    	result.add(rs.getString(1));
	    con.close();
	}
	catch(Exception e){ System.out.println(e);}  
	 
	return result;
}

public static Set<String> finding_missing_dsns(Set<String> gateway_dsn, Set<String> dsn)
{
	Set<String> output = new HashSet<String>();
	for(String str:gateway_dsn)
	{
		if(dsn.contains(str))
			continue;
		else
			output.add(str);
			
	}
	return output;
}

	public static void deleting_records_from_groups_table(Set<String> missingdsns)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/zig_db","root","sK021dh@");  
			  
			for(String dsn:missingdsns)
			{
				Statement stmt=con.createStatement();
				boolean rs=stmt.execute("delete from groups where gateway_dsn="+"'"+dsn+"'"); 
			}
		   con.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}
	
	public static void deleting_records_from_scenes_table(Set<String> missingdsns)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/zig_db","root","sK021dh@");  
			Statement stmt=con.createStatement();  
			for(String dsn:missingdsns)
			{
				boolean rs=stmt.execute("delete from scenes where gateway_dsn="+"'"+dsn+"'"); 
			}
		   con.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}

	public static void main(String[] args) {
		
		Set<String> output=finding_missing_dsns(fetching_gatewaydsn_zibinding(), fetching_dsn_device());
		
		if(output.size()==0)
		{
			System.out.println("All the gateway_dsn from zbindings table of zig db exist into devices table of ads db.");
		}
		else
		{
			for(String str:output)
				System.out.println("Missing dsn: "+str);
		}
		
		System.out.println("--------------------------------------------------");
		Set<String> beforetemp=fetching_distinct_values("zig_db","groups");
		for(String str:beforetemp)
			System.out.println("groups table values BEFORE: "+str);
		System.out.println("--------------------------------------------------");
		
		deleting_records_from_groups_table(output);
		
		System.out.println("--------------------------------------------------");
		Set<String> aftertemp=fetching_distinct_values("zig_db","groups");
		for(String str:aftertemp)
			System.out.println("groups table values AFTER: "+str);
		
		System.out.println("--------------------------------------------------");
		System.out.println("--------------------------------------------------");
		
		Set<String> beforetemp1=fetching_distinct_values("zig_db","scenes");
		for(String str:beforetemp1)
			System.out.println("scenes table values BEFORE: "+str);
		System.out.println("--------------------------------------------------");
		
		deleting_records_from_scenes_table(output);
		
		System.out.println("--------------------------------------------------");
		Set<String> aftertemp1=fetching_distinct_values("zig_db","scenes");
		for(String str:aftertemp1)
			System.out.println("scences table values AFTER: "+str);
		System.out.println("--------------------------------------------------");

	}

}
