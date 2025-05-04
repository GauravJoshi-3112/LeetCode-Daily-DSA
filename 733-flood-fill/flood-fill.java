class Solution {
    public boolean [][] visited;
    public void dfs(int [][] image, int sr, int sc, int colVar,  int color) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        else if (visited[sr][sc]) return;
        else {
            visited[sr][sc] = true;
            if (image[sr][sc] == colVar) image[sr][sc] = color;
            else return;
            dfs(image, sr+1, sc, colVar, color);
            dfs(image, sr, sc+1, colVar, color);
            dfs(image, sr-1, sc, colVar, color);
            dfs(image, sr, sc-1, colVar, color);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length];
        dfs(image, sr,sc,image[sr][sc], color);
        return image;
    }
}