package com.optumrx.autofusion.core.mobile.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

	/**
	 * POJO Root of mobile Device Configuration
	 * @author MAC
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Generated("org.jsonschema2pojo")
	@JsonPropertyOrder({"test target","app name","app install file path","bundle Id","devices","full reset","app package","app activity"})
	
	
	public class MobileConfig {
		//CHECKSTYLE:OFF
		private static final String TEST_TARGET ="test target";
		private static final String APP_NAME ="app name";
		private static final String APP_INSTALL_FILE_PATH ="app install file path";
		private static final String BUNDLE_ID ="bundle Id";
		private static final String DEVICES="devices";
		private static final String FULL_RESET ="full reset";
		private static final String APP_PACAKGE ="app package";
		private static final String APP_ACTIVITY ="app activity";
		
		@JsonProperty(TEST_TARGET)
		private TestTarget testTarget;
		
		@JsonProperty(APP_NAME)
		private String appName;
		
		@JsonProperty(APP_INSTALL_FILE_PATH)
		private String  appInstallFilePath;
		
		@JsonProperty(BUNDLE_ID)
		private String  bundleId;
		
		@JsonProperty(DEVICES)
		private List<Device>  devices= new ArrayList<Device>();
		
		@JsonProperty(FULL_RESET)
		private Boolean  fullReset;
		
		@JsonProperty(APP_PACAKGE)
		private String  appPackage;
		
		@JsonProperty(APP_ACTIVITY)
		private String  appActivity;
		
		@JsonIgnore
		private Map<String ,Object> additionalProperties = new HashMap<String, Object>();
		
		/**
		 *Get test Target 
		 *
		 *@return The testTarget
		 */
		@JsonProperty(TEST_TARGET)
		public TestTarget getTestTarget() {
			return testTarget;	
		}
		
		/**
		 * Set test Target
		 * @param testTarget The test target
		 */
		@JsonProperty(TEST_TARGET)
		public void setTestTarget(final TestTarget testTarget) {
			this.testTarget=testTarget;	
		}
		
		/**
		 *Get mobile app name. 
		 *
		 *@return The app name
		 */
		@JsonProperty(APP_NAME)
		public String getAppName() {
			return appName;	
		}
		
		/**
		 * Set mobile app name.
		 * @param appName The app Name
		 */
		@JsonProperty(APP_NAME)
		public void setAppName(final String appName) {
			this.appName=appName;	
		}
		
		/**
		 *Get test Target 
		 *
		 *@return The testTarget
		 */
		@JsonProperty(APP_INSTALL_FILE_PATH)
		public String getAppInstallFilePath() {
			return appInstallFilePath;	
		}
		
		/**
		 * Set test Target
		 * @param testTarget The test target
		 */
		@JsonProperty(APP_INSTALL_FILE_PATH)
		public void setAppInstallFilePath(final String appInstallFilePath) {
			this.appInstallFilePath=appInstallFilePath;	
		}
		
		/**
		 *Get test Target 
		 *
		 *@return The testTarget
		 */
		@JsonProperty(BUNDLE_ID)
		public String getBundleId() {
			return bundleId;	
		}
		
		/**
		 * Set test Target
		 * @param testTarget The test target
		 */
		@JsonProperty(BUNDLE_ID)
		public void setBundleId(final String bundleId) {
			this.bundleId=bundleId;	
		}
		
		/**
		 *Get test Target 
		 *
		 *@return The testTarget
		 */
		@JsonProperty(DEVICES)
		public List<Device> getDevices() {
			return devices;	
		}
		
		/**
		 * Set test Target
		 * @param testTarget The test target
		 */
		@JsonProperty(DEVICES)
		public void setDevices(final TestTarget testTarget) {
			this.testTarget=testTarget;	
		}
		
		/**
		 *Get test Target 
		 *
		 *@return The testTarget
		 */
		@JsonProperty(FULL_RESET)
		public Boolean getFullReset() {
			return fullReset;	
		}
		
		/**
		 * Set test Target
		 * @param testTarget The test target
		 */
		@JsonProperty(FULL_RESET)
		public void setFullReset(final Boolean fullReset) {
			this.fullReset=fullReset;	
		}
		
		/**
		 *Get test Target 
		 *
		 *@return The testTarget
		 */
		@JsonProperty(APP_PACAKGE)
		public String getAppPackage() {
			return appPackage;	
		}
		
		/**
		 * Set test Target
		 * @param testTarget The test target
		 */
		@JsonProperty(APP_PACAKGE)
		public void setAppPackage(final String appPackage) {
			this.appPackage=appPackage;	
		}
		
		/**
		 *Get test Target 
		 *
		 *@return The testTarget
		 */
		@JsonProperty(APP_ACTIVITY)
		public String getAppActivity() {
			return appActivity;	
		}
		
		/**
		 * Set test Target
		 * @param testTarget The test target
		 */
		@JsonProperty(APP_ACTIVITY)
		public void setTestTarget(final String appActivity) {
			this.appActivity=appActivity;	
		}
		
		/**
		 * Get any Additional properties in JSON Object.
		 * 
		 * @return Additional properties in JSON Object.
		 * 
		 */
		@JsonAnyGetter
		public Map<String, Object>getAdditionalProperties(){
			return this.additionalProperties;
			
		}
		/**
		 * Set Additional properties in JSON Object.
		 * 
		 * @param name Additional properties in JSON Object.
		 * @param value Additional properties in JSON Object.
		 */
		
		@JsonAnySetter
		public void setAdditionalProperty(final String name ,final Object value) {
			this.additionalProperties.put(name, value);
		}
		
		//CHECKSTYLE:ON
		
}
