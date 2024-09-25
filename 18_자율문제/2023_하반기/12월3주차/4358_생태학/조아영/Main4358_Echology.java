import java.io.*;
import java.util.*;

public class Main4358_Echology {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int total = 0;
        Map<String, Integer> map = new HashMap<>();
        while (true) {
        	total++;
        	map.put(s, map.getOrDefault(s,0)+1);
        	s = br.readLine();
        	if (s==null || s.length()==0) break;
        }
        //방법 1
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String tree = entry.getKey();
            list.add(tree);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String tree : list) {
            int count = map.get(tree) * 100;
            sb.append(tree + " " + String.format("%.4f", (double)count / (double)total) + "\n");
        }
        System.out.print(sb);
        
        //방법 2
//      Object[] keys = map.keySet().toArray();
//		Arrays.sort(keys);
//		StringBuilder sb = new StringBuilder();
//		for(Object key : keys) {
//			String keyStr = (String) key;
//			int count = map.get(keyStr);
//			double per = (double)(count * 100.0) / count;
//			
//			sb.append(keyStr + " " + String.format("%.4f", per) + "\n");	// 소수점 4번 째 자리까지 출력 
//		}
//		System.out.println(sb);
    }
}
