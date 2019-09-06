import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class lab1 {
	private static Scanner inFile;
	public static void main(String[] args) {
		 lab1 a = new lab1();  
		 	a.openFile();
	        a.readFile();
	        a.closeFile();
	    

	}
	
	public void openFile(){
		try{
		inFile = new Scanner(Paths.get("C:\\Users\\Marty\\Desktop\\events.txt"));
		}catch (Exception e) {
			System.out.println("Could not open file.... " + inFile + " exiting ");
		}
		
	}
	public void readFile(){		 
			int type = 0;
		
			while (inFile.hasNext()) {
				type = inFile.nextInt();
				System.out.print("type : " + type + "  " +
				 "month : " + inFile.nextInt() + "  " +
				 "day : " + inFile.nextInt() + "  " +
				 "year : " + inFile.nextInt() + "  " +
				 "hour : " + inFile.nextInt() + "  "  +
				 "minute : " + inFile.nextInt() + "  "  +
				 "description : " + inFile.next() + "  ");
				if (type == 1 || type == 3)
					System.out.print("extra : " + inFile.next() + "  ");
				else
					System.out.print("extra:");
				System.out.println();
			}

			
	
	}
	// write closeFile
	public void closeFile() 
	{
		if (inFile != null)
			inFile.close();
	}

	
	
}