package craft.cla.utills;

public enum EndPointURL {
	
	Argentina("/Prices?ticker=BASMNYARA189N");
	
	String endPointUrl;
	
	EndPointURL(String rp){
		this.endPointUrl = rp;
	}
	
	public String getResourcePath(){
		return this.endPointUrl;
	}
	
	public String getResourcePath(String data){
		return this.endPointUrl+data;
	}
}
