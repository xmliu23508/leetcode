package palindrome_partition_ii;

public class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] isP = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    isP[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        isP[i][j] = true;
                    } else {
                        isP[i][j] = isP[i + 1][j - 1];
                    }
                }
            }
        }
        int[] cut = new int[len];
        for (int i = 1; i < len; i++) {
            if (isP[0][i]) {
                cut[i] = 0;
            } else {
                cut[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= i; j++) {
                    if (isP[j][i]) {
                        cut[i] = Math.min(cut[i], cut[j - 1] + 1);
                    }
                }
            }
        }
        return cut[len - 1];
    }
}