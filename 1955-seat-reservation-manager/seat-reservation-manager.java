class SeatManager {

    PriorityQueue<Integer> queue;
    int count = 1;
    public SeatManager(int n) {
        queue = new PriorityQueue<>();
    }
    
    public int reserve() {
        if (queue.isEmpty()) return count++;
        return queue.poll();
    }
    
    public void unreserve(int seatNumber) {
        queue.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */