public class BinarySearchTree {
    SetNode root;
    int height;
    
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

    public SetNode findMax(SetNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public SetNode findMin(SetNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public SetNode findNextLarger(SetNode node) {
        if (node.right != null)
            return findMin(node.right);
        while (node.parent != null && node.parent.left != node)
            node = node.parent;
        return node.parent;
    }

    public void simpleRemove(SetNode node) {
        //TODO
    }

    public void remove(SetNode node) {
        //TODO
    }

    public void rotate(SetNode node) {
        //TODO
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
