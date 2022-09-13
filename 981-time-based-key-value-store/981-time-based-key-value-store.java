class TimeMap {

    // Initialize a HashMap to hold the key with a value that is associated with 
    // a TreeMap to keep track of the value based on the timestamp
    private HashMap<String, TreeMap<Integer, String>> timeMap;
    
    public TimeMap() {
        timeMap = new HashMap<String, TreeMap<Integer,String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new TreeMap<Integer,String>());
        }
        
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) {
            return "";
        }
        
        // New to me, floorKey will take the value that is less than or equal to
        // the timestamp in a TreeMap associated with the key
        Integer floorKey = timeMap.get(key).floorKey(timestamp);
        if(floorKey != null) {
            return timeMap.get(key).get(floorKey);
        }
        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */