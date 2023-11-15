import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj20922 {
    

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] cnt = new int[100001]; // 1~100000갯수를 셀것이다.
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        //입력끝
        
        int start = 0;
        int end = 0;
        while (end < arr.length) { // 마지막 포인터가 arr안에 있을때 돌려돌려
        	while (end < arr.length && cnt[arr[end]] + 1 <= k) { // 근데 카운트가 k보다 작거나 같을때 돌려
        		cnt[arr[end]]++; // 마지막 포인터가 가리키는 숫자의 카운트를 늘려준다
        		end++; // 마지막포인터 오른쪽으로 이동
        	}
        	int length = end - start;
        	ans = Math.max(ans, length);
        	cnt[arr[start]]--; // 스타트 포인터 오른쪽으로 이동해줄거니까 카운트 내려주고
        	start++; // 스타트 포인트 오른쪽으로 이동!
        }
        
        System.out.println(ans);
        
    }

    

}
