// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

import java.util.Formatter;

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinarySearchTree<T extends Comparable<? super T>>
{
  /** The tree root. */
  private BinaryNode<T> root;
  
  
  // Basic node stored in unbalanced binary search trees
  private static class BinaryNode<T>
  {
    T element;            // The data in the node
    BinaryNode<T> left;   // Left child
    BinaryNode<T> right;  // Right child
    
    // Constructors
    BinaryNode( T data )
    {
      this( data, null, null );
    }
    
    BinaryNode( T data, BinaryNode<T> lt, BinaryNode<T> rt )
    {
      element  = data;
      left     = lt;
      right    = rt;
    }
  }
  
  
  /**
   * Construct the tree.
   */
  public BinarySearchTree( )
  {
    root = null;
  }
  
  /**
   * Insert into the tree; duplicates are ignored.
   * This is version 1 of the insert method
   * @param x the item to insert.
   */
  public void insertV1(T x) {
    
    if (root == null)
      root =  new BinaryNode<T>(x);
    else
      insertV1(x, root); // call the private recursive method
  }
  
  /**
   * Private internal method to insert into a subtree rooted at a given node.
   * This method should not be called with a null value as the given node.
   * @param x the item to insert.
   * @param t the node that roots the subtree.
   * @return the new root of the subtree.
   */
  private void insertV1(T x, BinaryNode<T> subTreeRoot){    
    int compareResult = x.compareTo(subTreeRoot.element);
    
    if (compareResult < 0){
      // insert in left subtree
      if (subTreeRoot.left == null)
        subTreeRoot.left = new BinaryNode<T>(x);
      else
        insertV1(x, subTreeRoot.left); // recursive call
    }
    
    else if (compareResult > 0){
      // insert in the right subtree
      if (subTreeRoot.right == null)
        subTreeRoot.right = new BinaryNode<T>(x);
      else
        insertV1(x, subTreeRoot.right); // recursive call
    }
    else {
      // compareResult == 0 i.e. they are equal
      // the item is already in the tree -- ignore.
    }
  }
  
  
  /**
   * Insert into the tree; duplicates are ignored.
   * This is version 2 of the insert method
   * @param x the item to insert.
   */
  public void insertV2( T x )
  {
    root = insertV2( x, root ); // call the private recursive method
  }
  
  /**
   * Private internal method to insert into a subtree rooted at a given node.
   * This method returns the new subtree root -- this is the same as the
   * provided subtree root if it wasn't null, or it is the newly created node, if
   * the provided subtree root was null
   * @param x the item to insert.
   * @param t the node that roots the subtree.
   * @return the new root of the subtree.
   */
  private BinaryNode<T> insertV2( T x, BinaryNode<T> t )
  {
    if( t == null )
      return new BinaryNode<T>( x, null, null );
    
    int compareResult = x.compareTo( t.element );
    
    if( compareResult < 0 )
      t.left = insertV2( x, t.left ); // recursive call to insert in left subtree
    
    else if( compareResult > 0 )
      t.right = insertV2( x, t.right ); // recursive call to insert in right subtree
    
    else
      ;  // Duplicate; do nothing
    
    return t;
  }
  
  /**
   * Find the smallest item in the tree.
   * @return smallest item or null if empty.
   */
  public T findMin( )
  {
    if( isEmpty( ) )
      throw new RuntimeException("Cannot find min element in an empty tree.");
    
    // call the private findMin method and return the element at the node
    // returned by the private findMin method
    return findMin( root ).element;
  }
  
  /**
   * Private method to find the smallest item in a subtree.
   * @param t the node that roots the subtree.
   * @return node containing the smallest item.
   */
  private BinaryNode<T> findMin( BinaryNode<T> t )
  {
    if( t == null ) // base case
      return null;
    
    else if( t.left == null ) // base case
      return t;
    
    else
      return findMin( t.left ); // recurisve call
  }
  
  /**
   * Find the largest item in the tree.
   * @return the largest item of null if empty.
   */
  public T findMax( )
  {
    if( isEmpty( ) )
      throw new RuntimeException("Cannot find max element in an empty tree.");
    
    // call the private findMax method and return the element at the node
    // returned by the private findMax method
    return findMax( root ).element;
  }
  
  /**
   * Private method to find the largest item in a subtree.
   * @param t the node that roots the subtree.
   * @return node containing the largest item.
   */
  private BinaryNode<T> findMax( BinaryNode<T> t )
  {
    // This method is implemented iteratively rather than
    // recursively, simply to show that it is possible to do so.
    if( t != null ) {
      while( t.right != null )
        t = t.right;
    }
    
    return t;
  }
  
  /**
   * Find an item in the tree.
   * @param x the item to search for.
   * @return true if not found.
   */
  public boolean contains( T x )
  {
    return contains( x, root ); // call the private method
  }
  
  /**
   * Private method to find an item in a subtree.
   * @param x is item to search for.
   * @param t the node that roots the subtree.
   * @return node containing the matched item.
   */
  private boolean contains( T x, BinaryNode<T> t )
  {
    if( t == null )
      return false;
    
    int compareResult = x.compareTo( t.element );
    
    if( compareResult < 0 )
      return contains( x, t.left );
    
    else if( compareResult > 0 )
      return contains( x, t.right );
    
    else // compareResult == 0 i.e. they are equal
      return true;    // Match
  }
  
  /**
   * Make the tree logically empty.
   */
  public void makeEmpty( )
  {
    root = null;
  }
  
  /**
   * Test if the tree is logically empty.
   * @return true if empty, false otherwise.
   */
  public boolean isEmpty( )
  {
    return root == null;
  }
  
  /**
   * Print the tree contents in sorted order.
   * (I.e. it prints an in-order traversal of the tree)
   */
  public void printTree( )
  {
    if( isEmpty( ) )
      System.out.println( "Empty tree" );
    else {
      printTree( root ); // call the private method
      System.out.println();
    }
  }

  /**
   * Private method to print a subtree in sorted order.
   * Note that this is an in-order traversal of the tree
   * @param t the node that roots the subtree.
   */
  private void printTree( BinaryNode<T> t )
  {
    if( t != null )
    {
      printTree( t.left );
      
      System.out.print( t.element + " " );
      
      printTree( t.right );
    }
  }
    
  /**
   * Remove from the tree. Nothing is done if x is not found.
   * @param x the item to remove.
   */
  public void remove( T x )
  {
    root = remove( x, root ); // call the private recursive method
  }
  
  /**
   * Private internal method to remove from a subtree.
   * This method returns the new subtree root -- this is the same as the
   * provided subtree root if the item to delete was not at the subtree root.
   * Otherwise, if the item to delete was at the subtree root, then the new 
   * subtree root will be the node
   * /
   * @param x the item to remove.
   * @param t the node that roots the subtree.
   * @return the new root of the subtree.
   */
  private BinaryNode<T> remove( T x, BinaryNode<T> t )
  {
    if( t == null )
      return t;   // Item not found; do nothing
    
    int compareResult = x.compareTo( t.element );
    
    if( compareResult < 0 )
      t.left = remove( x, t.left ); // remove recursively from left subtree
    
    else if( compareResult > 0 )
      t.right = remove( x, t.right ); // remove recursively from right subtree
    
    // if we got here, then it means compareResult == 0, which means that
    // we have found the node containing the value that we want to delete!  
    // Now, we need to deal with the node's children, if any.
    else if( t.left != null && t.right != null ) // Node to delete has 2 children
    {
      // If the node to delete has 2 children, we need to replace it
      // with the minimum element in its left subtree
      BinaryNode<T> nodeOnRightWithMinElt = findMin( t.right );
      t.element = nodeOnRightWithMinElt.element;
      t.right = remove( nodeOnRightWithMinElt.element, t.right );
    }
    
    else { // Node to delete has either one child or no children
      // replace t with its child, if any
      t = ( t.left != null ) ? t.left : t.right;
      
      /* Note that the code above is the same as the code below
       
       // one left child - replace t with its left child
       if (t.left != null)
          t = t.left;
       // one right child - replace t with its right child
       else
          t = t.right;
          
       */
    }
    
    return t;
  }
   
  
  /**
   * This method tries to draw a tree.  It's a little complicated because
   * to draw a tree, we need a level-order (breadth-first) traversal of the tree.
   * That is, we move from a node to other nodes at the same level, rather
   * than moving to its children.  To facilitate that, we put nodes in a queue
   * as we encounter them.
   * Note that this is not a typical method you would find in a binary search tree
   * class. It is, however, an interesting method because it illustrates using 
   * one data structure to implement an operation of another data structure.
   **/
  public void drawTree(){
    final int SMALLEST_SPACE = 2;
    int height = height(root); // call the private method to compute tree height
    int maxNodes = (int) Math.pow(2, height+1)-1;
    int maxLeaves = maxNodes/2;
    int baseWidth = SMALLEST_SPACE*(maxLeaves);
    int center = baseWidth/2;
    Formatter formatter = new Formatter(System.out);
    
    // queue of nodes at the current level
    Queue<BinaryNode<T>> q1 = new Queue<BinaryNode<T>>();
    q1.enqueue(root);
    
    // will hold queue of nodes at the next level
    Queue<BinaryNode<T>> q2 = new Queue<BinaryNode<T>>();;
    
    int lastSpace = (int) Math.pow(2, height+1);
    
    for (int i=0; i<=height; i++){
      int nPositionsAtLevel = (int) Math.pow(2,i);
      int spaces =  (int) Math.pow(2, (height-i)) * SMALLEST_SPACE;
      int start = center - (nPositionsAtLevel/2*spaces) + (i == 0 ? 0 : spaces/2); 
            
      // print initial spacing
      for (int j=0;j<start; j++){
        System.out.print(" ");
      }
      
      // draw the nodes the current level
      int n = 0;
      while (!q1.isEmpty()){        
        BinaryNode<T> node = q1.dequeue();
        if (node != null){
          // enqueue the children of the node in the queue for the next level
          q2.enqueue(node.left);
          q2.enqueue(node.right);
        } else {
          // enqueue null instead of children to make the spacing right
          q2.enqueue(null);
          q2.enqueue(null);
        }
        
        // display the value of the current node preceded by the correct number of spaces
        if (node != null)
          formatter.format(("%"+(n==0 ? spaces-start : spaces) + "d"),node.element);
        else
          formatter.format(("%"+ (n==0 ? spaces-start : spaces) + "s"),"");
        
        // put the correct number of spaces afterwards.
        for (int j=0; j<spaces; j++)
          System.out.print(" ");
        
        n++;
      }
      System.out.println();
      
      // swap the two queues so that the next level becomes the current level.
      // The empty queue then becomes the queue for the next level.
      Queue<BinaryNode<T>> temp = q1; // temporary reference for 1st (now empty) queue
      q1 = q2; // make the second queue the current queue
      q2 = temp; // empty queue is now the second queue
    }
  }
  
  /**
   * Internal method to compute height of a subtree.
   * @param t the node that roots the subtree.
   */
  private int height( BinaryNode<T> t )
  {
    if( t == null )
      return -1;
    
    else
      return 1 + Math.max( height( t.left ), height( t.right ) );    
  }



  /**
   * using Breadth First to implement Prioty Queue
   * 
   */

   public void breadFirst(){
     //get instance of the queue
    Queue<BinaryNode<T>> queue = new Queue<BinaryNode<T>>();
    //store the root node as first element of the array
    queue.enqueue(root);
    //get an instance of node
    BinaryNode<T> eachNode;
    //as long as the array is not empty 
    //get all element using by visiting each level of the tree and output it
    while(!queue.isEmpty()){
      eachNode = queue.dequeue();
      System.out.println(eachNode.element);
      if(eachNode.left != null) queue.enqueue(eachNode.left);
      if(eachNode.right != null ) queue.enqueue(eachNode.right);
     }
    }
}
