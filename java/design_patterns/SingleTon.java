class SingleTon{
  //Eager Instantiation approach
  private static SingleTon instance = new SingleTon();
  private SingleTon(){
  }
  public static SingleTon getInstance(){
    return instance;
  }
  public String saySomething(){
    return "Hey U called me";
  }
  public static void main(String [] args){
    SingleTon sg = SingleTon.getInstance();
    System.out.println(sg.saySomething());
  }
}