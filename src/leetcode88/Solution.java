package leetcode88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);

        int p1 = 0;
        int p2 = 0;

        int i = 0;
        while (p1 < m && p2 < n) {
            nums1[i++] = nums3[p1] <= nums2[p2] ? nums3[p1++] : nums2[p2++];
        }

        while (p1 < m) {
            nums1[i++] = nums3[p1++];
        }

        while (p2 < n) {
            nums1[i++] = nums2[p2++];
        }
    }
}
