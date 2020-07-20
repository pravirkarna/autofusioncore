package com.optumrx.autofusion.core.mobile.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import gherkin.deps.com.google.gson.Gson;

import com.google.gson.*;



public class PerfectoReportDownloader {
	
	// The Perfecto Continuous Quality Lab you work with
	public static final String CQL_NAME ="optum";
	
	public static final String REPORTING_SERVER_URL ="https://" +CQL_NAME +  ".reporting.perfectomobile.com";

	//See https://developers.perfectomobile.com/display/PD/DigitalZoom+Reporting+Public+API on how to obtain a Security Token
	private static String PERFECTO_SECURITY_TOKEN_KEY;
	
	//private static final String SECURITY_TOKEN = System.getProperty(PERFECTO_SECURITY_TOKEN_KEY);
	
	public static void perfectoResultDownsloader(String driverExecutionID ,String securePerfectoToken)throws Exception {
		
		PERFECTO_SECURITY_TOKEN_KEY = securePerfectoToken;
		
		//
		JsonObject executions = retrieveTestExecutions(driverExecutionID);
		
		JsonArray resources =executions.getAsJsonArray("resources");
		if(resources.size()==0) {
			System.out.println("There are no test execution for that period of time");
		}else {
			JsonObject testExecution =resources.get(0).getAsJsonObject();
			
			//Added by JAY to get testID"
			
			//String testID = testExecution.get("id").getAsString();
			
			//Retrieves a list of commands of single test (as a json)
			
			//retrieveTestCommands(testExecution);
			
			//Download Video
			downloadVideo(testExecution);
			
			//downloadAttachments(testExecution);
			
			downloadsPDF(testExecution);
		}
	}
	
	
	public static JsonObject retreiveTestExecutions(String driverExecutionID) throws URISyntaxException ,IOException{
		URIBuilder uriBuilder =new  URIBuilder(REPORTING_SERVER_URL + "/export/api/v1/test-executions");
		
		// Optional : Filter by range . In this example: retrieve test execution of the post month (result may contains tests of multiple driver execution)
		uriBuilder.addParameter("startExecutionTime[0]", Long.toString(System.currentTimeMillis()-TimeUnit.DAYS.toMillis(30)));
		uriBuilder.addParameter("endExecutionTime[0]", Long.toString(System.currentTimeMillis()));
		
		//Optional: Filter by a specific driver execution: retrieve test execution ID that you obtain at script execution
		uriBuilder.addParameter("externalID[0]", driverExecutionID);
		
		HttpGet getExecutions = new HttpGet(uriBuilder.build());
		addDefaultRequestHeaders(getExecutions);
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		HttpResponse getExecutionsResponse = httpClient.execute(getExecutions);
		JsonObject execution;
		try(InputStreamReader inputStreamReader =new InputStreamReader(getExecutionsResponse.getEntity().getContent())){
			Gson gson =new GsonBuilder().setPrettyPrinting().create();
			String response = IOUtils.toString(inputStreamReader);
			try {
				execution=gson.fromJson(response, JsonObject.class);
			}catch(JsonSyntaxException e) {
				throw new RuntimeExecution("Unable to parse repsonse: " + response);
			}
		}
		
		return executions;
		
	}
	
	private static void retrieveTestCommands(JsonObject testException) throws URISyntaxException, IOException {
		String testId = testExecption.get("id").getAsString();
		HttpGet getCommands = new HttpGet (new URI(REPORTING_SERVER_URL +"/export/api/v1/test-execution/" +testId +"/commands"));
		addDefaultRequestHeaders(getCommands);
		HttpCLient httpClient = HttpClientBuilder.create().build();
		HttpResponse getCommandsResponse = httpClient.execute(getCommands);
		try(InputStreamReader inputStreamReader =new InputStreamReader(getCommandsResponse.getEntity().getContent())){
			Gson gson =new GsonBuilder().setPrettyPrinting().create();
			JsonObject commands =gson.fromJson(IOUtils.toString(inputStreamReader),JsonObject.class);
			//System.out.println("List of commands response" +gson.toJson(commands));
			
		}
	}
	
	private static void downloadAttachments(JsonObject testExecution) throws IOException, URISyntaxException{
		System.out.println("Calling other methods to download attachment");
		JsonArray artifacts =testExecution.getAsJsonArray("artifacts");
		for(JsonElement artifactsElement : artifacts) {
			JsonObject artifact = artifactsElement.getAsJsonObject();
			String artifactType =artifact.get("type").getAsString();
			System.out.println(artifactType);
			
			if(artifactType.equals("DEVICE_LOGS")) {
				String testID =testExecution.get("id").getAsString();
				String path =artifact.get("path").getAsString();
				URIBuilder uriBuilder =new URIBuilder(path);
				downloadFile(testID, uriBuilder.build(),".zip", "device logs");
			}
				
			}
			
		}
    private static void downloadFile(String fileName, URI uri ,String suffix, String description) throws IOException {
    		downloadFileToFS(new HttpGet(uri), fileName, suffix, description);
		
	}
	
	private static void downloadFileToFS(HttpGet httpGet ,String fileName ,String suffix ,String description) throws IOException{
		
		
		System.out.println("The file");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
