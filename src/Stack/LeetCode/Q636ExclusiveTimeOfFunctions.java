package Stack.LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Q636ExclusiveTimeOfFunctions {
    static void main(String[] args) {
        int n = 2;
        List<String> logs = List.of("0:start:0","1:start:2","1:end:5","0:end:6");


        int[] ans = exclusiveTime(n , logs);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {

        // array to store result
        int ans[] = new int[n];

        Stack<Integer> st = new Stack<>();
        // stores the running time of the process
        int prevtime = 0;

        for(String log : logs) {
            String[] split = log.split(":");

            int id = Integer.parseInt(split[0]);
            int timeStamp = Integer.parseInt(split[2]);

            if(split[1].equals("start")) {

                if(!st.empty()) {
                    // calc time till which last process run
                    ans[st.peek()] += timeStamp-prevtime;
                }
                st.push(id);
                // process will keep running form the start time of the new process
                prevtime = timeStamp;
            }else {
                // the process end so calculate its running time and pop the process form stack
                ans[st.pop()] += timeStamp - prevtime+1;
                // new process will run form time  = timestamp + 1
                prevtime = timeStamp+1;
            }
        }
    return ans;
    }
}
