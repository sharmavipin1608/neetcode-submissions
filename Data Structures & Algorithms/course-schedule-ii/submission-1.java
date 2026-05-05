class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] preq : prerequisites) {
            adjList.get(preq[1]).add(preq[0]);
            inDegree[preq[0]]++;
        }    

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            result[index++] = currentCourse;   
            
            for (int course : adjList.get(currentCourse)) {
                inDegree[course]--;

                if (inDegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }

        return index == numCourses ? result : (new int[0]);
    }
}
