class NumberContainers {
    // Creating Two Map's
    // Map 1 :- index -> element
    // Map 2 :- element -> indxes in sorted order
    HashMap<Integer,Integer> indexMap;
    HashMap<Integer,TreeSet<Integer>> elemMap;
    public NumberContainers() {
        indexMap = new HashMap<>();
        elemMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            // Some Element Does already Exists in that Map
            TreeSet<Integer> pq = elemMap.get(indexMap.get(index));
            if (pq.size() == 1) elemMap.remove(indexMap.get(index));
            else pq.remove(index);
        }

        indexMap.put(index, number);
        // Number Already Existed
        TreeSet<Integer> pq = elemMap.getOrDefault(number, new TreeSet<>());
        pq.add(index);
        elemMap.put(number,pq);
    }
    
    public int find(int number) {
        if (elemMap.containsKey(number)) {
            return elemMap.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */