#ifndef THREED_H
#define THREED_H

#include "TwoD.h"

class ThreeD : public TwoD{
	int x;
	int * y;
	int * z ;
	public :
		ThreeD();
		ThreeD(int x, int y, int z);
		~ThreeD();

		void printPoint();
};

#endif
