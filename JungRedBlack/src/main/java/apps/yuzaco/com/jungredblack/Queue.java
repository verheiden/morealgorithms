package apps.yuzaco.com.jungredblack;

import com.sun.tools.javac.util.GraphUtils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by jung on 10/31/17.
 */

public class Queue<Item> implements Iterable<Item>
{
    private Node<Item> first;
    private Node<Item>  last;
    private int n;

    // helper linked list class
    private static class  Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    /**
     * Initialize an empty queue
     */
    public Queue()
    {
        first = null;
        last = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty()
    {
       return(first != null);
    }
    public int size()
    {
        return n;
    }

    /**
     * Returns the item least recently added to this queue
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Item peek()
    {
        if ( isEmpty()) throw new NoSuchElementException("Queue undeflow");
        return first.item;
    }

    /**
     * Adds the item to the queue
     * @param item
     */
    public void enqueue(Item item)
    {
       Node<Item> temp = last;
       last = new Node<Item>();
       last.item = item;
       last.next = null;
       if (isEmpty()) first = last;
       else temp.next = last;
       n++;
    }
    public Item dequeue(){
         if ( isEmpty()) throw new NoSuchElementException("Queue undeflow");
         Item item = first.item;
         n--;
         first = first.next;
         if ( isEmpty() )
             last = null;
         return item;
    }
    /**
     * Returns an iterator that iterates
     */
    public Iterator<Item> iterator() { return new ListIterator<Item> (first);}

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        public ListIterator(Node<Item> first) { current = first; }
        public boolean hasNext() { return current != null ; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
