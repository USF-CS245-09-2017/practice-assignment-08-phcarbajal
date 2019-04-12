// BST.java
public class BST<S> 
{
    public class BSTNode
    {
        BSTNode left;
        BSTNode right;
        Comparable data;

        public BSTNode(Comparable val)
        {
            data = val;
            left = null;
            right = null;
        }

        public BSTNode getLeft() 
        {
            return left;
        }

        public BSTNode getRight() 
        {
            return right;
        }

        public void setLeft(BSTNode left) 
        {
            this.left = left;
        } 

        public void setRight(BSTNode right) 
        {
            this.right = right;
        }

        public void setData(Comparable data) 
        {
            this.data = data;
        }
    } // end of BST class

    private BSTNode root;

    // recursive find
    public boolean find(Comparable val)
    {
        return find(root, val);
    }

    public boolean find(BSTNode node, Comparable val)
    {
        if (node == null)
        {
            return false;
        }
        if (node.data.compareTo(val) == 0)
        {
            return true;
        }

        else if (node.data.compareTo(val) > 0)
        {
            return find(node.right, val);
        }
        else
        {
            return find(node.left, val);
        }
    }

    //calls insert recursively
    public void insert(Comparable val)
    {
        root = insert(root,val);
    }

    public BSTNode insert(BSTNode node, Comparable val)
    {
        if (node == null)
        {
            BSTNode n = new BSTNode(val);
            return n;
        } 
        else if (node.data.compareTo(val) > 0)
        {
            node.right = insert(node.right,val);
        } 
        else
        {
            node.left = insert(node.left,val);
        } 

        return node;
    }

    // calls recursively
    public void print()
    {
        print(root);
    }
    
    // recursive print
    public void print(BSTNode node)
    {
        if (node != null)
        {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    } 

    public void delete(Comparable val)
    {
        root = delete(root, val);
    }

    public BSTNode delete(BSTNode node, Comparable val) {
        if (node == null)
        {
            return null;
        }
        if (node.data.compareTo(val) == 0) 
        {
            if (node.left == null)
            {
                return node.right; 
            }
            else if (node.right == null)
            {
                return node.left; 
            }
            else 
            {
                if (node.right.left == null) 
                {
                    node.data = node.right.data;
                    node.right = node.right.right;
                    return node;
                }
                else 
                {
                    node = (BSTNode) removeSmallest(node.right);
                    return node;
                } 
            } 
        }
        else if (node.data.compareTo(val) < 0)
        {
            node.right = delete(node.right, val);
        }
        else
        {
            node.left = delete(node.left, val);
        }

        return null;
    }

    Comparable removeSmallest(BSTNode node)
    {
        if (node.left.left == null)
        {
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        }
        else
        {
            return removeSmallest(node.left);
        } 
    } 
}