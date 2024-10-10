//백준 거짓말 자바
//union, find
import java.io.*;
import java.util.*;

public class Main{
    private static int[] parents;
    private static int n, m;
    private static ArrayList<Integer> eList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int en = Integer.parseInt(st.nextToken());
        if (en == 0) {
            System.out.println(m);
            return;
        } else {
            for (int i = 0; i < en; i++) {
                eList.add(Integer.parseInt(st.nextToken()));
            }
        }
        ArrayList<Integer>[] partyList = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            partyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pn = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            partyList[i].add(x);
            for (int j = 1; j < pn; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                partyList[i].add(y);
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int num: partyList[i]) {
                if (eList.contains(find(parents[num]))) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;

        }


        System.out.println(cnt);
    }
    private static int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }
    private static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (eList.contains(ry)) {
            int temp = rx;
            rx = ry;
            ry = temp;
        }
        parents[ry] = rx;
    }
}
