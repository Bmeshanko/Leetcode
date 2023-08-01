class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        String ret = "";
        int i = 0; int j = 0;
        while (i < word1.length() && j < word2.length()) {
            ret += word1.charAt(i++);
            ret += word2.charAt(j++);
        }

        if (i < word1.length()) {
            ret += word1.substring(i);
        } else {
            ret += word2.substring(j);
        }
        return ret;
    }
}