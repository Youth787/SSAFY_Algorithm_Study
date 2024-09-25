
class Solution {

    //음양 더하기 
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < signs.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }

    //귤 고르기
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(((o1, o2) -> map.get(o2) - map.get(o1)));

        for (Integer i : keyList) {
            if (k <= 0) break;
            answer++;
            k -= map.get(i);
        }
        return answer;
    }

    //아날로그 시계
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        int start = toSecond(h1,m1,s1);
        int end = toSecond(h2,m2,s2);
        answer = cal(end) - cal(start) + (alramNow(start)? 1:0); 
        															
        return answer;
    }
    static int cal(int time){
        int sm = time*59/3600; 
        int sh = time*719/43200;
        int a = 43200 <= time ? 2 : 1;    
        return sm+sh - a;
    }
    static int toSecond(int h,int m,int s){
        int k = h*3600+m*60+s;
        return k;
    }
    static boolean alramNow(int time){
        return time*59%3600==0 || time*719%43200==0; 
    }
}
