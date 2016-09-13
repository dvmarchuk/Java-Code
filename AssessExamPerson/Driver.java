import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Driver {
	public static void main(String[] args){
		TransferStudent t1, t2;


		try{
			t1 = new TransferStudent("John", "Doe", "Computer Science", 24);

			t2 = new TransferStudent("Kim", "Brown", "Computer Science", 27);

		}catch (IllFormedTransferStudent e){
			System.out.println(e.toString());
			return;
		}


		TransferStudent[] students = {t1, t2};
		writeStudents("students.txt", students);




	}
	
	
	private static void writeStudents(String students, TransferStudent[] students){
		PrintWriter writer;

		try{
			writer = new PrintWriter("students.txt", students);
		}catch (FileNotFoundException | UnsupportedEncodingException e){
			e.printStackTrace();
			return;
		}

		for(int i = 0; i< students.length; i++){
			writeStudents ws = students[i];
			writer.println(ws.getFirstName() + " " + ws.getLastName() + " " + ws.getMajor + " " + ws.getNumTransferCredits);

		}
		writer.close();
	}

}
