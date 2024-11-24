import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so hang: ");
        int rows = scanner.nextInt();
        System.out.print("Nhap so cot: ");
        int cols = scanner.nextInt();
        int newrows=rows+1,
            newcols=cols+1;

        int[][] matrixA = new int[newrows][newcols];
        int[][] matrixB = new int[newrows][newcols];
        int[][] result = new int[newrows][newcols];

        System.out.println("Phan tu ma tran A:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(" A[" + i + "," + j + "]: ");
                matrixA[i-1][j-1] = scanner.nextInt();
            }
        }

        System.out.println("Phan tu ma tran B:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print("B[" + i + "," + j + "]: ");
                matrixB[i-1][j-1] = scanner.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("Ket qua la:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
