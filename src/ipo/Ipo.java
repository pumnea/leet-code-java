package ipo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital,
 * LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources,
 * it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its
 * total capital after finishing at most k distinct projects.
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i]
 * is needed to start it.
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be
 * added to your total capital.
 * Pick a list of at most k distinct projects from given projects to maximize your final capital,
 * and return the final maximized capital.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 *
 * @author Alex Pumnea
 */
public class Ipo {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int projectIdx = 0;
        int[][] projects = new int[n][2];

        for (int i = 0; i < n; i++) {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }

        Arrays.sort(projects, Comparator.comparingInt(a -> a[1]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            while (projectIdx < n && projects[projectIdx][1] <= w) {
                maxHeap.add(projects[projectIdx][0]);
                projectIdx++;
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            w += maxHeap.poll();
        }

        return w;
    }
}
