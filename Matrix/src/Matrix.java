import java.util.Arrays;
import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
public class Matrix<T>{

	int counter = 0;
	Object [][] matrixArray;
	int rows;
	int cols;


	public Matrix(){//constructor initializes the capacity to 0

		matrixArray = new Object [0][0];

	}


	public Matrix(int k){ //constructor makes k x k matrix and fills with null

		matrixArray = new Object [rows][cols];	

	}


	public Matrix(int k, int m){ //constructor makes a k x m matrix and fills with null

		matrixArray = new Object [rows][cols];		

	}

	
	
	public boolean init(int k, int m){
		rows = k;
		cols = m;
		matrixArray = new Object[rows][cols];
		return true;

	}

	
	
	public boolean add (T element, int k, int m) throws Exception{


		//throws NullPointerException checks if the first argument is null
		if(element == null){
			throw new NullPointerException("First arguement can not be null");
		}

		//throw exception if second or third arguments are negative
		if (k < 0 || m < 0){
			throw new MatrixOutOfBoundsException();
		}
		
		counter++;

		do{
			cols = m*2;
			rows = k*2;
		}while(k >= rows && m >= cols);			


		matrixArray[k][m] = element;//adds the element
		System.out.println("added " + element);
		return true;

	}



	@SuppressWarnings("unchecked")
	public T remove (int k, int m) throws MatrixOutOfBoundsException{
		counter--;

		if(rows < k | cols < m){
			throw new MatrixOutOfBoundsException();
		}

		Object returnVal = matrixArray[k][m];
		matrixArray[k][m] = null; 
		return (T) returnVal;
	}



	public int size(){
		System.out.println("number of elements: " + counter);
		return counter;
	}



	@SuppressWarnings("unchecked")
	public T elementAt(int k, int m) throws MatrixOutOfBoundsException{

		if(rows < k || cols < m){
			throw new MatrixOutOfBoundsException();
		}
		
	
		Object returnVal = matrixArray[k][m];
		System.out.println("element at [" + k + "][" + m +"] is " + returnVal);
		return (T) returnVal;
	}


}