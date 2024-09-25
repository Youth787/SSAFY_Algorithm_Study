import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>(); // 입력을 받기 위한 map
		
		int cnt = 0; // 전체 개수
		while (true) {
			String line = br.readLine();
			if(line==null || line.isEmpty()) {
				break;
			}
			cnt++;
			if (!map.containsKey(line)) {
				map.put(line, 1);
			} else {
				map.put(line, map.get(line) + 1);
			}

		} // 입력 받기

		List<String> sortedKeys = new ArrayList<>(map.keySet());
		Collections.sort(sortedKeys); // key값을 정렬

		HashMap<String, Float> map1 = new HashMap<>(); // %를 담기 위한 map

		for (String key : sortedKeys) {
			map1.put(key, ((float)map.get(key) / cnt) * 100);
		}

		for(String key : sortedKeys) {
			System.out.printf("%s %.4f \n", key, map1.get(key));
		}

	}

}
