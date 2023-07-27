class Solution221 {
    public int min(int a, int b, int c) {
        int ret = a;
        if (b < ret) ret = b;
        if (c < ret) ret = c;
        return ret;
    }

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int largest = 0;
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (largest == 0 && matrix[i][j] == '1') largest = 1;
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1'){
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;    
                } else {
                    matrix[i][j] = 0;
                }
                if (dp[i][j] > largest) largest = dp[i][j];
            }
        }

        /*for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0 ; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return largest * largest;*/
    }
}