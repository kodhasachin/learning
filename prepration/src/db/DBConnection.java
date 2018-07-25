package db;

import java.io.IOException;
import java.sql.*;
import java.util.*;


import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBConnection {
	

	private static Connection connection = null;
    private static Session session = null;
    private static String sshHost = "gateway-stage.ayladev.com";
    private static String sshUser = "ayla";
    private static String SshKeyFilepath = "/Users/skodha/.ssh/id_rsa";
    private static String SshKeyFilePassword = "sk021dh@";
    
    private static String adsdbremoteHost = "staging-database.cp4py5rykrmm.us-east-1.rds.amazonaws.com";
    private static String adsdbName = "ads_stage";
    private static String adsdbuserName = "ads";
    private static String adsdbpassword = "xr33stg0";
    
    private static String zigdbremoteHost = "staging-database.cp4py5rykrmm.us-east-1.rds.amazonaws.com";		
    private static String zigdbName = "zig_stage";
    private static String zigdbuserName = "zig";
    private static String zigdbpassword = "xr33stg0";
    
   
    private static int remotePort = 3306;
    
    private static int assinged_port=0;
    
    private static void connectSSH(String dbhosturl) throws SQLException, IOException {
        
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
            System.out.println("connectSSH localport is:"+localPort);
           // int assinged_port = session.setPortForwardingL(localPort, remoteHost, remotePort);
            
            assinged_port = session.setPortForwardingL(localPort, dbhosturl, remotePort);

            System.out.println("localhost:" + assinged_port + " -> " + dbhosturl + ":" + remotePort);
            System.out.println("Port Forwarded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	private static void connectToDataBase(String dataBaseName, String dbUserName, String dbUserPwd ) throws SQLException {
        
        //int localPort = 3306; // any free port can be used
		int localPort = assinged_port;
        String localSSHUrl = "localhost";
        try {

            //mysql database connectivity
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName(localSSHUrl);
            System.out.println("connectToDataBase localport is:"+localPort);
            dataSource.setPortNumber(localPort);
            dataSource.setUser(dbUserName);
            dataSource.setAllowMultiQueries(true);

            dataSource.setPassword(dbUserPwd);
            dataSource.setDatabaseName(dataBaseName);

            connection = dataSource.getConnection();

            System.out.print("Connection to server successful!:" + connection + "\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	 public static void displaying_table_values(String dbhosturl,String dbname, String dbuser,String dbuserpwd, String table, String col_name)
		{
			LinkedHashSet<String> result = new LinkedHashSet<String>();
			try{
				connectSSH(dbhosturl);
			    connectToDataBase(dbname,dbuser, dbuserpwd);
				Statement stmt=connection.createStatement();  
			    ResultSet rs=stmt.executeQuery("select "+col_name+" from "+table); 
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
	 
	 public static Set<String> fetching_gatewaydsn_zibinding(String dbname, String dbuser, String dbuserpwd)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH(zigdbremoteHost);
			    connectToDataBase(dbname, dbuser, dbuserpwd );
				Statement stmt=connection.createStatement();  
			    ResultSet rs=stmt.executeQuery("select distinct gateway_dsn from z_bindings"); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
				
			    System.out.println("Total number of Distinct gateway_dsn from z_bindings table is as: "+result.size());
			    
			}
			catch(Exception e){ System.out.println(e);}  
			 
			return result;
		} 
	 
	 public static Set<String> fetching_dsn_device(String dbname, String dbuser, String dbuserpwd)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH(adsdbremoteHost);
			    connectToDataBase(dbname, dbuser, dbuserpwd);
				Statement stmt=connection.createStatement();
			    ResultSet rs=stmt.executeQuery("select distinct dsn from devices"); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
			    System.out.println("Total number of Distinct dsn from devices table is as: "+result.size());
			}
			catch(Exception e){ System.out.println(e);}  
			 
			return result;
		}
	 
	 public static Set<String> fetching_distinct_values(String dbhosturl, String dbname, String dbusername,String dbuserpwd, String table)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH(dbhosturl);
			    connectToDataBase(dbname, dbusername, dbuserpwd);
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
			System.out.println("Total number of Missing dsns in device table of ADS DB in Staging Environment is: "+output.size());
			return output;
		}
		
		public static void deleting_records_from_table(Set<String> missingdsns, String dbhosturl, String dbname, String dbuser,String dbuserpwd, String tableName)
		{
			try{
				connectSSH(dbhosturl);
			    connectToDataBase(dbname, dbuser, dbuserpwd);
				  
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
		

	
	
	
	public static void main(String[] args) throws IOException 
	{
		Set<String> output=finding_missing_dsns(fetching_gatewaydsn_zibinding(zigdbName, zigdbuserName, zigdbpassword), fetching_dsn_device(adsdbName, adsdbuserName, adsdbpassword));
		
		if(output.size()==0)
		{
			System.out.println("All the gateway_dsn from zbindings table of zig db exist into devices table of ads db.");
		}
		else
		{
			System.out.println("The dsn missing in device table of ADS DB in Staging Environment are as:");
			for(String str:output)
				System.out.println(str);
		}
		
		//displaying_table_values(zigdbName, zigdbuserName, "schema_migrations", "version");
		
		

	
	}
}
