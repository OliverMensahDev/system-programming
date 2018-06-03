package os.lab2.Demo;
class Consumer extends Thread {
  int sleep_time;
  int jobs_to_consume_per_wakeup;
  int total_jobs_to_consume;

  public void run(){
    System.out.println("consumer>>starting");
        for (int i = 1; i <= total_jobs_to_consume; i++) {
          System.out.println("consumer[" +i+"]>>sleeping.");
          System.out.println("consumer[" +i+"]>>awake.");
          System.out.println("consumer[" +i+"]>>consumed item 1.");
         System.out.println("consumer[" +i+"]>>consumed item 2.");
         int tracker = i*2 ;
         if(tracker  <  total_jobs_to_consume ){
           System.out.println("consumer progress is " + i*2+"/"+total_jobs_to_consume);
         }
         else{
            System.out.println("consumer progress is " + total_jobs_to_consume+"/"+total_jobs_to_consume);
            break;
         }
        }
        System.out.println("consumer>>ended");
        
         
        
  }
  
 
public Consumer(int sleep_time, int jobs_to_consume_per_wakeup, int total_jobs_to_consume) {
  this.sleep_time = sleep_time;
  this.jobs_to_consume_per_wakeup = jobs_to_consume_per_wakeup;
  this.total_jobs_to_consume = total_jobs_to_consume;
}


}
