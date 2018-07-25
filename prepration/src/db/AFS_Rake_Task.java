package db;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class AFS_Rake_Task {
	
	private static Connection connection = null;
    private static Session session = null;
    private static String sshHost = "gateway-1b.aylanetworks.com";
    private static String sshUser = "sachin";
    private static String SshKeyFilepath = "/Users/skodha/.ssh/id_rsa";
    private static String SshKeyFilePassword = "sk021dh@";
    
    private static int assinged_port=0;
    private static int remotePort = 3306;
    
    private static String prod_afsdbremoteHost = "afs-prod-replica.cobodw8no5wx.us-east-1.rds.amazonaws.com";
    private static String prod_afsdbName = "afs_prod";
    private static String prod_afsdbuserName = "afs_ro";
    private static String prod_afsdbpassword = "9378rX6N6H";
	
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
	
	public static void displaying_dsn_reserveId(String dbhosturl,String dbname, String dbuser,String dbuserpwd, String dsn)
	{
		LinkedHashMap<String,String> result = new LinkedHashMap<String, String>();
		try{
			connectSSH(dbhosturl);
		    connectToDataBase(dbname,dbuser, dbuserpwd);
			Statement stmt=connection.createStatement();  
		    ResultSet rs=stmt.executeQuery("SELECT dsn,reserve_oem_id_str,model FROM afs_prod.f_devices where dsn='"+dsn+"'");
		    rs.next();
		    System.out.println(rs.getString(1)+":"+rs.getString(2));
		    while(rs.next())
		    	result.put(rs.getString(1),rs.getString(2));
		    connection.close();
		    session.disconnect();
		    
			
		    
		}
		catch(Exception e){ System.out.println(e);}  
		 

	}
	
	private static void read_excel(String dbhosturl,String dbname, String dbuser,String dbuserpwd) throws IOException, SQLException
	{
		String outputFile = "/Users/skodha/sachin/aylatmp/5234-RakeTask/SVC-5082_Reserved_Identified_531040DSNs_B4_RAKETASK.csv";
		CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
		csvOutput.write("dsn");
		csvOutput.write("reserve_oem_id_str");
		csvOutput.write("model");
		csvOutput.endRecord();
		
		connectSSH(dbhosturl);
	    connectToDataBase(dbname,dbuser, dbuserpwd);
		Statement stmt=connection.createStatement();
		
		CsvReader filereader = new CsvReader("/Users/skodha/sachin/aylatmp/5234-RakeTask/SVC-5082_Reserved_Identified_531040DSNs.csv");
		filereader.readHeaders();
		
		while(filereader.readRecord())
		{
			String dsn = filereader.get("DSN");
			ResultSet rs=stmt.executeQuery("SELECT dsn,reserve_oem_id_str,model FROM afs_prod.f_devices where dsn='"+dsn+"'");
			rs.next();
			csvOutput.write(rs.getString(1));
			if(rs.getString(2)==null)
			    //csvOutput.write(rs.getString(2));
				csvOutput.write("null");
			else
				csvOutput.write(rs.getString(2));
			csvOutput.write(rs.getString(3));
			csvOutput.endRecord();
		}
		csvOutput.close();
		filereader.close();
		connection.close();
	    session.disconnect();
		
	}

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		read_excel(prod_afsdbremoteHost,prod_afsdbName, prod_afsdbuserName,prod_afsdbpassword);
		

	}

}
