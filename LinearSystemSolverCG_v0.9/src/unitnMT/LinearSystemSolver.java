package unitnMT;

/**
 * LinearSystemSolver v0.9
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
 */
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
 	* Instantiates a new linear system solver.
 	* 
 	* @desc Constructor method. All methods are contained in Stack section
 	*		 of the memory like local variables. But the Constructor method
 	*		 allocate in the Heap memory the space for an object of type
 	* 		 LinearSystemSolver.
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
 	* Input parameters.
 	* 
 	* @desc This method take in input the values of the matrices from keyboard
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
 	* @throws IterativeSolverDoubleNotConvergedException
 	* 				the iterative solver double not converged exception
 	* @desc The main method first calls the printDescription() method, it reads the SIZE
 	* 		 of the linear system and thus calls the constructor method.
 	* 		 Once the matrices are instantiated, the inputParameters() method is called
 	* 		 and all the matrices are filled.
 	* 
 	* 		 The DoubleCG() object is constructed and the solver is called.
 	*  
 	*/
	public static void main(String[] args) throws IterativeSolverDoubleNotConvergedException {

		
		printDescription();
		
		TextIO.put("Please insert the number of rows of the linear system: ");
		SIZE = TextIO.getShort();
		
		LinearSystemSolver LinearSystem = new LinearSystemSolver();

		LinearSystem.inputParameters();		
		
		DoubleCG conjugateGradient = new DoubleCG(LinearSystem.matx);
		DoubleMatrix1D matSol = conjugateGradient.solve(LinearSystem.matA,
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
