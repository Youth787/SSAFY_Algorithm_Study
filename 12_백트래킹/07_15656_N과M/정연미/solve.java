import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 중복이 가능한 수열 

public class N과M7 {
    static int N, M;
    static int[] arr, result;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) 
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        nPr(0);
        
        bw.flush();
        bw.close();
    }// main end

    public static void nPr(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) 
                bw.write(result[i] + " ");
            bw.newLine();
            return;
        } // 기저조건

        for (int i = 0; i < N; i++) {
            result[depth] = arr[i];
            nPr(depth + 1);
        }
    }
}