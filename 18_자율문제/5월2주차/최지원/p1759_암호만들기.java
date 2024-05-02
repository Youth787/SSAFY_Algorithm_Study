import java.util.*;

public class Main {

    static char[] arr;
    static boolean[] visited;
    static int l, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();

        arr = new char[c];
        visited = new boolean[c];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);

        dfs(0, 0);

    } //main

    static void dfs(int start, int count) {
        if (count == l) {
            String word = "";
            int a = 0;
            int b = 0;
            for (int i = 0; i < c; i++) {
                if (visited[i]) {
                    word += arr[i];

                    if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                        a++;
                    } else {
                        b++;
                    }
                }
            }
            if (a >= 1 && b >= 2) {
                System.out.println(word);
            }
        }

        for (int i = start; i < c; i++) {
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    } //dfs
} //class
