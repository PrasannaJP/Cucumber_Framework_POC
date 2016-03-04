package com.webuitests.pages;

import com.webuiframework.oua.uitests.control.Element;
import com.webuiframework.oua.uitests.control.Input;
import com.webuiframework.oua.uitests.panel.BasePanel;

public class AdministratorLoginPage extends BasePanel<AdministratorLoginPage> {
	
	private static AdministratorLoginPage administratorLoginPage;
	
	public static String userinputXpath = "//div[contains(@class,'username')]/input";
	public static String passwordinputXpath = "//div[contains(@class,'password')]/input";
	public static String signininputXpath = "//div[contains(@class,'user')]/a";
	public static String loginbuttontypeXpath = "//button[@type='submit']";
	public static String signinbuttontypeXpath = "//input[@type='submit']";
	public static String adminusernameXpath = "//input[contains(@id,'user')]";
	public static String adminpwdXpath = "//input[contains(@id,'pass')]";
	
	
	 public final Input<AdministratorLoginPage> usernameinput = new Input<AdministratorLoginPage>("textfield", userinputXpath,"xpath", this);
	 public final Input<AdministratorLoginPage> passwordinput = new Input<AdministratorLoginPage>("textfield", passwordinputXpath,"xpath", this);
	 public final Input<AdministratorLoginPage> loginButton = new Input<AdministratorLoginPage>("button", loginbuttontypeXpath,"xpath", this);
	 public final Element<AdministratorLoginPage> SignIninput = new Element<AdministratorLoginPage>("class", signininputXpath,"xpath", this);
	 public final Input<AdministratorLoginPage> signinbuttontype = new Input<AdministratorLoginPage>("button", signinbuttontypeXpath,"xpath", this);
	 public final Input<AdministratorLoginPage> AdminUserName = new Input<AdministratorLoginPage>("textfield", adminusernameXpath,"xpath", this);
	 public final Input<AdministratorLoginPage> AdminPwd = new Input<AdministratorLoginPage>("textfield", adminpwdXpath,"xpath", this);
	 
	 public static AdministratorLoginPage get() {
	        if (administratorLoginPage == null) {
	        	administratorLoginPage = new AdministratorLoginPage();
	        }
	        return administratorLoginPage;
	    }
	
	

}