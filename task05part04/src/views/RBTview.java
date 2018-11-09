package views;

import models.RedBlackTree;

public class RBTview {



    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printRedBlackTree(RedBlackTree tree) {
        System.out.println();
        for (String str : tree.getTreePicture()) {
            System.out.println(str);
        }
        System.out.println();
    }
}
