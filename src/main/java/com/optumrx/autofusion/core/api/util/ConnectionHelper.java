package com.optumrx.autofusion.core.api.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConnectionHelper {
	
	public static HttpURLConnection httpURLConnection =null;
	
	public static HttpURLConnection createGetConnection(String inputUrl, HashMap<String,String> headerParameters ) {
		URL url =null;
		try {
			url =new URL(inputUrl);
			httpURLConnection= (HttpURLConnection)url.openConnection();
			httpURLConnection.setDoOutput(true);
			if(!headerParameters.isEmpty()) {
				for(String headerKey : headerParameters.keySet()) {
					httpURLConnection.setRequestProperty(headerKey, headerParameters.get(headerKey));
				}
			}
			httpURLConnection.connect();
			return httpURLConnection;
		}catch(Exception e) {
			e.printStackTrace();
			return httpURLConnection;
		}	
	}
	
	public static HttpURLConnection createPostConnection(String endPointUrl, HashMap<String,String> headerParameters ) {
		URL url =null;
		try {
			url =new URL(endPointUrl);
			httpURLConnection= (HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true);
			if(!headerParameters.isEmpty()) {
				for(String headerKey : headerParameters.keySet()) { //in place of headerKey key is written
					httpURLConnection.setRequestProperty(headerKey, headerParameters.get(headerKey));
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return httpURLConnection;
		}	
		return httpURLConnection;
	}
	
	public static HttpURLConnection createDeleteConnection(String endPointUrl, HashMap<String,String> headerParameters ) {
		URL url =null;
		try {
			url =new URL(endPointUrl);
			httpURLConnection= (HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("DELETE");
			httpURLConnection.setDoOutput(true);
			if(!headerParameters.isEmpty()) {
				for(String headerKey : headerParameters.keySet()) { //in place of headerKey key is written
					httpURLConnection.setRequestProperty(headerKey, headerParameters.get(headerKey));
				}
			}
			httpURLConnection.connect();
		
		}catch(Exception e) {
			e.printStackTrace();
			return httpURLConnection;
		}
		return httpURLConnection;
	}
	
	public static HttpURLConnection createPutConnection(String endPointUrl, HashMap<String,String> headerParameters ) {
		URL url =null;
		try {
			url =new URL(endPointUrl);
			httpURLConnection= (HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("PUT");
			httpURLConnection.setDoOutput(true);
			if(!headerParameters.isEmpty()) {
				for(String headerKey : headerParameters.keySet()) { //in place of headerKey key is written
					httpURLConnection.setRequestProperty(headerKey, headerParameters.get(headerKey));
				}
			}
			httpURLConnection.connect();
		
		}catch(Exception e) {
			e.printStackTrace();
			return httpURLConnection;
		}
		return httpURLConnection;
	}
	
	public static void printResponse(HttpURLConnection result) {
		
		try {
			InputStream inputStream =result.getInputStream();
			ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
			byte[] buf =new byte[512];
			int read=-1;
			while((read = inputStream.read(buf))>0) {
				byteArrayOutputStream.write(buf,0,read);
			}
			System.out.println( new String(byteArrayOutputStream.toByteArray()));
			
			Pattern p=Pattern.compile("\"([^\"]*)\"");
			Matcher m = p.matcher(new String(byteArrayOutputStream.toByteArray()));
			while(m.find()) {
				System.out.println(m.group(1));
			}
 			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	public static void verifyText(HttpURLConnection result) throws IOException {
		InputStream inputStream =result.getInputStream();
		java.util.Scanner s=new java.util.Scanner(inputStream).useDelimiter("\\:");
		while(s.hasNext()) {
			System.out.println(s.next());
			System.out.println(s.delimiter());
		}
		//yet to complete this implementation
	}
		

}