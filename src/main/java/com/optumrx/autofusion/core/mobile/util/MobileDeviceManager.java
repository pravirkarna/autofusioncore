package com.optumrx.autofusion.core.mobile.util;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.optumrx.autofusion.core.mobile.model.MobileConfig;

import cucumber.deps.com.thoughtworks.xstream.InitializationException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Class that handles creation and closing of mobile Device Driver
 * 
 * @author MAC
 *
 */
public class MobileDeviceManager {

	//TODO: Reference to enum
	private static final String IOS_DRIVER="IOS";
	private static final String ANDROID_DRIVER ="ANDROID";
	
	/**
	 *Local variable to store an initialized AppiumDriver . Warning:Not thread safe. 
	 *
	 */
	private static AppiumDriver mobileDriver; 
	
	/**
	 *Local variable to store an initialized Mobile Configuration . Warning:Not thread safe. 
	 *
	 */
	private static MobileConfig mobileConfigInfo;
	/**
	 * Prevent class from being instantiated.
	 */
	
	private MobileDeviceManager() {
		//Empty constructor
	}
	
	public static String getPlatformName() {
		System.out.println("driver name:"+ mobileDriver.getClass().toString());
		if(mobileDriver.getClass().toString().contains("IOSDriver")){
		return IOS_DRIVER;
		}else {
			return ANDROID_DRIVER;
		}
		
	}
	
	/**
	 * 
	 * @param configFilePathString
	 * @return reference to configuration object
	 * @throws IOException 
	 */
	public static Boolean loadConfig(final String configFilePathString) throws IOException {
		if(mobileConfigInfo == null){
			ConfigurationManager.initialize(configFilePathString);
			mobileConfigInfo=ConfigurationManager.getConfig();
		}
		return mobileConfigInfo != null;
	}
	/**
	 * Get a reference to an initialized mobile device driver
	 * @return reference to mobile device driver
	 */
	
	public static AppiumDriver getDeviceDriver() {
		if(mobileDriver != null) {
			return mobileDriver;
		}
		throw new InitializationException("Mobile Device Driver Not Initialised");
	}
	/**
	 * Create a device driver based on external configuration
	 * @param configPath
	 * @return device driver
	 * @throws IOException invalid configuration file
	 */
	
	public static AppiumDriver createAndGetDeviceDriver(final String configPath) throws IOException{
		
		if(mobileConfigInfo ==null) {
			loadConfig(configPath);
		}
		return createAndGetDeviceDriver(mobileConfigInfo, false);
	}
	
	public static AppiumDriver createAndGetDeviceDriver(final MobileConfig mobileConfig , Boolean forceReload) throws  IOException {
		
		if (forceReload || mobileDriver ==null) {
			URL url =new URL(mobileConfigInfo.getTestTarget().getUrl());
		
		String platformName = mobileConfigInfo.getDevices().get(0).getPlatformName().toUpperCase();
		
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability("user",mobileConfigInfo.getTestTarget().getUsername());
		capabilities.setCapability("password",mobileConfigInfo.getTestTarget().getPassword());
		capabilities.setCapability("udid",mobileConfigInfo.getDevices().get(0).getUdid());
		capabilities.setCapability("bundleid",mobileConfigInfo.getBundleId());
		capabilities.setCapability("app",mobileConfigInfo.getAppInstallFilePath());
		capabilities.setCapability("autoLaunch",true);
		capabilities.setCapability("Platform",platformName);
		capabilities.setCapability("fullReset",mobileConfigInfo.getFullReset());
		capabilities.setCapability("appPackage",mobileConfigInfo.getAppPackage());
		capabilities.setCapability("appActivity",mobileConfigInfo.getAppActivity());
		
		if(platformName.equals(IOS_DRIVER)) {
			mobileDriver = new IOSDriver(url, capabilities);
		}else if(platformName.equals(ANDROID_DRIVER)){
			mobileDriver = new AndroidDriver(url, capabilities);
		}
		if(mobileDriver != null) {
			mobileDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		
		}
		return mobileDriver;
	}
		
		/**
		 * close a previously initialized mobile device driver.
		 * @return true id successful
		 */
		public static Boolean closeDeviceDriver() {
			
			if(mobileDriver != null) {
				mobileDriver.close();
				mobileDriver=null;
			}
			return mobileDriver ==null;
			
		}
		
}
