import java.io.IOException;




public class Driver {

	public static void main(String[] args) {

		try {
			HuffmanEncoder.encode("original.txt", "encoding.txt", "code.serialized");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Finished encoding file.");
	}

}
