
public class HuffmanData implements Comparable<HuffmanData> {
	private int symbol;
	private int frequency;
	
	public HuffmanData(int symbol, int frequency) {
		this.symbol = symbol;
		this.frequency = frequency;
	}
	
	public int getSymbol() {
		return symbol;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public String toString() {
		return symbol + "-" + frequency;
	}

	@Override
	public int compareTo(HuffmanData data) {
		if (this.frequency == data.getFrequency())
			return 0;
		else if (this.frequency < data.getFrequency())
			return -1;
		else
			return 1;
	}
	
	public boolean equals(HuffmanData data) {
		if (this.frequency == data.getFrequency())
			return true;
		else
			return false;
	}
	
}
