package rotate_array;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * @author Alex Pumnea
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (!validForRotation(nums, k)) return;
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static boolean validForRotation(int[] nums, int k) {
        return k != 0 || nums.length > 2;
    }

    private void reverse(int[] nums, int startPos, int endPos) {
        while (startPos < endPos) {
            swap(nums, startPos++, endPos--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
