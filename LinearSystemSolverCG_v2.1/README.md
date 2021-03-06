#ReadMe - LinearSystemSolver v2.1


------------------------------------------------------------------------------------------

###Evolutionary steps:

- [-] linear system size, **A** matrix and **b** array elements are keyboard-input;
- [x] linear system size, **A** matrix and **b** array elements are read from text files;
- [x] separated classes for linear system solver, read matrix 1D and read matrix 2D;
- [-] **A** matrix is part of the code, but it's stored like **SparseRCDoubleMatrix2D**;

------------------------------------------------------------------------------------------

This code solve a simple **linear system** of the form Ax=b where:

* **A** is the *known* n-by-n matrix symmetric, positive define and real;
* **b** is *known* array;
* **x** is the *unknown* array;

##Packages & classes

I imported:

* DoubleMatrix1D
* DoubleMatrix2D
* DoubleCG
* IterativeSolverDoubleNotConvergedException
* SparseDoubleMatrix1D
* SparseDoubleMatrix2D

All this classes are included in the **CERN PARALLEL COLT** library.   


I used *TextIO* class to print the results. The known matrix **A** and the known array **b** are read from files, placed in the */src/* folder.

Matrix and arrays are stored like sparse matrix and sparse arrays.


##Conjugate Gradient Method

The system is solved by the **Conjugate Gradient Method**; this method is implemented in the *DoubleCG* class included in the *Parallel Colt* library, multithreaded version of *Colt*.


