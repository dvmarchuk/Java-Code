public class TransferStudent extends Student {

	int numTransferCredits;

	public TransferStudent (String f, String l, String m, int n){
		throws IllFormedTransferStudent;


		super (f, l, m);
		numTransferCredits = n;

		if(f==null || l == null || m == null){
			throw new IllFormedTransferStudent("null");
		}
	}

	int getNumTransferCredits(){
		return numTransferCredits;
	}
}
