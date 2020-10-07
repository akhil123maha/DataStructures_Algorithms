package com.ds.algo.facebook.leetcode;

import java.util.*;

/***
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 *
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPoints {
    static class Point {
        double x;
        double y;

        Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static List<Point> kClosest(List<Point> points, int K) {
        PriorityQueue<Point> heap = new PriorityQueue<>(K, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                double distanceOfA = Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2));
                double distanceOfB = Math.sqrt(Math.pow(b.x, 2) + Math.pow(b.y, 2));
                if(distanceOfA < distanceOfB)
                    return -1;
                else if(distanceOfA > distanceOfB)
                    return 1;
                else
                    return 0;
            }
        });
        for (Point point: points) {
            heap.add(point);
        }
        List<Point> kClosetPoints = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            Point point = heap.poll();
            kClosetPoints.add(point);
        }
        return kClosetPoints;
    }

    public static void main(String[] args) {
        //[[3,3],[5,-1],[-2,4]]
        Point a = new Point(3, 3);
        Point b = new Point(5, -1);
        Point c = new Point(-2, 4);
        List<Point> points = Arrays.asList(a, b, c);
        List<Point> kClosest = KClosestPoints.kClosest(points, 2);
        System.out.println("kClosest = " + kClosest);

    }
}
