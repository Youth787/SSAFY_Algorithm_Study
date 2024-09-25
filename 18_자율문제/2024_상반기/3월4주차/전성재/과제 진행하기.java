import java.util.*;

class Solution {
    
    static class Task {
        private String name;
        private int start;
        private int playtime;
        
        public Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        
        public Task(String name, int playtime) {
            this.name = name;
            this.playtime = playtime;
        }
    }
    
    public List<String> solution(String[][] plans) {
    	// 정답을 저장할 리스트
        List<String> answer = new ArrayList<>();
        
        // 해야할 과제들을 시작시간 순으로 저장
        PriorityQueue<Task> pq = new PriorityQueue<>(
            (o1, o2) -> (o1.start - o2.start)
        );
        
        for(int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            
            String[] str = plans[i][1].split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int start = (h * 60) + m;
            
            int time = Integer.parseInt(plans[i][2]);
            
            pq.add(new Task(name, start, time));
        }
        
        // 잠시 멈춘 과제를 저장
        Stack<Task> remainingTasks = new Stack<>();
        
        while(!pq.isEmpty()) {
            Task currentTask = pq.poll();
            
            String curName = currentTask.name;
            int curStart = currentTask.start;
            int curPlaytime = currentTask.playtime;
            
            // 현재 시각
            int currentTime = curStart;
            
            // 새로운 과제가 남아있는 경우(진행중이던 과제 제외)
            if(!pq.isEmpty()) {
                Task nextTask = pq.peek();
                
                // 지금 과제를 끝내고도 다음 과제 시작까지 시간이 남는 경우
                if(currentTime + curPlaytime < nextTask.start) {
                    answer.add(curName);
                    currentTime += curPlaytime;
                    
                    // 잠시 멈춘 과제가 있는 경우, 남는 시간동안 멈췄던 과제 해결
                    while(!remainingTasks.isEmpty()) {
                        Task rem = remainingTasks.pop();
                        
                        // 다음 새로운 과제 시작전까지 다 끝낼수 있는 경우
                        if(currentTime + rem.playtime <= nextTask.start) {
                            currentTime += rem.playtime;
                            answer.add(rem.name);
                            continue;
                        } 
                        // 다음 새로운 과제 시작전까지 못 끝내는 경우
                        else {
                            int t = rem.playtime - (nextTask.start - currentTime);
                            // 추가로 한 시간만 빼서 멈춘 과제 목록에 다시 추가
                            remainingTasks.push(new Task(rem.name, t));
                            break;
                        }
                    }
                }
                // 지금 과제 끝내면 새로운 과제 시작할 시간인 경우
                else if(curStart + curPlaytime == nextTask.start) {
                    answer.add(curName);
                    continue;
                }
                // 새로운 과제 시작전까지 지금 과제를 못 끝내는 경우
                else {
                    int t = (nextTask.start - currentTime);
                    remainingTasks.push(new Task(curName, curPlaytime - t));
                }
                
            }
            
            // 더 이상 남아있는 새로운 과제가 없는 경우
            else {
                // 남아있는 과제(잠시 멈춘 과제)도 없는 경우
                if(remainingTasks.isEmpty()) {
                    currentTime += curPlaytime;
                    answer.add(curName);
                }
                // 남아있는 과제는 있는 경우
                else {
                    answer.add(curName); // 새로운 과제부터 먼저 해결
                    
                    // 남아있는 과제들을 정해진 순서대로 끝내면 됨
                    while(!remainingTasks.isEmpty()) {
                        Task rem = remainingTasks.pop();
                        answer.add(rem.name);
                    }
                }
            }
        }
        
        return answer;
    }
}
