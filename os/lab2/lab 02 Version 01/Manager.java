package os.lab2.Demo;

class Manager
{
  
  public static void run_code_demo_01(){
    System.out.println("CODE DEMO 01");
    System.out.println("manager>>starting");
    Consumer consumer = new Consumer(10,2,7);
    consumer.run();
    System.out.println("manager>>ending");
    
  }
  
  
  
  public static void run_code_demo_02(){
    System.out.println("CODE DEMO 02");
    System.out.println("manager>>starting");
    Producer producer = new Producer(1000,2,3);
    producer.run();
    System.out.println("manager>>ending");
    
  }
  public static void run_code_demo_03(){
    System.out.println("CODE DEMO 03");
    System.out.println("manager>>starting");
    
    Producer producer = new Producer(1000,2,5);
    Consumer consumer = new Consumer(1000,3,5);
    Thread producer_thread = new Thread(producer);
    Thread consumer_thread = new Thread(consumer);
    producer_thread.start();
    consumer_thread.start();
    System.out.println("manager>>ending");
    
  }
  
  public static void main(String args[])
  {
    Manager.run_code_demo_01();
    System.out.println("\n \n ");
    Manager.run_code_demo_02();
    System.out.println("\n \n ");
    Manager.run_code_demo_03();
    
  }
}
