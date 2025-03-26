public class NegativeNumber {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1, 5, -7};

        int index = findFirstNegative(nums);
        System.out.println("Index of first negative number: " + index);
    }

    public static int findFirstNegative(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
