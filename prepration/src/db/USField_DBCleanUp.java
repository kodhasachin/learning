package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class USField_DBCleanUp {
	
	private static Connection connection = null;
    private static Session session = null;
    private static String sshHost = "gateway-1b.aylanetworks.com";
    private static String sshUser = "sachin";
    private static String SshKeyFilepath = "/Users/skodha/.ssh/id_rsa";
    private static String SshKeyFilePassword = "sk021dh@";
    
    private static String adsdbremoteHost = "ads-field-db.cobodw8no5wx.us-east-1.rds.amazonaws.com";
    private static String adsdbName = "ads_field";
    private static String adsdbuserName = "ads_ro";
    private static String adsdbpassword = "89xQMUGb9R";
    
    private static String zigdbremoteHost = "zig-field-db.cobodw8no5wx.us-east-1.rds.amazonaws.com";
    private static String zigdbName = "zig_field";
    private static String zigdbuserName = "zig_ro";
    private static String zigdbpassword = "c3C5g5eF74";
    
    
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
	
	private static void connectToDataBase(String dataBaseName, String dbUserName, String dbUserPwd) throws SQLException {
        
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
	
	 public static void displaying_table_values(String dbhosturl, String dbname, String dbuser, String dbuserpwd, String table, String col_name)
		{
			LinkedHashSet<String> result = new LinkedHashSet<String>();
			try{
				connectSSH(dbhosturl);
			    connectToDataBase(dbname,dbuser,dbuserpwd);
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
			    connectToDataBase(dbname, dbuser, dbuserpwd);
				Statement stmt=connection.createStatement();  
			    ResultSet rs=stmt.executeQuery("select distinct gateway_dsn from z_bindings"); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
				
			    System.out.println("Total number of Distinct z_bindings->gateway_dsn is as: "+result.size());
			    
			}
			catch(Exception e){ System.out.println(e);}  
			 
			return result;
		} 
	 
	 public static Set<String> fetching_from_id_zibinding(String dbname, String dbuser, String dbuserpwd)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH(zigdbremoteHost);
			    connectToDataBase(dbname, dbuser, dbuserpwd);
				Statement stmt=connection.createStatement();  
			    ResultSet rs=stmt.executeQuery("select distinct from_id from z_bindings"); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
				
			    System.out.println("Total number of Distinct z_bindings->from_id is as: "+result.size());
			    
			}
			catch(Exception e){ System.out.println(e);}  
			 
			return result;
		} 
	 
	 public static Set<String> fetching_to_id_zibinding(String dbname, String dbuser, String dbuserpwd)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH(zigdbremoteHost);
			    connectToDataBase(dbname, dbuser, dbuserpwd);
				Statement stmt=connection.createStatement();  
			    ResultSet rs=stmt.executeQuery("select distinct to_id from z_bindings"); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
				
			    System.out.println("Total number of Distinct z_bindings->to_id is as: "+result.size());
			    
			}
			catch(Exception e){ System.out.println(e);}  
			 
			return result;
		} 
	 
	 
	 public static Set<String> fetching_node_dsn_zig_group_datapoints(String dbname, String dbuser, String dbuserpwd)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH(zigdbremoteHost);
			    connectToDataBase(dbname, dbuser, dbuserpwd);
				Statement stmt=connection.createStatement();  
			    ResultSet rs=stmt.executeQuery("select distinct node_dsn from group_datapoints"); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
				
			    System.out.println("Total number of Distinct group_datapoints->node_dsn is as: "+result.size());
			    
			}
			catch(Exception e){ System.out.println(e);}  
			 
			return result;
		} 
	 
	 public static Set<String> fetching_node_dsn_zig_scene_datapoints(String dbname, String dbuser, String dbuserpwd)
		{
			Set<String> result = new HashSet<String>();
			try{
				connectSSH(zigdbremoteHost);
			    connectToDataBase(dbname, dbuser, dbuserpwd);
				Statement stmt=connection.createStatement();  
			    ResultSet rs=stmt.executeQuery("select distinct node_dsn from scene_datapoints"); 
			    while(rs.next())
			    	result.add(rs.getString(1));
			    connection.close();
			    session.disconnect();
				
			    System.out.println("Total number of Distinct scene_datapoints->node_dsn is as: "+result.size());
			    
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
			    System.out.println("Total number of Distinct devices->dsn is as: "+result.size());
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
			System.out.println("Total number of Missing dsns in device table of ADS DB in USField Environment is: "+output.size());
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
		
   public static void missing_gatewaydsns(Set<String> dsn_devices)
   {
   	 Set<String> missing_gatewaydsns=finding_missing_dsns(fetching_gatewaydsn_zibinding(zigdbName, zigdbuserName, zigdbpassword), dsn_devices);
		
		if(missing_gatewaydsns.size()==0)
		{
			System.out.println("All z_bindings->gateway_dsn of zig db exist into devices table of ads db.");
		}
		else
		{
			System.out.println("The missing z_bindings->gateway_dsn of zig db in USField Environment are as:");
			System.out.println("-------------------------------------------------------------------------------------");
			for(String str:missing_gatewaydsns)
				System.out.print(str+" ,");
			System.out.println("-------------------------------------------------------------------------------------");
		}
   }
   
   public static void missing_from_ids(Set<String> dsn_devices)
   {
       Set<String> missing_from_ids=finding_missing_dsns(fetching_from_id_zibinding(zigdbName, zigdbuserName, zigdbpassword), dsn_devices);
		
		if(missing_from_ids.size()==0)
		{
			System.out.println("All z_bindings->from_id of zig db exist into devices table of ads db.");
		}
		else
		{
			System.out.println("The missing z_bindings->from_id of zig db in USField Environment are as:");
			System.out.println("-------------------------------------------------------------------------------------");
			for(String str:missing_from_ids)
				System.out.print(str+" ,");
			System.out.println("-------------------------------------------------------------------------------------");
		}
   }
   
   public static void missing_to_ids(Set<String> dsn_devices)
   {
      Set<String> missing_to_ids=finding_missing_dsns(fetching_to_id_zibinding(zigdbName, zigdbuserName, zigdbpassword), dsn_devices);
		
		if(missing_to_ids.size()==0)
		{
			System.out.println("All z_bindings->to_id of zig db exist into devices table of ads db.");
		}
		else
		{
			System.out.println("The missing z_bindings->to_id of zig db in USField Environment are as:");
			System.out.println("-------------------------------------------------------------------------------------");
			for(String str:missing_to_ids)
				System.out.print(str+" ,");
			System.out.println("-------------------------------------------------------------------------------------");
		}
   }
   
   public static void missing_node_dsn_groupdp(Set<String> dsn_devices)
   {
      Set<String> missing_node_dsns_groupdp=finding_missing_dsns(fetching_node_dsn_zig_group_datapoints(zigdbName, zigdbuserName, zigdbpassword), dsn_devices);
		
		if(missing_node_dsns_groupdp.size()==0)
		{
			System.out.println("All the group_datapoints->node_dsn of zig db exist into devices table of ads db.");
		}
		else
		{
			System.out.println("The misisng group_datapoints->node_dsn of zig db in USField Environment are as:");
			System.out.println("-------------------------------------------------------------------------------------");
			for(String str:missing_node_dsns_groupdp)
				System.out.print(str+" ,");
			System.out.println("-------------------------------------------------------------------------------------");
		}
   }
   
   public static void missing_node_dsn_scenedp(Set<String> dsn_devices)
   {
      Set<String> missing_node_dsns_scenedp=finding_missing_dsns(fetching_node_dsn_zig_scene_datapoints(zigdbName, zigdbuserName, zigdbpassword), dsn_devices);
		
		if(missing_node_dsns_scenedp.size()==0)
		{
			System.out.println("All the scene_datapoints->node_dsn of zig db exist into devices table of ads db.");
		}
		else
		{
			System.out.println("The missing scene_datapoints->node_dsn of zig db in USField Environment are as:");
			System.out.println("-------------------------------------------------------------------------------------");
			for(String str:missing_node_dsns_scenedp)
				System.out.print(str+" ,");
			System.out.println("-------------------------------------------------------------------------------------");
		}
   }
	
	
	public static void main(String[] args) throws IOException 
	{
		Set<String> dsn_devices = fetching_dsn_device(adsdbName, adsdbuserName, adsdbpassword);
		missing_gatewaydsns(dsn_devices);
		missing_from_ids(dsn_devices);
		missing_to_ids(dsn_devices);
		missing_node_dsn_groupdp(dsn_devices);
		missing_node_dsn_scenedp(dsn_devices);
      
		
		
      
		
      
		
		
      
		
		
      
		
		//displaying_table_values(zigdbName, zigdbuserName, "schema_migrations", "version");
		
		

	
	}

}
