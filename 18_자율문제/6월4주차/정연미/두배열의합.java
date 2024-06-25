package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 두배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += a[j];
                A.add(sum);
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                B.add(sum);
            }
        }

        Collections.sort(A);
        Collections.sort(B);

        int aSize = A.size();
        int bSize = B.size();

        long cnt = 0;
        int leftPointer = 0;
        int rightPointer = B.size() -1;

        while(leftPointer < aSize && rightPointer >=0){
            int sum = A.get(leftPointer) + B.get(rightPointer);
            if(sum == T){
                int aresult = A.get(leftPointer);
                int bresult = B.get(rightPointer);
                long leftCnt = 0;
                long rightCnt = 0;

                while(leftPointer < aSize && A.get(leftPointer) == aresult){
                    leftCnt++;
                    leftPointer++;
                }
                while(rightPointer >= 0 && B.get(rightPointer) == bresult){
                    rightCnt++;
                    rightPointer--;
                }
                cnt += leftCnt * rightCnt;
            }
            else if(sum < T){
                leftPointer++;
            }else if( sum> T){
                rightPointer --;
            }
        }
        System.out.println(cnt);
    }
}
