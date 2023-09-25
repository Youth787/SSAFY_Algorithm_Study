import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] vowels = { 'a', 'e', 'i', 'o', 'u'}; //모음

        while(true){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("end")) break;
            else {
                boolean t = true;
				boolean Vowel = false;
                int cntVowel = 0;//모음 카운트
                int cntConsonant = 0;//자음 카운트
                
                for(int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);
                    boolean isVoewl = false;
                    //모음인지 확인 : 모음이 연속 몇 번 나오는지 체크, 자음 연속 개수는 0으로
                    for(int j = 0; j < vowels.length; j++){
                        if(c == vowels[j]){
                            isVoewl = true;
                            Vowel = true;
                            cntVowel++;
                            cntConsonant = 0;
                            break;
                        }
                    }
                    //자음이라면
                    if(!isVoewl) {
                        cntConsonant++;
                        cntVowel = 0;
                    }
                    //문자열 끝까지 탐색했는데 모음이 없다면
					if (i == s.length()-1){
                        if(!Vowel) {
                            System.out.println("<" + s + "> is not acceptable.");
                            t = false;
                            break;
                        }
                    }
                    if(i >= 1){
                        //동일한 문자가 2개 연속되는지 검사
                        if(c == s.charAt(i-1) && c != 'e' && c != 'o'){
                            System.out.println("<" + s + "> is not acceptable.");
                            t = false;
                            break;
                        }
                        //모음 혹은 자음이 3개 연속되는지 검사
                        else if(cntVowel >= 3 || cntConsonant >= 3){
                            System.out.println("<" + s + "> is not acceptable.");
                            t = false;
                            break;
                        }
                    }
                }
                if(t) System.out.println("<" + s + "> is acceptable.");
            }
        }
    }
}
