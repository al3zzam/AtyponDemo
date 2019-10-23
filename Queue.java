import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {

    private Node head, tail;

    private class Node{
        Item item;
        Node next;
    }

    public Queue(){
        head = null;
        tail = null;
    }

    public void enqueue(Item e){
        if(e==null)
            throw new IllegalArgumentException();
        Node oldtail = tail;
        tail = new Node();
        tail.item = e;
        tail.next = null;
        if(head ==null)
            head = tail;
        else
            oldtail.next = tail;
    }

    public Item dequeue(){
        if(head==null)
            throw new NoSuchElementException();
          Item tmp = head.item;
          head = head.next;
          if(head==null)
              tail = null;
          return tmp;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        int cnt = 0;
        Node ptr = head;
        while(ptr!=null) {
            ptr = ptr.next;
            cnt++;
        }
        return cnt;
    }
    @Override
    public iterator<Item> iterator(){
        return new QueueIterate();
    }
    public class QueueIterate implements Iterator<Item>{
        Node ptr=head;
        @Override
        public boolean hasNext() {
            return head==tail;
        }

        @Override
        public Item next() {
            head++;
            return ptr=head;
        }
    }

}
