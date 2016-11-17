import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HuffmanEncoder {

	private static final Boolean DEBUG = true;
	private static final int ETX_SYM = 3;
	
	public static void 
	encode(String inFileName, String outFileName, String codeFile) throws IOException 
	{
		Map<Integer, Integer> symbolTable = createSymbolTable(inFileName);
		HuffmanLinkedList nodeList = createNodeList(symbolTable);
		BinaryNode<HuffmanData> rootNode = createHuffmanTree(nodeList);
		Map<Integer, String> huffmanCodeMap = createHuffmanCodeMap(rootNode);
		writeSerializedHuffmanCodeToFile(codeFile, huffmanCodeMap);
		encodeFile(inFileName, outFileName, huffmanCodeMap);
		return;
	}

	/************************** createSymbolTable() **************************
	 * Construct a HashMap (char symbol, int frequency) of key,value pairs.
	 * For each symbols in a file, if the symbol has not been seen before
	 * add it to the HashMap and set its frequency to 1, otherwise increment
	 * the symbols frequency in the HashMap.  
	 * @throws IOException 
	 *************************************************************************/

	private static Map<Integer, Integer> 
	createSymbolTable(String file) throws IOException
	{
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		BufferedReader is = new BufferedReader(new FileReader(file));
		int symbol;
		int frequency;

		while ((symbol = is.read()) != -1) {
			if (map.containsKey(symbol)) {
				frequency = map.get(symbol);
				map.put(symbol, ++frequency);
			}
			else {
				map.put(symbol, 1);
			}
		}
		
		// Add end-of-text symbol to table
		map.put(ETX_SYM, 1);
		
		if (DEBUG) {
			System.out.println("Symbol Table: ");
			System.out.println(map.toString());
		}

		is.close();
		return map;
	}
	/*************************** createNodeList() ****** **********************
	 * Create a LinkedList of BinaryNodes where each Node contains 
	 * a symbol and a frequency field. 
	 * For each (symbol, frequency) in the HashMap add a new BinaryNode
	 * to the LinkedList while keeping the list sorted in increasing order
	 * according to frequency. 
	 **************************************************************************/

	private static HuffmanLinkedList 
	createNodeList(Map<Integer, Integer> map) 
	{
		HuffmanLinkedList nodeList = new HuffmanLinkedList ();

		Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> setIterator = set.iterator();

		Entry<Integer, Integer> e = null;
		HuffmanData data = null;

		while(setIterator.hasNext()) {
			e = setIterator.next();
			data = new HuffmanData(e.getKey(), e.getValue());
			nodeList.add(data);
		}

		if (DEBUG) {
			System.out.println("Huffman Sorted Linked List: ");
			Iterator<BinaryNode<HuffmanData>> it = nodeList.iterator();
			while (it.hasNext()) {
				System.out.print(it.next().getData().toString() + " ");
			}
			System.out.println();
		}

		return nodeList;
	}

	/************************* createHuffmanTree() *****************************
	 * While the LinkedList has more than 1 BinaryNode, create a new BinaryNode 
	 * with frequency equal to the sum of the frequencies of the top two Nodes in
	 * the list.  Set the left child equal to the top Node and remove the top Node from 
	 * the list. Then set the right child equal to the new top Node and remove the top 
	 * Node from the list.  Insert the new Node into the sorted LinkedList while 
	 * maintaining its sortedness.
	 ***************************************************************************/

	private static BinaryNode<HuffmanData> 
	createHuffmanTree(HuffmanLinkedList nodeList) 
	{
		BinaryNode<HuffmanData> node1 = null;
		BinaryNode<HuffmanData> node2 = null;
		BinaryNode<HuffmanData> newNode = null;
		int newFrequency = 0;

		while(nodeList.size() > 1) {
			node1 = nodeList.pop();
			node2 = nodeList.pop();
			newFrequency = node1.getData().getFrequency() + node2.getData().getFrequency();
			newNode = new BinaryNode<HuffmanData>(new HuffmanData(0, newFrequency));
			newNode.setLeftChild(node1);
			newNode.setRightChild(node2);
			nodeList.add(newNode);
		}
		
		if (DEBUG) {
			depthFirstSearch(newNode);
		}

		return newNode; 
	}

	private static void depthFirstSearch(BinaryNode<HuffmanData> node) 
	{
		if (node.getLeftChild() == null && node.getRightChild() == null)
			System.out.printf("%d ^ ", node.getData().getSymbol());
		else {
			if (node.getLeftChild() != null) {
				System.out.printf("< ");
				depthFirstSearch(node.getLeftChild());
			}
			if (node.getRightChild() != null) {
				System.out.printf("> ");
				depthFirstSearch(node.getRightChild());
			}
			System.out.printf("^ ");
		}
	}


	/************************ createHuffmanCodeMap() ****************************
	 * Traverse the Huffman Tree using a Depth First Search while maintaining a
	 * String that represents the path from the root. If descending a left branch
	 * concatenate a '0' to the string, if descending a right branch concatenate
	 * a '1' to the string, and if ascending remove the last character. When you
	 * visit a leaf, add (symbol,code) to the HashMap where symbol is the
	 * symbol stored in the leaf Node and code is the String that was constructed
	 * while traversing the Tree.
	 ****************************************************************************/

	private static Map<Integer, String>
	createHuffmanCodeMap(BinaryNode<HuffmanData> rootNode)
	{
		return null;
	}

	/****************** writeSerializedHuffmanCodeToFile() **********************
	 * Write the huffman code HashMap as a serialized object to an output file
	 ****************************************************************************/

	private static void
	writeSerializedHuffmanCodeToFile(String fileName, Map<Integer, String> huffmanCodeMap) 

	{
		return;
	}

	/***************************** encodeFile() *********************************
	 * While reading each symbol of the input file, output the code associated 
	 * with the symbol that is stored the code HashMap.
	 ****************************************************************************/

	private static void 
	encodeFile(String inFileName, String outFileName, Map<Integer, String> huffmanCodeMap) 

	{
		return;
	}

}
