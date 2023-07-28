class Solution1505 {
    public String minInteger(String num, int k) {
        if (k == 0 || num.length() == 0) return num;
        char[] arr = num.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            char min = arr[i];
            int minIdx = i;
            for (int j = i + 1; j < arr.length && j < i + k + 1; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            char temp = arr[minIdx];
            for (int j = minIdx; j > i; j--) {
                arr[j] = arr[j - 1];
                k--;
            }
            arr[i] = temp;
        }
        return new String(arr);   
    }
}