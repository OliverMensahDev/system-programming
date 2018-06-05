class Car {
  private String carType;
  private int noDoors;
  private double weight;
  private double maxSpeed;
  private String registerNo;
  
  
  //getters 
  public String getCarType() {
    return this.carType;
  }
  
  public int getNoDoors() {
    return this.noDoors;
  }
  
  public double getWeight() {
    return this.weight;
  }
  
  public double getMaxSpeed(){
    return this.maxSpeed;
  }
  
  private void setReg(String no){
    this.registerNo = no;
  }
  public String getReg(){
    return this.registerNo;
  }
  //setters 
  public void setCarType(String carType) {
    this.carType = carType;
  }
  
  public void setNoDoors(int noDoors) {
    this.noDoors = noDoors;
  }
  
  public void setWeight(double weight) {
    this.weight = weight;
  }
  
  public void setMaxSpeed(double maxSpeed){
    this.maxSpeed = maxSpeed;
  }
}