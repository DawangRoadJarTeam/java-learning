package cn.dawangroad.jarteam;

import java.util.Stack;

/**
 * @author zhiyingyang
 * @version 2018-12-03 17:27
 */
public class BTree {
    static void middle(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.l;
            } else {
                cur = stack.pop();
                System.out.print(cur.value);
                cur = cur.r;
            }
        }
    }

    static void pre(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value);
            if (node.r != null) {
                stack.push(node.r);
            }
            if (node.l != null) {
                stack.push(node.l);
            }
        }
    }

    static void post(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            while (peek.l != null || peek.r != null) {
                if (peek.r != null) {
                    stack.push(peek.r);
                }
                if (peek.l != null) {
                    stack.push(peek.l);
                }
                peek = stack.peek();
            }

            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.print(node.value);

                TreeNode treeNode = stack.peek();
                while (treeNode.r != null && treeNode.r == node) {
                    node = stack.pop();
                    System.out.print(treeNode.value);
                    if (stack.isEmpty()) {
                        break;
                    }
                    treeNode = stack.peek();
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, null, null);
        TreeNode n2 = new TreeNode(3, null, null);
        TreeNode n3 = new TreeNode(2, n1, n2);
        TreeNode n4 = new TreeNode(5, null, null);
        TreeNode n5 = new TreeNode(7, null, null);
        TreeNode n6 = new TreeNode(6, n4, n5);
        TreeNode root = new TreeNode(4, n3, n6);

        System.out.println("middle: ");
        middle(root);
        System.out.println();

        System.out.println("pre: ");
        pre(root);
        System.out.println();

        System.out.println("post: ");
        post(root);
        System.out.println();
    }

    static class TreeNode {
        int value;
        TreeNode l;
        TreeNode r;

        public TreeNode(int value, TreeNode l, TreeNode r) {
            this.value = value;
            this.l = l;
            this.r = r;
        }
    }
}
