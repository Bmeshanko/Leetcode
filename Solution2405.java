import java.util.HashSet;
class Solution2405 {
    public int partitionString(String s) {
        int partitions = 1;
        HashSet<Character> hash = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (hash.contains(s.charAt(i))) {
                hash.clear();
                partitions++;
            }
            hash.add(s.charAt(i));
        }
        return partitions;
    }
}