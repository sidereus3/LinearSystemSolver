package unitnMT;

import java.io.File;
import java.util.Scanner;

import cern.colt.matrix.tdouble.impl.SparseDoubleMatrix2D;

// TODO: Auto-generated Javadoc
/**
 * The Class readMatrix2D.
 */
public class readMatrix2D{
	
	/** The size. */
	int SIZE = 0;
	
	/** The mat a. */
	SparseDoubleMatrix2D matA;
	
	/** The input. */
	Scanner input;
	
	
	
	/**
	 * Instantiates a new read matrix2 d.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	readMatrix2D() throws java.io.FileNotFoundException {
		
		input = new Scanner(new File("src/A.txt"));
		SIZE = dimensionMatrix2D();
		matA = new SparseDoubleMatrix2D(SIZE,SIZE);
		loadMatrix2D();
		

		
	}
	
	
	
	/**
	 * Dimension matrix2 d.
	 *
	 * @return the int
	 */
	int dimensionMatrix2D(){
		
		int rows = 0;
		//int column = 0;
		
		while (input.hasNextLine()){
			++rows;
			//TextIO.put("Row " + rows + "\n");
			Scanner colReader = new Scanner(input.nextLine());
			while(colReader.hasNextInt()){
			}
			colReader.close();
		}
		
		input.close();
		
		TextIO.put("Rows of matrix A = " + rows + "\n");
		return rows;
		
	}
	
	
	
	/**
	 * Load matrix2 d.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public void loadMatrix2D() throws java.io.FileNotFoundException {
		
		Scanner input2 = new Scanner(new File("src/A.txt"));
		
		
		TextIO.put("Go into loadMatrix2D method");
		for(int i = 0; i < SIZE; ++i){
		    for(int j = 0; j < SIZE; ++j){
		        if(input2.hasNextDouble()){
//		        	TextIO.put(input2.nextDouble());
		            matA.set(i,j,input2.nextDouble());
		        }
		    }
		}
		
		input2.close();
		
		// Print the known n-by-n matrix
		System.out.println("\n"
				+ "A MATRIX =========================================\n"
				+ "\n"
				+ "The known n-by-n matrix A must be:\n"
				+ "	1- symmetric\n"
				+ "	2- positive definite\n"
				+ "	3- real\n");
		
		
		System.out.println("\n"
				+ matA + "\n"
				+ "\n");	
		
	}
	
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public void main(String[] args){
		
	}
	
}