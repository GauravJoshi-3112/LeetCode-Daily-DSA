class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> rightA = new Stack<>();
        for(int i=0; i<asteroids.length; i++) {
            if (asteroids[i] > 0) rightA.push(asteroids[i]);
            else {
                while ((!rightA.isEmpty()) && rightA.peek() > 0 && Math.abs(asteroids[i]) > rightA.peek()) {
                    int elem = rightA.pop();
                }
                if (rightA.isEmpty() || rightA.peek() < 0) rightA.push(asteroids[i]);
                else if (rightA.peek() == Math.abs(asteroids[i])) rightA.pop();
            }
        }

        return rightA.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();

    }
}