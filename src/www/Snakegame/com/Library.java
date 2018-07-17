package www.Snakegame.com;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.ResultSet;

public class Library {
	
	public Connection getconnection() throws SQLException {
		  Driver driver=new Driver();
		  String url="jdbc:mysql://127.0.0.1:3306/fisrt";
		  Properties info=new Properties();
		  info.put("user", "root");
		  info.put("password", "zhaoziqian");
		  Connection connection=(Connection) driver.connect(url, info);
		  return connection;
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
	//׷������
	public void insert_book(String name,String publishers,String author) throws SQLException {
		Connection connection=getconnection();
		
		String sql="insert into library(book_name,book_publishers,book_author)"
		+"values('"+ name + "','" + publishers + "','" + author +"')";
		 java.sql.Statement statement=connection.createStatement();
		 int rows=statement.executeUpdate(sql);
		 System.out.println("�ɹ�׷��" + rows + "������" );

	}
	//ɾ������
	public  void  delete(int id) throws SQLException {
		  
		Connection connection=getconnection();
	  
	  String sql="delete from library where id=" + id;
	  Statement statement=connection.createStatement();
	  int rows=statement.executeUpdate(sql);
	  System.out.println("�ɹ�ɾ��"+ rows + "������");
	  
	}
	
	//��������
	public  void  update_library( String bookname, int id) throws SQLException {
		   Connection conn=null;
		   Statement statement=null;
		
		  try {
		   conn=getconnection();
		 //����SQL����
		   String sql="update library set "+" book_name='" + bookname + "' where id= "+id+"";
		   statement=conn.createStatement();
		   int rows=statement.executeUpdate(sql);
		   System.out.println("�ɹ�����" +rows +"������");
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }finally {
		    close(conn,statement,null);
			  
		  }//�ر����ݿ�����
		  }
	
	//ģ����ѯ
    public void query_library(String namebook) throws SQLException {
		String[][] datas=new String[100][5];
		Connection connection=getconnection();
		Statement statement=null;
		java.sql.ResultSet resultset=null;
		int index=0;
		
		String sql="select * from library where book_name like '%" + namebook + "%' ";
		try {
		    statement=connection.createStatement();
		    resultset=statement.executeQuery(sql);
		
		while(resultset.next()) {
			int id=resultset.getInt("id");
			String name=resultset.getString("book_name");
			String publishers=resultset.getString("book_publishers");
			String author=resultset.getString("book_author");
			Date   date=resultset.getDate("date"); 
			
			datas[index][0]=String.valueOf(id);
		   	datas[index][1]=name;
		   	datas[index][2]=publishers;
		   	datas[index][3]=author;
		   	datas[index][4]=String.valueOf(date);   	
		    index++;				
		}
		
		LibraryRecord.Allrecord(datas, index);
		}catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	
	

	public static void main(String[] args) throws SQLException {
	     Library library=new Library();
	      @SuppressWarnings("resource")
		 Scanner input=new Scanner(System.in);
	      while(true) {
		  System.out.println("============================================================="); 
	      System.out.println("                                                           ͼ�����ϵͳ ");
	      System.out.println("                                                             ");
	      System.out.println("       1.��������     2.ɾ������    3.��������    4.��ѯ����  5.�˳�ϵͳ                    ");
		  System.out.println("============================================================="); 
	      System.out.print("��ѡ��ִ�еĲ�������");
          int chooice=input.nextInt();
          while(chooice< 1 || chooice >5){
			  System.out.print("���������ڣ�������ѡ��");
			  chooice=input.nextInt();
		  }
          
	      if(chooice==1) {
	      System.out.print("����������");
		  String name1 = input.next();
		  System.out.print("�����������");
		  String publishers1 = input.next();
		  System.out.print("����������");
		  String author1 = input.next();
		  library.insert_book(name1, publishers1, author1);	
	      }
	      
	      if(chooice==2) {
		  System.out.print("������ɾ�����ݵ�id");
          int id=input.nextInt();
          library.delete(id);
	      }
	      
	      if(chooice==3) {
	    	  System.out.print("���������������ֵ");
			  String bookname = input.next();
			  System.out.print("������������ݵ�id");
			  int id=input.nextInt();
			  library.update_library(bookname, id);
	      }
	      
	      if(chooice==4) {
	    	  System.out.print("�������ѯ������");
			  String name = input.next(); 
			  library.query_library(name);  
	      }
	      else{
	    	  System.out.print("�����˳�ϵͳ������");
	    	  System.exit(0);
	      }
	      
	     }
	}

}
