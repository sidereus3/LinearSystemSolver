ReadMe
======

This is my first java code.
This code solve a simple **linear system** of the form Ax=b where:

<<<<<<< HEAD
	- A is the known n-by-n matrix symmetric, positive define and real;
	- b is known vector;
	- x is the unknown vector;
=======
	- **A** is the *known* n-by-n matrix symmetric, positive define and real;
	- **b** is *known* vector;
	- **x** is the *unknown* vector;
>>>>>>> 7a6cda711ee118c733fd1fa7ce50ab394a305887

The code read the A matrix and the b vector from the text files in the src folder.


Conjugate Gradient Method
-------------------------

The system is solved by the **Conugate Gradient Method**; this method is implemented in the *DoubleCG class* included in the *Parallel Colt library*, multithreaded version of *Colt*.


Packages & classes
-------------------------

I imported:

	- DoubleMatrix1D
	- DoubleMatrix2D
	- DoubleCG
	- IterativeSolverDoubleNotConvergedException
	- SparseDoubleMatrix1D
	- SparseDoubleMatrix2D

All this classes are included in the **CERN PARALLEL COLT** library.   

<<<<<<< HEAD
I used TextIO class like video output class.
=======
I used TextIO class to read input values.
>>>>>>> 7a6cda711ee118c733fd1fa7ce50ab394a305887
