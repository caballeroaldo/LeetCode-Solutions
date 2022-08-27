class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> schedule = new ArrayList<>();

        HashMap<Integer, Integer> appearances = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
    
        for (int i = 0; i < numCourses; i++) {
            appearances.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // b. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child);
            appearances.put(child, appearances.get(child) + 1);
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : appearances.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        // d. For each source, add it to the schedule 
        // and subtract one from all of its 
        // children's in-degrees if a child's in-degree 
        // becomes zero, add it to sources queue
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            schedule.add(vertex);
            // get the node's children to decrement their in-degrees
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                appearances.put(child, appearances.get(child) - 1);
                if (appearances.get(child) == 0)
                    sources.add(child);
            }
        }

        // if schedule doesn't contain all tasks, 
        // there is a cyclic dependency between 
        // tasks, therefore, we will not be able to schedule all tasks
        return schedule.size() == numCourses;
    }
}