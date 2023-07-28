class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = nums1[i];
        }

        int i = 0; int j = 0; int c = 0;
        while (i < m || j < n) {
            if (i < m && (j == n || nums[i] < nums2[j])) {
                nums1[c++] = nums[i++];
            } else {
                nums1[c++] = nums2[j++];
            }
        }
    }
}