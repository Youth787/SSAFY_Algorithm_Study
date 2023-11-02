import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int ComputerNum;
    static int NetworkNum;
    static boolean[][] graph;
    static boolean[] visit;
    static int count;
    static void dfs(int v){
        count++;
        visit[v] = true;
        for(int i=1;i<=ComputerNum;i++){
            if((!visit[i])&&(graph[v][i])){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       ComputerNum = Integer.parseInt(br.readLine());
       NetworkNum = Integer.parseInt(br.readLine());
       graph = new boolean[ComputerNum+1][ ComputerNum+1];
       visit = new boolean[ComputerNum+1];
        for(int i=0; i<NetworkNum;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            graph[a1][a2] = true;
            graph[a2][a1] = true;
        }
        count =0;
        dfs(1);
        System.out.println(count-1);
    }

}
