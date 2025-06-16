import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] arr) {
        int n = arr.length;
        int m = (n + 1) / 2; // 숫자 개수
        int[][] dpMax = new int[m][m];
        int[][] dpMin = new int[m][m];

        // 초기값: 자기 자신
        for(int i=0; i<m; i++) {
            dpMax[i][i] = dpMin[i][i] = Integer.parseInt(arr[2*i]);
        }

        // 구간 길이
        for(int len=2; len<=m; len++) {
            for(int i=0; i<=m-len; i++) {
                int j = i+len-1;
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;
                // k: 연산자 인덱스
                for(int k=i; k<j; k++) {
                    String op = arr[2*k+1];
                    if(op.equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] + dpMax[k+1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] + dpMin[k+1][j]);
                    } else {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] - dpMin[k+1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] - dpMax[k+1][j]);
                    }
                }
            }
        }
        return dpMax[0][m-1];
    }
}
