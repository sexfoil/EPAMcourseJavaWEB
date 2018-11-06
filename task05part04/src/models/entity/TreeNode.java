package models.entity;

public class TreeNode {

    private boolean isRed;
    private TreeNode child_L;
    private TreeNode child_R;
    private int data;
    private TreeNode parent;
    private int height;

    public TreeNode(int data) {
        this.data = data;
        initData();
    }

    private void initData() {
        isRed = true;
        parent = null;
        child_L = null;
        child_R = null;
        //height = 0;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getChild_L() {
        return child_L;
    }

    public void setChild_L(TreeNode child_L) {
        this.child_L = child_L;
    }

    public TreeNode getChild_R() {
        return child_R;
    }

    public void setChild_R(TreeNode child_R) {
        this.child_R = child_R;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
