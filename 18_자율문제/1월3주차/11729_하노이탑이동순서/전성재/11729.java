import java.io.*;

public class Main{
    static StringBuffer sb;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        hanoi(1, 2, 3, N);

        System.out.println(cnt);
        System.out.print(sb);
    }

    static void hanoi(int from, int use, int to, int N){
        if(N == 1) {
            cnt++;
            sb.append(from+" "+to).append("\n");
            return;
        }

        hanoi(from, to, use, N-1);
        sb.append(from+" "+to).append("\n");
        cnt++;
        hanoi(use, from, to, N-1);
    }
}
