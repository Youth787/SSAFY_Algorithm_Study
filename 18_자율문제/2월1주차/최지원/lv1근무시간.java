import java.io.*;
import java.util.*;
/*
 * 문자열로 입력된 숫자 끊어서 사용할 때 (ex. 09:17_19:24) => int num = Integer.valueOf(tmp.substring(3,5));
 * substring(시작 인덱스, 끝인덱스-1) 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            String tmp = br.readLine();
            int stH = Integer.valueOf(tmp.substring(0,2));
            int stM = Integer.valueOf(tmp.substring(3,5));
            int edH = Integer.valueOf(tmp.substring(6,8));
            int edM = Integer.valueOf(tmp.substring(9,11));
            if (edM < stM) {
                edH--;
                edM += 60;
            }
            sum += (edM- stM) + (edH - stH)*60;
        }
        System.out.println(sum);
    }
}
