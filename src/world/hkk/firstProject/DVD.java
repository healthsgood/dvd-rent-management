package world.hkk.firstProject;
public class DVD {
	
	private String name;
	private String price;
	private boolean isLend=false;
	private String tenant="  ";
	private String lendDate="          ";
	int rentTimes=0;
	DVD(String name,String price,boolean isLend,String tenant,String lendDate,int rentTimes){
		this.name=name;
		this.price=price;
		this.isLend=isLend;
		this.tenant=tenant;
		this.rentTimes=rentTimes;
		this.lendDate=lendDate;
	}
	DVD(String name,String price){
		this.name=name;
		this.price=price;
	}
	DVD(){}
	void showAll(){
		System.out.println(name+(name.length()>4?"\t":"\t\t")+price+"\t"
			+(isLend?"已借出\t":"未借出\t")+tenant+"\t\t"+lendDate+"\t"+rentTimes+"次");
	}
	void showOnlyIsLend(){
		if(isLend)
			System.out.println(name+(name.length()>4?"\t":"\t\t")+price+"\t"+tenant+"\t"+lendDate+"\t"+rentTimes+"次");
	}
	void showOnlyNotLend(){
		if(!isLend)
			System.out.println(name+(name.length()>4?"\t":"\t\t")+price+"\t"+rentTimes+"次");
	}
	public String getName() {
		return name;
	}
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	public String getLendDate() {
		return lendDate;
	}
	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isLend() {
		return isLend;
	}
	public void setLend(boolean isLend) {
		this.isLend = isLend;
	}
	
}