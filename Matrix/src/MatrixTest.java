public class MatrixTest {
	

	public static void main(String[] args) throws Exception {
		tests();
	}

	static void tests() throws Exception {

		Matrix<Integer> m1 = new Matrix<>();
			
		m1.init(5, 5);
		m1.add(3, 1, 1);
		m1.elementAt(2,2);
		m1.add(1, 2, 2);
		m1.remove(3, 1);
		m1.size();
		
	}
	
}
