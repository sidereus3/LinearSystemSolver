#ReadMe - LinearSystemSolver v1.2


------------------------------------------------------------------------------------------

###Evolutionary step:

The code read the **A** matrix and the **b** vector from the text files in the src folder.

------------------------------------------------------------------------------------------

This code solve a simple **linear system** of the form Ax=b where:

* **A** is the *known* n-by-n matrix symmetric, positive define and real;
* **b** is *known* vector;
* **x** is the *unknown* vector;

**A** and **b** are stored like sparse matrix and vector.

##Conjugate Gradient Method

The system is solved by the **Conjugate Gradient Method**; this method is implemented in the *DoubleCG* class included in the *Parallel Colt* library, multithreaded version of *Colt*.


##Packages & classes

I imported:

- DoubleMatrix1D
- DoubleMatrix2D
- DoubleCG
- IterativeSolverDoubleNotConvergedException
- SparseDoubleMatrix1D
- SparseDoubleMatrix2D

All this classes are included in the **CERN PARALLEL COLT** library.   

I used TextIO class to print the results and some description.