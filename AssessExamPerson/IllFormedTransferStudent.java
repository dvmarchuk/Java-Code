public class IllFormedTransferStudent extends Exception {
	
	String reason;
	
	public IllFormedTransferStudent(String reason){
		this.reason = reason;
	}
	
	public String toString(){
		return ("ill formed section: " + reason);
	}
	
}
