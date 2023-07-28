import java.util.ArrayList;
import java.util.Arrays;
class Solution2150 {
    public ArrayList<Integer> findLonely(int[] nums) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (nums.length == 0) return ret;
        if (nums.length == 1) {
            ret.add(nums[0]);
            return ret;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (i > 0 && i < nums.length - 1 && nums[i] - nums[i - 1] > 1 && nums[i + 1] - nums[i] > 1) {
                ret.add(a);
            } else if (i == 0 && nums[i + 1] - nums[i] > 1) {
                ret.add(a);
            } else if (i == nums.length - 1 && nums[i] - nums[i - 1] > 1) {
                ret.add(a);
            }
        }
        return ret;
    }
}