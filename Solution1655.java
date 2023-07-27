import java.util.Arrays;
import java.util.ArrayList;
class Solution1655 {
    public static boolean canDistribute(int[] nums, int[] quantity) {
        Arrays.sort(nums);
        // At most 50 unique values in nums
        ArrayList<Integer> dist = new ArrayList<Integer>();
        int temp = nums[0];
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                idx++;
            } else {
                dist.add(idx);
                temp = nums[i];
                idx = 1;
            }
        }

        dist.add(idx);

        int[] a = new int[dist.size()];
        for (int i = 0; i < dist.size(); i++) {
            a[i] = dist.get(i);
        }

        Arrays.sort(quantity);

        return rec(a, quantity, quantity.length - 1);
    }

    public static boolean rec(int[] dist, int[] quantity, int j) {
        if (j == -1) return true;

        for (int i = 0; i < dist.length; i++) {
            if (quantity[j] <= dist[i]) {
                dist[i] -= quantity[j];
                if (rec(dist, quantity, j - 1)) return true;
                dist[i] += quantity[j];
            }
        }
        return false;
    }
}