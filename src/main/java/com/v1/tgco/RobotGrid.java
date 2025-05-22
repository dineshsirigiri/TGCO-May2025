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
        if (!isSafe(a, b) || !isSafe(x, y)) return -1;

        Set<String> visited = new HashSet<>();
        visited.add(a + "," + b);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1], dist = curr[2];

            if (cx == x && cy == y) return dist;

            for (int[] each : STARTING_ROUTES) {
                int nx = cx + each[0];
                int ny = cy + each[1];
                String key = nx + "," + ny;
                if (!visited.contains(key) && Math.abs(nx) <= MAX_COORDINATE && Math.abs(ny) <= MAX_COORDINATE && isSafe(nx, ny)) {
                    queue.add(new int[]{nx, ny, dist + 1});
                    visited.add(key);
                }
            }
        }

        return -1;
    }
}
