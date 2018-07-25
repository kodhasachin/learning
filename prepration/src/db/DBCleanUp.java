package db;

import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.*;


import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBCleanUp {
	

	private static Connection connection = null;
    private static Session session = null;
    private static String sshHost = "gateway-stage.ayladev.com";
    private static String sshUser = "ayla";
    private static String SshKeyFilepath = "/Users/skodha/.ssh/id_rsa";
    private static String SshKeyFilePassword = "sk021dh@";
    
//    private static String adsdbName = "sampledatabase";
//    private static String adsdbuserName = "root";
//    
//    private static String zigdbName = "zig_db";
//    private static String zigdbuserName = "root";
//    private static String dbpassword = "sk012dha";
    
    private static String adsdbName = "ads_stage";
    private static String adsdbuserName = "ads";
    
    private static String zigdbName = "zig_stage";
    private static String zigdbuserName = "zig";
    private static String dbpassword = "xr33stg0";
    private static String remoteHost = "staging-database.cp4py5rykrmm.us-east-1.rds.amazonaws.com";
    //private static String remoteHost = "localhost";
    private static int remotePort = 3306;
    
    private static void connectSSH() throws SQLException, IOException {
        
        int localPort = 0; // any free port can be used
        
    
        String driverName = "com.mysql.jdbc.Driver";

        try {
            java.util.Properties config = new java.util.Properties();
            JSch jsch = new JSch();
            session = jsch.getSession(sshUser, sshHost, 22);
            jsch.addIdentity(SshKeyFilepath,SshKeyFilePassword);
            config.put("StrictHostKeyChecking", "no");
            config.put("ConnectionAttempts", "1");
            session.setConfig(config);
            session.connect();

            System.out.println("SSH Connected");

            Class.forName(driverName).newInstance();
            System.out.println("localport is:"+localPort);
            int assinged_port = session.setPortForwardingL(localPort, remoteHost, remotePort);

            System.out.println("localhost:" + assinged_port + " -> " + remoteHost + ":" + remotePort);
            System.out.println("Port Forwarded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	private static void connectToDataBase(String dataBaseName, String dbUserName) throws SQLException {
        
        int localPort = 3036; // any free port can be used
        String localSSHUrl = "localhost";
        try {

            //mysql database connectivity
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName(localSSHUrl);
            System.out.println("localport is:"+localPort);
            dataSource.setPortNumber(localPort);
            dataSource.setUser(dbUserName);
            dataSource.setAllowMultiQueries(true);

            dataSource.setPassword(dbpassword);
            dataSource.setDatabaseName(dataBaseName);

            connection = dataSource.getConnection();

            System.out.print("Connection to server successful!:" + connection.toString() + "\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	 public static void displaying_table_values(String dbname, String dbuser, String table)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH();
			    connectToDataBase(dbname,dbuser);
				Statement stmt=connection.createStatement();  
			    ResultSet rs=stmt.executeQuery("select name from "+table); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
				int i=0;
				for(String str:result)
				{
					i++;
					System.out.println(i+" value :"+str);
			}
			    
			}
			catch(Exception e){ System.out.println(e);}  
			 

		}
	 
	 public static Set<String> fetching_gatewaydsn_zibinding(String dbname, String dbuser)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH();
			    connectToDataBase(dbname, dbuser);
				Statement stmt=connection.createStatement();  
			    ResultSet rs=stmt.executeQuery("select distinct gateway_dsn from z_bindings"); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
				
			    System.out.println("Distinct gateway_dsn from z_bindings table are as:");
			    for(String str:result)
					System.out.println("Missing dsn: "+str);
			}
			catch(Exception e){ System.out.println(e);}  
			 
			return result;
		} 
	 
	 public static Set<String> fetching_dsn_device(String dbname, String dbuser)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH();
			    connectToDataBase(dbname, dbuser);
				Statement stmt=connection.createStatement();
			    ResultSet rs=stmt.executeQuery("select distinct dsn from devices"); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
			    System.out.println("Distinct dsn from devices table are as:");
			    for(String str:result)
					System.out.println("Missing dsn: "+str);
			}
			catch(Exception e){ System.out.println(e);}  
			 
			return result;
		}
	 
	 public static Set<String> fetching_distinct_values(String dbname, String dbusername, String table)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH();
			    connectToDataBase(dbname, dbusername);
				Statement stmt=connection.createStatement();  
			    ResultSet rs=stmt.executeQuery("select distinct gateway_dsn from "+table); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
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
		
		public static void deleting_records_from_table(Set<String> missingdsns, String dbname, String dbuser, String tableName)
		{
			try{
				connectSSH();
			    connectToDataBase(dbname, dbuser);
				  
				for(String dsn:missingdsns)
				{
					Statement stmt=connection.createStatement(); 
					boolean rs=stmt.execute("delete from "+tableName+" where gateway_dsn="+"'"+dsn+"'"); 
				}
				connection.close();
			    session.disconnect();
			}
			catch(Exception e){ System.out.println(e);} 
		}
		
		/*	public static void deleting_records_from_scenes_table(Set<String> missingdsns, String dbname, String dbuser )
		{
			try{
				connectSSH();
			    connectToDataBase(dbname, dbuser);
			    
				for(String dsn:missingdsns)
				{
					Statement stmt=connection.createStatement(); 
					boolean rs=stmt.execute("delete from scenes where gateway_dsn="+"'"+dsn+"'"); 
				}
				connection.close();
			    session.disconnect();
			}
			catch(Exception e){ System.out.println(e);} 
		}

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
		}*/
	
	
	
	public static void main(String[] args) throws IOException 
	{
		Set<String> output=finding_missing_dsns(fetching_gatewaydsn_zibinding(zigdbName, zigdbuserName), fetching_dsn_device(adsdbName, adsdbuserName));
		
		if(output.size()==0)
		{
			System.out.println("All the gateway_dsn from zbindings table of zig db exist into devices table of ads db.");
		}
		else
		{
			for(String str:output)
				System.out.println("Missing dsn: "+str);
		}
		
		
		/*System.out.println("--------------------------------------------------");
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
		Set<String> beforetemp1=fetching_distinct_values("zig_db","scenes");
		for(String str:beforetemp1)
			System.out.println("scenes table values BEFORE: "+str);
		System.out.println("--------------------------------------------------");
		
		deleting_records_from_scenes_table(output);
		
		System.out.println("--------------------------------------------------");
		Set<String> aftertemp1=fetching_distinct_values("zig_db","scenes");
		for(String str:aftertemp1)
			System.out.println("scences table values AFTER: "+str);
		System.out.println("--------------------------------------------------");*/
		
		//displaying_table_values("staging-database.cp4py5rykrmm.us-east-1.rds.amazonaws.com", "zig", "xr33stg0", "zig_stage", "z_bindings");
		//displaying_table_values("devices");
		//ServerSocket serverSocket = new ServerSocket(0);
	    //System.out.println("listening on port " + serverSocket.getLocalPort());
	
	}
}
