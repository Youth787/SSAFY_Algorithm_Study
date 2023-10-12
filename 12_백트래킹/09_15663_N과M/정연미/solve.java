package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

//입력 값에 중복된 값이 있는 경우

public class N과M9 {
    static LinkedHashSet<String> set;// 중복 제거를 위한 해쉬셋
    static int N, M;
    static int[] result, arr;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        arr = new int[N];
        visited = new boolean[N];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // 정렬
        nPr(0);
        set.forEach(System.out::println);
        //names.forEach(d->
        //System.out.println(d)
        //);
        
        //메소드 참조(::)를 사용하면 더욱 간단하게 확인가능
        //names.forEach(System.out::println);
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
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                nPr(depth + 1);
                visited[i] = false;
            }
        }
    }
}