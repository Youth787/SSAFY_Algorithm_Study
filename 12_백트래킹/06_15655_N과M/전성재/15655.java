import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static int n, m;
    public static int[] arr, nums;
   public static boolean[] visit; // 방문 여부
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n+1];

        nums=new int[n+1];

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0, 1);
        System.out.println(sb);
    }

    public static void dfs(int cnt, int start){

        if(cnt == m){
            for(int val:arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=n; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[cnt] = nums[i];
                dfs(cnt+1, i+1);
                visit[i]=false;
            }
        }

    }
}
