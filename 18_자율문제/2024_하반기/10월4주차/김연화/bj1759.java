import java.io.*;
import java.util.*;

public class Main {

    public static int L, C;
    public static char[] list;
    public static char[] code;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < C; x++) {
            list[x] = st.nextToken().charAt(0);
        }


        // 정렬
        Arrays.sort(list);

        makeCode(0,0);

    }

    public static void makeCode(int x,int idx) {


        if (idx == L) {
            // 최소 한개의 모음, 최소 2개의 자음인지 확인
            if (isValid()) {
                System.out.println(code);
            }
            return;
        }

        // 아직 길이 L의 코드를 만들지 않았고 글자도 아직 남았다.

        for (int i = x; i < C; i++) {
            code[idx] = list[i];
            makeCode(i+1, idx + 1);
        }
    }

    // 최소 모음 1개, 최소 자음 2개인지 확인
    public static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }

}

