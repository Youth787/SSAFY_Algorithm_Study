import java.io.FileInputStream;
import java.util.Scanner;
 
//[문제] n개의 자연수 중 최소 1개 이상의 수를 선택하여 그 합이 k가 되는 경우의 수 출력
//[입력] t, n, k, n개의 자연수 수열(1~100 수)
 
public class Solution { 
    static int n;
    static int k;
    static int sum;
    static int cnt;
    static int[] nums; //수열 저장할 배열

    public static void main(String[] args) {       
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트 케이스 수
        for (int tc = 1; tc<=t; tc++) {
            n = sc.nextInt(); //수열에 든 자연수 개수
            k = sc.nextInt(); //나왔으면 좋겠는 합          
            nums = new int[n]; //여기서 배열 새롭게 부르면서 사이즈를 n이라고 정해준다
             
            sum = 0;
            cnt = 0;
             
            for (int i = 0; i<n; i++) {
                nums[i]=sc.nextInt();
            } //입력
             
            arr(0,0);             
            System.out.println("#"+tc+" "+cnt);
        }//test_case
    }//main
  
  public static void arr(int idx, int sum) {
        //기저파트
        if (idx == n) {
            if (sum == k) {
                cnt++;
            }
            return;
        }
         
        //재귀파트
        arr(idx+1,sum + nums[idx]);//합
        arr(idx+1, sum);//x
    }//arr
}//class
