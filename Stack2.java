
import java.util.NoSuchElementException;

public class Stack2<Item> {

    private Item[] items;
    private int N ;

    private void resize(int capacity){
        Item[] temp = (Item[]) new Object[capacity];
        for(int i=0; i<N; i++)
            temp[i] = items[i];
        items = temp;
    }

    public Stack2(){
        items = (Item[]) new Object[1];
        N = 0;
    }

    public void add (Item item){
        if(item == null)
            throw new IllegalArgumentException();
        if(N == items.length){
            resize(items.length * 2);
        }
        items[N++] = item;
    }

    public Item remove ( ){
        if(N==0)
            throw new NoSuchElementException();
        Item tmp = items[N-1];
        items[N-1] = null;
        N--;
        if(N == items.length / 4)
            resize(items.length/2);
        return tmp;
    }

    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;
    }

}
