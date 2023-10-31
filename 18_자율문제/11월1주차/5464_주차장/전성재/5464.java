import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] currentParking = new int[n + 1]; // 몇번 칸에 몇번차가 주차중인지
        int[] carWeight = new int[m + 1]; // 차량들의 무게
        int[] parkingWeight = new int[n + 1]; // 주차 공간들의 단위 무게당 요금

        int sum = 0;

        for (int i = 1; i <=n; i++) {
            parkingWeight[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <=m; i++) {
            carWeight[i] = Integer.parseInt(br.readLine());
        }
        Queue<Integer> queue = new LinkedList<>();

       outer: for (int i = 0; i < 2 * m; i++) {
            int car = Integer.parseInt(br.readLine());

            if (car > 0) { // 들어오는 차라면
                for (int j = 1; j < n + 1; j++) { // 번호 순대로
                    if (currentParking[j] == 0) { // 빈자리가 있으면
                        currentParking[j] = car; // 차를 주차
                        continue outer;
                    }
                }
                queue.offer(car); //빈자리가 없으면 큐에 넣음
            } else { // 나가는 차라면
                for (int j = 1; j < n + 1; j++) {
                    if (currentParking[j] == car * (-1)) {
                        currentParking[j] = 0; // 해당 자리를 0으로
                        sum += parkingWeight[j] * carWeight[car * (-1)];
                        if (!queue.isEmpty()) currentParking[j] = queue.poll();
                        // 큐가 비어있지 않다면 차가 빠져나간 자리에 맨 앞에 있는 차를 넣음
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
