package world.hkk.firstProject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Manage {
	DVD dvd[]=new DVD[50];
	int count=5;
	boolean stop=false;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date time=new Date();

	Manage(){
		dvd[0]=new DVD("黑暗骑士","48.8",true,"张三","2017-12-15",5);
		dvd[1]=new DVD("星际穿越","36.6",false,"  ","          ",1);
		dvd[2]=new DVD("敦刻尔克","59.8",true,"李四","2018-02-28",2);
		dvd[3]=new DVD("记忆碎片","37.5",false,"  ","          ",0);
		dvd[4]=new DVD("盗梦空间","45.9",false,"  ","          ",2);
	}
	void init(){//初始化主菜单
		System.out.println("\n------欢迎使用DVD管理系统------\n"
				+ "------------主菜单------------\n"
				+ "1,查看所有DVD\n2,查看已借出DVD\n3,查看未借出DVD\n4,"
				+ "删除DVD\n5,添加DVD\n6,租借DVD\n7,归还DVD\n8,DVD排行榜\n"
				+ "9,退出\n请选择对应的操作(1/2/3/4/5/6/7/8/9):");
	}
	int searchIndex(String name){//根据影片名查找下标
		int index=-1;
		for(int i=0;i<count;++i)if(dvd[i].getName().equals(name))index=i;
		return index;
	}
	void list(boolean special){//1,查看所有DVD
		System.out.println("\n影片\t\t\t价格\t\t状态\t\t借阅者\t借出日期\t\t借阅次数");
		for(int i=0;i<count;++i)dvd[i].showAll();
		if(special)isContinue();
	}
	void lendList(boolean special){//2,查看已借出DVD
		System.out.println("\n影片\t\t价格\t借阅者\t借出日期\t\t借阅次数");
		for(int i=0;i<count;++i)dvd[i].showOnlyIsLend();
		if(special)isContinue();
	}
	void notLendList(boolean special){//3,查看未借出DVD
		System.out.println("\n影片\t\t价格\t借阅次数");
		for(int i=0;i<count;++i)dvd[i].showOnlyNotLend();
		if(special)isContinue();
	}
	void delete(){//4,删除DVD
		System.out.println("------------删除DVD----------");
		boolean first=true;
		while(true){
			if(!first){
				System.out.println("DVD列表如下:");
				list(false);
				System.out.println("\n请参考此表输入:");
			}else System.out.println("请输入DVD影片名:");
			int index=searchIndex(input());
			if(index==-1){
				first=false;
				System.out.print("您输入的影片名不存在!");
				continue;
			}
			else if(dvd[index].isLend()){
				System.out.println("此DVD已被借出,仍要删除?(输入y确认)");
				if(input().equals("y")){
					for(int i=index;i<count-1;++i)dvd[i]=dvd[i+1];
					--count;
				}else {
					first=true;
					continue;
				}
			}else {
				for(int i=index;i<count-1;++i)dvd[i]=dvd[i+1];
				--count;
			}
			int tmp=miniMenu("删除");
			if(tmp==1){
				first=true;
				continue;
			}
			if(tmp==2)break;
			if(tmp==3)stop=true;break;
		}
	}
	void add(){//5,添加DVD
		System.out.println("------------添加DVD----------");
		boolean first=true;
		while(true){
			if(!first){
				System.out.println("DVD列表如下:");
				list(false);
				System.out.println("\n请参考此表输入:");
			}
			else System.out.println("请输入DVD影片名:");
			String name=input();
			int index=searchIndex(name);
			if(index!=-1){
				first=false;
				System.out.print("您要添加的DVD已存在!");
				continue;
			}
			System.out.println("请输入影片价格:");
			String price=input();
			++count;
			dvd[count-1]=new DVD(name,price);
			int tmp=miniMenu("添加");
			if(tmp==1){
				first=true;
				continue;
			}
			if(tmp==2)break;
			if(tmp==3)stop=true;break;
		}
	}
	void rent(){//6,租赁
		System.out.println("------------租赁DVD----------");
		boolean first=true;
		while(true){
			if(!first){
				notLendList(false);
				System.out.println("\n请参考此表输入影片名:");
			}
			else System.out.println("请输入DVD影片名:");
			String name=input();
			int index=searchIndex(name);
			if(index==-1){
				first=false;
				System.out.println("此影片不存在!以下为所有未借出DVD:");
				continue;
			}
			if(dvd[index].isLend()){
				first=false;
				System.out.println("操作失败!此影片已被出租!以下为所有未借出DVD:");
				continue;
			}
			System.out.println("请输入租赁者姓名:");
			dvd[index].setTenant(input());//租赁姓名
			dvd[index].setLend(true);//状态
			++dvd[index].rentTimes;//借阅次数
			dvd[index].setLendDate(sdf.format(time));//租赁时间
			int tmp=miniMenu("租赁");
			if(tmp==1){
				first=true;
				continue;
			}
			if(tmp==2)break;
			if(tmp==3)stop=true;break;
		}
	}
	void pay() throws Exception{//7,归还
		System.out.println("------------归还DVD----------");
		boolean first=true;
		while(true){
			if(!first){
				lendList(false);
				System.out.println("\n请参考此表输入影片名:");
			}
			else System.out.println("请输入DVD影片名:");
			int index=searchIndex(input());
			if(index==-1){
				first=false;
				System.out.println("此影片不存在!以下为所有借出DVD:");
				continue;
			}
			if(!dvd[index].isLend()){
				first=false;
				System.out.println("此影片未借出,无需归还!以下为所有借出DVD:");
				continue;
			}
			dvd[index].setLend(false);
			dvd[index].setTenant("  ");
			Date t=sdf.parse(dvd[index].getLendDate());//定义临时日期对象!!!!!!!!!!!!!!!!!!
			dvd[index].setLendDate("          ");
			long days=(time.getTime()-t.getTime())/(24*60*60*1000);
			System.out.println("租金为："+(days+1)+"元");
			int tmp=miniMenu("归还");
			if(tmp==1){
				first=true;
				continue;
			}
			if(tmp==2)break;
			if(tmp==3)stop=true;break;
		}
	}
	void rankList(){//8,排行榜
		int tmp[]=new int[count];
		for(int i=0;i<count;++i)tmp[i]=dvd[i].rentTimes;
		for(int i=1;i<=count-1;++i)for(int j=0;j<count-i;++j){
			if(tmp[j]==tmp[j+1])tmp[j+1]=-1;
			if(tmp[j]<tmp[j+1])tmp[j]=tmp[j]+tmp[j+1]-(tmp[j+1]=tmp[j]);
		}
		System.out.println("\n影片\t\t价格\t状态\t借阅者\t借出日期\t\t借阅次数");
		for(int i=0;i<count;++i)for(int j=0;j<count;++j)if(dvd[j].rentTimes==tmp[i])dvd[j].showAll();
		isContinue();
	}
	void isContinue(){//是否继续
		System.out.println("\n是否继续?(y/其他)");
		if(!input().equals("y")){
			System.out.println("\n----------系统已退出----------");
			stop=true;
		}
	}
	int miniMenu(String op){//小菜单
		System.out.println(op+"成功!");
		System.out.println("\n请输入您要继续进行的操作:");
		System.out.println("(1)继续"+op+"    (2)返回主菜单    (其他)退出系统");
		String menu=input();
		if(menu.equals("1"))return 1;
		else if(menu.equals("2"))return 2;
		else{
			System.out.println("\n----------系统已退出----------");
			stop=true;
		}return 3;
	}
	String input(){//输入语句
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		return sc.next();
	}
}
