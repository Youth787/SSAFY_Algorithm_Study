import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
  
        arr = new int[(int) Math.pow(2, k) - 1];//노드 수 = 2의 k제곱 -1개
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();//노드 저장
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>()); //깊이는 k
        }
      
        search(0,arr.length - 1,0);// 탐색

        StringBuilder sb = new StringBuilder();
      
        // 출력을 위해 StringBuilder에 담기
        for (int i = 0; i < k; i++) {
            for (int j : list.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void search(int start, int end, int depth) {
        //기저
        if(depth == k) return;
      
        int mid = (start + end) / 2; // 중간값

        list.get(depth).add(arr[mid]); // depth에 맞게 노드 삽입

        search(start, mid - 1, depth + 1);// 왼쪽 재귀
        search(mid + 1, end, depth + 1);// 오른쪽 재귀
    }
}
