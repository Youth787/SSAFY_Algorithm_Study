import java.io.*;
import java.util.*;

public class bj9934 {
    static int k;
    static int[] arr;
    static StringBuffer[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2, k) - 1]; // 숫자는 항상 2의 k승 -1 개가 존재한다

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        //입력 처리 끝
        //출력 위한 배열 생성해준다.
        ans = new StringBuffer[k];
        for (int i = 0; i < k; i++) {
            ans[i] = new StringBuffer();
        }
        
        //재귀함수를 돌린다.
        solve(0, arr.length - 1, 0);

        for (int i = 0; i < k; i++) {
            bw.write(ans[i].toString() + "\n");
        }
        bw.flush();

    }
    //mid를 부모로 두면서 계속 갱신해나간다. 계속 홀수개니까 미드가 나올수밖에없다!
    static void solve(int start, int end, int floor) {
        if (floor == k) { // floor가 트리 깊이
            return;
        }
        int mid = (start + end) / 2;
        ans[floor].append(arr[mid] + " ");

        solve(start, mid - 1, floor + 1);
        solve(mid + 1, end, floor + 1);
    }
}
//https://lotuslee.tistory.com/100
