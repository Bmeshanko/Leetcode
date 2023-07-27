class Solution1537 {
    public int maxSum(int[] a, int[] b) {
        long sum1 = 0; long sum2 = 0;
        int i = 0; int j = 0;
        while (i < a.length || j < b.length) {
            if (i < a.length && (j == b.length || a[i] < b[j])) {
                sum1 += a[i++];
            } else if (j < b.length && (i == a.length || a[i] > b[j])) {
                sum2 += b[j++];
            } else {
                sum1 = Math.max(sum1, sum2) + a[i];
                sum2 = sum1;
                i++; j++;
            }
            //System.out.println("1: " + sum1 + " 2: " + sum2);
        }
        return (int) (Math.max(sum1, sum2) % 1000000007);
    }
}