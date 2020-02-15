import java.io.*;

// implements a binary tree node
class Node
{
    public int value;
    public Node left;
    public Node right;

    public Node(Node left, Node right)
    {
        this.left = left;
        this.right = right;
    }
}

class BinaryTree
{
    public Node root;

    public void SetRoot(Node root)
    {
        this.root = root;
    }

    public void preOrderTraversal()
    {
        _preOrder(this.root, 0);
    }   

    private void _preOrder(Node n, int depth)
    {
        if (n == null)
        {
            return;
        }
        else
        {
            _preOrder(n.left, depth + 1);
            System.out.println("Value: " + n.value + " depth: " + depth);
            _preOrder(n.right, depth + 1);
        }
    }
}

public class ExploreTrees
{
    public static void main(String[] args)
    {
        System.out.println("\nHello World!");

        // Evaluate creation of minimal BST
        int[] elems = {-1, 0, 0, 0, 2, 3, 4};
        BinaryTree t = createMinimalBST(elems);
        t.preOrderTraversal();
    }   

    public static BinaryTree createMinimalBST(int[] elems)
    {
        if (elems.length == 0)
        {
            return null;
        }
        else
        {
            BinaryTree tree = new BinaryTree();
            tree.SetRoot(createMinimalBSTHelper(elems, 0, elems.length-1));
            return tree;
        }
    }

    private static Node createMinimalBSTHelper(int[] elems, int start, int end)
    {
        int mid = (start + end) / 2;

        if (end < start)
        {
            return null;
        }
        else 
        {
            Node n = new Node(null, null);
            n.value = elems[mid];
            n.left = createMinimalBSTHelper(elems, start, mid - 1);
            n.right = createMinimalBSTHelper(elems, mid + 1, end);
            return n;
        }
    }
}