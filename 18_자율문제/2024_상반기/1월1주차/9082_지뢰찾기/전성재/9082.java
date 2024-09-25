import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int total = 0;
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                total += (str.charAt(i) - '0');
            }
            br.readLine();
            System.out.println((total+2)/3);
        }
    }
}
