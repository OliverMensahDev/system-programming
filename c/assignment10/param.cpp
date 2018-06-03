#include "TwoD.h"
#include <math.h>
TwoD::TwoD(){
  x= 0;
  y = new int(0);
}
TwoD::TwoD(int x, int y){
  this->x = x;
  y = new int;
  *y = y;
}
TwoD::~TwoD(){
  delete y;
}
void TwoD::setPoint(int *a, int *b){
  a = new int ;
  x = *a;
  b = new int();
  y = new int;
  *y = *b;
}
virtual void TwoD::printPoint(){
  cout << "Two-D Point is "+ <<this->x <<", "<< this->y<<")" <<end1
}
void TwoD::convert2Polar(float& magnitude, float* angle){
  angle = new float;
  *angle = (float) atan(y/x);
  manitude = sqrt(pow(x,2) + pow(y,2 ));
}
float TwoD::computeDistance(TwoD *B){
  B = new TwoD;
  *B->y = new int ;
  return sqrt(pow(B->x - this->x, 2) + pow(*B->y - this->y, 2));
  }
