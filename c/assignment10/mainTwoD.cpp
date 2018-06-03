#include "TwoD.h"

int  main() {
  TwoD point;
  TwoD point1(2,4);
  TwoD point2(1,2);
  point1.convert2Polar();
  point2.computeDistance(point1(2,4))
  return 0;
}
