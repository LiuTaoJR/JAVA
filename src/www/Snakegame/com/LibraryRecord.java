package www.Snakegame.com;

public class LibraryRecord {
	static void Allrecord(String[][] data,int index) {
		   for(int i=0;i<=index;i++) {
			   for(int j=0;j<=4;j++) {
				   System.out.print(data[i][j] +" ");
			   }
			   System.out.println();
		   }
		   
	   }

}
