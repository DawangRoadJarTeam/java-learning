package cn.dawangroad.jarteam;

import javax.annotation.PostConstruct;

/**
 * Description: BinaryTree
 *
 * @author ervin
 * @version 2018-08-1810:06
 */
public class BinaryTree {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public static void middleScan(TreeNode root) {
        if (root == null) {
            return;
        }
        middleScan(root.left);
        System.out.print(" " + root.value + " ");
        middleScan(root.right);
    }

    public static void preScan(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(" " + root.value + " ");
        preScan(root.left);
        preScan(root.right);
    }

    public static void postScan(TreeNode root) {
        if (root == null) {
            return;
        }
        postScan(root.left);
        postScan(root.right);
        System.out.print(" " + root.value + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        TreeNode n3 = new TreeNode();
        TreeNode n4 = new TreeNode();
        TreeNode n5 = new TreeNode();
        TreeNode n6 = new TreeNode();
        TreeNode n7 = new TreeNode();
        TreeNode n8 = new TreeNode();
        TreeNode n9 = new TreeNode();

        root.value = 2;
        root.right = n1;

        n1.value = 7;
        n1.left = n2;

        n2.value = 3;
        n2.right = n3;

        n3.value = 4;
        n3.right = n4;

        n4.value = 5;

        n1.right = n5;
        n5.value = 8;
//        n5.left = n6;
//
//        n6.value = 4;
//        n6.right = n7;
//
//        n7.value = 7;
//        n7.left = n8;
//
//        n8.value = 6;
//        n8.left = n9;
//
//        n9.value = 5;


        middleScan(root);
        System.out.println();
        preScan(root);
        System.out.println();
        postScan(root);
    }
}
