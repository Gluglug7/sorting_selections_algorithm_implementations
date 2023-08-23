public class UnionFind {
    int[] parent;
    int[] height;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.height = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = -1;
            this.height[i] = 0;
        }
    }

    public int findRep(int x) {
        int rep = x;
        while (parent[rep] != -1) {
            rep = parent[rep];
        }
        while (parent[x] != rep) {
            int next = parent[x];
            parent[x] = rep;
            x = next;
        }

        return rep;
    }

    public boolean isSameBage(int x, int y) {
        return findRep(x) == findRep(y);
    }

    public void mergeBags(int x, int y) {
        int a = findRep(x);
        int b = findRep(y);
        if (a == b) return;
        if (height[a] > height[b]) {
            parent[b] = a;
        } else if (height[a] < height[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            height[a]++;
        }
    }
}
