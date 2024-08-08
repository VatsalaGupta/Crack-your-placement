public class MostStonesRemovedwithSameRoworColumn {
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        MostStonesRemovedwithSameRoworColumn solution = new MostStonesRemovedwithSameRoworColumn();
        System.out.println("Max stones removed: " + solution.removeStones(stones));
    }

    private int numOfIslands = 0;

    public int removeStones(int[][] stones) {
        int[] parent = new int[20003]; // Union-Find data structure with enough space
        for (int i = 0; i < 20003; i++) {
            parent[i] = i; // Initialize each element as its own parent
        }
        
        for (int[] stone : stones) {
            unionSets(stone[0], stone[1] + 10000, parent);
        }
        
        return stones.length - numOfIslands;
    }

    private void unionSets(int a, int b, int[] parent) {
        int parA = findParent(a, parent);
        int parB = findParent(b, parent);
        if (parA != parB) {
            parent[parB] = parA;
            numOfIslands--;
        }
    }

    private int findParent(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node], parent); // Path compression
        }
        return parent[node];
    }
}
