package apps.yuzaco.com.jungredblack;

import java.util.Scanner;
import java.util.NoSuchElementException;



class JungRedBlack<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    Node root = null;
    private class Node {
        Key key;
        Value val;
        Node left, right;
        int size;
        boolean color;

        public Node(Key k, Value v, boolean col, int size)
        {
            key = k;
            val = v;
            color = col;
            this.size = size;
        }
    }
    /*
     * Initializes an empty symbol
     *
     */
    public JungRedBlack() {}

    /**
     * Returns the value associated with the given key.
     */
    public Value get(Key key)
    {
        if ( key == null ) throw new IllegalArgumentException("argument to get(0 is null");
        return(get(root, key));
    }

    public Value get(Node h, Key key)
    {
        while(h != null )
        {
            int cmp = h.key.compareTo(key);
            if ( cmp == 0 )
                return h.val;
            if ( cmp < 0 )
                return get(h.left, key);
            else
                return get(h.right, key);
        }
        return null;
    }

/**
 * Does this given tree contain the given key?
 * @param key : the key
 * @return { @code true } if this tree contains {@code key} and
 *     {@code false} otherwise
 * @throws IllegalArgumentException if {@code key} is {@code null}
 */
public boolean contains(Key key)
{
    return get(key)  != null ;
}
/*********************************************************************
 * Red-black tree insertion.
 *********************************************************************/
    /**
     * Inserts the specified key-value pair into the tree, overwriting the old
     * value with the new value if the tree already contains the specified key.
     * Deletes the specified key ( and its associated value ) from this tree
     *  if the specified value is {@code null}.
     * @param key
     * @param val
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val)
    {
        if (key == null)
            throw new IllegalArgumentException("Argument key to put() is null");

        if (val == null)
        {
            delete(key);
            return;
        }
        root = put(root, key, val);
        root.color = BLACK;
    }

    //Insert the key-value pair in the subtree rooted at h

    private Node put(Node h, Key key, Value val) {
        if ( h == null ) return new Node(key, val, RED, 1);
        int cmp = key.compareTo(h.key);
        if ( cmp < 0 ) h.left = put(h.left, key, val);
        else if ( cmp > 0 ) h.right = put(h.right, key, val);
        else h.val = val;
        // fix up any right-leaning links
        if ( isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if ( isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if ( isRed(h.left) && isRed(h.right))  flipColors(h);
        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }
    private Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        x.left = h;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.color = h.color;
        h.color = RED;
        x.right = h;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }
    //flip the color of a node and its both children's color
    private void flipColors(Node x)
    {
        x.color = !x.color;
        x.left.color = !x.left.color;
        x.right.color = !x.right.color;
    }
    private boolean isRed(Node node) {
        if ( node == null ) return false;
        return node.color == RED ;
    }

    /*
     * Assuming h is red and both h.right and h.right.left are black, make h.right
     * or one of its children red.
     */
    private Node moveRedRight(Node h) {
        flipColors(h);
        if ( isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }
   // restore red/black tree invariant.
    private Node balance(Node h) {
        // assert ( h != null )
        if ( isRed(h.right))        h = rotateLeft(h);
        if ( isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if ( isRed(h.left) && isRed(h.right)) flipColors(h);
        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }
    public int height() { return height(root); }
    /**
     * Returns the height of the BST ( for debugging ).
     * @return the height of the BST ( a 1-node tree has height 0 )
     */
    private int height(Node h) {
        if ( h == null ) return -1;
        return(1 + Math.max(height(h.left), height(h.right)));
    }
    /**
     * Returns the largest key in the tree
     * @return the largest key in the tree
     */
    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("calls max() with an empty tree");
        return (max(root).key);
    }
    private Node max(Node h)
    {
        if (h.right == null )
            return h;
        return(max(h.right));
    }
    /**
     * Returns the smallest key in the tree
     * @return the smallest key in the tree
     */
    public Key min() {
        if (isEmpty())
            throw new NoSuchElementException("calls min() with an empty tree");
        return (min(root).key);
    }
    private Node min(Node h)
    {
        if (h.left == null )
            return h;
        return(min(h.left));
    }
    public boolean isEmpty()
    {
        return ( root == null );
    }

    /**
     * Returns the largest key in the tree than equal to {@code key}.
     * @param key the key
     * @return the largest key in the tree less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if ( key == null ) throw new IllegalArgumentException("argument to floor() is null");
        if ( isEmpty() ) throw new NoSuchElementException("calls floor() with empy tree");
        Node x = floor(root, key);
        if ( x == null )
            return null;
        else
            return x.key;
    }
    // the largest key in the subtree rooted at x less than or equal to the given key
    public Node floor(Node h, Key key) {
        if ( h == null )
            return null;
        int cmp = key.compareTo(h.key);
        if ( cmp == 0 )
              return h;
        if ( cmp < 0 )
            return(floor(h.left, key));
        Node t = floor(h.right, key);
        if ( t == null )
            return h;
        else return  t;

    }

    /**
     * retruns the smallest key in the tree greater than or equal to {@code key}.
     * @param  key the key
     * @return the smallest key in the tree greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no sush key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if ( key == null ) throw new IllegalArgumentException("argument to ceiling is null");
        if ( isEmpty()) throw new NoSuchElementException("calls ceiling() with empty tree");
        Node x = ceiling(root, key);
        if ( x == null )
            return null;
        else
            return x.key;
    }
    // the smallest key in the subtree rooted at x greater than or equal to the given key
    private Node ceiling(Node h, Key key) {
        if ( h == null )
             return null;
        int cmp = key.compareTo(h.key);
        if ( cmp == 0 )
            return h;
        if ( cmp > 0 )
            return ceiling( h.right, key);
        Node t = ceiling(h.left, key) ;
        if ( t == null )
            return h;
        else  return t;
    }

    /*
     * Assume  that h is red, and both h.left and h.left.left are black.
     *  make h.left or one of its children red.
     */
    private Node moveRedLeft(Node h) {
        flipColors(h);
        if ( isRed(h.right.left) ) {
            h = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }
    private int size(Node h) {
        if ( h == null ) return 0;
        return h.size;
    }
    public int size()
    {
        return size(root);
    }
    /**
     * Removes the specified key and its associated value form this tree
     *  if the key is this tree.
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key}   is {@code null}
     */
    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key))
            return;
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = delete(root, key);
        if (!isEmpty())
            root.color = BLACK;
    }
    // delete the key-value pair with the given key rooted at h
    private Node delete(Node h, Key key)
    {
        if ( key.compareTo(h.key)<0)
        {
            if ( !isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        }
        else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.val = x.val;
                h.right = deleteMin(h.right);
            }
            else
                h.right = delete(h.right, key);
        }
        return balance(h);
    }

    /**
     * Removes the smallest key from the tree.
     * @throws NoSuchElementException if the tree is empty
     */
    public void deleteMin()
    {
        if ( isEmpty()) throw new NoSuchElementException("Empty tree");
        if ( !isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMin(root);
        if ( !isEmpty()) root.color = BLACK;
    }
    // delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h)
    {
        if ( h.left == null )
            return null;
        if ( !isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }

    /**
     * Unit test the {@code  JungRedBlack} data type.
     * @param args the command-line arguments
     */
    public static void main(String[] args)
    {
        JungRedBlack<Integer,String > tree = new JungRedBlack<Integer, String>();
        Scanner StdIn = new Scanner(System.in);
        int i = 100;
        while(StdIn.hasNext())
        {
            String data = StdIn.nextLine();
            tree.put(i, data );
            i++;
        }
        for ( Integer k : tree.keys())
            System.out.println(tree.get(k));
        System.out.println();
    }
    /**
     * Returns all keys in the tree as an {@code Iterable}.
     * To iterate over all the keys in the tree {@code tree},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     * @return all keys in the tree as an {@code tree}
     */
    public Iterable<Key> keys(){
        if ( isEmpty())  return new Queue<Key>();
        return keys(min(), max());
    }
    /*
     * Returns all keys in the tree in the given range,
     * as an {@code Iterable}.
     * @param lo mininum endpoint
     * @param hi maximum endpoint
     * @return all keys in the tree between {@code lo} and {@code hi} as an {@code Iterable}
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *    is {@code  null}
     */
    public Iterable<Key> keys(Key lo, Key hi){
        if ( lo == null ) throw new IllegalArgumentException("first argument to keys() is null");
        if ( hi == null ) throw new IllegalArgumentException("second argument to keys() is null");
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    // add the keys between lo and hi in the tree root at x to the queue
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if ( x == null ) return;
        int cmplo  = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if ( cmplo < 0 )  keys(x.left, queue, lo, hi);
        if ( cmplo <= 0 && cmphi >= 0 )
              queue.enqueue(x.key);
        if ( cmphi > 0 ) keys(x.right, queue, lo, hi);

    }
}