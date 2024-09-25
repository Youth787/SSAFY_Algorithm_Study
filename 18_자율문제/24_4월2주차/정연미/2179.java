package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 비슷한단어2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        // 입력받기
        for(int i=0; i<N; i++){
            String input = br.readLine();
            if(!list.contains(input)) {
                list.add(input);
            }
        }

//        Collections.sort(list,(o1,o2)->(o1.length()-o2.length()));

        int result = 0;
        String[] arr_result = new String[2];
        for(int i=0; i<N-1; i++){
            String check1 = list.get(i);
            for(int j=i+1; j<N; j++) {
                String check2 = list.get(j);
                int cnt =0;
                int size=Math.min(check1.length(),check2.length());
                for(int k=0; k<size; k++){
                    if(check1.charAt(k)!=check2.charAt(k)){
                        break;
                    }
                    cnt++;
                }
                if(result<cnt){
                    result =cnt;
                    arr_result[0] = check1;
                    arr_result[1] = check2;
                }
            }
        }
        System.out.println(arr_result[0]);
        System.out.println(arr_result[1]);
    }
}
