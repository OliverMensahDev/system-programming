#include <iostream>
#include "ThreeD.h"

int main (void){
	
	TwoD * P2;
	ThreeD * P3;
	P3 = new ThreeD(2,3,4);
	P2 = new TwoD();
	P3->printPoint(); // output is Three-D Point is  (2,3,4)

	ThreeD F (4,5,6);
	*P2 = F;

	P2->printPoint();
	//vii. What do you expect to print?
	//I expected it to print (0,0) and it did
	return 0;
}

void printAll(ThreeD A){
	A.printPoint();
} 
