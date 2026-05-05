class WordDictionary {
    WordDictionary[] trie = new WordDictionary[26];
    boolean end = false;


    public WordDictionary() {
        Arrays.fill(trie, null);
    }

    public void addWord(String word) {
        WordDictionary current = this;

        for (char ch : word.toCharArray()) {
            if (current.trie[ch - 'a'] == null) {
                current.trie[ch - 'a'] = new WordDictionary();
            }

            current = current.trie[ch - 'a'];
        }

        current.end = true;
    }

    public boolean search(String word) {
        return find(word, 0, this);
    }

    private boolean find(String word, int wordIndex, WordDictionary dict) {
        if (wordIndex == word.length()) return dict.end;
        
        char ch = word.charAt(wordIndex);

        if (ch == '.') {
            for (WordDictionary curr : dict.trie) {
                if (curr != null && find(word, (wordIndex + 1), curr)) {
                    return true;
                }
            }

            return false;
            
        } else {
            if (dict.trie[ch - 'a'] == null) {
                return false;
            
            } 
            
            return find(word, (wordIndex + 1), dict.trie[ch - 'a']);
        }
    }
}
