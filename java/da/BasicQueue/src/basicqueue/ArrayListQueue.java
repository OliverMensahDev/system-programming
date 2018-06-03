/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicqueue;

import java.util.ArrayList;

/**
 *
 * @author olivermensah
 * @param <X>
 */
public class ArrayListQueue<X> {
    ArrayList<X> queue = new ArrayList<>();
    
    public void enQueue(X item){
        queue.add(item);
    }
    public int size(){
        return queue.size();
    }
    public X deQueue(){
        if(queue.isEmpty() ){
            //throw new IllegaStateException("No more items  on the stack");
            return null;
        }
        else{
            return queue.remove(0);
        }
    }
    
    public boolean contains(X item){
        boolean found = false;
        for( int i=0; i < queue.size(); i++){
            if(queue.get(i).equals(item)){
                found = true;
                break;
            }
        }
        return found;
    }
    
    public X access(int pos){
       X item = null;
       for(int i = 0; i < queue.size(); i++){
           if( i == pos){
               item = queue.get(i);
           }
       }
       return item;
    }
    
    
}
