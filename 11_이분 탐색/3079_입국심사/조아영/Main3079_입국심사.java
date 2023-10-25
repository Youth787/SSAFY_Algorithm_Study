import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3079_입국심사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N과 M 그리고 각 입국 심사대에서 걸리는 시간을 arr 배열에 데이터를 입력받음
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int[] arr = new int[n];
        // 그리고 가장 입국 심사대에서 오래 걸리는 시간을 max_value 로 구함
        int max_value = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max_value = Math.max(max_value, arr[i]);
        }
      
        long left = 0L;
        long right = (max_value) * 1000000000L;

        long ans = 0L;
        while (left<= right){
            long mid = (left+right) / 2;
            // mid초 일 때 각 입국 심사대에서 보낼 수 있는 수를 카운트 해줌
            long cnt = 0;
            for(int i=0;i<n;i++){
                cnt += (mid / arr[i]);

            }
            // 비교 후 탐색 범위 변경
            if(cnt >= m){
                ans = mid;
                right = mid-1;
            }  else if (cnt < m){
                left = mid +1;

            }
        }

        System.out.println(ans);

    }
}
