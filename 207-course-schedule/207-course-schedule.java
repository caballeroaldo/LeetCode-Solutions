class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> Schedule = new ArrayList<>();
        
        // Course i with how many prereqs are needed to take it
        HashMap<Integer,Integer> numPreq = new HashMap<>();
        
        // Course i with List Corresponding to Other Courses Course i is a prereq of 
        HashMap<Integer,List<Integer>> listOfPreq = new HashMap<>();
        
        // Initialize the Maps 
        for(int i = 0; i < numCourses; i++) {
            numPreq.put(i, 0);
            listOfPreq.put(i, new ArrayList<Integer>());
        }
        
        // Load the Maps with how many prereqs each courses has
        for(int j = 0; j < prerequisites.length; j++) {
            int course = prerequisites[j][1];
            int prereq = prerequisites[j][0];
            numPreq.put(course, numPreq.get(course) + 1);
            listOfPreq.get(prereq).add(course);
        }
        
        Queue<Integer> order = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : numPreq.entrySet()) {
            if(entry.getValue() == 0) {
                order.add(entry.getKey());
            }
        }
        
        while(!order.isEmpty()) {
            int currentCourse = order.poll();
            Schedule.add(currentCourse);
            List<Integer> updateList = listOfPreq.get(currentCourse);
            for(int c: updateList) {
                numPreq.put(c, numPreq.get(c) -1);
                if(numPreq.get(c) == 0) {
                    order.add(c);
                }
            }
        }
        return Schedule.size() == numCourses;
        
    }
}