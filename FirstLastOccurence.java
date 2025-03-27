import java.util.*;

public class FirstLastOccurence {
          public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of elements in the sorted array: ");
            int n = scanner.nextInt();
            int[] sortedArr = new int[n];

            System.out.println("Enter the sorted elements:");
            for (int i = 0; i < n; i++) {
                sortedArr[i] = scanner.nextInt();
            }


            System.out.print("Enter the target value: ");
            int targetVal = scanner.nextInt();


            int[] result = findFirstAndLastOccurrence(sortedArr, targetVal);


            if (result[0] == -1) {
                System.out.println("Element not found in the array.");
            } else {
                System.out.println("First Occurrence: " + result[0]);
                System.out.println("Last Occurrence: " + result[1]);
            }

            scanner.close();
        }

        public static int[] findFirstAndLastOccurrence(int[] arr, int target) {
            int first = findBoundary(arr, target, true);
            int last = findBoundary(arr, target, false);
            return new int[]{first, last};
        }

        private static int findBoundary(int[] arr, int target, boolean findFirst) {
            int left = 0, right = arr.length - 1, result = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    result = mid;
                    if (findFirst) right = mid - 1;  // Keep searching left
                    else left = mid + 1;  // Keep searching right
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }
}


