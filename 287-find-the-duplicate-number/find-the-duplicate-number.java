class Solution {
    public int findDuplicate(int[] arr) {
        int index = 0;
        while(index < arr.length) {
            int curr = arr[index];
            if (curr == index+1) index++;
            else if (arr[curr-1] == curr) return arr[index];
            else {
                int elem = arr[curr-1]; // Correct Pos
                arr[curr-1] = curr;
                arr[index] = elem;
            }
        }

        return -1;
    }
}