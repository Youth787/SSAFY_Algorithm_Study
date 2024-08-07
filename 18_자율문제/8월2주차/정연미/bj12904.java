import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String First = br.readLine();
        String Second = br.readLine();

        change(First, Second);
        System.out.println(flag?1:0);
    }
    public static void change(String first, String second){
        if(first.equals(second)) {
            flag = true;
            return;
        }

        if(second.length()<=first.length())
            return;

        if(second.charAt(second.length()-1)=='A'){
            second = second.substring(0, second.length()-1);
            change(first,second); // 1번째 조건으로 바꾸기
        } else {
            second = second.substring(0, second.length()-1);
            // 문자열 reverse 하기
            // string 클래스에 reverse 메서드가 없다. 따라서 stringbuffer or stringbuilder 사용하기
            StringBuilder sb = new StringBuilder(second);
            String reverse = sb.reverse().toString();
            change(first,reverse); // 두번째 조건으로 바꾸기
        }
    }
}
