import java.util.Arrays;
import java.util.Scanner;

public class bj15656 {

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

    static void dfs(int idx, int cnt) { // 시간초과 났던 코드는 visited를 사용했는데, 그러지 말고 idx를 같이 dfs에 넣어서 가져가서 재귀돌리기 + sb사용
        if (cnt == m) {
            for (int i = 0; i < m; i++)
                sb.append(temp[i]).append(" ");
            sb.append("\n");
            return;
        }


        for (int i = 0; i < n; i++) {
            temp[cnt] = nums[i];
            dfs(i + 1, cnt + 1);
        }


    }
}

//시간초과난 코드
// import java.util.Arrays;
// import java.util.Scanner;

// public class Main {

//     static int n, m;
//     static int[] nums, temp;
//     static boolean[] visited;

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         m = sc.nextInt();
//         nums = new int[n];
//         for (int i = 0; i < n; i++) {
//             nums[i] = sc.nextInt();
//         }
//         Arrays.sort(nums);
//         visited = new boolean[n];
//         temp = new int[m];

//         solve(0);

//     }

//     static void solve(int cnt) {
//         if (cnt == m) {
//             for (int i = 0; i < m; i++)
//                 System.out.print(temp[i] + " ");
//             System.out.println();
//             return;
//         }


//         for (int i = 0; i < n; i++) {
//             visited[i] = true;
//             temp[cnt] = nums[i];
//             solve(cnt + 1);
//             visited[i] = false;
//         }


//     }
// }

