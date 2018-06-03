/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicstack;

import java.util.ArrayList;

/**
 *
 * @author olivermensah
 * @param <X>
 */
public class ArrayListStack<X>  implements stack<X>{

    private ArrayList<X> stringList = new ArrayList<X>();
      
    public void push(X newItem){
        stringList.add(newItem);
    }
    
    @Override
    public X pop(){
        if(stringList.isEmpty() ){
            //throw new IllegaStateException("No more items  on the stack");
            return null;
        }
        else{
            return stringList.remove(stringList.size() -1);
        }
    }

    public boolean contains(X item){
        boolean found = false;
        for( int i=0; i < stringList.size(); i++){
            if(stringList.get(i).equals(item)){
                found = true;
                break;
            }
        }
        return found;
    }
    
    public X access(X item){
        while (stringList.size()> 0){
            X tempItem = pop();
            if(item.equals(tempItem)){
                return tempItem;
            }
        }
        //throw new IllegalArgumentException("Could not find item on the stack");
        return null;
    }

    public int size(){
        return stringList.size();
    }    

    @Override
    public void push() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
