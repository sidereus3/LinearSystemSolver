package unitnMT;

/**
 * LinearSystemSolver v2.1
 * 
 * @desc	This class contains only the call to the DoubleCG class. The other method
 * 			are print method.
 * 
 * @author	Francesco Serafin, 2013
 * Copyright GPL v. 3 (http://www.gnu.org/licenses/gpl.html)
 * */

import java.io.*;

import cern.colt.matrix.tdouble.DoubleMatrix1D;
import cern.colt.matrix.tdouble.algo.solver.DoubleCG;
import cern.colt.matrix.tdouble.algo.solver.IterativeSolverDoubleNotConvergedException;
import cern.colt.matrix.tdouble.impl.SparseDoubleMatrix1D;




// TODO: Auto-generated Javadoc
/**
 * The Class LinearSystemSolver.
 */
public class LinearSystemSolver {
	
	/** The matx. */
	DoubleMatrix1D matx;

	
	
/**
 * Instantiates a new linear system solver.
 * 
 * @desc	in this case, it's instantiates only the sparse array that
 * 			contains the solution
 *
 * @param ROWS the rows
 */
	LinearSystemSolver(int ROWS) {

		matx = new SparseDoubleMatrix1D(ROWS);
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
	 * Prints the mat x.
	 *
	 * @param matSol the mat sol
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
 	* @desc this method calls the other class readMatrix1D and readMatrix2D. Once the
 	* 		files are read, the main is equal to the main v0.9 and v1.2
 	*
 	* @param args the arguments
 	* @throws IterativeSolverDoubleNotConvergedException the iterative solver double not converged exception
 	* @throws FileNotFoundException the file not found exception
 	*/
	public static void main(String[] args) throws IterativeSolverDoubleNotConvergedException, java.io.FileNotFoundException {

		
		printDescription();


		readMatrix2D rM2D = new readMatrix2D();
		readMatrix1D rM1D = new readMatrix1D();

		
		LinearSystemSolver LinearSystem = new LinearSystemSolver(rM2D.SIZE);		
		
		DoubleCG conjugateGradient = new DoubleCG(LinearSystem.matx);
		DoubleMatrix1D matSol = conjugateGradient.solve(rM2D.matA,
				rM1D.matb,LinearSystem.matx);
		
		printMatX(matSol);
		
		System.exit(1);
	}
}
