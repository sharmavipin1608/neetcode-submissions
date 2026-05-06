class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int refs = 0;
        int index = -1;

        TrieNode() {
            Arrays.fill(children, null);
        }

        public void addWord(String word, int index) {
            TrieNode curr = this;
            curr.refs++;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
                curr.refs++;
            }
            curr.index = index;
        }
    }

class Solution {
    private final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        buildDict(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, words);
            }
        }
        return result;
    }

    private void dfs(char[][]board, int r, int c, TrieNode node, String[] words) {
        int rows = board.length;
        int cols = board[0].length;

        if (r < 0 || c < 0 || r == rows || c == cols || board[r][c] == '#' 
            || node.children[board[r][c] - 'a'] == null) {
            return;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        TrieNode prev = node;
        node = node.children[temp - 'a'];
        
        if (node.index != -1) {
            result.add(words[node.index]);
            node.index = -1;
            node.refs--;
            if (node.refs == 0) {
                node = null;
                prev.children[temp - 'a'] = null;
                board[r][c] = temp;
                return;
            }
        }

        for (int [] dir : DIRS) {
            dfs(board, r + dir[0], c + dir[1], node, words);
        }

        board[r][c] = temp;
    }

    private void buildDict(String[] words) {
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i], i);
        }
    }
}
