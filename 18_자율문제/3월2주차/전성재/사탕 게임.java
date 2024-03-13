import java.util.*;

public class Main {
    static char[][] arr;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];
        max = 0;

        sc.nextLine();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j + 1 < n) {
                    swap(i, j, i, j + 1);
                    check();
                    swap(i, j, i, j + 1);
                }

                if(i + 1 < n) {
                    swap(i, j, i + 1, j);
                    check();
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(max);
    }
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static void check() {
        for(int i = 0; i < arr.length; i++) {
            int count = 1;
            for(int j = 1; j < arr.length; j++) {
                if(arr[i][j] == arr[i][j - 1]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        for(int i = 0; i < arr.length; i++) {
            int count = 1;
            for(int j = 1; j < arr.length; j++) {
                if(arr[j][i] == arr[j - 1][i]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }
    }
}
