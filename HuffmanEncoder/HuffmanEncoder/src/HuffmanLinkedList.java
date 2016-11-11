import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
@SuppressWarnings({ "serial", "unused" })

public class HuffmanLinkedList extends LinkedList <BinaryNode <HuffmanData>>{

	public HuffmanLinkedList(){
		super();
	} 

	@SuppressWarnings({ "unchecked" })
	public boolean add(HuffmanData data){//that takes huffmanData objects and inserts them in order according to frequency

		if(super.size() == 0){
			BinaryNode<HuffmanData> binN = new BinaryNode<HuffmanData>(data);
			super.add(binN);
			return true;
		}

		Iterator<BinaryNode <HuffmanData>> iterator = super.iterator();
		BinaryNode<HuffmanData> nextData = iterator.next();


		while(iterator.hasNext() == true){
			BinaryNode<HuffmanData> currentNode = iterator.next();//set the current node equal to the iterators next element
			//TODO
			if (currentNode.getData().getFrequency() > data.getFrequency()){				//if the current node's frequency is greater than the data's frequency
				int getIndex = super.indexOf(currentNode);					//1. get the index of the current node in the linked list
				BinaryNode<HuffmanData> nBinaryN = currentNode;					//2. Create a new BinaryNode to hold the data
				super.add(getIndex, nBinaryN);					//3. Add the new BinaryNode at the index of the currentNode
				return true;
			}


		}

		//if the data's frequency is greater than all nodes in the ilnkedList 
		@SuppressWarnings("rawtypes")
		BinaryNode binN = new BinaryNode(data);
		super.add(binN);
		//add a new BinaryNode with the data to the end of the list


		return true;

	}



}