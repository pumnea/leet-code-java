package majority_element;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * @author Alex Pumnea
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorityElement = 0;
        for (int num : nums) {
            if (count == 0) {
                majorityElement = num;
            }
            if (num == majorityElement) {
                count++;
            } else {
                count--;
            }
        }
        return majorityElement;
    }
}
