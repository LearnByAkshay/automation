package craft.cla.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VerifyBaseMoney {

	@SerializedName("internalId")
	@Expose
	private String internalId;
	@SerializedName("ticker")
	@Expose
	private String ticker;
	@SerializedName("date")
	@Expose
	private String date;
	@SerializedName("value")
	@Expose
	private Double value;

	public String getInternalId() {
//	System.out.println(" "+internalId);
		return internalId;
	
	}

	public void setInternalId(String internalId) {
	this.internalId = internalId;
	}

	public String getTicker() {
	return ticker;
	}

	public void setTicker(String ticker) {
	this.ticker = ticker;
	}

	public String getDate() {
	return date;
	}

	public void setDate(String date) {
	this.date = date;
	}

	public Double getValue() {
	return value;
	}

	public void setValue(Double value) {
	this.value = value;
	}

}
