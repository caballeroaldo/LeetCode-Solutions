/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // Will keep track of the node value to 
    // the new cloned Node associated to the value
    public HashMap<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }
        // If the cloned Node isn't made yet, create it 
        // and add it to the map to keep track
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        
        // Recursively clone each of the neighbors to establish 
        // the connections of the graph
        for(Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return newNode;
        
        
        
    }
}