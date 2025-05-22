package com.v1.tgco;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RobotGrid {
    // Placeholder code for the main implementation class

    private static final int[][] STARTING_ROUTES = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static final int MAX_COORDINATE = 9999;

    public boolean isSafe(int x, int y) {
        long product = (long) x*y;
        int sum = 0;
        product = Math.abs( product );
        while (product > 0) {
            sum += ( int ) (product % 10);
            product /= 10;
        }
        return sum < 19;
    }

    public int totalSafeSquares() {
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int total = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            total++;
            for (int[] each : STARTING_ROUTES) {
                int x = curr[0] + each[0];
                int y = curr[1] + each[1];
                String key = x + "," + y;
                if (!visited.contains(key) && Math.abs(x) <= MAX_COORDINATE && Math.abs(y) <= MAX_COORDINATE && isSafe(x, y)) {
                    queue.add(new int[]{x, y});
                    visited.add(key);
                }
            }
        }
        return total;
    }

    public int shortestSafeJourney(int a, int b, int x, int y) {
        // TODO: Add implementation logic here
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
