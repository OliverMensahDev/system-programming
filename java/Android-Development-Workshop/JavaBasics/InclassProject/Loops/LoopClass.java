package InclassProject.Loops;

public class LoopClass {
  
  public LoopClass(){}
  
  public void doLoop(){
    //print even nos from 1 to 20 
    for(int i = 1; i <= 20; i+=1){
      if(i %2 == 0) {
        System.out.println(i);
      }
    }
  }
  
}
