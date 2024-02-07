import java.util.*;

public class 과제진행하기 {
    public static void main(String[] args) {
        String[][] plans = {
                {"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}
        };

        String[] answer = solution(plans);
        System.out.print("[");
        for (int i = 0; i < answer.length - 1; i++) {
            System.out.print("\"" + answer[i] + "\",");
        }
        System.out.println("\"" + answer[answer.length-1] + "\"]");
    }

    public static String[] solution(String[][] plansArr) {
        Plan[] plans = new Plan[plansArr.length];
        for(int i = 0; i < plansArr.length; i++) {
            plans[i] = new Plan(plansArr[i]);
        }
        Arrays.sort(plans, (a, b) -> a.start - b.start);

        Stack<Plan> stop = new Stack<>();
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < plans.length - 1; i++) {
            Plan nowPlan = plans[i];
            Plan nextPlan = plans[i+1];

            // 지금 하는 일의 끝나는 시간이 다음 일의 시간보다 늦을 경우
            if(nowPlan.getEndTime() > nextPlan.start) {
                // 지금 하는 일의 남은 시간
                // 지금하는 일의 끝나는 시간에서 다음일의 시작 시간을 빼는 것
                nowPlan.playTime = nowPlan.getEndTime() - nextPlan.start;
                stop.push(nowPlan);
                continue;
            }
            answer.add(nowPlan.name);

            // 다음 일이 시작할 때까지 남은 시간
            int restTime = nextPlan.start - nowPlan.getEndTime();

            // 다음 일 시작할 시간이 되거나 정체된 일이 없을 때까지 반복
            while(restTime > 0 && !stop.isEmpty()) {
                Plan stoppedPlan = stop.peek();
                int timeDiff = stoppedPlan.playTime - restTime;
                stoppedPlan.playTime = timeDiff;
                restTime = timeDiff * -1;
                if(timeDiff > 0) {break;}
                answer.add(stop.pop().name);
            }
        }

        answer.add(plans[plans.length - 1].name);
        while(!stop.isEmpty()) answer.add(stop.pop().name);

        return answer.toArray(new String[answer.size()]);
    }

    public static class Plan {
        String name;
        int start;
        int playTime;

        public Plan(String name, String start, String playTime) {
            this.name = name;
            String[] time = start.split(":");
            this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            this.playTime = Integer.parseInt(playTime);
        }

        public Plan(String[] plan) {
            this(plan[0], plan[1], plan[2]);
        }

        public int getEndTime() {
            return start + playTime;
        }
    }
}