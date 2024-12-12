package pack.model;

public class Package {
	private int packageId;
	private String packageName;
	private double packagePrice;
	
	public Package(int packageId, String packageName, double packagePrice) {
		this.packageId = packageId;
        this.packageName = packageName;
        this.packagePrice = packagePrice;
	}
	public int getpackageId() {
		return packageId;
	}
	public void setpackageId(int packageId) {
		this.packageId = packageId;
	}
	
	public String getpackageName() {
		return packageName;
	}
	public void setpackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public double getpackagePrice() {
		return packagePrice;
	}
	public void setpackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}
	
	
}
