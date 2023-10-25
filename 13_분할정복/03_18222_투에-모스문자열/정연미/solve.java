import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://velog.io/@jh5253/%EB%B0%B1%EC%A4%80-18222-%ED%88%AC%EC%97%90-%EB%AA%A8%EC%8A%A4-%EB%AC%B8%EC%9E%90%EC%97%B4-Java%EC%9E%90%EB%B0%94

public class Main {
    static long [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine());
        map = new long[65];
        map[0] = 1;
        for(int i = 1; i < 65; ++i)
        {
            map[i] = map[i-1] * 2;
        }
        System.out.print(get(K));
    }
    static long get(long k)
    {
        if(k == 1) return 0;

        for(int i = 0; i < 65; ++i)
        {
            if(k <= map[i]) return 1- get(k - map[i-1]);
        }
        return 0;
    }

}