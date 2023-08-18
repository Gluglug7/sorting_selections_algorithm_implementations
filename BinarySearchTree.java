public class BinarySearchTree {
    SetNode root;
    
    public boolean contains(int value) {
        SetNode node = root;
        while (node != null) {
            if (node.key == value)
                return true;
            if (value > node.key)
                node = root.right;
            if (value < node.key)
                node = root.left;
        }
        return false;
    }

    public void add(int value) {
        if (root == null) {
            root = new SetNode(value, null);
            return;
        }
        SetNode parent = null;
        SetNode node = root;
        while (node != null) {
            if (node.key == value) return;
            parent = node;
            if (value < node.key) {
                node = parent.left;
            } else {
                node = parent.right;
            }
        }

        SetNode newNode = new SetNode(value, parent);
        if (value < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }
}

class SetNode {
    int key;
    SetNode left, right;
    SetNode parent;
    
    SetNode(int key, SetNode parent) {
        this.key = key;
        this.parent = parent;
    }
}
