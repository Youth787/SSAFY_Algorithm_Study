
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

// 입력값에 중복된 값이 들어온다. 
// 인덱스에 대한 중복을 허용하는 순열 

public class N과M11 {
    static LinkedHashSet<String> set;
    static int N, M;
    static int[] result, arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        arr = new int[N];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // 정렬
        nPr(0);
        set.forEach(System.out::println);
    }

    public static void nPr(int depth) throws IOException {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++)
                sb.append(result[i] + " ");
            set.add(sb.toString());
            return;
        } // 기저조건

        for (int i = 0; i < N; i++) {
                result[depth] = arr[i];
                nPr(depth + 1);
        }
    }
}