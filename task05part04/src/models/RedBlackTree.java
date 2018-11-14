package models;

import models.entity.TreeNode;

import java.util.ArrayList;

public class RedBlackTree {

    private TreeNode root;
    private ArrayList<String> treePicture;

    public RedBlackTree() {
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


    public boolean delete(int data) {
        TreeNode node = findNode(data, root);
        if (node != null) {
            return removeNode(node);
        }
        return false;
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


    private boolean removeNode(TreeNode node) {
        if (root.getChild_L() == null && root.getChild_R() == null) {
            root = null;
            return true;
        }
        boolean isRoot = node == root;

        TreeNode parent = node.getParent();
        boolean isNodeLeft = !isRoot && parent.getChild_L() == node;

        /*
         *  TWO CASES       +(1) NODE IS A LEAF OR HAS ONLY ONE CHILD
         *                  +(2) NODE HAS TWO CHILDREN
         */
        if (node.getChild_L() == null || node.getChild_R() == null) {
            /*
             *  CASE (1) NODE IS A LEAF OR HAS ONLY ONE CHILD
             */
            TreeNode successor = node.getChild_L() != null ? node.getChild_L() : node.getChild_R();

            if (isRoot) {
                root = successor;
                root.setRed(false);
                return true;
            }
            boolean isSuccessorRed = successor != null && successor.isRed();
            if (isNodeLeft) {
                parent.setChild_L(successor);
            } else {
                parent.setChild_R(successor);
            }
            if (successor != null) {
                successor.setParent(parent);
            }
            if (node.isRed() || isSuccessorRed) {
                /*
                 *  NODE OR SUCCESSOR IS RED: COLOR SUCCESSOR AS A BLACK
                 */
                if (successor != null) {
                    successor.setRed(false);
                }
                return true;
            } else {
                /*
                 *  NODE AND SUCCESSOR IS BLACK: COLOR SUCCESSOR AS A DOUBLE BLACK AND MAKE IT SINGLE BLACK
                 */
                makeSingleBlack(isNodeLeft, parent);
                return true;
            }
        } else {
            /*
             *  CASE (2) NODE HAS TWO CHILDREN
             */

            TreeNode largestNode = findLargestInLeftSubtree(node.getChild_L());

            TreeNode largestParent = largestNode.getParent();
            boolean isLargestNodeLeft = largestParent.getChild_L() == largestNode;

            node.setData(largestNode.getData());

            if (largestNode.getChild_L() == null) {
                /*
                 *  LARGEST NODE IS LEAF
                 */
                if (isLargestNodeLeft) {
                    largestParent.setChild_L(null);
                } else {
                    largestParent.setChild_R(null);
                }

                if (!largestNode.isRed()) {
                    makeSingleBlack(isLargestNodeLeft, largestParent);
                }
            } else {
                /*
                 *  LARGEST NODE HAS LEFT CHILD
                 */
                largestNode.getChild_L().setParent(largestParent);
                largestNode.getChild_L().setRed(false);
                if (isLargestNodeLeft) {
                    largestParent.setChild_L(largestNode.getChild_L());
                } else {
                    largestParent.setChild_R(largestNode.getChild_L());
                }
            }
        }

        return true;
    }


    private void makeSingleBlack(boolean isNodeLeft, TreeNode parent) {
        if (parent == null) return;

        TreeNode sibling;
        if (isNodeLeft) {
            sibling = parent.getChild_R();
        } else {
            sibling = parent.getChild_L();
        }

        /*
         *  NODE AND SUCCESSOR IS BLACK: COLOR SUCCESSOR AS A DOUBLE BLACK AND MAKE IT SINGLE BLACK
         *
         *  THREE CASES     +(1) SIBLING IS RED
         *                  +(2) SIBLING IS BLACK AND HAS TWO BLACK CHILDREN
         *                  +(3) SIBLING IS BLACK AND HAS AT LEAST ONE RED CHILD
         */
        if (/*sibling != null && */sibling.isRed()) {
            /*
             *  CASE (1) SIBLING IS RED
             */
            if (isNodeLeft) {
                // rotate left
                singleRotateLeft(parent.getParent(), parent, sibling);
            } else {
                // rotate right
                singleRotateRight(parent.getParent(), parent, sibling);
            }
            parent.setRed(true);
            sibling.setRed(false);
            makeSingleBlack(isNodeLeft, parent);
        } else {
            if ( (sibling.getChild_L() == null || !sibling.getChild_L().isRed()) &&
                    (sibling.getChild_R() == null || !sibling.getChild_R().isRed())) {
                /*
                 *  CASE (2) SIBLING IS BLACK AND HAS TWO BLACK CHILDREN
                 */
                TreeNode grandpa = parent.getParent();
                boolean isParentLeft = grandpa == null || grandpa.getChild_L() == parent;
                sibling.setRed(true);
                if (parent.isRed()) {
                    parent.setRed(false);
                } else {
                    makeSingleBlack(isParentLeft, grandpa);
                }
            } else {
                /*
                 *  CASE (3) SIBLING IS BLACK AND HAS AT LEAST ONE RED CHILD
                 */
                if (isNodeLeft) {
                    if (!sibling.getChild_R().isRed()) {
                        singleRotateRight(parent, sibling, sibling.getChild_L());
                        sibling = sibling.getParent();
                        sibling.setRed(false);
                        sibling.getChild_R().setRed(true);
                    }
                    singleRotateLeft(parent.getParent(), parent, sibling);
                    sibling.getChild_R().setRed(false);
                } else {
                    if (!sibling.getChild_L().isRed()) {
                        singleRotateLeft(parent, sibling, sibling.getChild_R());
                        sibling = sibling.getParent();
                        sibling.setRed(false);
                        sibling.getChild_L().setRed(true);
                    }
                    singleRotateRight(parent.getParent(), parent, sibling);
                    sibling.getChild_L().setRed(false);
                }
                if (parent.isRed()) {
                    parent.setRed(false);
                    sibling.setRed(sibling != root);
                }
            }
        }

    }


    private TreeNode findNode(int data, TreeNode node) {
        TreeNode found = null;
        if (node != null) {
            if (data < node.getData()) {
                found = findNode(data, node.getChild_L());
            } else if (data > node.getData()) {
                found = findNode(data, node.getChild_R());
            } else {
                found = node;
            }
        }
        return found;
    }


    private TreeNode findLargestInLeftSubtree(TreeNode node) {
        if (node.getChild_R() != null) {
            return findLargestInLeftSubtree(node.getChild_R());
        }
        return node;
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

            // TWO WAYS: UNCLE (1)+ RED OR (2)+ BLACK
            if (uncle != null && uncle.isRed()) {
                // RED UNCLE
                parent.setRed(false);
                uncle.setRed(false);
                grandpa.setRed(true);
                balanceTree(grandpa);
            } else {
                // BLACK UNCLE
                greatGrand = grandpa.getParent();
                // FOUR WAYS:   (1)+ NODE AND PARENT ARE LEFT CHILDREN
                //              (2)+ NODE IS LEFT BUT PARENT IS RIGHT CHILD
                //              (3)+ NODE IS RIGHT BUT PARENT IS LEFT CHILD
                //              (4)+ NODE AND PARENT ARE RIGHT CHILDREN
                if (isNodeLeft) {
                    if (isParentLeft) {
                        // (1) NODE AND PARENT ARE LEFT CHILDREN
                        singleRotateRight(greatGrand, grandpa, parent);
                        grandpa.setRed(true);
                        parent.setRed(false);
                    } else {
                        //  (2) NODE IS LEFT BUT PARENT IS RIGHT CHILD
                        singleRotateRight(grandpa, parent, node);
                        singleRotateLeft(greatGrand, grandpa, node);
                        grandpa.setRed(true);
                        node.setRed(false);
                    }
                } else {
                    if (isParentLeft) {
                        // (3) NODE IS RIGHT BUT PARENT IS LEFT CHILD
                        singleRotateLeft(grandpa, parent, node);
                        singleRotateRight(greatGrand, grandpa, node);
                        grandpa.setRed(true);
                        node.setRed(false);
                    } else {
                        // (4) NODE AND PARENT ARE RIGHT CHILDREN
                        singleRotateLeft(greatGrand, grandpa, parent);
                        grandpa.setRed(true);
                        parent.setRed(false);
                    }
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