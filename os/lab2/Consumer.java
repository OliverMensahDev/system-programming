package os.lab2;
class Consumer extends Thread {
  int sleep_time;
  int jobs_to_consume_per_wakeup;
  int total_jobs_to_consume;

  public void run(){
    System.out.println("consumer>>starting");
        for (int i = 1; i <= total_jobs_to_consume; i++) {
          System.out.println("consumer[" +i+"]>>sleeping.");
          System.out.println("consumer[" +i+"]>>awake.");
          System.out.println("consumer progress is " + i+"/"+total_jobs_to_consume);
        }
        System.out.println("consumer>>ending");
        
         
        
  }
  
 
public Consumer(int sleep_time, int jobs_to_consume_per_wakeup, int total_jobs_to_consume) {
  this.sleep_time = sleep_time;
  this.jobs_to_consume_per_wakeup = jobs_to_consume_per_wakeup;
  this.total_jobs_to_consume = total_jobs_to_consume;
}


}
