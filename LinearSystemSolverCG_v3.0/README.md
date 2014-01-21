#ReadMe - LinearSystemSolver v2.1


------------------------------------------------------------------------------------------

###Evolutionary steps:

- [-] linear system size, **A** matrix and **b** vector elements are keyboard-input;
- [-] linear system size, **A** matrix and **b** vector elements are read from text files;
- [x] separated classes for linear system solver, read matrix 1D and read matrix 2D;
- [x] **A** matrix is part of the code, but it's stored like **SparseCCDoubleMatrix2D**;

------------------------------------------------------------------------------------------

This code solve a simple **linear system** of the form Ax=b where:

* **A** is the *known* n-by-n matrix symmetric, positive define and real;
* **b** is *known* vector;
* **x** is the *unknown* vector;

The class *readMatrix1D* read the **b** vector from the text files in the src folder. **b** is stored like sparse and vector, **A** is stored like sparse matrix in *compressed-column form*.


##Conjugate Gradient Method

The system is solved by the **Conugate Gradient Method**; this method is implemented in the *DoubleCG class* included in the *Parallel Colt library*, multithreaded version of *Colt*. This method can have in input a sparse matrix in *compressed-column form*.


##Packages & classes

###LinearSystemSolver class

I imported:

- java.io.*;

and from **CERN PARALLEL COLT** library:

- DoubleMatrix1D;
- DoubleCG;
- IterativeSolverDoubleNotConvergedException;
- SparseDoubleMatrix1D;

-------------------------------------------------

###readMatrix1D class

I imported:

- java.io.File;
- java.util.Scanner;

and from **CERN PARALLEL COLT** library:

- SparseDoubleMatrix1D;

-------------------------------------------------

###readCCsparseMatrix2D class

I imported:

- java.io.File;
- java.util.Scanner;

and from **CERN PARALLEL COLT** library:

- SparseCCDoubleMatrix2D;