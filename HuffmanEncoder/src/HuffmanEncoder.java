import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;


@SuppressWarnings("serial")
public class HuffmanEncoder {

	private static final Boolean DEBUG = true;
	private static final int EOT_SYM = 3;

	public static void encode(String inFileName, String outFileName, String codeFile) throws IOException {

		Map<Integer, Integer> symbolTable = createSymbolTable(inFileName); 
		HuffmanLinkedList nodeList = createNodeList(symbolTable); 
		BinaryNode<HuffmanData> rootNode = createHuffmanTree(nodeList); 
		Map<Integer, String> huffmanCodeMap = createHuffmanCodeMap(rootNode); 
		writeSerializedHuffmanCodeToFile(codeFile, huffmanCodeMap); 
		encodeFile(inFileName, outFileName, huffmanCodeMap);
		return; 

	}



	private static HuffmanLinkedList createNodeList(Map<Integer, Integer> map){
		return null;
	}

	private static BinaryNode<HuffmanData> createHuffmanTree (HuffmanLinkedList nodeList){
		return null;
	}

	private static Map<Integer, String> createHuffmanCodeMap (BinaryNode <HuffmanData> rootNode) {
		return null;
	}

	private static void setMapWithDepthFirstSearch(Map<Integer, String> huffmanCodeMap, BinaryNode<HuffmanData> curNode, String code) {
		return;
	}

	private static void writeSerializedHuffmanCodeToFile(String fileName, Map<Integer, String> huffmanCodeMap) {
		return;
	}

	private static void encodeFile(String inFileName, String outFileName, Map<Integer, String> huffmanCodeMap) {
		return;
	}



	private static Map<Integer, Integer>createSymbolTable(String file) throws IOException{
		/* Construct a HashMap (char symbol, int frequency) of key,value pairs.
		 * For each symbols in a file, if the symbol has not been seen before
		 * add it to the HashMap and set its frequency to 1, otherwise increment
		 * the symbols frequency in the HashMap.*/

		

			HashMap<Integer, Integer> hashMap = new HashMap <Integer, Integer>();

			BufferedReader buff = new BufferedReader(new FileReader(file));

			try{
				
				int val = 0;

				while((val = buff.read()) != -1){
					if(hashMap.containsKey(val)){
						char vChar = (char)val;
						System.out.println(vChar);
					}
					else{
						hashMap.put(val, 1);
					}
				}

			}catch(Exception e){
			e.printStackTrace();
			}

			hashMap.put(EOT_SYM, 1);
			buff.close();	

			if(DEBUG){
				System.out.print("Symbol Table: ");
				for(Integer name : hashMap.keySet()){
					String key = name.toString();
					String va = hashMap.get(name).toString();
					System.out.println(key + " " + va);
				}




			}
			return hashMap;
		}

	}






		/*************************** createNodeList() *****************************
		 * Create a List of BinaryNodes where each Node contains a symbol and a
		 * frequency field. For each (symbol, frequency) pair in the HashMap add a
		 * new BinaryNode to the List while keeping the list sorted in increasing order
		 * according to frequency. **************************************************************************/ /************************** createHuffmanTree() ***************************
		 * While the List has more than 1 BinaryNode, create a new BinaryNode
		 * with frequency equal to the sum of the frequencies of the top two Nodes in
		 * the list. Set the left child equal to the top Node and remove the top Node from * the list. Then set the right child equal to the new top Node and remove the top * Node from the list. Insert the new Node into the sorted List while
		 * maintaining its sortedness. ***************************************************************************/ /************************ createHuffmanCodeMap() ************************** * Traverse the Huffman Tree using a Depth First Search while maintaining a
		 * String that represents the path from the root. If descending a left branch
		 * concatenate a '0' to the string, if descending a right branch concatenate
		 * a '1' to the string, and if ascending remove the last character. When you
		 * visit a leaf, add (symbol,code) to the HashMap where symbol is the
		 * symbol stored in the leaf Node and code is the String that was constructed
		 * while traversing the Tree. ****************************************************************************/ /***************** writeSerializedHuffmanCodeToFile() *********************
		 * Write the Huffman code HashMap as a serialized object to an output file ****************************************************************************/ /**************************** encodeFile() *********************************
		 * While reading each symbol of the input file, output (in binary) the code
		 * associated with the symbol that is stored the code HashMap. ****************************************************************************/















