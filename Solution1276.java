import java.util.ArrayList;
import java.util.List;

public class Solution1276 {
    public List<Integer> numOfBurgers(int tomato, int cheese) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (tomato % 2 != 0) return ret;
        int jumbo = (tomato - (2 * cheese)) / 2;
        int small = cheese - jumbo;
        if (jumbo < 0 || small < 0) return ret;
        ret.add(jumbo);
        ret.add(small);
        return ret;
    }
}
