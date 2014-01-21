package unitnMT;

// TODO: Auto-generated Javadoc
/**
 * The Class LinearSystemSolver.
 */

// imported libraries
//import java.util.*;
//import java.lang.Object;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;

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
	
	/** The mat a. */
	DoubleMatrix2D matA;		// The known n-by-n matrix
	
	/** The matb. */
	DoubleMatrix1D matb;		// The known matrix
	
	/** The matx. */
	DoubleMatrix1D matx;		// The unknown matrix
	
	/** The size. */
	private static int SIZE;	// Number of rows of the linear system
	
	
	
/**
 * Instantiates a new linear algebra.
 */
	LinearSystemSolver() {

		matA = new SparseDoubleMatrix2D(SIZE,SIZE);
		matb = new SparseDoubleMatrix1D(SIZE);
		matx = new SparseDoubleMatrix1D(SIZE);
		
	}

	
	
/**
 * Prints the description.
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
 * Input parameters.
 */
	private void inputParameters(){
		
		// Fill and print the known n-by-n matrix
		System.out.println("\n"
				+ "A MATRIX =========================================\n"
				+ "\n"
				+ "The known n-by-n matrix A must be:\n"
				+ "	1- symmetric\n"
				+ "	2- positive definite\n"
				+ "	3- real\n");
		
		for (int row=0; row< SIZE; row++){
			for (int col=0; col < SIZE; col++){
				TextIO.putln("Input value in pos (" + row + "," + col + ")");
				matA.set(row,col,TextIO.getDouble());
			}	
		}
		
		System.out.println("\n"
				+ matA + "\n"
				+ "\n");
		
		// Fill and print the known vector
		System.out.println("\n"
				+ "b MATRIX =========================================\n"
				+ "\n"
				+ "The matrix b is known\n");
		
		for (int row=0; row < SIZE; row++){	
			TextIO.putln("Input value in pos (" + row + ",1)");
			matb.set(row,TextIO.getDouble());
			matx.set(row,0);
		}
		
		System.out.println("\n"
				+ matb + "\n"
				+ "\n");

	}

	
	
/**
 * The main method.
 *
 * @param args the arguments
 * @throws IterativeSolverDoubleNotConvergedException the iterative solver double not converged exception
 */
	public static void main(String[] args) throws IterativeSolverDoubleNotConvergedException {

		
		printDescription();
		
		// input the number of rows of the linear system
		/*SIZE = Integer.parseInt(
				JOptionPane.showInputDialog("Input row numbers of the linear system : ")
				);*/
		TextIO.put("Please insert the number of rows of the linear system: ");
		SIZE = TextIO.getShort();
		
		LinearSystemSolver LinearSystem = new LinearSystemSolver();

		LinearSystem.inputParameters();		
		
		DoubleCG prova = new DoubleCG(LinearSystem.matx);
		DoubleMatrix1D matSol = prova.solve(LinearSystem.matA,
				LinearSystem.matb,LinearSystem.matx);
		
		System.out.println("\n"
				+ "x MATRIX =========================================\n"
				+ "\n"
				+ "The system present a unique solution and it's\n"
				+ "contained in the vector x.\n"
				+ "\n"
				+ matSol + "\n"
				+ "\n");
		
		System.exit(1);
	}
}
