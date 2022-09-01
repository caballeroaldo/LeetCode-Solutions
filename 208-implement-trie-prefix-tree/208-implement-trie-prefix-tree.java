class Trie {
    
    class Node {
        private Node[] children;
        private boolean endOfWord;
        private char val;
        
        public Node(char val) {
            this.val = val;
            this.endOfWord = false;
            this.children = new Node[26];
        }
    }
    
    Node root;

    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node(ch);
            }
            curr = curr.children[ch - 'a'];
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        Node res = isWord(word);
        return res != null && res.endOfWord;
    }
    
    private Node isWord(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch - 'a'] == null ) {
                return null;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()) {
            if(curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */