import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//시간초과 개빡친다고
public class bj20923 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 각각 가지는 카드갯수
        int m = Integer.parseInt(st.nextToken()); // 게임 진행 횟수
        Deque<Integer> doo = new ArrayDeque<>(2500000); // 처음 도도 가진 카드 스택
        Deque<Integer> su = new ArrayDeque<>(2500000); // 처음 수연 가진 카드 스택
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            doo.addLast(Integer.parseInt(st.nextToken()));
            su.addLast(Integer.parseInt(st.nextToken()));
        }
        //입력 끝
        // 도도 먼저 시작
        // 종을 도도가 치면 수연꺼 먼저 ㄷㄷ꺼에 합한 후, 도도 앞에 그라운드에 있는 카드도 뒤집어서
        // 도도 카드 아래로 가져와 합친다.
        // 그라운드가 비어있는데 치면 안됨 !!
        // 그라운드 도도 & 그라운드 수연은 큐로 만들자!
        // 도도는 카드 한개가 5면 종치고, 수연이는 합이 5가되면 종을 친다.
        Deque<Integer> gdoo = new ArrayDeque<>(2500000);
        Deque<Integer> gsu = new ArrayDeque<>(2500000);
        int nowDoo;
        int nowSu = -1;
        int count = 0;
        while (!doo.isEmpty() || !su.isEmpty() || count < m) {
            nowDoo = doo.pollLast(); // 도도가 먼저 카드를 뽑고
            gdoo.add(nowDoo); // 그라운드에 낸다
            count++;
            a: if (nowSu < 0 || nowDoo < 0) {
                break a;
            } else if (nowSu == 5 || nowDoo == 5) { // 도도가 이기는 조건
                for (int i = 0; i < gsu.size(); i++) {
                    doo.addLast(gsu.poll());
                }
                for (int i = 0; i < gdoo.size(); i++) {
                    doo.addLast(gdoo.poll());
                }
                nowDoo = -1;
                nowSu = -1;

            } else if (nowSu + nowDoo == 5) { // 수연이 이기는 조건
                for (int i = 0; i < gdoo.size(); i++) {
                    su.addLast(gdoo.poll());
                }
                for (int i = 0; i < gsu.size(); i++) {
                    su.addLast(gsu.poll());
                }
                nowDoo = -1;
                nowSu = -1;
            }

            if(doo.isEmpty() || su.isEmpty() || count == m) break;
            nowSu = su.pollLast(); // 수연이가 카드 뽑고
            gsu.add(nowSu); // 그라운드에 낸다.
            count++;

            b: if (nowDoo < 0 || nowSu < 0) {
                break b;
            } else if (nowSu == 5 || nowDoo == 5) { // 도도가 이기는 조건
                for (int i = 0; i < gsu.size(); i++) {
                    doo.addLast(gsu.poll());
                }
                for (int i = 0; i < gdoo.size(); i++) {
                    doo.addLast(gdoo.poll());
                }
                nowDoo = -1;
                nowSu = -1;
            } else if (nowSu + nowDoo == 5) { // 수연이 이기는 조건
                for (int i = 0; i < gdoo.size(); i++) {
                    su.addLast(gdoo.poll());
                }
                for (int i = 0; i < gsu.size(); i++) {
                    su.addLast(gsu.poll());
                }
                nowDoo = -1;
                nowSu = -1;
            }

        }
        StringBuilder sb = new StringBuilder() ;
        if (doo.size() == su.size()) {
            sb.append("dosu");
        } else if (doo.size() > su.size()) {
            sb.append("do");
        } else {
            sb.append("su");
        }
        System.out.println(sb);

    }
}
