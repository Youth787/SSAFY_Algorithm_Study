import java.util.*;


//1. count == m 일때 마다 sb를 새로 만들어주는것 생각못했음
//2. 게다가 그거를 HashSet에 String으로 넣어서 중복 제거해서 출력하는걸 생각 못했음
// HashMap으로 풀려했는데 Set생각했으면 수월했을듯.. String으로 전부 바꿔서 출력하는것 기억해두기
//https://girawhale.tistory.com/72
public class bj15663 {

    static int n, m;
    static int[] nums, temp;
    static boolean[] visited;
    static LinkedHashSet<String> ans;

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
        ans = new LinkedHashSet<>();

        dfs(0);

        for (String s: ans)
            System.out.print(s);
    }

    //count: depth라고 생각하기
    static void dfs(int count) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append(temp[j]).append(" ");
            }
            sb.append("\n");
            ans.add(sb.toString());
            return;

        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[count] = nums[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
        }
    }

