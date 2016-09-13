public class IllFormedTransferStudent extends Exception {
	
	private static final long serialVersionUID = -6670770516998566992L;
	String reason;
	
	public IllFormedTransferStudent(String reason){
		this.reason = reason;
	}
	
	public String toString(){
		return ("ill formed section: " + reason);
	}
	
}
