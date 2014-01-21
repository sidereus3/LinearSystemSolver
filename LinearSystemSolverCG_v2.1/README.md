#ReadMe - LinearSystemSolver v2.1


------------------------------------------------------------------------------------------

###Evolutionary steps:

- [ ] linear system size, **A** matrix and **b** vector elements are keyboard-input;
- [x] linear system size, **A** matrix and **b** vector elements are read from text files;
- [x] separated classes for linear system solver, read matrix 1D and read matrix 2D;
- [ ] **A** matrix is part of the code, but it's stored like **SparseCCDoubleMatrix2D**;

------------------------------------------------------------------------------------------

This code solve a simple **linear system** of the form Ax=b where:

* **A** is the *known* n-by-n matrix symmetric, positive define and real;
* **b** is *known* vector;
* **x** is the *unknown* vector;

The separeted classes *readMatrix1D* and *readMatrix2D* read the **A** matrix and the **b** vector from the text files in the src folder. **A** and **b** are stored like sparse matrix and vector.

##Conjugate Gradient Method

The system is solved by the **Conugate Gradient Method**; this method is implemented in the *DoubleCG class* included in the *Parallel Colt library*, multithreaded version of *Colt*.


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

###readMatrix2D class

I imported:

- java.io.File;
- java.util.Scanner;

and from **CERN PARALLEL COLT** library:

- SparseDoubleMatrix2D;