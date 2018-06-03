
#include <iostream>
#include <math.h>


#ifndef TWOD_H
#define TWOD_H

using namespace std;

class TwoD{
	int x;
	int *y;
	public:
		TwoD();
		TwoD(const TwoD& B); // copy constructor 
		TwoD(int x, int y);
		~TwoD();
		void setPoint(int *a, int *b);
		virtual void printPoint();

		//this prints a message like: Two-D Point is (xx,yy)
		void convert2Polar(float& magnitude, float* angle);

		//angle is computered as atan(y/x)
		//magnitude is
		float computeDistance(TwoD *B);

		//distance is calculated as sqrt((x2-x1)^2+ (y2-y1)^2 ).
		// You may need to use the pow() function.
		float operator - (TwoD B);
};

#endif