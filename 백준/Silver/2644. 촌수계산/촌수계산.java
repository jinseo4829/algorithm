import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int start;
    static int target;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int result = bfs(start, target);
        System.out.println(result);
    }

    public static int bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int count = current[1];

            if(person == target)  {
                return count;
            }

            for(int next: graph[person]) {
                if(!visited[next]) {
                    queue.offer(new int[]{next, count + 1});
                    visited[next] = true;
                }
            }
        }
        
        return -1;
    }

}