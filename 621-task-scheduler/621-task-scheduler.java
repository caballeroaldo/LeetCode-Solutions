class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Base case if cooldown is nonexistent
        if(n == 0) {
            return tasks.length;
        }
        
        // HashMap to keep track of Tasks
        int[] countTasks = new int[26];
        for(char c : tasks) {
            countTasks[c - 'A']++;
        }
        
        // Max heap to know which task is next to be processed
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a,b) -> b - a);
        for(int v : countTasks) {
            if(v > 0) {
                maxHeap.add(v);
            }
        }
        
        // Queue to know when to push task to the heap for processing
        // Pair with Task and the Time it can be processed again
        Queue<Pair<Integer,Integer>> processing = new LinkedList<>();
        
        int time = 0;
        while((!maxHeap.isEmpty() || !processing.isEmpty())) {
            time++;
            // If maxHeap is not empty process most task
            if(!maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                task -= 1;
                if(task > 0) {
                    processing.add(new Pair(task, time+n));
                }
            }
            
            // If queue is not empty, check if current time == peek time
            if(!processing.isEmpty() && processing.peek().getValue() == time) {
                maxHeap.add(processing.poll().getKey());
            }
        }
        
        return time;
        
    }
}