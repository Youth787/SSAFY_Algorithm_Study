import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();
            StringBuilder sb = new StringBuilder(input);
            String result = "2";

            // 회문
            if (input.equals(sb.reverse().toString())) {
                result = "0";
            }

            // 유사회문
            else {
                int left = 0;
                int right = input.length() - 1;
                while (left < right) {
                    if (input.charAt(left) != input.charAt(right)) {
                        // 왼쪽, 오른쪽 각각 지워봄
                        StringBuilder delLeft = new StringBuilder(input).deleteCharAt(left);
                        StringBuilder delRight = new StringBuilder(input).deleteCharAt(right);

                        // 둘중 하나라도 성사되면 유사회문
                        if (delLeft.toString().equals(delLeft.reverse().toString()) || delRight.toString().equals(delRight.reverse().toString())) {
                            result = "1";
                        }
                        break;
                    }
                    left++;
                    right--;
                }
            }
            answer.append(result).append("\n");
        }
        answer.deleteCharAt(answer.length() - 1);
        System.out.print(answer);
   }
}
