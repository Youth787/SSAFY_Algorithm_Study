import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj5464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 주차장 자리 수
        int m = Integer.parseInt(st.nextToken()); // 들어올 차 수
        int[] price = new int[n + 1]; // 주차장 자리 값
        int[] w = new int[m + 1]; // 차 무게
        boolean[] check = new boolean[n + 1]; // 주차장 자리 찼나요 ?
        int[] number = new int[n + 1]; // 주차장 자리에 차 번호 몇번이 들어갔나요?
        check[0] = true; // 0번은 안써용
        int total = 0; // 최종 금액 담아줄 변수
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) { // i: 주차장번호, price[i]: 가격
        	price[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= m; i++) { // i: 차번호, w[i]:차 무게
        	w[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= m * 2; i++) { // 나가는거까지 m*2
        	int a = Integer.parseInt(br.readLine()); // 숫자를 받아와서요
        	if (a >= 0) { // 양수면 차가 들어오는건데
        		int flag = 0;
        		for (int j = 1; j <= n; j++) { // 빈자리에 넣어줄거에요(주차장 번호 작은순서대로니까 그냥 1부터 돌려서 break걸어줌)
        			if (!check[j]) {
        				check[j] = true; // 자리찼어요
        				number[j] = a; // a번이 들어왔어요
        				flag = 1; // 빈자리 있었어요
        				total += (w[a] * price[j]); // 차 들어왔으니 주차비 받을게요~
        				break; // 주차했으니 멈춰!!
        			}
        		}
        		if (flag == 0) { // 빈자리가없으면 q에 넣어줄거에요
        			q.add(a);
        		}
        	} else { // 음수가 들어온다면 차가나가요
        		int b = Math.abs(a); // 양수로 바꿔주고
        		for (int j = 1; j <= n; j++) {
        			if (b == number[j]) { // 차가 들어간 자리를 찾아서
        				check[j] = false; // 나감처리
        				number[j] = 0; // 나감처리
        				if (!q.isEmpty()) { // 근데 q가 안비어있으면 q에있는 차가 먼저 들어와야죠?
                			int next = q.poll(); // 하나 뽑아서
                			check[j] = true; // 주차완
                			number[j] = next; // next 차량이 j자리에 들어갔음
                			total += (w[next] * price[j]); // 들어왔으니 주차비 받을게요~
                		}
        			}
        		}
        	}
        }
        System.out.println(total);
    }
    
}
