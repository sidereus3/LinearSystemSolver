package unitnMT;

/**
 * LinearSystemSolver v1.2
 * 
 * @desc	This class solves a linear system by DoubleCG class. All data (known and
 * 			unknown matrices and arrays) are stored like sparse matrices or arrays.
 * 
 * 			The DoubleCG class requires only sparse matrices and arrays to solve the
 * 			linear system.
 * 
 * 			Only three methods are necessary:
 * 				-the constructor method LinearSystemSolver();
 * 				-the printDescription() method, to print the description
 * 				of the code;
 * 				-the inputParameters() method is necessary to take the
 * 				input from keyboard.
 * 
 * @author	Francesco Serafin, 2013
 * Copyright GPL v. 3 (http://www.gnu.org/licenses/gpl.html)
 * */

// imported libraries
import java.util.*;
import java.io.*;

import cern.colt.matrix.tdouble.DoubleMatrix1D;
import cern.colt.matrix.tdouble.DoubleMatrix2D;
import cern.colt.matrix.tdouble.algo.solver.DoubleCG;
import cern.colt.matrix.tdouble.algo.solver.IterativeSolverDoubleNotConvergedException;
import cern.colt.matrix.tdouble.impl.SparseDoubleMatrix1D;
import cern.colt.matrix.tdouble.impl.SparseDoubleMatrix2D;



// TODO: Auto-generated Javadoc
/**
 * The Class LinearSystemSolver.
 */
public class LinearSystemSolver {
	
	/** The size.
	 * 	numbers of rows of the linear system */
	private static int SIZE;
	
	/** The matrix A.
	 * 	is the known SIZE-by-SIZE matrix */
	DoubleMatrix2D matA;
	
	/** The array b.
	 * 	is the known array */
	DoubleMatrix1D matb;
	
	/** The mat x.
	 * 	is the unknown array */
	DoubleMatrix1D matx;
	
	
	
/**
 	* Instantiates a new linear algebra.
 	*
 	* @desc	Constructor method. All methods are contained in Stack section
 	* 		of the memory like local variables. But the Constructor method
 	* 		allocate in the Heap memory the space for an object of type
 	* 		LinearSystemSolver.
 	*/
	LinearSystemSolver() {

		matA = new SparseDoubleMatrix2D(SIZE,SIZE);
		matb = new SparseDoubleMatrix1D(SIZE);
		matx = new SparseDoubleMatrix1D(SIZE);
		
	}

	
	
/**
 	* Prints the description.
 	*
 	* @desc	printDescription is the method where print the initial description
 	* 		of the code. This is a static method, so it's contained in the
 	* 		Static section of the memory.
 	*/
	public static void printDescription(){
		
		System.out.println("\n"
				+ "DESCRIPTION ======================================\n"
				+ "\n"
				+ "This program solve a linear system of the form\n"
				+ "Ax=b, with the Conjugate Gradient Method.\n"
				+ "\n"
				+ "The method is implemented in the DoubleCG class\n"
				+ "contained in Parallel Colt library.\n"
				+ "\n"
				+ "==================================================\n");
		
	}
	
	
	
/**
	 * Read matrix dimension.
	 *
	 * @desc	readMatrixDimension is the method where read the dimension
	 * 			of the SIZE-by-SIZE sparse matrix A.
	 * @return	the number of rows of the linear system
	 */
	public static int readMatrixDimension(){
		
		int rows = 0;
		
		
		try{
			Scanner input = new Scanner(new File("src/A.txt"));
			while (input.hasNextLine()){
				++rows;
//				TextIO.put("Row " + rows + "\n");
				Scanner colReader = new Scanner(input.nextLine());
				while(colReader.hasNextInt()){
				}
				colReader.close();
			}
			input.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
			TextIO.put("The matrix A was not found");
			System.exit(1);
			
		}
		
		try{
			Scanner input = new Scanner(new File("src/b.txt"));
//			while (input.hasNextLine()){
//				++rows;
////				TextIO.put("Row " + rows + "\n");
//			}
			input.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
			TextIO.put("The vector b was not found");
			System.exit(1);
			
		}
		
		TextIO.put("The A matrix dimension is: " + rows + " x " + rows + "\n");
		
		return rows;
		
	}
	
	
	
/**
 	* Gets the parameters.
 	*
 	* @desc	inputParameters is a non-static method, so it's contained in
 	* 			the Stack memory. It receives the value by an Input Dialog
 	* 			Window for A matrix and an Input Dialog Window for b matrix.
 	* 			The result is the complete matrices of the system.
 	*
 	* @return 	the filled matrices
 	* 
 	* @throws 	FileNotFoundException the file not found exception
 	*/
	private void readMatrixParameters() throws java.io.FileNotFoundException {
		
		// read the data in the n-by-n matA and in the known matb
		Scanner input = new Scanner(new File("src/A.txt"));
		
		for(int i = 0; i < SIZE; ++i){
		    for(int j = 0; j < SIZE; ++j){
		        if(input.hasNextDouble()){
		            matA.set(i,j,input.nextDouble());
		        }
		    }
		}
		
		input.close();
		
		input = new Scanner(new File("src/b.txt"));
		
		for(int i = 0; i < SIZE; ++i){
			if(input.hasNextDouble()){
				matb.set(i,input.nextDouble());
		    }
		}
		
		input.close();
		
		
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
		
		// Print the known array
		System.out.println("\n"
				+ "b MATRIX =========================================\n"
				+ "\n"
				+ "The matrix b is known\n");
		
		
		System.out.println("\n"
				+ matb + "\n"
				+ "\n");

	}
	
	
	
/**
	 * Prints the mat x.
	 * 
	 * @desc	this method print the solution of the conjugate gradient
	 * 			method
	 *
	 * @param 	matSol the matrix of solution is the result of the conjugate
	 * 			gradient method
	 */
	public static void printMatX(DoubleMatrix1D matSol){
		
		System.out.println("\n"
				+ "x MATRIX =========================================\n"
				+ "\n"
				+ "The system present a unique solution and it's\n"
				+ "contained in the vector x.\n"
				+ "\n"
				+ matSol + "\n"
				+ "\n");
		
	}

	
	
/**
 	* The main method.
 	*
 	* @param	args the arguments
 	* 
 	* @throws	IterativeSolverDoubleNotConvergedException the iterative solver double not converged exception
 	* 
 	* @throws	FileNotFoundException the file not found exception is useful if you want a robust code. Insert
 	* 			in a try-catch get error when the read text file is empty.
 	*/
	public static void main(String[] args) throws IterativeSolverDoubleNotConvergedException, java.io.FileNotFoundException {

		
		printDescription();
		
		SIZE = readMatrixDimension();
				
		LinearSystemSolver LinearSystem = new LinearSystemSolver();

		LinearSystem.readMatrixParameters();		
		
		DoubleCG conjugateGradient = new DoubleCG(LinearSystem.matx);
		DoubleMatrix1D matSol = conjugateGradient.solve(LinearSystem.matA,
				LinearSystem.matb,LinearSystem.matx);
		
		printMatX(matSol);
		
		System.exit(1);
	}
}
