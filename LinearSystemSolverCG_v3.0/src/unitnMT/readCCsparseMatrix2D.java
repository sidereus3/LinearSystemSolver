package unitnMT;

import java.io.File;
import java.util.Scanner;

import cern.colt.matrix.tdouble.impl.SparseCCDoubleMatrix2D;

// TODO: Auto-generated Javadoc
/**
 * The Class readCCsparseMatrix2D.
 */
public class readCCsparseMatrix2D{
	
	/** The size. */
	int SIZE = 0;
	int[] Mi = {0,2,1,3,0,2,1};
	//int[] Mp = {0,2,4,6};
	int[] Mj = {0,0,1,1,2,2,3};
	double[] Mv = {4.0,1.0,2.0,5.0,1.0,1.0,5.0};
	
	boolean Mf = false;
	boolean Mt = true;
	
	/** The mat a. */
	SparseCCDoubleMatrix2D matA;
	
	/** The input. */
	Scanner input;
	
	
	
	/**
	 * Instantiates a new read matrix2 d.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	readCCsparseMatrix2D() throws java.io.FileNotFoundException {
		
		input = new Scanner(new File("src/A.txt"));
		SIZE = dimensionMatrix2D();
		matA = new SparseCCDoubleMatrix2D(SIZE,SIZE,Mi,Mj,Mv,Mf,Mf,Mt);
		TextIO.put("End read SparseCCDoubleMatrix2D");
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
		
	/*	Scanner input2 = new Scanner(new File("src/A.txt"));
		
		
		TextIO.put("Go into loadMatrix2D method");
		for(int i = 0; i < SIZE; ++i){
		    for(int j = 0; j < SIZE; ++j){
		        if(input2.hasNextDouble()){
//		        	TextIO.put(input2.nextDouble());
		            matA.set(i,j,input2.nextDouble());
		        }
		    }
		}
		
		input2.close();*/
		
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