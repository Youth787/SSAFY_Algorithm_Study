import java.io.*;

public class Main2607_비슷한단어 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine())-1;
        String standard = reader.readLine();
        int len = standard.length();
        int[] alphabet = new int[26]; 
        for(int i=0; i<len; i++) {
            alphabet[standard.charAt(i)-'A']++;
        }
        
        int ans = 0;
        while(n-- > 0) {
            int[] temp = alphabet.clone();
            String comp = reader.readLine();
            int cnt = 0;
            for(int i=0; i<comp.length(); i++) {
                if(temp[comp.charAt(i)-'A'] > 0) {
                    cnt++;
                    temp[comp.charAt(i)-'A']--;
                }
            }
            if(len-1 == comp.length() && cnt == comp.length()) { //길이가 한글자 작을 때
                ans++;
            } else if(len == comp.length()) { //길이가 같을 때
                if(cnt == len || cnt == len-1) ans++;
            } else if(len+1 == comp.length()) { //길이가 한글자 클 때
                if(cnt == len) ans++;
            }
        }
        System.out.println(ans);
    }
}
