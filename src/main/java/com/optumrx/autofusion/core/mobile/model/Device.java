package com.optumrx.autofusion.core.mobile.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;
/**
 * POJO for mobile Device Configuration
 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Generated("org.jsonschema2pojo")
	@JsonPropertyOrder({
		"device name","platform name","manufacturer","platform version","udid"
	})
	
public class Device {
		
		
		// CHECKSTYLE : OFF
		
		private static final String DEVICE_NAME="device name";
		private static final String PLATFORM_NAME="platform name";
		private static final String MANUFACTURER="manufacturer";
		private static final String PLATFORM_VERSION="paltform version";
		private static final String UDID="udid";
	
		@JsonProperty(DEVICE_NAME)
		private String deviceName;
		
		@JsonProperty(PLATFORM_NAME)
		private String platformName;
		
		@JsonProperty(MANUFACTURER)
		private String manufacturer;
		
		@JsonProperty(PLATFORM_VERSION)
		private String platformVersion;
		
		@JsonProperty(UDID)
		private String udid;
		
		@JsonIgnore
		private Map<String,Object> additionalProperties =
		new HashMap<String , Object>();
		
		/**
		 * Get user identifiable device name.
		 * @return user identifiable device name
		 */
		
		@JsonProperty(DEVICE_NAME)
		public String getDeviceName() {
			return deviceName;
		}
		
		/**
		 * Set user identifiable device name.
		 * @param user identifiable device name
		 */
		
		@JsonProperty(DEVICE_NAME)
		public void setDeviceName(final String deviceName) {
			this.deviceName=deviceName;
		}
		
		
		/**
		 * Get Device's platform name.
		 * @return Device's platform name ,Android, iOS
		 */
		
		@JsonProperty(PLATFORM_NAME)
		public String getPlatformName() {
			return platformName;
		}
		
		/**
		 * Set  Device's platform name.
		 * @param platformName Device's platform name, Android ,iOS
		 */
		
		@JsonProperty(PLATFORM_NAME)
		public void setPlaformName(final String platformName) {
			this.platformName=platformName;
		}
		
		/**
		 * Get Device's Manufacturer.
		 * @return Device's Manufacturer
		 */
		
		@JsonProperty(MANUFACTURER)
		public String getManufacturer() {
			return manufacturer;
		}
		
		/**
		 * Set  Device's Manufacturer.
		 * @param Manufacturer Device's MAnufacturer
		 */
		
		@JsonProperty(MANUFACTURER)
		public void setManufatcurer(final String manufacturer) {
			this.manufacturer=manufacturer;
		}
		
		/**
		 * Get Platform version.
		 * @return Device's platform version
		 */
		
		@JsonProperty(PLATFORM_VERSION)
		public String getPlatformVersion() {
			return platformVersion;
		}
		
		/**
		 * Set  platform version.
		 * @param plateformVersion Device's platform version
		 */
		
		@JsonProperty(PLATFORM_VERSION)
		public void setPlatformVersion(final String platformVersion) {
			this.platformVersion=platformVersion;
		}
		
		/**
		 * Get UDID.
		 * @return Device's UDID
		 */
		
		@JsonProperty(UDID)
		public String getUdid() {
			return udid;
		}
		
		/**
		 * Set UDID.
		 * @param UDID Device's udid
		 */
		
		@JsonProperty(UDID)
		public void setUdid(final String udid) {
			this.udid=udid;
		}
		
		
		/**
		 * Get any additional properties in JSON Object
		 * @return Additional properties in JSON obect
		 */
		@JsonAnyGetter
		public Map<String,Object> getAdditionalProperties(){
			return this.additionalProperties;
			
		}
		
		/**
		 * Set additional properties in JsonObject
		 * 
		 * @param name Additional property name in JSON object
		 * @param value Additional property value in JSON object
		 */
		
		@JsonAnySetter
		public void setAdditionalProperty(final String name , final Object value) {
			this.additionalProperties.put(name, value);
		}
		
		//CHECKSTYLE:ON		
}
