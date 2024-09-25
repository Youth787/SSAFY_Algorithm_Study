//그널의 길이가 항상 5의 배수=총 시그널을 다섯 개로 나누고
import java.io.*;
import java.util.Arrays;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int r = 5;
        int c = n / r;

        String st = br.readLine();
        String[][] signal = new String[r][c];

        int k=0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                signal[i][j] = String.valueOf(st.charAt(k));
                k++;
            }
        }

        for (int i = 0; i < c; i++) {
            if (signal[0][i].equals("#")) {
                if (i == c - 1 ) {
                    sb.append("1");
                    continue;
                }
                if (!signal[0][i + 1].equals("#")) {
                    // 0또는 4 (다음 열이 #이 아님)
                    if (signal[3][i].equals("#")) {
                        // 3행이 #이므로 암호는 1
                        sb.append("1");
                    } else {
                        sb.append("4");
                        i += 3;
                    }
                } else {
                    // 0,4 제외
                    if (signal[1][i].equals("#") && signal[1][i + 2].equals("#")) {
                        if (!signal[2][i + 1].equals("#")) {
                            sb.append("0");
                        } else {
                            if (signal[3][i].equals("#")) {
                                sb.append("8");
                            } else {
                                sb.append("9");
                            }
                        }
                    } else if (!signal[1][i].equals("#") && signal[1][i + 2].equals("#")) {
                        if (!signal[2][i].equals("#")) {
                            sb.append("7");
                        } else {
                            if (signal[3][i].equals("#")) {
                                sb.append("2");
                            } else {
                                sb.append("3");
                            }
                        }
                    } else {
                        if (!signal[3][i].equals("#")) {
                            sb.append("5");
                        } else {
                            sb.append("6");
                        }
                    }
                    i += 3;
                }
            }
        }

        System.out.println(sb);
    }
}

