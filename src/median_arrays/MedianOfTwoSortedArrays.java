package median_arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * @author Alex Pumnea
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] joinedArr = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        int size = joinedArr.length;

        if(size % 2 != 0) {
            return joinedArr[size / 2];
        }
        return IntStream.of(joinedArr[size / 2 - 1], joinedArr[size / 2]).average().orElseThrow();
    }
}
