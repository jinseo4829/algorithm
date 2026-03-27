import java.io.*;
import java.util.*;

public class Main {

    static int t;

    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            Point[] points = new Point[n+2];

            for(int i=0; i<n+2; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }

            sb.append(bfs(points, n)).append("\n");
        }

        System.out.print(sb);

    }

    public static String bfs(Point[] points, int n) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+2];

        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()) {

            int current = queue.poll();

            if(current == n+1) {
                return "happy";
            }

            for(int i=0; i<n+2; i++) {

                if(!visited[i] && getDistance(points[current], points[i]) <= 1000) {

                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return "sad";
    }

    public static int getDistance(Point a, Point b) {

        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

}