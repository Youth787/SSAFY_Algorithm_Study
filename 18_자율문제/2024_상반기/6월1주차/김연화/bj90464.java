import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int num = Integer.parseInt(br.readLine()); 
        for (int h = 0; h < num; h++) {
            str = br.readLine().replace(" ", ""); 
            int max = 0;  
            int count = 0; 

            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            for (int j = 1; j < arr.length; j++) {
                if (arr[max] < arr[j])
                    max = j;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[max] == arr[i])
                    count++;

            }

            char ch = (char) (max + 'a');
            System.out.println(count > 1 ? "?" : ch);

        }
    }
}
