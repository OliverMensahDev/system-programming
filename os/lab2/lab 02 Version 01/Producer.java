package os.lab2.Demo;
class Producer implements Runnable
{
int sleep_time;
int jobs_to_produce_per_wakeup;
int total_jobs_to_produce;


   public void run(){
    System.out.println("producer>>starting");
        for (int i = 1; i <= total_jobs_to_produce; i++) {
          System.out.println("producer[" +i+"]>>sleeping.");
          System.out.println("producer[" +i+"]>>awake.");
          System.out.println("producer[" +i+"]>>produced item 1.");
         System.out.println("producer[" +i+"]>>produced item 2.");
         int tracker = i*2 ;
         if(tracker  <  total_jobs_to_produce ){
           System.out.println("producer progress is " + i*2+"/"+total_jobs_to_produce);
         }
         else{
            System.out.println("producer progress is " + total_jobs_to_produce+"/"+total_jobs_to_produce);
            break;
         }
        }
        System.out.println("producer>>ended");
        
         
        
  }
public Producer(int sleep_time, int jobs_to_produce_per_wakeup, int total_jobs_to_produce) {
  this.sleep_time = sleep_time;
  this.jobs_to_produce_per_wakeup = jobs_to_produce_per_wakeup;
  this.total_jobs_to_produce = total_jobs_to_produce;

}



}
