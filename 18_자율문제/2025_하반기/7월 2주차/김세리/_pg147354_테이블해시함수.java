import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data,(a,b)->{
            // col-1 같을 땐 원래 주어진 행에서(기본키에서) 내림차순(큰게 먼저)
           if(a[col-1]==b[col-1]) return Integer.compare(b[0],a[0]);
            // col-1 열의 값 오름차순(작은게 먼저)
            return Integer.compare(a[col-1],b[col-1]);
        });
        for(int i=row_begin-1;i<=row_end-1;i++){
            int sum =0;
            for(int j=0;j<data[0].length;j++){
                sum += data[i][j]%(i+1);
            }
            answer ^=sum;
        }
        return answer;
    }
}
