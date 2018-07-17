package www.Snakegame.com;

import java.sql.SQLException;
import java.util.Scanner;

public class DD {
	CC cc=new CC();
	Scanner input=new Scanner(System.in); 

	
	public void ShowInsert() throws SQLException {
		  System.out.println("");
		  System.out.println("==================添加数据=====================");		  
		  System.out.println("请输入用户名");
		  String user = input.next();
		  System.out.println("请输入密码");
		  String password = input.next();
		  cc.insert(user, password);
		  
	 }
	
	public void ShowUpdate() throws SQLException {
		  System.out.println("");
		  System.out.println("==================添加数据=====================");		  
		  System.out.println("请输入用户名");
		  String user = input.next();
		  System.out.println("请输入密码");
		  String password = input.next();
		  cc.insert(user, password);
		  
	 }
	
	   

}
