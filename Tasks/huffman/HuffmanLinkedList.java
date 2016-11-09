import java.util.LinkedList;
import java.util.ListIterator;

@SuppressWarnings("serial")
public class HuffmanLinkedList extends LinkedList<BinaryNode<HuffmanData>> {

	public HuffmanLinkedList() {
		super();
	}
	
	public boolean add(HuffmanData data) {
		return add(new BinaryNode<HuffmanData>(data));
	}
	
	@Override
	public boolean add(BinaryNode<HuffmanData> newNode) {
		
		if (size() == 0) {
			super.add(newNode);
			return true;
		}

		BinaryNode<HuffmanData> curNode = null;
		ListIterator<BinaryNode<HuffmanData>> listIterator = listIterator();

		while(listIterator.hasNext()) {
			curNode = listIterator.next();
			if (curNode.compareTo(newNode) >= 0) {
				int index = indexOf(curNode);
				add(index, newNode);
				return true;
			}
		}

		addLast(newNode);	
		
		return true;
	}
}

