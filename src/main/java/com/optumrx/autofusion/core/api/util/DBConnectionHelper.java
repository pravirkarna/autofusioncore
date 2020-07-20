package com.optumrx.autofusion.core.api.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.client.api.Authentication;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.DocumentDescriptor;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.JacksonHandle;

public class DBConnectionHelper {
	
	public static Map<String,String> inputConDetails=new HashMap<String ,String>();
	public static List<Map<String,String>> dbDataTable;
	public static String expectedDate=null;
	public static String fromatedDate;
	
	private String dbUserName;
	private String dbPassword;
	private String dbHostName;
	private int dbPort;
	private String dbName;
	private String dbCollectionName;
	private String RequestID;
	private DatabaseClient client=null;
	private DocumentDescriptor desc;
	private JacksonHandle jacksonHandle =new JacksonHandle();
	private JSONDocumentManager documentManager;
	
	public static List<Map<String, String>> getData(String testEnv , Map<String ,String> inputConDetail){
		
		Statement stmt =null;
		ResultSet rs =null;
		Connection conn =null;
		String finalUrl =null;
		List<Map<String,String>> results =new ArrayList<Map<String,String>>();
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			if(testEnv.equals("Test")) {
				finalUrl=inputConDetail.get("URL")+";DatabaseName="+inputConDetails.get("DatabseName");
			}
			if (testEnv.equals("Stage")) {
				finalUrl=inputConDetail.get("URL")+";DatabaseName="+inputConDetails.get("DatabseName")+";user="+inputConDetails.get("User ID")+";password="+inputConDetails.get("Password");
			}
			Connection con = DriverManager.getConnection(finalUrl);
			stmt =con.createStatement();
			rs=stmt.executeQuery(inputConDetail.get("SqlQuery"));
			
			ResultSetMetaData metaData =rs.getMetaData();
			while(rs.next()) {
				Map<String,String> record =new LinkedHashMap<String,String>();
				for(int col=1;col<=metaData.getColumnCount();col++) {
					record.put(metaData.getColumnLabel(col),rs.getString(col));
				}
				results.add(record);	
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt !=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception mysqlEx) {
				System.out.println(mysqlEx.toString());
				
			}
		}
		return results;	
	}
	
	public static void printMap(List<Map<String,String>>rows) {
		for(int rowNum=0;rowNum<rows.size();rowNum++)
			System.out.println(rowNum+"="+rows.get(rowNum));
	}
	
	public void getMarkLogicDBDetails(String dbUserName,String dbPassword,String dbHostName,int dbPort,String dbName) {
		this.dbUserName=dbUserName;
		this.dbPassword=dbPassword;
		this.dbHostName=dbHostName;
		this.dbPort=dbPort;
		this.dbName=dbName;
		
	}
	
	public void marklogicDBConnc() {
		client= getClient();
	}
	
	public DatabaseClient getClient() {
		try {
			client=DatabaseClientFactory.newClient(dbHostName,dbPort,dbName,dbUserName,dbPassword,com.marklogic.client.DatabaseClientFactory.Authentication.BASIC);
		}catch(Exception e) {
			System.out.println("Error occured during conection establishment"+e);
		}
		return client;
		
	}
	
			
	
	
}