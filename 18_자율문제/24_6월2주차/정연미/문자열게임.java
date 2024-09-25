package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < T; testcase++) {
            String input = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K==1){
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26];
            for(int i=0; i<input.length(); i++){
                alpha[input.charAt(i)-'a']++;
            }

            int max = -1;
            int min = Integer.MAX_VALUE;
            for(int i=0; i<input.length(); i++){
                if(alpha[input.charAt(i)-'a']<K) continue;

                int count =1;
                for(int j=i+1; j<input.length(); j++){
                    if(input.charAt(j) == input.charAt(i)) count ++;
                    if(count ==K){
                        min = Math.min(min, j-i+1);
                        max = Math.max(max, j-i+1);
                        break;
                    }
                }
             }

            if(min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
            else System.out.println(min+" "+max);

        }
    }
}
