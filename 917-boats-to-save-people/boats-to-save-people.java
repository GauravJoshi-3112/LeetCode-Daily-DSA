class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        int start = 0, end = people.length-1;
        Arrays.sort(people);
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                boatCount++;
                start++;
                end--;
            } else {
                boatCount++;
                end--;
            }
        }

        return boatCount;
    }
}