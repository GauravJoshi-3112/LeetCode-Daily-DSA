class Solution {
    public int findCenter(int[][] edges) {
        for(int i=1; i<edges.length; i++) {
            int [] prevEdge = edges[i-1];
            int [] currEdge = edges[i];
            if (currEdge[0] == prevEdge[0] || currEdge[0] == prevEdge[1]) return currEdge[0];
            else return currEdge[1];
        }
        return -1;
    }
}