package www.Snakegame.com;

public class Record {

   static void Allrecord(String[][] data,int index) {
	   for(int i=0;i<=index;i++) {
		   for(int j=0;j<=3;j++) {
			   System.out.print(data[i][j] +" ");
		   }
		   System.out.println();
	   }
	   
   }

}
