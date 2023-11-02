import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	private int x;
	private int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
	
}
public class bj9205fail {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
        	int n = Integer.parseInt(br.readLine());
        	List<Node> list = new ArrayList<>();
        	String ans = "happy";
        	int beer = 20;
        	for (int i = 0; i < n + 2; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		list.add(new Node(a, b));
        	}
        	for (int i = 0; i < n + 1; i++) {
        		Node start = list.get(i);
        		Node end = list.get(i + 1);
        		if (getDist(start.getX(), start.getY(), end.getX(), end.getY()) > beer * 50) {
        			ans = "sad";
        			break;
        		}
        	}
        	System.out.println(ans);
        	
        }
        
    }
    static int getDist(int x, int y, int x1, int y1) {
    	return Math.abs(x - x1) + Math.abs(y - y1);
    }

}

//1
//5
//0 0
//1000 0
//2000 0
//3000 0
//1000 1000
//4000 0
//5000 0
