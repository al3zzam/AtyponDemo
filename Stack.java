import java.util.NoSuchElementException;

public class Stack<Item> {

    private Node head;

    private class Node{
        Item item;
        Node next;
    }


    public Stack(){
        this.head = null;
    }

    public void push(Item e){
        if(e == null)
            throw new IllegalArgumentException();
        Node oldhead = head;
        head = new Node();
        head.item = e;
        head.next = oldhead;
    }

    public Item pop(){
        if(head ==null)
            throw new NoSuchElementException();
        Item tmp = head.item;
        head = head.next;
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


}
