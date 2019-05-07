package world.hkk.firstProject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static world.hkk.firstProject.FormatUtil.*;

public class DVD {

	public class TitleEntry{
		private String title;
		private String value;
		private boolean leftTable;

		public TitleEntry(String title, String value, boolean leftTable) {
			this.title = title;
			this.value = value;
			this.leftTable = leftTable;
		}

		public boolean isLeftTable() {
			return leftTable;
		}

		public void setLeftTable(boolean leftTable) {
			this.leftTable = leftTable;
		}


		public TitleEntry(String title, String value) {
			this.title = title;
			this.value = value;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
	
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
		Map<String,String> map = new HashMap<>();
		List<TitleEntry> titleEntries = new ArrayList<>();
		titleEntries.add(new TitleEntry(MOVIE_NAME,name));
		titleEntries.add(new TitleEntry(PRICE_NAME,price));
		titleEntries.add(new TitleEntry(IS_LEND_NAME,isLend?"已借出":"未借出"));
		titleEntries.add(new TitleEntry(TENANT_NAME,tenant));
		titleEntries.add(new TitleEntry(LEND_DATE_NAME,lendDate));
		titleEntries.add(new TitleEntry(RENT_TIMES_NAME,String.valueOf(rentTimes),true));
		printFormatTitleEntries(titleEntries);
		System.out.println();
//		System.out.println(name+(name.length()>4?"\t":"\t\t")+price+"\t"
//			+(isLend?"已借出\t":"未借出\t")+tenant+"\t\t"+lendDate+"\t"+rentTimes+"次");
	}
	void showOnlyIsLend(){
		if(isLend){
			Map<String,String> map = new HashMap<>();
			List<TitleEntry> titleEntries = new ArrayList<>();
			titleEntries.add(new TitleEntry(MOVIE_NAME,name));
			titleEntries.add(new TitleEntry(PRICE_NAME,price));
			titleEntries.add(new TitleEntry(TENANT_NAME,tenant));
			titleEntries.add(new TitleEntry(LEND_DATE_NAME,lendDate));
			titleEntries.add(new TitleEntry(RENT_TIMES_NAME,rentTimes + "",true));
			printFormatTitleEntries(titleEntries);
			System.out.println();
		}
//			System.out.println(name+(name.length()>4?"\t":"\t\t")+price+"\t"+tenant+"\t"+lendDate+"\t"+rentTimes+"次");
	}
	void showOnlyNotLend(){
		if(!isLend){
			Map<String,String> map = new HashMap<>();
			List<TitleEntry> titleEntries = new ArrayList<>();
			titleEntries.add(new TitleEntry(MOVIE_NAME,name));
			titleEntries.add(new TitleEntry(PRICE_NAME,price));
			titleEntries.add(new TitleEntry(RENT_TIMES_NAME,"" + rentTimes,true));
			printFormatTitleEntries(titleEntries);
			System.out.println();
		}
//			System.out.println(name+(name.length()>4?"\t":"\t\t")+price+"\t"+rentTimes+"次");
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