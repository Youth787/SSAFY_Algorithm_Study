import java.io.*;
import java.util.*;

/*
 * 금고에는 귀금속 종류 = n. 배낭 최대 중량 w키로
 * 각 금속의 무게 m, 무게당 가격 p -> 가장 비싸게 채우면 얼마?
 * 전동톱으로 잘려진 부분의 무게만큼의 가치를 가짐
 *
 * 무게, 가격을 한번에 저장하고, 가격 순으로 정렬하자 => ArrayList로.
 * 정렬 기준 만들 때 Collections.sort( 이름, (o1,o2) -> 정렬기준)
 * ArrayList에 add할 때 바로 배열을 만드려면 => 선언방법 중 new int[] {원소1, 원소2, ...} 방법 사용
 * 가격은 m만큼 넣었으면 m*p원, 잘랐으면 잘라서 남긴 무게*p원 
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<int[]> info = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            info.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        Collections.sort(info, (o1,o2) -> o2[1]-o1[1]); //가격이 높은 순으로 정렬해서.

        int ans = 0;
        
        for (int[] stone: info) {
            if (w <= stone[0]) {
                ans += w*stone[1]; //남은 w만큼 톱으로 잘라서 넣었음
                break;
            } else {
                ans += stone[0]*stone[1]; //온전하게 금속을 넣었다면 가치 = (금속 무게)*(무게당 가치)
                w -= stone[0]; //w를 금속 무게만큼 빼버림
            }
        }

        System.out.println(ans);
        
    } //main
} //class
