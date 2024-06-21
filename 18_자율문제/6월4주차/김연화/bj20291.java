import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<String, Integer> map = new TreeMap<>();
		for(int i = 0; i<n; i++) {
			String str = sc.next();
			String ext = str.substring(str.indexOf(".")+1);
			if(map.containsKey(ext)) {
				int tmp = map.get(ext);
				map.replace(ext, ++tmp);
			}else {
				map.put(ext, 1);
			}
		}
		for(String key: map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
	}
}
