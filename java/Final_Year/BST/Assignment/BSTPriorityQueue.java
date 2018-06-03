import java.util.Scanner;

public class BSTPriorityQueue<T>{
      BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

      public Integer get(){
          return bst.findMax();
      }

      public void insert(int item){
          bst.insertV2(item);
      }

      public void remove(int item){
          bst.remove(item);
    }

    public static void main(String []args){
        BSTPriorityQueue<Integer> pq = new BSTPriorityQueue<Integer>();

    Scanner keyboard = new Scanner(System.in);
    String input;
    boolean done = false;
    
    System.out.println("Please enter numbers to enter into the tree." +
                       "Type a non-numerical string when you're done.");
    
    do {
      input = keyboard.next();
      try {
        int n = Integer.parseInt(input);
         pq.insert(n);
      }
      catch (Exception e) {
        done = true;
      }
    } while (!done);
      System.out.println(  pq.get());
    }
}