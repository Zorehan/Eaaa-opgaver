package bst;

import java.util.ArrayList;

/**
 * BST is a binary search tree.
 * Note: Equal elements are not allowed in the tree.
 * Note: The methods add() and remove does not re-balance the tree.
 */

public class BST<E extends Comparable<E>> {
    private TreeNode root;
    private int size = 0;
    private java.util.Comparator<E> c;

    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * Create a BST with a specified comparator
     */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    public static void main(String[] args)
    {
        BST<Integer> bst = new BST<>();
        bst.insert(45);
        bst.insert(22);
        bst.insert(11);
        bst.insert(15);
        bst.insert(30);
        bst.insert(25);
        bst.insert(77);
        bst.insert(90);
        bst.insert(88);

        System.out.println(bst.toString());
        System.out.println("inorder");
        bst.inorder();
        System.out.println("\n postorder");
        bst.postorder();
        System.out.println("\n preorder");
        bst.preorder();
        System.out.println("\n " + bst.inorderListprint());
        System.out.println("\n" + bst.findHeight());
        System.out.println("\n" + bst.sumOfElements());
    }

    // Return a (current, parent)-pair consisting of
    // the node containing the element e and this node's parent.
    // Return value:
    //   current != null and parent != null: current contains e and parent is the parent to current
    //   current != null and parent == null: current is the root containing e
    //   current == null and parent != null: e is not found
    //         and parent is the node where a node with e would be inserted as child
    //   current == null and parent == null: the three is empty
    private NodePair locateNodeAndParent(E e) {
        boolean found = false;
        TreeNode parent = null;
        TreeNode current = root; // Start from the root
        while (!found && current != null) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                found = true;
            }
        }
        return new NodePair(current, parent);
    }



    private class NodePair {
        private TreeNode current;
        private TreeNode parent;

        public NodePair(TreeNode current, TreeNode parent) {
            this.current = current;
            this.parent = parent;
        }
    }




    /**
     * Returns true if the element is in the tree
     */
    public boolean search(E e) {
        // Locate the node with the element e (and its parent node).
        NodePair pair = locateNodeAndParent(e);
        return pair.current != null;
    }


    /**
     * Insert element e into the binary tree
     * Return true if the element is inserted successfully
     * Return false if the element is found in the tree before insertion.
     */
    public boolean insert(E e) {
        // Locate the node with the element e and its parent node.
        NodePair pair = locateNodeAndParent(e);
        boolean inserted = false;
        if (pair.current == null) {
            if (root == null) {
                root = new TreeNode(e); // Create a new root
            } else {
                TreeNode parent = pair.parent;
                // Create a new node and attach it to the parent node.
                if (c.compare(e, parent.element) < 0) {
                    parent.left = new TreeNode(e);
                } else {
                    parent.right = new TreeNode(e);
                }
            }
            inserted = true;
            size++;
        }
        return inserted; // Element inserted successfully
    }


    /**
     * Inorder traversal from the root
     */
    public ArrayList<E> inorderListprint()
    {
        return inorderListprint(root);
    }

    private ArrayList<E> inorderListprint(TreeNode root)
    {
        ArrayList<E> returnList = new ArrayList<>();
        if (root != null)
        {
            returnList.addAll(inorderListprint(root.left));
            returnList.add(root.element);
            returnList.addAll(inorderListprint(root.right));
        }
        return returnList;
    }

    private E findMax(TreeNode root)
    {
        if (root == null) {
            return null;
        }

        while (root.right != null) {
            root = root.right;
        }

        return root.element;
    }

    private E findMin(TreeNode root)
    {
        if (root == null)
        {
            return null;
        }

        while(root.left != null)
        {
            root = root.left;
        }

        return root.element;
    }

    public int findHeight()
    {
        return findHeight(root);
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void inorder() {
        inorder(root);
    }

    /**
     * Inorder traversal from a subtree
     */
    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }
    }

    public int sumOfElements()
    {
        return sumOfElements(root);
    }

    private int sumOfElements(TreeNode root) {
        if (root == null) {
            return 0;
        }


        if (root.element instanceof Integer) {
            return (Integer) root.element + sumOfElements(root.left) + sumOfElements(root.right);
        } else {
            return 0;
        }
    }

    public void postorder()
    {
        postorder(root);
    }

    private void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element + " ");
        }


    }

    public void preorder()
    {
    preorder(root);
    }

    private void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }


    private class TreeNode {
        private E element;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(E e) {
            element = e;
        }
    }


    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    private TreeNode getRoot() {
        return root;
    }


    /**
     * Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree
     */
    public boolean delete(E e) {
        // Locate the node with the element e and its parent node.
        NodePair pair = locateNodeAndParent(e);
        boolean found = true;
        if (pair.current == null) { // the element e is not in the tree
            found = false;
        } else {
            TreeNode current = pair.current;
            TreeNode parent = pair.parent; // may be null
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (c.compare(e, parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost(biggest) node in the left subtree of
                // the current node and also its parent
                TreeNode parentOfRightMost = current;
                TreeNode rightMost = current.left;

                if (rightMost.right == null) { // special case: no node to the right of rightMost
                    current.element = rightMost.element;
                    current.left = rightMost.left;
                } else {
                    while (rightMost.right != null) {
                        parentOfRightMost = rightMost;
                        rightMost = rightMost.right; // keep going to the right
                    }
                    // Replace the element in current by the element in rightMost.
                    current.element = rightMost.element;
                    // Eliminate rightmost node.
                    parentOfRightMost.right = rightMost.left;
                }

            }
            size--; // Reduce the size of the tree
        }
        return found; // Element deleted successfully
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(TreeNode node) {
        if (node == null) return "";
        return toString(node.left) + " " + node.element + " " + toString(node.right);
    }

    //-------------------------------------------------------------------


}
