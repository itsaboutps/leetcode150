package HeapAndPriorityQ;

import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println("Task Scheduler");
    }
}



class Solution {
    public int leastInterval(char[] tasks, int n) {
         int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int max_count = freq[25];
        int num_max = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == max_count) {
                num_max++;
            } else {
                break;
            }
        }
        int formulaResult = (max_count - 1) * (n + 1) + num_max;
        return Math.max(formulaResult, tasks.length);
    }
}