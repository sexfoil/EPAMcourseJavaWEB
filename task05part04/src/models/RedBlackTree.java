package models;

import models.entity.TreeNode;

public class RedBlackTree {

    private int size;
    private TreeNode root;

    public RedBlackTree() {
        size = 0;
    }

    private void createRoot(int data) {
        root = new TreeNode(data);
        root.setRed(false);
    }

    public void add(int data) {
        if (root == null) {
            createRoot(data);
        }
        // add node to tree...
    }
}
