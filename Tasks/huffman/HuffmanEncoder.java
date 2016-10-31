
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HuffmanEncoder {

	private static final Boolean DEBUG = true;
	
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
		return null;
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
		return null;
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
		return null;
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
