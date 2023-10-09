import java.util.*;


public class bj15664 {

    static int n, m, cnt;
    static int[] nums, temp;
    static LinkedHashSet<String> ans;
  // 조합이니까 visited는 필요 없다.
  // 이전 09_15663 과 같은 방향으로 풀되, 순열이 아닌 조합문제!

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
        ans = new LinkedHashSet<>();

        dfs(0, 0);

        for (String s: ans)
            System.out.print(s);
    }

    //count: depth라고 생각하슈
    static void dfs(int idx, int count) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append(temp[j]).append(" ");
            }
            sb.append("\n");
            ans.add(sb.toString());
            return;

        }
        if (idx >= n) return;


        visited[idx] = true;
        temp[count] = nums[idx];
        dfs(idx + 1, count + 1);
        visited[idx] = false;
        dfs(idx + 1, count);

        }
}


