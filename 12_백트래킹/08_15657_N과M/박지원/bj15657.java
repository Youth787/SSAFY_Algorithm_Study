import java.util.Arrays;
import java.util.Scanner;

public class bj15657 {

    static int n, m;
    static int[] nums, temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        temp = new int[m];

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int startIdx, int cnt) { // 중복수열!! 은 startIdx와 depth를 가지고 dfs를 들어간다. 
        if (cnt == m) {
            for (int i = 0; i < m; i++)
                sb.append(temp[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = startIdx; i < n; i++) { // 그래서 dfs안에있는 for문의 첫 인덱스를 startIdx로 설정한다. > visited배열이 필요가 없음.
            temp[cnt] = nums[i];
            dfs(i, cnt + 1);
        }
    }
}

