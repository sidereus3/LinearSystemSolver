#ReadMe - LinearSystemSolver v0.9


------------------------------------------------------------------------------------------

###Evolutionary steps:

- [x] linear system size, **A** matrix and **b** vector elements are keyboard-input;
- [ ] linear system size, **A** matrix and **b** vector elements are read from text files;
- [ ] separated classes for linear system solver, read matrix 1D and read matrix 2D;
- [ ] **A** matrix is part of the code, but it's stored like **SparseCCDoubleMatrix2D**;

------------------------------------------------------------------------------------------

This is my first java code.
This code solve a simple **linear system** of the form Ax=b where:

* **A** is the *known* n-by-n matrix symmetric, positive define and real;
* **b** is *known* vector;
* **x** is the *unknown* vector;

The rows number of linear system and matrix and vector elements are keyboard-input. I used *TextIO* class to read input values and to print the results.

Matrix and vectors are stored like sparse matrix and vector.

##Conjugate Gradient Method

The system is solved by the **Conjugate Gradient Method**; this method is implemented in the *DoubleCG* class included in the *Parallel Colt* library, multithreaded version of *Colt*.


##Packages & classes

I imported:

* DoubleMatrix1D
* DoubleMatrix2D
* DoubleCG
* IterativeSolverDoubleNotConvergedException
* SparseDoubleMatrix1D
* SparseDoubleMatrix2D

All this classes are included in the **CERN PARALLEL COLT** library.   
