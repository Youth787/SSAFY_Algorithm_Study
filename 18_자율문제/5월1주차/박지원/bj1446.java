import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

// 백준 지름길
// 연습하기 너무좋은 문제!! 다들 풀어보쇼!!!
// 1번예제기준 1~150까지 node가 된다는 생각을 못해서 어려웠음.. 이것만 알면 금방 풀듯?
class Route {
    int start;
    int end;
    int length;

    public Route(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }


}

public class Main {
    static int n, d, answer;
    static ArrayList<Route> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        answer = d;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if (end > d) continue;
            if (end - start > length) {
                list.add(new Route(start, end, length));
            }
        }
        Collections.sort(list, new Comparator<Route>() {
            public int compare(Route o1, Route o2) {
                if (o1.start == o2.start) {
                    return Integer.compare(o1.end, o2.end);
                }
                return Integer.compare(o1.start, o2.start);
            }
        });
        int[] distance = new int[d + 1];
        int move = 0;
        int idx = 0;
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;


        while (move < d){
            if (idx < list.size()){
                Route s = list.get(idx);
                if (move == s.start){
                    distance[s.end] = Math.min(distance[move] + s.length, distance[s.end]);
                    idx++;
                } else {
                    distance[move + 1] = Math.min(distance[move + 1], distance[move] + 1);
                    move++;
                }
            } else {
                distance[move + 1] = Math.min(distance[move + 1], distance[move] + 1);
                move++;
            }
        }
        System.out.println(distance[d]);
    }
}
