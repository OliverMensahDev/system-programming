/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicstack;

/**
 *
 * @author olivermensah
 * @param <X>
 */
public class BasicStack<X>  implements stack<X>{

    private X[] data;
    private int stackPointer;

    public BasicStack(){
        data = (X[]) new Object[1000];
        stackPointer = 0;
    }

    public void push(X newItem){
        //assign to previous value and increase it 
        data[stackPointer++] = newItem;
    }
    
    @Override
    public X pop(){
        //decrement and return 
        if(stackPointer ==0 ){
            //throw new IllegaStateException("No more items  on the stack");
            return null;
        }
        return data[--stackPointer];
    }

    public boolean contains(X item){
        boolean found = false;
        for( int i=0; i < stackPointer; i++){
            if(data[i].equals(item)){
                found = true;
                break;
            }
        }
        return found;
    }
    
    public X access(X item){
        while (stackPointer > 0){
            X tempItem = pop();
            if(item.equals(tempItem)){
                return tempItem;
            }
        }
        //throw new IllegalArgumentException("Could not find item on the stack");
        return null;
    }

    public int size(){
        return stackPointer;
    }

    @Override
    public void push() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
