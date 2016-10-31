
public class Driver {

	public static void main(String[] args) {
		try{
			HuffmanEncoder.encode("original.txt", "encoding.txt", "code.serialized");
			System.out.println("Finished encoding file.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}