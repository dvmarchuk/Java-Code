public class HuffmanData {
	private int symbol;
	private int frequency;

	public HuffmanData(int symbol, int frequency){
		this.symbol = symbol;
		this.frequency = frequency; 
	}
	
	public int getSymbol(){
		return symbol;
	}
	public int getFrequency(){
		return frequency; 
	}
	@Override
	public String toString(){
		return symbol + "-" + frequency; 
	}

}
