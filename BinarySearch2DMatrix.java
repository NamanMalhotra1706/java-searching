import java.util.Scanner;

public class BinarySearch2DMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the matrix elements in sorted order (row-wise):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Input: Target value
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        // Search for target in the matrix
        boolean found = searchMatrix(matrix, target);

        // Display result
        if (found) {
            System.out.println("Target value found in the matrix!");
        } else {
            System.out.println("Target value NOT found in the matrix.");
        }

        scanner.close();
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols]; // Convert 1D index to 2D indices

            if (midValue == target) return true;
            else if (midValue < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
