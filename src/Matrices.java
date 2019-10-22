import java.util.Scanner;

public class Matrices {
    // Method for adding two matrices
    public static int[][] add(int[][] a, int[][] b) {

        if (a.length != b.length && a[0].length != b[0].length)
            throw new ArithmeticException();

        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result[0].length; j++)
                result[i][j] = a[i][j] + b[i][j];

        return  result;
    }

    // Method for subtracting two matrices
    public static int[][] sub(int[][] a, int[][] b) {

        if (a.length != b.length && a[0].length != b[0].length)
            throw new ArithmeticException();

        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result[0].length; j++)
                result[i][j] = a[i][j] - b[i][j];

        return  result;
    }

    // Method for multiplying two matrices
    public static int[][] mult(int[][] a, int[][] b) {

        if (a[0].length != b.length)
            throw new ArithmeticException();

        int[][] result = new int[a.length][b[0].length];

        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result[0].length; j++)
                for (int k = 0; k < b.length; k++)
                    result[i][j] += a[i][k] * b[k][j];

        return result;
    }

    // Method for transposing a matrix
    public static int[][] transpose(int[][] a) {

        int[][] result = new int[a[0].length][a.length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return  result;
    }

    // Method for cheching matrix equality
    public static boolean equal(int[][] a, int[][] b) {

        if (a.length != b.length || a[0].length != b[0].length)
            return false;
        else {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] != b[i][j])
                        return false;
                }
            }
        }
        return true;
    }

    // Method for checking diagonal matrix
    public static boolean diagonal(int[][] a) {

        if (a.length != a[0].length)
            return false;
        else {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (i != j && a[i][j] != 0)
                        return false;
                }
            }
        }
        return true;
    }

    // Method for checking identity matrix
    public static boolean identity(int[][] a) {

        if (a.length != a[0].length)
            return false;
        else {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if ((i != j && a[i][j] != 0) || (i == j && a[i][j] != 1))
                        return false;
                }
            }
        }
        return true;
    }

    // Method for checking Upper Triangular Matrix
    public static boolean upperTriMat(int[][] a) {

        if (a.length != a[0].length)
            return false;
        else {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (i > j && a[i][j] != 0)
                        return false;
                }
            }
        }
        return true;
    }

    // Method for checking Lower Triangular Matrix
    public static boolean lowerTriMat(int[][] a) {

        if (a.length != a[0].length)
            return false;
        else {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (i < j && a[i][j] != 0)
                        return false;
                }
            }
        }
        return true;
    }
    public static int[][] matInput(int r, int c) {
        Scanner input = new Scanner(System.in);
        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("matrix1["+i+"]["+j+"]: ");
                mat[i][j] = input.nextInt();
            }
        }
        return mat;
    }
    // Main Method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\t=====!!!!!^^^^^ MENU ^^^^^!!!!!=====");
        System.out.println("\n\t1. Matrix Addition");
        System.out.println("\t2. Matrix Subtraction");
        System.out.println("\t3. Matrix Multiplication");
        System.out.println("\t4. Checking Matrix Equality");
        System.out.println("\t5. Checking Diagonal Matrix");
        System.out.println("\t6. Checking Identity Matrix");
        System.out.println("\t7. Cheching Upper Triangular Matrix");
        System.out.println("\t8. Cheching Lower Triangular Matrix");
        System.out.println("\t9. Transpose Matrix");

        int choice = input.nextInt();

        switch (choice) {
            case 1: case 2: case 3: case 4:

                System.out.print("Enter rows of first matrix: ");
                int r1 = input.nextInt();
                System.out.print("Enter columns of first matrix: ");
                int c1 = input.nextInt();
                System.out.print("Enter rows of second matrix: ");
                int r2 = input.nextInt();
                System.out.print("Enter columns of second matrix: ");
                int c2 = input.nextInt();

                System.out.println("\nEnter the co-efficients of matrix 1:");
                int[][] mat1 = matInput(r1,c1);
                System.out.println("\nEnter the co-efficients of matrix 2:");
                int[][] mat2 = matInput(r2,c2);

                switch (choice) {
                    case 1:
                        try {
                            int[][] result = Matrices.add(mat1, mat2);
                            System.out.println("\nThe Resultant matrix is:");
                            for (int[] i : result) {
                                for (int j : i) {
                                    System.out.print(j + " ");
                                }
                                System.out.println();
                            }
                        } catch (Exception e) {
                            System.out.println("We cannot add these two matrix");
                        }
                        break;
                    case 2:
                        try {
                            int[][] result = Matrices.sub(mat1, mat2);
                            System.out.println("\nThe Resultant matrix is:");
                            for (int[] i : result) {
                                for (int j : i) {
                                    System.out.print(j + " ");
                                }
                                System.out.println();
                            }
                        } catch (Exception e) {
                            System.out.println("We cannot subtract these two matrix");
                        }
                        break;
                    case 3:
                        try {
                            int[][] result = Matrices.mult(mat1, mat2);
                            System.out.println("\nThe Resultant matrix is:");
                            for (int[] i : result) {
                                for (int j : i) {
                                    System.out.print(j + " ");
                                }
                                System.out.println();
                            }
                        } catch (Exception e) {
                            System.out.println("We cannot multiply these two matrix");
                        }
                        break;
                    case 4:
                        if (Matrices.equal(mat1, mat2))
                            System.out.println("\nThese two matrices are equal");
                        else
                            System.out.println("\nThese two matrices are not equal");
                        break;
                    }
                break;

            case 5: case 6: case 7: case 8: case 9:
                System.out.print("Enter rows of matrix: ");
                int r = input.nextInt();
                System.out.print("Enter columns of matrix: ");
                int c = input.nextInt();

                System.out.println("\nEnter the co-efficients of matrix:");
                int[][] mat = matInput(r,c);

                switch (choice) {
                    case 5:
                        if (Matrices.diagonal(mat))
                            System.out.println("\nThis is a diagonal matrix");
                        else
                            System.out.println("\nThis is not a diagonal matrix");
                        break;
                    case 6:
                        if (Matrices.identity(mat))
                            System.out.println("\nThis is an identity matrix");
                        else
                            System.out.println("\nThis is not an identity matrix");
                        break;
                    case 7:
                        if (Matrices.upperTriMat(mat))
                            System.out.println("\nThis is a upper triangular matrix");
                        else
                            System.out.println("\nThis is not a upper triangular matrix");
                        break;
                    case 8:
                        if (Matrices.lowerTriMat(mat))
                            System.out.println("\nThis is a lower triangular matrix");
                        else
                            System.out.println("\nThis is not a lower triangular matrix");
                        break;
                    case 9:
                        int[][] result = Matrices.transpose(mat);
                        System.out.println("The transpose matrix is:");
                        for (int[] i : result) {
                            for (int j : i) {
                                System.out.print(j);
                            }
                            System.out.println();
                        }
                        break;
                }
                break;
            default:
                System.out.println("\nInvalid Selection");
        }
    }
}


