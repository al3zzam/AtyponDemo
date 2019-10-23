import java.util.NoSuchElementException;

public class Queue2<Item> {

	    private Item[] items;
	        private int head,tail,n;

		    private void resize(int capacity){
			            Item[] temp = (Item[]) new Object[capacity];
				            int i = head;
					            for(int k=0; k<n; k++){
							                temp[k] = items[i];
									            i++;
										                if(i==n) i=0;
												        }
						            head = 0;
							            tail = n;
								            items = temp;
									        }

		        public Queue2(){
				        items = (Item[]) new Object[2];
					        head = 0;
						        tail = 0;
							        n = 0;
								    }

			    public void enqueue(Item e){
				            if(e==null)
						                throw new IllegalArgumentException();
					            if(n==items.length) resize(items.length*2);
						            items[tail++] = e;
							            if (tail == items.length) tail = 0;
								            n++;
									        }

			        public Item dequeue(){
					        if(n==0)
							            throw new NoSuchElementException();
						        Item item = items[head];
							        items[head] = null;
								        n--;  head++;
									        if (head == items.length) head = 0;
										        if (n > 0 && n == items.length/4) resize(items.length/2);
											        return item;
												    }

				    public boolean isEmpty(){
					            return n == 0;
						        }

				        public int size(){
						        return n;
							    }

}

