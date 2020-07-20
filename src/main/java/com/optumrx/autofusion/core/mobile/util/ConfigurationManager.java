package com.optumrx.autofusion.core.mobile.util;

import java.io.File;
import java.io.IOException;

import com.optumrx.autofusion.core.mobile.model.MobileConfig;

/**
*Manage Mobile Device Configuration
*@author MAC
*/
/**
 * 
 * @author MAC
 *
 */

public class ConfigurationManager {
	/**
	 * store a reference to an initialized mobile config
	 */
	private static MobileConfig configInfo;
	
	/**
	 * Prevent class from being instantiated.
	 */
	private ConfigurationManager() {
		//EMPTY Constructor
	}
	
    /**
     * Initialize a set of configuration object based on input configuration
     * file.
     * 
     * @param configFilePathString path to configuration file
     * @return true c
     * @throws IOException invalid configuration file
     */
	public static boolean initialize (String configFilePathString)throws IOException{
		
		//If configuration has been initialized , then no further action
		if(configInfo != null) {
			return true;
		}
		if(configFilePathString ==null || configFilePathString.isEmpty()) {
			throw new IllegalArgumentException("Config Filepath Not Specified");
		}
		File f =new File(configFilePathString);
		if(!f.exists()||f.isDirectory()) {
			throw new IllegalArgumentException(String.format("Config Filepath %s Not Found", configFilePathString));
		}
		configInfo=JsonHelper.readJsonFile(configFilePathString,MobileConfig.class);
		
		return true;
	}
	/**
	 * Initialize a set of configuration object based on input configuration
     * file.
	 *
	 * @param configFilePathString path to configuration file
	 * @return true path to configuration file
	 * @throws IOException invalid configuration file
	 */
	public static MobileConfig initializeAndGetConfig(String configFilePathString)throws IOException{
		
		initialize(configFilePathString);
		return configInfo;
		
	}
	
	/**
	 * Get reference to an initialized configuration object
	 * 
	 * @return reference to configuration
	 */
	public static MobileConfig getConfig() {
		 return configInfo;
	}
	
	/**
	 * 
	 * Un-Initialized a previously initialized configuration object
	 */
	
	public static void uninitialized() {
		 configInfo =null;
	}
	
	
	
	
}
