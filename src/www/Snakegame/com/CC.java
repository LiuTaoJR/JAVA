package www.Snakegame.com;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.ResultSet;

public class CC {
	 Scanner input=new Scanner(System.in); 
	//�������ݿ����ӵķ���
	public Connection getConnection() throws SQLException {
		  Driver driver=new Driver();
		  String url="jdbc:mysql://127.0.0.1:3306/fisrt";
		  Properties info=new Properties();
		  info.put("user", "root");
		  info.put("password", "zhaoziqian");
		  Connection conn=(Connection) driver.connect(url, info);
		  return conn;
		
	}
	
	//�ر����ݿ����ӵķ���
	public void close(Connection conn, Statement state,ResultSet result) {
		try {
			
			 if(conn !=null) {
				  conn.close();
			  }
			  if(state !=null) {
				  state.close();
			  }
			  if(result !=null) {
				  result.close();
			  }
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }
		
	}
     
	//ɾ������
	public  void  delete(int id) throws SQLException {
	  
		Connection conn=getConnection();
	  
	  //����SQL����
	  String sql="delete from account where id=" + id;
	  Statement statement=conn.createStatement();
	  int rows=statement.executeUpdate(sql);
	  System.out.println("�ɹ�ɾ��"+ rows + "������");
	}
	
	//��������
	public  void  update( String password1, int id) throws SQLException {
		   Connection conn=null;
		   Statement statement=null;
		
		  try {
		   conn=getConnection();
		 //����SQL����
		   String sql="update account set "+" user_password='" + password1 + "' where id= "+id+"";
		   statement=conn.createStatement();
		   int rows=statement.executeUpdate(sql);
		   System.out.println("�ɹ�����" +rows +"������");
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }finally {
		    close(conn,statement,null);
			  
		  }//�ر����ݿ�����
		  }
	
		
	 //��������
	public  void  insert(String user_account, String user_password ) throws SQLException {
		  
		  Connection conn=getConnection();
	 
		  String sql=" insert into account(user_account,user_password)" +  
		  "values('" + user_account + "','" +user_password +"')";
		  Statement statement=conn.createStatement();
		  int rows=statement.executeUpdate(sql);
		  System.out.println("�ɹ�׷��" + rows + "������" );
		}
	
	
	//ģ����ѯ����
	public void query(String id2) throws SQLException {
		
		Connection conn=getConnection();
		
		String sql="select id,user_account,user_password from account where user_account like '%" + id2 + "%' ";
		Statement statement=conn.createStatement();
		java.sql.ResultSet resultset=statement.executeQuery(sql);
		StringBuffer buffer =new StringBuffer();
		
		while(resultset.next()) {
			int id=resultset.getInt("id");
			String account=resultset.getString("user_account");
			String password=resultset.getString("user_password");
			buffer.append(id +"\t|" + account +"|\t"+password+"|"+System.lineSeparator());			
		}
		System.out.println(buffer.toString());
	}
	
	//��ʾ��������
	
	public void alldata() throws SQLException {
		Connection conn=getConnection();
		String[][] data=new String[100][4];
		Statement statement=null;
		java.sql.ResultSet resultset=null;
		int index=0;
		
		String sql="select * from account  ";
        try {
		statement=conn.createStatement();
		resultset=statement.executeQuery(sql);
		
		
		while(resultset.next()) {
			int    id=resultset.getInt("id");
			String all_account=resultset.getString("user_account");
			String all_password=resultset.getString("user_password");
			Date   all_date=resultset.getDate("date");
		   	data[index][0]=String.valueOf(id);
		   	data[index][1]=all_account;
		   	data[index][2]=all_password;
		   	data[index][3]=String.valueOf(all_date);   	
		    index++;
        }
		Record.Allrecord(data, index);
        }catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	
	//�û���¼�ж�
	public void alod() throws SQLException {
		Connection conn=getConnection();
		boolean a=true;
	    int b=0;
		while(a) {
		  if(b==1) {
			  System.out.println("");
			  System.out.print("���û������ڣ�����������");
		  }
		  System.out.print("�������û���");
		  String uu = input.next();
		  System.out.print("����������");
		  String pp = input.next();
		String sql="select * from account where user_account='"+ uu +"' and user_password='"+ pp +"' ";
		Statement statement=conn.createStatement();
		java.sql.ResultSet resultset=statement.executeQuery(sql);
	  if(resultset.next()) {
		  if(resultset.getString("user_account").equals(uu) && resultset.getString("user_password").equals(pp)) {
			  a=false;
		  }
		  else {
			  b=1;
			  a=true;
			  
		  }
	  }
		}
	}

	
	//������
	public static void main(String[] args) throws SQLException {
		  CC cc=new CC();
		  @SuppressWarnings("resource")
		  Scanner input=new Scanner(System.in);
		  System.out.println("=========================================================");
		  System.out.println("              Los Angeles Lakers����ϵͳ");
		  System.out.println("");
		  System.out.println("              1.��¼          2.ע��         3.�˳�     ");
		  System.out.println("=========================================================");
		  System.out.print("��ѡ�����Ĳ���");
		  int A=input.nextInt();
		  while(A< 1 || A >3){
			  System.out.print("���������ڣ�������ѡ��");
			  A=input.nextInt();
		  }if(A==1) {
			  cc.alod();
			  }
		  
		  
		 while(true) {
		  System.out.println("=========================================================");
		  System.out.println("                                      ��ӭʹ��Lakers����ϵͳ");
		  System.out.println("");
		  System.out.println("  1.�������     2.��������     3.ɾ������     4.�˳�ϵͳ     5.��ʾ��������   ");
		  System.out.println("=========================================================");
		  System.out.print("��ѡ�����Ĳ���");
		  int select=input.nextInt();
		  while(select< 1 || select >5){
			  System.out.print("���������ڣ�������ѡ��");
			  select=input.nextInt();
		  }
		  if(select==1) {
			  System.out.println("");
			  System.out.println("==========================�������=========================");
			  System.out.print("�������û���");
			  String use = input.next();
			  System.out.print("����������");
			  String passwor = input.next();
			  cc.insert(use, passwor);		  
		  }
		  else if(select==2) {
			  System.out.println("");
			  System.out.println("==========================��������=========================");
			  System.out.print("������setֵ");
			  String password1 = input.next();
			  System.out.print("������������ݵ�id");
			  int password2 = input.nextInt();
			  cc.update(password1, password2);
		  }
		  else if(select==3) {
			  System.out.println("");
			  System.out.println("==========================ɾ������=========================");
			  System.out.print("������Ҫɾ�����ݵ�id");
			  int id=input.nextInt();
			  cc.delete(id);		  
		  }
		  else if(select==4) {
			  System.out.print("������Ҫ��ѯ���û���");
			  String id2 = input.next();
			  cc.query(id2);
		  }
		  else {
			  System.out.println("");
			  System.out.println("==========================��ʾ��������======================");
		      cc.alldata();
		  }	 
	   }
	}
}
