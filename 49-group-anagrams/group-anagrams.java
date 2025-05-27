class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(int i=0; i<strs.length; i++) {
            // Traversing the Entire Array
            char [] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String str = new String(charArr);

            // Check if Key Already Exist
            if (map.containsKey(str)) {
                map.get(str).add(strs[i]);
            } else {
                map.put(str,new ArrayList<>());
                map.get(str).add(strs[i]);
            }
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}