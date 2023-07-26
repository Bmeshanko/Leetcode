import java.util.ArrayList;
class Solution2089 {
    public ArrayList<Integer> targetIndices(int[] nums, int target) {
        int i = 1;
        while (i < nums.length) {
            int x = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > x) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = x;
            i++;
        }

        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target) ret.add(i);
        }
        return ret;
    }
}