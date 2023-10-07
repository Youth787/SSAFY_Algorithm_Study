import java.util.Arrays;
import java.util.Scanner;

public class bj15655 {

    static int n, m;
    static int[] nums, temp;
    static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        visited = new boolean[n];
        temp = new int[m];

        solve(0, 0);

    }

    static void solve(int idx, int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++)
                System.out.print(temp[i] + " ");
            System.out.println();
            return;
        }
        if (idx >= n) return;

            visited[idx] = true;
            temp[cnt] = nums[idx];
            solve(idx + 1, cnt + 1);
            visited[idx] = false;
            solve(idx + 1, cnt);



    }
}
