import java.io.*;
import java.util.*;

//백준 1759 암호 만들기 브루트포스, 백트래킹
public class Main {
    static int l, c;
    static char[] alphabet;
    static BufferedWriter answer;
    static StringBuilder temp;
    static HashSet<Character> aeiou = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        alphabet = new char[c];
        answer = new BufferedWriter(new OutputStreamWriter(System.out));
        alphabet = br.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(alphabet);
        temp = new StringBuilder();
        
        solve(0);
        answer.flush();
        answer.close();
    }
    static void solve(int idx) throws IOException {
        if (temp.length() == l) {
            if (!isRight(temp.toString())) return;
            answer.write(temp.toString());
            answer.write("\n");
            return;
        }

        for (int i = idx; i < c; i++) {
            temp.append(alphabet[i]);
            solve(i + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    static boolean isRight(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (aeiou.contains(str.charAt(i))) cnt++;
        }
        if (cnt == 0) return false;
        return str.length() - cnt > 1;
    }
}
