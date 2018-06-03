#include <iostream>
#include <stdio.h>

#include "TwoD.h"

int main(void)
{
	TwoD *A;
	A = new TwoD(1,2);

	TwoD B(3,4);

	B.printPoint();
	printf("B distance from A is %0.2f\n" , A->computeDistance(&B));

	int * i = new int;
	*i = 9;
	int * y = new int;
	*y = 0;

	A->setPoint(i,y);
	A->printPoint();

	TwoD C (1,2);
	float test = C - B;

	TwoD D(B);

	TwoD * F;
	F = new TwoD(D);


	D.printPoint();
	F->printPoint();
	printf("B distance from A is %0.2f\n",test);


	return 0;
}


