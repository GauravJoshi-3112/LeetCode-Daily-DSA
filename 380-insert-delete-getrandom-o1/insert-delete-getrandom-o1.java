class RandomizedSet {
    // Declare Map to Store (ElementValue, Index)
    // Declare list for fast Retrieval and GetRandom
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    public RandomizedSet() {
        // Initialize the List and Map
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        // First Check if Value already Exists or Not 
        if (map.containsKey(val)) return false; // return False (cannot insert Value already exists) O(1)
        map.put(val,list.size()); // Inserting Element at map & list 
        list.add(val); // Adding at Last Index By Default 
        return true; // Hence all Operation O(1)
    }
    
    public boolean remove(int val) {
        // Checks if value exists in Map or Not
        if (!map.containsKey(val)) return false; // false if not exists 
        int index = map.get(val); // get Index at Last
        // Swap Element from last Index to elemIndex
        int elemAtLastIndex = list.get(list.size()-1);
        map.put(elemAtLastIndex, index);
        list.set(index,elemAtLastIndex);
        // Swapping is Done to not shift the elements in case of removal from middle of list. Otherwise operation would have been costed O(N)
        list.remove(list.size()-1); // Remove Last index Element
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int getRandomIndex = (int)(Math.random()*100)%list.size();
        return list.get(getRandomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */