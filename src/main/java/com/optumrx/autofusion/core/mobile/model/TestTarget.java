package com.optumrx.autofusion.core.mobile.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * POJO for Mobile Device Test Target
 * 
 * @author MAC
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"name","url","username","password"})
public class TestTarget {
	
	//CHECKSTYLE:OFF
	
	private static final String NAME ="name";
	private static final String URL ="url";
	private static final String USERNAME ="username";
	private static final String PASSWORD ="password";
	
	@JsonProperty(NAME)
	private String name;
	
	@JsonProperty(URL)
	private String url;
	
	@JsonProperty(USERNAME)
	private String username;
	
	@JsonProperty(PASSWORD)
	private String password;
	
	@JsonIgnore
	private Map<String ,Object> additionalProperties = new HashMap<String, Object>();
	
	
	/**
	 *Get test Target name.
	 *
	 *@return The testTarget name.
	 */
	@JsonProperty(NAME)
	public String getName() {
		return name;	
	}
	
	/**
	 * Set test Target name.
	 * @param name The test target name.
	 */
	@JsonProperty(NAME)
	public void setName(final String name) {
		this.name=name;	
	}
	
	/**
	 *Get test Target url.
	 *
	 *@return The testTarget url.
	 */
	@JsonProperty(URL)
	public String getUrl() {
		return url;	
	}
	
	/**
	 * Set test Target url.
	 * @param url The test target url.
	 */
	@JsonProperty(URL)
	public void seturl(final String url) {
		this.url=url;	
	}
	
	/**
	 *Get test Target username.
	 *
	 *@return The username to connect to the test target.
	 */
	@JsonProperty(USERNAME)
	public String getUsername() {
		return username;	
	}
	
	/**
	 * Set test Target username.
	 * @param username The username to connect to the test target.
	 */
	@JsonProperty(USERNAME)
	public void setUsername(final String username) {
		this.username=username;	
	}
	
	
	/**
	 *Get test Target Password.
	 *
	 *@return The password to connect to the test target.
	 */
	@JsonProperty(PASSWORD)
	public String getPassword() {
		return password;	
	}
	
	/**
	 * Set test Target password.
	 * @param password The password to connect to the test target.
	 */
	@JsonProperty(PASSWORD)
	public void setPassword(final String password) {
		this.password=password;	
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
