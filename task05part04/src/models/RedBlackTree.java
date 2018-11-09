package models;

import models.entity.TreeNode;

import java.util.ArrayList;

public class RedBlackTree {

    private int size;
    private TreeNode root;
    private ArrayList<String> treePicture;

    public RedBlackTree() {
        size = 0;
        treePicture = new ArrayList<>();
    }

    private void createRoot(int data) {
        root = new TreeNode(data);
        root.setRed(false);
    }

    public boolean add(int data) {
        boolean added = true;
        if (root == null) {
            createRoot(data);
        } else {
            TreeNode newNode = new TreeNode(data);
            added = insertNode(root, newNode);
            if (added) {
                balanceTree(newNode);
            }
        }
        return added;
    }


    private boolean insertNode(TreeNode parent, TreeNode node) {
        boolean inserted = false;
        if (node.getData() < parent.getData()) {
            if (parent.getChild_L() == null) {
                parent.setChild_L(node);
                node.setParent(parent);
                inserted = true;
            } else {
                inserted = insertNode(parent.getChild_L(), node);
            }
        } else if (node.getData() > parent.getData()) {
            if (parent.getChild_R() == null) {
                parent.setChild_R(node);
                node.setParent(parent);
                inserted = true;
            } else {
                inserted = insertNode(parent.getChild_R(), node);
            }
        }
        return inserted;
    }


    public boolean remove(int data) {
        if (root == null) return false;
        if (root.getChild_L() == null && root.getChild_R() == null && root.getData() == data) {
            root = null;
            return true;
        }

        TreeNode node = findNode(data, root);

        if (node == null) return false;

        if (node.isRed()) {
            TreeNode parent = node.getParent();
            // THREE WAYS
            if (node.getChild_L() != null && node.getChild_R() != null) {
                // BOTH CHILDREN NOT NULL
                System.out.println("NOT NULL BOTH");
            } else if (node.getChild_L() == null && node.getChild_R() == null) {
                // BOTH CHILDREN ARE NULL
                boolean isNodeLeft = parent.getChild_L() == node;
                if (isNodeLeft) {
                    parent.setChild_L(null);
                } else {
                    parent.setChild_R(null);
                }
            } else {
                // ONE CHILD NULL ANOTHER NOT
            }
        } else {
            System.out.println("Removing black " + node.getData());
        }

        return true;
    }

    private TreeNode findNode(int data, TreeNode node) {
        TreeNode found = null;
        if (node != null) {
            if (data < node.getData()) {
                found = findNode(data, node.getChild_L());
            } else if (data > node.getData() ) {
                found = findNode(data, node.getChild_R());
            } else {
                found = node;
            }
        }
        return found;
    }


    private void balanceTree(TreeNode node) {
        if (node == root) {
            node.setRed(false);
            return;
        }

        // DO IF PARENT RED
        if (node.getParent().isRed()) {
            TreeNode parent, uncle, grandpa, greatGrand;
            parent = node.getParent();
            grandpa = parent.getParent();
            boolean isNodeLeft = parent.getChild_L() == node;
            boolean isParentLeft = grandpa.getChild_L() == parent;
            boolean isUncleLeft = !isParentLeft;
            uncle = isUncleLeft ? grandpa.getChild_L() : grandpa.getChild_R();

            // TWO WAYS: UNCLE (1) RED OR (2) BLACK
            if (uncle != null && uncle.isRed()) {
                // RED UNCLE
                parent.setRed(false);
                uncle.setRed(false);
                grandpa.setRed(true);
                balanceTree(grandpa);
            } else {
                // BLACK UNCLE
                greatGrand = grandpa.getParent();
                // FOUR WAYS:   (1) NODE AND PARENT ARE LEFT CHILDREN
                //              (2) NODE IS LEFT BUT PARENT IS RIGHT CHILD
                //              (3) NODE IS RIGHT BUT PARENT IS LEFT CHILD
                //              (4) NODE AND PARENT ARE RIGHT CHILDREN
                if (isNodeLeft && isParentLeft) {
                    // (1) SINGLE LEFT ROTATION
                    singleRotateRight(greatGrand, grandpa, parent);
                    grandpa.setRed(true);
                    parent.setRed(false);

                } else if (isNodeLeft && !isParentLeft) {
                    //  (2) NODE IS LEFT BUT PARENT IS RIGHT CHILD
                    parent.setChild_L(null);
                    node.setChild_R(parent);
                    parent.setParent(node);
                    node.setParent(grandpa);
                    singleRotateLeft(greatGrand, grandpa, node);
                    grandpa.setRed(true);
                    node.setRed(false);

                } else if (!isNodeLeft && isParentLeft) {
                    // (3) NODE IS RIGHT BUT PARENT IS LEFT CHILD
                    parent.setChild_R(null);
                    node.setChild_L(parent);
                    parent.setParent(node);
                    node.setParent(grandpa);
                    singleRotateRight(greatGrand, grandpa, node);
                    grandpa.setRed(true);
                    node.setRed(false);

                } else {
                    // (4) SINGLE LEFT ROTATION
                    singleRotateLeft(greatGrand, grandpa, parent);
                    grandpa.setRed(true);
                    parent.setRed(false);

                }
            }
        }
    }

    private void singleRotateLeft(TreeNode greatGrand, TreeNode grandpa, TreeNode parent) {
        grandpa.setChild_R(parent.getChild_L());
        if (grandpa.getChild_R() != null) {
            grandpa.getChild_R().setParent(grandpa);
        }
        parent.setChild_L(grandpa);
        parent.setParent(greatGrand);
        updateGreatGrandpa(greatGrand, grandpa, parent);
        grandpa.setParent(parent);
    }

    private void singleRotateRight(TreeNode greatGrand, TreeNode grandpa, TreeNode parent) {
        grandpa.setChild_L(parent.getChild_R());
        if (grandpa.getChild_L() != null) {
            grandpa.getChild_L().setParent(grandpa);
        }
        parent.setChild_R(grandpa);
        parent.setParent(greatGrand);
        updateGreatGrandpa(greatGrand, grandpa, parent);
        grandpa.setParent(parent);
    }

    private void updateGreatGrandpa(TreeNode greatGrand, TreeNode grandpa, TreeNode parent) {
        if (greatGrand != null) {
            boolean isGrandpaLeft = greatGrand.getChild_L() == grandpa;
            if (isGrandpaLeft) {
                greatGrand.setChild_L(parent);
            } else {
                greatGrand.setChild_R(parent);
            }
        } else {
            root = parent;
        }
    }

    private void drawTree(TreeNode node, int step) {
        if (node != null) {
            String s = getTab(step) + node.getData() + (node.isRed() ? "-R" : "-B");
            if (node.getChild_R() != null) {
                drawTree(node.getChild_R(), step + 1);
            }
            treePicture.add(s);
            if (node.getChild_L() != null) {
                drawTree(node.getChild_L(), step + 1);
            }
        }
    }

    private String getTab(int times) {
        String s = "    ";
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < times; i++) {
            tab.append(s);
        }
        return tab.toString();
    }

    public ArrayList<String> getTreePicture() {
        treePicture.clear();
        drawTree(root, 0);
        return treePicture;
    }
}
