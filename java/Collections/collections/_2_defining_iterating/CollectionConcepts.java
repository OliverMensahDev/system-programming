package Collections.collections._2_defining_iterating;

import Collections.collections.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionConcepts{
  
  public static void main(String[] args) {
    Product door = new Product("Wooden Door", 35);
    Product floorPanel = new Product("Floor Panel", 25);
    Product window = new Product("Glass Window", 10);
    
    Collection<Product> products = new ArrayList<>();
    products.add(door);
    products.add(floorPanel);
    products.add(window);
    //removes overhead of using Arrays.toString(prodducts)
    System.out.println(products); 
    
    // Collection Operators
    System.out.println(products.size()); 
    System.out.println(products.isEmpty()); 
    System.out.println(products.contains(window));
    //System.out.println(products.removeAll()); 
    System.out.println(products); 
    
    
    
    
    
    
    //Loop with Iterators: Cursor to step through a collection
    final Iterator<Product> productIterator = products.iterator();
    while(productIterator.hasNext()){
      Product  product = productIterator.next(); // give me the next element and move forward.
      System.out.println(product);
    }
    
    //for each : under the hood, it desugars the for each to Iterator
    // For loop do not accept modification of code in Java
    for (Product product: products){
      System.out.println(product);
    }
    
    // using some conditions with collection.
    for (Product product: products){
      if(product.getWeight() > 20) System.out.println(product);
    }
    //what you can do with iterator but not in foreach loop 
    
    while(productIterator.hasNext()){
      Product  product = productIterator.next(); 
      if(product.getWeight() > 20) System.out.println(product);
      else productIterator.remove();
    }
    
  }
  
}