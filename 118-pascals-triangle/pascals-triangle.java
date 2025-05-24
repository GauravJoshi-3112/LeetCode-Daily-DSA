class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> baseCase = new ArrayList<>();
        baseCase.add(1);
        list.add(baseCase);
        for(int i=1; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = list.get(i-1);
            for(int j=0; j<= prevRow.size(); j++) {
                if (j == 0 || j== prevRow.size()) row.add(1);
                else row.add(prevRow.get(j) + prevRow.get(j-1));
            }
            list.add(row);
        }
        return list;
    }
}