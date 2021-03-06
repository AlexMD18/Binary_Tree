//BinaryTree1.java
//* To be modified by you
//* 
//* Implementation of Binary Tree data structure.
//* Covered in Lec#16 and Lec#17.
package assign7_template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Class for a binary tree that stores type E objects.
 *
 * @author Koffman and Wolfgang
 *
 */
public class BinaryTree1<E> implements Serializable {

    public static void main(String[] args) {
        //create the expression tree in Fig 6.12 by directly creating the nodes
        //  and directly connecting them accordingly

        //create 2 leaf nodes
        Node<Character> x = new Node<>('x');
        Node<Character> y = new Node<>('y');
        //create the parent node of x and y:
        Node<Character> plus = new Node<>('+');
        Node<Character> multiply = new Node<>('*');
        Node<Character> divide = new Node<>('/');
        Node<Character> a = new Node<>('a');
        Node<Character> b = new Node<>('b');
        //connect + and x, y:
        multiply.left = plus;
        multiply.right = divide;
        plus.left = x;
        plus.right = y;
        divide.left = a;
        divide.right = b;

        //create a binary tree named exprB that is rooted at *
        BinaryTree1<Character> exprBT = new BinaryTree1<>(multiply);
        //or:
        //create an empty binary tree: exprBT
        //BinaryTree1<Character> exprBT = new BinaryTree1<>();
        //make + as the root of the BT: exprBT       
        //exprBT.root = plus;        
        //call toString() to verify the tree structure
        System.out.println(exprBT.toString());

        //----Assign 7 ------
        //add more code to create the expression BT in Fig 6.12 on P.271
        //Hint: construct the tree by 
        //starting with leaves and moving up to the root of the entire tree.     
        //call toString() to verify the tree structure  
        StringBuilder expressionTree = new StringBuilder();

    }

    public void createBT(Node node) {
        StringBuilder expressionTree = new StringBuilder();

        if (root.left != null) {
            expressionTree.append("(");
            createBT(root.left);
            expressionTree.append(")");
        }

        expressionTree.append(root);

        if (root.right != null) {
            expressionTree.append("(");
            createBT(root.right);
            expressionTree.append(")");
        }
    }

    public int depth() {
        return depth(root);
    }

    public int depth(Node<E> node) {
        int leftDepth;
        int rightDepth;

        if (node == null) {
            return 0;
        } else {
            leftDepth = depth(node.left);
            rightDepth = depth(node.right);

            if (leftDepth > rightDepth) {
                return (leftDepth + 1);
            } else {
                return (rightDepth + 1);
            }
        }
    }

    //add your private recursive counter part for depth
    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    //add your private recursive counter part for size
    public String preOrderTraverse() {
        return preOrderTraverse(root);
    }

    public String preOrderTraverse(Node<E> node) {
        //add your code
        String preOrderString;
        preOrderString = node.data.toString() + " ";

        if (node.left != null) {
            preOrderString = preOrderString + preOrderTraverse(node.left);
        }

        if (node.right != null) {
            preOrderString = preOrderString + preOrderTraverse(node.right);
        }
        return preOrderString;
    }

    //add your private recursive counter part for preOrderTraverse
    public String inOrderTraverse() {
        return inOrderTraverse(root);
    }

    public String inOrderTraverse(Node<E> node) {
        //add your code
        String inOrderString = "";

        if (node.left != null) {
            inOrderString = inOrderString + inOrderTraverse(node.left);
        }

        inOrderString = inOrderString + node.data.toString() + " ";

        if (node.right != null) {
            inOrderString = inOrderString + inOrderTraverse(node.right);
        }
        return inOrderString;
    }

    //add your private recursive counter part for inOrderTraverse   
    public String postOrderTraverse() {
        return postOrderTraverse(root);
    }

    public String postOrderTraverse(Node<E> node) {
        String postOrderString = "";

        if (node.left != null) {
            postOrderString = postOrderString + postOrderTraverse(node.left);
        }

        if (node.right != null) {
            postOrderString = postOrderString + postOrderTraverse(node.right);
        }

        postOrderString = postOrderString + node.data.toString() + " ";
        return postOrderString;
    }

    //add your private recursive counter part for postOrderTraverse        
    //--------end of assign 7---------
    /*<listing chapter="6" number="1">*/
    /**
     * Class to encapsulate a tree node.
     */
    protected static class Node<E> implements Serializable {
        // Data Fields

        /**
         * The information stored in this node.
         */
        protected E data;
        /**
         * Reference to the left child.
         */
        protected Node<E> left;
        /**
         * Reference to the right child.
         */
        protected Node<E> right;

        // Constructors
        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        //This constructor should be protected, not public,
        // because classes that are not subclasses of BinaryTree1 do not directly use Node.
        protected Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /**
         * Returns a string representation of the node.
         *
         * @return A string representation of the data fields
         */
        //must be public because it overrides what's in class Object.
        @Override
        public String toString() {
            return data.toString();
        }
    }
    /*</listing>*/

    // Data Field
    /**
     * The root of the binary tree
     */
    //use the access modifier protected to give family member classes the direct access
    //   to the root data field.
    protected Node<E> root;

    /**
     * Construct an empty BinaryTree1
     */
    public BinaryTree1() {
        root = null;
    }

    /**
     * Construct a BinaryTree1 with a specified root. Should only be used by
     * subclasses.
     *
     * @param root The node that is the root of the tree.
     */
    //Use the access modifier protected because we want to hide details of Node class
    //   from non-family member classes (i.e. classes that are not subclasses of BinaryTree1).
    protected BinaryTree1(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree as its left
     * subtree and rightTree as its right subtree.
     */
    public BinaryTree1(E data, BinaryTree1<E> leftTree, BinaryTree1<E> rightTree) {
        root = new Node<E>(data);           //new node: right, left are both null
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;               //don't have to do this, root.left is already null
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;              //don't have to do this, root.right is already null.
        }
    }

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root or the left subtree
     * is null
     */
    public BinaryTree1<E> getLeftSubtree() {
        if (root != null && root.left != null) { //if there is a left subtree
            return new BinaryTree1<E>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     *
     * @return the right sub-tree or null if either the root or the right
     * subtree is null.
     */
    public BinaryTree1<E> getRightSubtree() {
        if (root != null && root.right != null) {   //if there is a right subtree
            return new BinaryTree1<E>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Return the data in the root node
     *
     * @return the data in the root node or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        //empty tree or 1-node tree
        return (root == null || (root.left == null && root.right == null));
    }

    /**
     * get a string containing all data items in this binary tree. The string is
     * a preorder traversal sequence of this binary tree.
     *
     * @return the preorder traversal sequence of this binary tree as a string.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //call the private recursive method to do the real job.
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal of the binary tree rooted at node.
     *
     * @param node The local root (i.e. the current root node)
     * @param depth The depth of the local root
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth,
            StringBuilder sb) {
        //add a number of spaces that is proportial to the depth value
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {         //current root node does not exist
            sb.append("null\n");
        } else {
            sb.append(node.toString()); //add current root node's data
            sb.append("\n");
            //recursively preorder traverse the left subtree of current root node
            preOrderTraverse(node.left, depth + 1, sb);
            //recursively preorder traverse the right subtree of current root node            
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /*<listing chapter="6" number="2">*/
    /**
     * Method to read a binary tree.
     *
     * @pre The input consists of a preorder traversal of the binary tree. The
     * line "null" indicates a null tree.
     * @param scan the Scanner attached to the input file
     * @return The binary tree
     */
    public static BinaryTree1<String> readBinaryTree1(Scanner scan) {
        // Read a line and trim leading and trailing spaces.
        String data = scan.nextLine().trim();
        if (data.equals("null")) { //data (i.e. current root node's data) is "null"
            return null;
        } else {
            //recursively keep reading and building the left subtree of current root node until it's done.
            BinaryTree1<String> leftTree = readBinaryTree1(scan);
            //recursively keep reading and building the right subtree of current root node until it's done.
            BinaryTree1<String> rightTree = readBinaryTree1(scan);
            //build and return a new binary tree that has root data in variable data, leftTree as left subtree, rightTree as right subtree.
            return new BinaryTree1<String>(data, leftTree, rightTree);
        }
    }
    /*</listing>*/
}
/*</listing>*/
