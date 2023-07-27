import java.util.HashMap;
class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indices = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (indices.containsKey(nums[i])) {
                if (i - indices.get(nums[i]) <= k) return true;
            }
            indices.put(nums[i], i);
        }
        return false;
    }
}