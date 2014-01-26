package unitnMT;

import java.io.File;
import java.util.Scanner;

import cern.colt.matrix.tdouble.impl.SparseDoubleMatrix1D;

// TODO: Auto-generated Javadoc
/**
 * The Class readMatrix1D.
 */
public class readMatrix1D{
	
	/** The size. */
	int SIZE = 0;
	
	/** The matb. */
	SparseDoubleMatrix1D matb;
	
	/** The input. */
	Scanner input;
	
	
	
	/**
	 * Instantiates a new read matrix1 d.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	readMatrix1D() throws java.io.FileNotFoundException {
		
		input = new Scanner(new File("src/b.txt"));
		SIZE = dimensionMatrix1D();
		matb = new SparseDoubleMatrix1D(SIZE);
		loadMatrix1D();
		

		
	}
	
	
	
	/**
	 * Dimension matrix1 d.
	 *
	 * @return the int
	 */
	int dimensionMatrix1D(){
		
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
		
		TextIO.put("Rows of vector b = " + rows + "\n");
		return rows;
		
	}
	
	
	
	/**
	 * Load matrix1 d.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public void loadMatrix1D() throws java.io.FileNotFoundException {
		
		Scanner input2 = new Scanner(new File("src/b.txt"));
		
		for(int i = 0; i < SIZE; ++i){
			if(input2.hasNextDouble()){
				matb.set(i,input2.nextDouble());
		    }
		}
		
		input2.close();
		
		// Print the known vector
		System.out.println("\n"
				+ "b MATRIX =========================================\n"
				+ "\n"
				+ "The matrix b is known\n");
		
		
		System.out.println("\n"
				+ matb + "\n"
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