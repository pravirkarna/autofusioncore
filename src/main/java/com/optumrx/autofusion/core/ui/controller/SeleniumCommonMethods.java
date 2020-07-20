package com.optumrx.autofusion.core.ui.controller;

//TODO: Nalin - check the origin of this class from Mark. package com.optumrx.autofusion.core.ui.controller;

import java.util.HashMap;
import java.awt.Robot;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions; import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumCommonMethods {
	
	static int LOG_VAR;
	int failFlag;
	String fieldName;
	String screenName;
	public static String DVARIABLE = "";
	public static int synctime, Longsynctime;
	public static HashMap<String, String> dataholder = new HashMap<String, String>(); // HashMap for construct)

	public static Robot robo;
	public static String ACTUALPARA = "";// Used in Geteleproperty,Asserteleproperty Keywords
	public static WebDriverWait wait;
	  
    public static String fieldValue, inputSheet, testModulePath;
    
    public static String Error_Msg;
    
	//VERIFY VERIFY VERIFY VERIFY VERIFY VERIFY VERIFY VERIFY VERIFY VERIFY
	//VERIFY
	//********************************************** // Object Category: VERIFY
	//Method Name :SYNC_FindElement
	//Parameter: WebElement: Any type of WebElement // Returns: boolean
	//Purpose: To verify object exists, is enabled and is displayed on screen
	//**********************************************
	public static boolean Verify_VisibleEnabled_Element(WebElement element) {
	try {
	if (!(element.equals(null)) || (element.isEnabled() && element.isDisplayed())) {System.out.println("Verify_VisibleEnabled_Element: Element exist");
	                   return true;
	             } else {
	System.out.println("Verify_VisibleEnabled_Element: Element does NOT exist");
	                   return false;
	             }
	} catch (NoSuchElementException e) { System.out.println("Verify_VisibleEnabled_Element:NoSuchElementException thrown");
	             return false;
	        } catch (Exception e) {
	             e.printStackTrace();
	             return false;
	        }
	}
	//********************************************** // Object Category: VERIFY
	//Method Name :Verify_Value_Element
	//Parameter: WebElement, String: Expected Value // Returns: boolean
	//Purpose: To compare Expected and Actual string Values
	//**********************************************
	
	public boolean Verify_Value_Element(WebElement element, String
	Expected_Value) {
	String Actual_Value = element.getAttribute("value"); if (Actual_Value.equals(Expected_Value)) {
	System.out.println("Verify_Value_Element: String value is Matching");
	             return true;
	        } else {
	System.out.println("Verify_Value_Element: String value NOT Matching!");
	             return false;
	        }
	}
	//CHECKBOX CHECKBOX CHECKBOX CHECKBOX CHECKBOX CHECKBOX CHECKBOX CHECKBOX
	//CHECKBOX CHECKBOX CHECKBOX CHECKBOX CHECKBOX CHECKBOX CHECKBOX
	//**********************************************
	//Object Category: CheckBox
	//Method Name :CHK_Setcheck
	//Parameter: WebElement:CheckBox, boolean: true=check false=Uncheck
	  // Returns: boolean
	//Purpose: To check or Uncheck a checkBox type element // **********************************************

	public void CHK_SetCheck(WebElement element, boolean checkOnOff) {
	try {
		if (checkOnOff) {
			  if (!(element.isSelected())) {
			element.click(); 
			System.out.println("CHK_SetCheck: CheckBox was checked ");
			  }
	
	  } else {
		  if (element.isSelected()) {
			  element.click(); 
			  System.out.println("CHK_SetCheck: CheckBox was Un-checked");
		  }
		}
	
	} catch (NoSuchElementException e) { 
		System.out.println("SYNC_FindElement:NoSuchElementException thrown");
	        
	} catch (Exception e) {
	             e.printStackTrace();
	        }
	}

	//DROPDOWN COMBOBOX DROPDOWN COMBOBOX DROPDOWN COMBOBOX DROPDOWN COMBOBOX
	//DROPDOWN COMBOBOX DROPDOWN COMBOBOX DROPDOWN COMBOBOX DROPDOWN
	/* Methods to select a DropDown item based on Value, Index and Text */
	//********************************************** // Object Category: ComboBox, DropDown
	//Method Name :DropDown_SelectByText
	//Parameter: WebElement, String: Input Value
	//Returns: void
	//Purpose: To Select a drop down Item by a string Text
	//**********************************************
	
		public static void DropDown_SelectByText(WebElement element,
		String Value) {
		        if (element != null) {
		Select select = new Select(element); 
		select.selectByVisibleText(Value); 
		System.out.println("Value "+Value+ "is selected");
		} 
	}
		
	//public static void DropDown_SelectByText(String Value, String // locatorValue, String locator) {
	//System.out.println(getDriver());
	//WebElement element =getDriver().findElement(By.id(locatorValue)); // if (element != null) {
	//element.click();
	//Select select = new Select(element); // select.selectByVisibleText(Value);
	//}
	//}
	//**********************************************
	//Object Category: ComboBox, DropDown
	//Method Name :DropDown_SelectByValue
	//Parameter: WebElement, String: Input Value
	//Returns: void
	//Purpose: To Select a drop down Item by a string Value // **********************************************
	public static void DropDown_SelectByValue(WebElement
	SelectTypeElement, String stringValue) {
	Select select = new Select(SelectTypeElement); select.selectByValue(stringValue);
	}
	
	//********************************************** // Object Category: ComboBox, DropDown
	//Method Name :DropDown_SelectByIndex
	//Parameter: WebElement, INT: Input Value
	//Returns: void
	//Purpose: To Select a drop down Item by Index Number (int) // **********************************************
	public void DropDown_SelectByIndex(WebElement SelectTypeElement, int In_index) {
	Select select = new Select(SelectTypeElement);
	        select.selectByIndex(In_index);
	  }
	
	//********************************************** // Object Category: ComboBox, DropDown
	//Method Name :DropDown_GetSelectedOption
	//Parameter: WebElement: Select Type
	  // Returns: WebElement: option
	//Purpose: To Get the selected option item in a dropdown list and return
	//that option
	//**********************************************
	public static WebElement DropDown_GetSelectedOption(WebElement
	SelectTypeElement) {
	        WebElement option = null;
	try {
	Select select = new Select(SelectTypeElement); option = select.getFirstSelectedOption(); return option;
	} catch (NoSuchElementException e) { System.out.println("DropDown_GetSelectedOption:NoSuchElementException thrown");
	             return option;
	        } catch (Exception e) {
	             e.printStackTrace();
	             return option;
	        }
	}
	
	//********************************************** // Object Category: ComboBox, DropDown
	//Method Name :DropDown_GetListOfOptions
	//Parameter: WebElement: Select Type
	  // Returns: WebElement: option
	//Purpose: To Get all the option items in a dropdown list and return all
	//those options
	//********************************************** 
	public static List<WebElement>DropDown_GetListOfOptions(WebElement SelectTypeElement) { 
		List<WebElement> options = null;
	try {
	Select select = new Select(SelectTypeElement); options = select.getOptions();
	return options;
	} catch (NoSuchElementException e) { 
		System.out.println("DropDown_GetSelectedOption:NoSuchElementException thrown");
	             return options;
	        } catch (Exception e) {
	             e.printStackTrace();
	             return options;
	        }
	}
	
	public static Boolean DropDown_FindOption(WebElement SelectTypeElement, String value) {
	        Boolean boolean1 = false;
	        try {
	Select select = new Select(SelectTypeElement); List<WebElement> options = select.getOptions(); for (WebElement option : options) {
	if (option.getText().equalsIgnoreCase(value))
	boolean1 = true;
	}
	             return boolean1;
	        } catch (NoSuchElementException e) {
	System.out.println("DropDown_FindOption: NoSuchElementException thrown");
	             return boolean1;
	        } catch (Exception e) {
	             e.printStackTrace();
	             return boolean1;
	        }
	}
	
	public static void funSwitchWin(WebDriver driver, String fValue) throws InterruptedException {
	//driver.switchTo().defaultContent(); 
		Thread.sleep(30);
	try {
	for (String Handle : driver.getWindowHandles())// 2 
		{
	String Title = driver.switchTo().window(Handle).getTitle();
	if (Title.equals(fValue)) { driver.switchTo().window(Handle); System.out.println("TestInfo : Successfully Switched to Window!" + Title);
	                        break;
	} }
	        } catch (Exception e) {
	             // TODO: handle exception
	//List<WebElement> ele = driver.findElements(By.xpath("abc"));
	             // ele.size()
	        }
	}
	
	public void testWebtable(WebElement tableElement, String data, WebDriver driver) {
	List<WebElement> tableRows = tableElement.findElements(By.tagName("tr"));
	        for (WebElement tableRow : tableRows) {
	             List<WebElement> tableColumns =
	tableRow.findElements(By.tagName("td"));
	for (WebElement tableColumn : tableColumns) {
	if (tableColumn.getText().equals(data)) { 
		JavascriptExecutor jse =(JavascriptExecutor) driver; 
		jse.executeScript("arguments[0].click();",tableColumn);
	}
	}
	        }
	}

	public static boolean webTableElementExist(WebElement tableElement, String data) {
	        boolean value = false;
	List<WebElement> tableRows = tableElement.findElements(By.tagName("tr"));
	for (WebElement tableRow : tableRows) {
	List<WebElement> tableColumns = tableRow.findElements(By.tagName("td"));
	for (WebElement tableColumn : tableColumns) {
	if (tableColumn.getText().contains(data)) {
	value = true;
	  return value;
	}
	}
	}
	        return value;
	  }

	public static boolean webTableHeaderExist(WebElement tableElement, String data) {
	        boolean value = false;
	List<WebElement> tableRows = tableElement.findElements(By.tagName("tr"));
	        for (WebElement tableRow : tableRows) {
	             List<WebElement> tableColumns =tableRow.findElements(By.tagName("th"));
	for (WebElement tableHeader : tableColumns) {
	if (tableHeader.getText().contains(data)) {
		    value = true;
	        return value;
	}
	}
	        }
	        return value;
	}
  
	public static boolean listElementExist(WebElement list, String data) {
	        boolean value = false;
	List<WebElement> listElements = list.findElements(By.tagName("li"));
	        for (WebElement element : listElements) {
	             if (element.getText().contains(data)) {
	value = true;
	                   return value;
	             }
	}
	        return value;
	  }
	
	public static boolean elementExist(List<WebElement> listElements, String data) {
		boolean value =false;
		for(WebElement element : listElements) {
			if(element.getText().contains(data)) {
				value =true;
				return value;
			}
			
		}
		return value;
	}
	
	public int testWebtable(WebElement tableElement) { int daysAvailable = 0;
	List<WebElement> tableRows =
	tableElement.findElements(By.tagName("tr"));
	for (WebElement tableRow : tableRows) {
	List<WebElement> tableColumns = tableRow.findElements(By.tagName("td"));
	             for (WebElement tableColumn : tableColumns) {
	                   if
	(!(tableColumn.getAttribute("class").contains("ui-state-disabled"))) if (tableColumn.getAttribute("data-handler").equalsIgnoreCase("selectDay")) { daysAvailable++;
	}
	} }
	        return daysAvailable;
	  }
	
	public WebElement testWebtablebyAttribute(WebElement tableElement, String data, String attribute, String tagName) {
	WebElement element = null;
	List<WebElement> tableRows = tableElement.findElements(By.tagName("tr"));
	        for (WebElement tableRow : tableRows) {
	             List<WebElement> tableColumns =
	tableRow.findElements(By.tagName("td"));
	for (WebElement tableColumn : tableColumns) {
	List<WebElement> tags = tableColumn.findElements(By.tagName(tagName));
	                   for (WebElement tag : tags) {
	                        if
	(tag.getAttribute(attribute).contains(data)) { element = tag;
	} }
	}
	  return element;
	}
	  return element;
	}
	
	public static int getTableSize(WebElement table) { List<WebElement> listElements =
	table.findElements(By.tagName("tr"));
	int size = listElements.size();
	        return size;
	  }
	public static List<WebElement> getTableElements(WebElement table) {
	List<WebElement> listElements = table.findElements(By.tagName("tr"));
	        return listElements;
	  }
	public static WebElement findRadioElement(WebDriver driver, String radioList, String value) {
	        WebElement radioButton = null;
	List<WebElement> radioButtons = driver.findElements(By.name(radioList));
	        int iSize = radioButtons.size();
	        for (int i = 0; i < iSize; i++) {
	String sValue = radioButtons.get(i).getAttribute("value");
	             if (sValue.equalsIgnoreCase(value)) {
	                   radioButton = radioButtons.get(i);
	                   break;
	} }
	        return radioButton;
	  }
	
	
	public static List<WebElement> getTableElement(WebElement table){
		List<WebElement> listElements =table.findElements(By.tagName("tr"));
		return listElements;
	}
	
	/*public static WebElement findRadioElement(WebDriver driver,String radioList,String value) {
		WebElement radioButton =null;
		List<WebElement> radioButtons =driver.findElements(By.name(radioList));
		int iSize = radioButton.getSize();
		for (int i =0; i<iSize ;i++) {
			String sValue =radioButtons.get(i).getAttribute(value);
			if(sValue.equalsIgnoreCase(value))) {
				radioButton =radioButton.get(i);
				break;
			}
		}

		return radioButton;
	}*/
	
	public static boolean verifyListElements(WebElement list, String value) {
	        List<WebElement> listElements =
	list.findElements(By.tagName("li"));
	        for (WebElement li : listElements) {
	             String chkbox = "No";
	             String lbl = "No";
	List<WebElement> input = li.findElements(By.tagName("input"));
	             for (WebElement checkbox : input) {
	                   if
	(checkbox.getAttribute("type").equalsIgnoreCase("checkbox")) ;
	if (checkbox.getAttribute("value").equalsIgnoreCase(value))
	                        ;
	                   chkbox = "Yes";
	}
	List<WebElement> label = li.findElements(By.tagName("label"));
	for (WebElement answer : label) {
	if (answer.getText().equalsIgnoreCase(value))
	lbl = "Yes";
	}
	             if (chkbox.equalsIgnoreCase("Yes") &&
	lbl.equalsIgnoreCase("Yes"))
	return true;
	}
	        return false;
	  }
	
	public String testWebtablerowData(WebElement tabElement, String attribute, String data) {
	        String rowData = null;
	List<WebElement> tableRows = tabElement.findElements(By.tagName("tr"));
	for (WebElement tablerow : tableRows) {
	if (tablerow.getAttribute(attribute).contains(data))
	                   rowData = tablerow.getText();
	}
	        return rowData;
	  }
	public WebElement testWebtablebyAttribute(WebElement tableRow, String data, String attribute) {
	        WebElement element = null;
	List<WebElement> tableColumns = tableRow.findElements(By.tagName("td"));
	        for (WebElement tableColumn : tableColumns) {
	             if
	(tableColumn.getAttribute(attribute).equalsIgnoreCase(data)) { element = tableColumn;
	                   return element;
	             }
	}
	        return element;
	  }
	
	public static WebElement getColumnData(WebElement tableRow, int columnNo) {
	        WebElement element = null;
	        int count = 0;
	        List<WebElement> tableColumns =
	tableRow.findElements(By.tagName("td"));
	for (WebElement tableColumn : tableColumns) {
	             count++;
	             if (count == columnNo) {
	                   element = tableColumn;
	                   return element;
	             }
	        }
	        // }
	        return element;
	}
	public static void wait(WebDriver driver, WebElement element, long waittime) {
	        try {
	             new WebDriverWait(driver,
	waittime).until(ExpectedConditions.visibilityOf(element));
	        } catch (Exception e) {
	             //e.printStackTrace();
	} }
	
	public static void waitToBeClickable(WebDriver driver, WebElement element, long waittime) {
	        try {
	             new WebDriverWait(driver,
	waittime).until(ExpectedConditions.elementToBeClickable(element)); } catch (Exception e) {
	             e.printStackTrace();
	        }
	}
	
	public static void highlighter(WebDriver driver, WebElement element) {
	final int wait = 1000;
	String orgStyle = element.getAttribute("style"); try {
	setStyle(driver, element, "style", "background-color: yellow; outline: 1px solid rgb(136, 255, 136);;");
	Thread.sleep(wait);
	setStyle(driver, element, "style", orgStyle);
	        } catch (InterruptedException e) {
	             e.printStackTrace();
	} }

	public static void setStyle(WebDriver driver, WebElement element, String attName, String value) {
	for (int i = 0; i < 3; i++) {
	JavascriptExecutor js = (JavascriptExecutor) driver; //
	//js.executeScript("arguments[0].setAttribute('style',//arguments[1]);",driver.findElement(Locator),
			// "color: red; border: 2px solid red;");
	js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, value);
	} }
	public static boolean existsElement(WebDriver driver, WebElement element) {
	        try {
	             element.isDisplayed();
	        } catch (NoSuchElementException e) {
	             return false;
	}
	        return true;
	  }
	
	public static void javaScripteExecutorClick(WebDriver driver, WebElement element) {
	try {
	JavascriptExecutor jse = (JavascriptExecutor) driver; jse.executeScript("arguments[0].click();", element);
	        } catch (Exception e) {
	             e.printStackTrace();
	} }
	
	//Added For Bhaskar--- *MIRAI specific------
	        //Commting this as he has some urgency
	//There is review required for using driver.quit // ********************************************** // Object Category: CLICK
	//Method Name :safeJavaScriptClick
	        // Parameter: WebElement
	        // Returns: null
	        // Purpose: To click on Web Element using JavaScriptExecutor click
	//**********************************************
	public static boolean safeJavaScriptClick(WebDriver driver, WebElement element) throws Exception {
	          try {
	                 WebDriverWait wait = new WebDriverWait(driver,180); 
	                 wait.until(ExpectedConditions.elementToBeClickable(element));
	} catch (Exception e) {
	System.out.println("INSIDE CATCH,Unable to get the element on UI");
	                //Assert.assertFalse("Verify_VisibleEnabled_Element: Element does NOT exist", true);
	}
	if (element.isEnabled() && element.isDisplayed()) {
	
	
	
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();",element);
	System.out.println("Clicked on element with using java script click");
	                 return true;
	          } else {
	System.out.println("Unable to click on element");
	//Assert.assertFalse("Verify_VisibleEnabled_Element: Element does NOT exist", true);
	                 return false;
	} }
	
	//********************************************** // Object Category: VERIFY
	//Method Name :funVerifyValue
	//Parameter: WebElement, String: Expected Value // Returns: null
	//Purpose: To verify whether required text(fValue), passed in feature file
	        // available or not
	//********************************************** 
	
	public static boolean funVerifyValue(WebDriver driver,
	WebElement element, String fValue) throws Exception { Thread.sleep(2000);
	String ActualTest = element.getText(); System.out.println("ActualTes==>" + ActualTest); System.out.println("ExpTes==>" + fValue);
	
	if (ActualTest.contains(fValue)) { System.out.println("TestInfo : Element Exists on Screen");
	    return true;
	} else {
	System.out.println("TestError : Element not Exists on Screen");
	//Assert.assertFalse("Verify_VisibleEnabled_Element: Element does NOT exist", true);
	                 return false;
	} }
	
	//********************************************** // Object Category: VERIFY
	//Method Name :funVerifyFals
	//Parameter: WebElement
	        // Returns: null
	//Purpose: To check a webelement should not be present on UI
	//********************************************** 
	
	public static boolean funVerifyFalse(WebDriver driver,WebElement element) throws InterruptedException {
	          WebElement elementFalse;
	          try {
	elementFalse = driver.findElement((By) element);
	          } catch (Exception e) {
	                 elementFalse = null;
	}
	if ((elementFalse != null) && (elementFalse.isEnabled() && elementFalse.isDisplayed())) {
	System.out.println("TestError : Element should not Exists on Screen but exist");
	//Assert.assertFalse("Verify_VisibleEnabled_Element: Element does NOT exist", true);
	         return false;
	} else {
	System.out.println("TestInfo : Element not Exists on Screen and its expected");
	         return true;
	} }
	
	public static boolean Verify_VisibleEnabled_Element(WebDriver driver,WebElement element) {
	
	try {
	WebDriverWait wait = new WebDriverWait(driver,180);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	if (!(element.equals(null))&& element.isDisplayed()){
	System.out.println("Verify_VisibleEnabled_Element: Element exist");
	return true;
	                  } else {
	System.out.println("Verify_VisibleEnabled_Element: Element does NOT exist");
	                  return false;
	                      }
	          }  catch (Exception e) {
	              e.printStackTrace();
	//Assert.assertFalse("Verify_VisibleEnabled_Element: Element does NOT exist", true);
	 return false;
	}
	}
}