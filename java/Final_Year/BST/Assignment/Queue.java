import java.util.NoSuchElementException;

// Define a generic stack
public class Queue <T> {
  private T[] queueArray;
  private int front;
  private int back;
  private int nItems;
  
  public static int INIT_CAPACITY = 5;
  
  // Constructor - creates a stack with an inital capacity of INIT_CAPACITY
  @SuppressWarnings("unchecked")
  public Queue() {
    queueArray = (T[]) new Object[INIT_CAPACITY];
    front = 0;
    back = -1;
    nItems = 0;
  }
  
  // Insert an item at the back of the queue
  public void enqueue(T item){
    if (isFull())
      expandArray();
    
    back = (back+1) % queueArray.length;
    queueArray[back] = item;
    nItems++;
    
    //System.out.println("n items is now " + nItems);
  }
  
  // Examines the item at the top of the stack
  public T peek() throws NoSuchElementException {
    if (isEmpty())
      throw new NoSuchElementException("Cannot examine front of an empty queue.");
    
    return queueArray[front];
  }
  
  // Removes the item at the front of the queue
  public T dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("Cannot remove from an empty queue.");
    
    T item = queueArray[front];
    //queueArray[front] = null;
    front = (front+1) % queueArray.length;
    nItems--;
    return item;
  }  
  
  public boolean isEmpty() {
    return (nItems==0);
  }
  
  private boolean isFull() {
    return (nItems == queueArray.length);
  }
  
  @SuppressWarnings("unchecked")
  private void expandArray(){
   //System.out.println("Expanding array");
   int newCapacity = queueArray.length*2;
   
   T[] newQueueArray = (T[]) new Object[newCapacity];
   int i = front; // index into old array
   int j = 0; // index into new array
   while (j<nItems){
     newQueueArray[j++] = queueArray[i++];
     i = i % queueArray.length; // wrap i around if necessary, since items may continue at the beginning of the array
   }
   front = 0;
   back = nItems-1;
   
   queueArray = newQueueArray;
  }
  
  // Test the queue
  public static void main(String[] args) {
    Queue<Integer> q = new Queue<Integer>();
    
    for (int i=0; i<15; i++){
      System.out.println("Enqueueing " + i);
      q.enqueue(i);
    }
    
    if (q.isEmpty())
      System.out.println("Queue is empty.");
    
    while (!q.isEmpty()) {
      System.out.println("Dequeueing " + q.dequeue());
    }
  }
}