class Solution {
    public int numIslands(char[][] grid) {
        boolean [][] visited = new boolean [grid.length][grid[0].length];
        int island = 0;
        // Traverse the Grid
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '0' || visited[i][j]) continue;
                // Conduct bfs for that node
                Queue<int []> q = new LinkedList<>();
                q.offer(new int [] {i,j});
                while(!q.isEmpty()) {
                    int [] node = q.poll();
                    int u = node[0], v = node[1];
                    if (u < 0 || v < 0 || u >= grid.length || v >= grid[0].length || grid[u][v] == '0' || visited[u][v]) continue;
                    else {
                        visited[u][v] = true;
                        q.offer(new int [] {u+1,v});
                        q.offer(new int [] {u-1,v});
                        q.offer(new int [] {u,v+1});
                        q.offer(new int [] {u,v-1});
                    }
                }
                island+=1;
            }
        }
        return island;
    }
}