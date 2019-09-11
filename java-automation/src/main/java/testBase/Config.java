package testBase;

import java.util.Properties;

public class Config extends TestBase{
	
	public Properties OR;
	public Config(Properties OR){
		System.out.println("I am here 3");
		this.OR= OR;
		System.out.println("I am here 4");
	}
	
	public String getUsername(){
		return OR.getProperty("username");
	}
	
	public String getPassword(){
		return OR.getProperty("password");
	}
	
	public String getURL(){
		return OR.getProperty("url");
	}
	
	public String getBrowser(){
		return OR.getProperty("browser");
	}

}
