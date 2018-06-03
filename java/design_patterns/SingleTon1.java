class SingleTon1{
  //Lazy instantiation
  private static SingleTon1 instance = null;
  private SingleTon1(){
  }
  public static SingleTon1 getInstance(){
    if(instance == null){
      instance = new SingleTon1();
    }
    return instance;
  }
  public String saySomething(){
    return "Hey U called me";
  }
  
  public static void main(String [] args){
    SingleTon1 sg = SingleTon1.getInstance();
     System.out.println(sg.saySomething());
  }
}