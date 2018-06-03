public class Factory
{
  interface Mobile
  {
    void getScreenSize();
  }
  
  class Android implements Mobile{
    @Override
    public void getScreenSize(){
      System.out.println("300 x 400");
    }
  }
    
    class Apple implements Mobile
    {
      @Override
      public void getScreenSize(){
          System.out.println("500 x 300");
      }
    }
    
    class MobileFactory
    {
      public Mobile getMobile(String mobileType)
      {
        if(mobileType == null)
        {
          return null;
        }
        if(mobileType.equalsIgnoreCase("Android"))
        {
          return new Android();
        }
        else if(mobileType.equalsIgnoreCase("Apple"))
        {
          return new Apple();
        }
        else
        {
          return null;
        }
      }
    }
    
    MobileFactory mobile = new MobileFactory();
      
    public static void main(String [] args)
    {
      Factory factory  = new Factory();
      
      Mobile android = factory.mobile.getMobile("Android");
      android.getScreenSize();
      
       Mobile apple = factory.mobile.getMobile("Apple");
       apple.getScreenSize();
       
       //Mobile firefox = factory.mobile.getMobile("firefox");
       //firefox.getScreenSize();
    }
}
      
      
      
      
      
      
        
        
        
      
    