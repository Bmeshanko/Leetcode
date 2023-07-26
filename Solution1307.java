import java.lang.Math;

class Solution1307 {
    public static String findChars(String[] words) {
        String ret = "";
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (ret.indexOf(words[i].charAt(j)) == -1) {
                    ret += words[i].charAt(j);
                }
            }
        }
        return ret;
    }

    public static String firstChars(String[] words) {
        String ret = "";
        for (int i = 0; i < words.length; i++) {
            if (ret.indexOf(words[i].charAt(0)) == -1) {
                ret += words[i].charAt(0);
            }
        }
        return ret;
    }

    public static boolean isSolvable(String[] words, String result) {
        String[] allWords = new String[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            allWords[i] = words[i];
        }
        allWords[allWords.length - 1] = result;

        String chars = findChars(allWords);
        String firstChars = firstChars(allWords);

        boolean[] used = new boolean[10];
        for (int i = 0; i < used.length; i++) used[i] = false;

        return backtrack(0, used, chars, firstChars, "", allWords);
    }

    public static boolean calcDiff(String[] words, String chars, String numMap) {
        int wordsSum = 0;
        int resSum = 0;
        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();
            int sum = 0;
            for (int j = 0; j < words[i].length(); j++) {
                int x = numMap.charAt(chars.indexOf(words[i].charAt(j))) - '0';
                sum += x * Math.pow(10, words[i].length() - j - 1);
            }
            if (i < words.length - 1) wordsSum += sum;
            else resSum = sum;
        }
        //System.out.println("Chars: " + chars + " Map: " + numMap + " " + wordsSum + " " + resSum);
        return wordsSum == resSum;
    }

    public static boolean backtrack(int step, boolean[] used, String chars, String firstChars, String numMap, String[] words) {
        if (numMap.length() == chars.length()) return calcDiff(words, chars, numMap);
        for (int i = 0; i <= 9; i++) {
            if (!used[i] && !(i == 0 && firstChars.indexOf(chars.charAt(step)) != -1)) {
                used[i] = true;
                numMap += (char) ('0' + i);
                if (backtrack(step + 1, used, chars, firstChars, numMap, words)) return true;
                used[i] = false;
                numMap = numMap.substring(0, numMap.length() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"SIX", "SEVEN", "SEVEN"};
        String result = "TWENTY";
        System.out.println(isSolvable(words, result));
    }
}