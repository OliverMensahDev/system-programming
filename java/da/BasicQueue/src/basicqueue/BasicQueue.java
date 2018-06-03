/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicqueue;

/**
 *
 * @author olivermensah
 * @param <X>
 */
public class BasicQueue<X>{
    private X[] data;
    private int front;
    private int end;
    
    public BasicQueue(){
       this(1000);
    }
    public BasicQueue(int size){
        this.front = -1;
        this.end = -1;
        data = (X[]) new Object[size];
    }
    
    public int size(){
        if(this.front == -1 && this.end ==-1){
            return 0;
        }else{
            return end - front + 1;
        }
    }
    
    public void enQueue(X item){
        //checking if it is full
        if((end +1)% data.length == front){
            throw new IllegalStateException("The Queue is full");
        }else if(size() == 0){
            front++;
            end++;
            data[end] = item;
        }else{
            end++;
            data[end] = item;
        }
    }
    
    public X deQueue(){
        X item = null;
        if(size() == 0){
         throw new IllegalStateException("Empty Queue so Cant dequeue");
        }else if(front == end){
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        }else{
            item = data[front];
            data[front]= null;
            front++;
        }
        return item;
    }
    
    public boolean contains(X item){
        boolean found = false;
        if(size() == 0) return found;
        for(int i = 0; i < size(); i++){
            if(data[i].equals(item))found = true;
        }
        return found;
    }
    
    public X access(int position){
        X item = null;
        if(size()== 0)
            item = (X)"No item in the queue";
        if(position < size()){
          for(int trueIndex = 0; trueIndex < size();trueIndex++){
              if(trueIndex == position)
                  item = data[position];
            }             
          }else
            item = (X) ("No item found at position" + position);
        
        return item;
    }
}

