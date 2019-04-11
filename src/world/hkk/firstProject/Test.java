package world.hkk.firstProject;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Manage m=new Manage();
		while(true){
			
			m.init();
			String menu=m.input();
			switch(menu){
			case "1":m.list(true);break;
			case "2":m.lendList(true);break; 
			case "3":m.notLendList(true);break;
			case "4":m.delete();break;
			case "5":m.add();break;
			case "6":m.rent();break;
			case "7":m.pay();break;
			case "8":m.rankList();break;
			case "9":
				System.out.println("\n----------系统已退出----------");
				m.stop=true;break;
			default:System.out.println("您的输入有误!\n");continue;
			}
			if(m.stop)break;
		}
	}

}
