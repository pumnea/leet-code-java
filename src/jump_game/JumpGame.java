package jump_game;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 *
 * @author Alex Pumnea
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (!isValid(nums)) return false;
        if (nums.length == 1) return true;

        int position = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > position) return false;
            position = Math.max(position, i + nums[i]);
            if (position >= nums.length - 1) return true;
        }
        return false;
    }

    private static boolean isValid(int[] nums) {
        return nums != null && nums.length > 0;
    }
}
