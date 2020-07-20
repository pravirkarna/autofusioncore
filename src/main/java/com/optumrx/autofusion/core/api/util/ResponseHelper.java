package com.optumrx.autofusion.core.api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import org.json.JSONObject;

public class ResponseHelper {
	
	public static String getResponseObject(HttpURLConnection httpURLConnection) throws IOException {
		String response =null;
		if(httpURLConnection.getResponseCode()!=HttpURLConnection.HTTP_OK) {
			response = readStream(httpURLConnection.getErrorStream());
		}else {
			response = readStream(httpURLConnection.getInputStream());
		}
		return response;
		
	}
	
	public static String postResponseObject(HttpURLConnection httpURLConnection, JSONObject jsonObject) throws Exception{
		String response=null;
		OutputStreamWriter wr =new OutputStreamWriter(httpURLConnection.getOutputStream());
		wr.write(jsonObject.toString());
		wr.flush();
		if(httpURLConnection.getResponseCode()!=HttpURLConnection.HTTP_OK) {
			response = readStream(httpURLConnection.getErrorStream());
		}else {
			response = readStream(httpURLConnection.getInputStream());
		}
		return response;
	}
	
	public static String deleteResponseObject(HttpURLConnection httpURLConnection) throws IOException {
		String response=null;
		if(httpURLConnection.getResponseCode()!=HttpURLConnection.HTTP_OK) {
			response = readStream(httpURLConnection.getErrorStream());
		}else {
			response = readStream(httpURLConnection.getInputStream());
		}
		return response;
		
	}
	
	public static String putResponseObject(HttpURLConnection httpURLConnection) throws IOException {
		String response;
		OutputStreamWriter out =new OutputStreamWriter(httpURLConnection.getOutputStream());
		out.write("Resource content");
		if(httpURLConnection.getResponseCode()!=HttpURLConnection.HTTP_OK) {
			response = readStream(httpURLConnection.getErrorStream());
		}else {
			response = readStream(httpURLConnection.getInputStream());
		}
		return response;
		
	}
	
	private static String readStream(InputStream stream) {
		StringBuilder response = new StringBuilder();
		BufferedReader in=null;
		try {
			in=new BufferedReader(new InputStreamReader(stream));
			String line;
			while((line=in.readLine())!=null) {
				response.append(line);
			}
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return response.toString();
	}
	

}
