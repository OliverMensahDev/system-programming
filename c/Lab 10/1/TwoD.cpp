#include <iostream>
#include <math.h>
#include "TwoD.h"

using namespace std;

TwoD::TwoD(){
	y = new int;
	x = *y =0;
}

TwoD::TwoD(int x, int y){
	this->x = x;
	this->y = new int;
	*this->y = y;
}

TwoD::~TwoD(){
	delete y;
}

void TwoD::setPoint(int *a, int *b){
	this->x = *a;
	this->y = b;
}
 void TwoD::printPoint(){
 	cout<< "Two-D Point is " << " (" <<x  <<"," <<*y<<")" <<endl;
 }

//this prints a message like: Two-D Point is (xx,yy)
void TwoD::convert2Polar(float& magnitude, float* angle){
	*angle = atan(*y/x);
	magnitude  = sqrt((pow(x,2)) + (pow(*y,2)));
}

//angle is computered as atan(y/x)
//magnitude is
float TwoD::computeDistance(TwoD *B){
	return sqrt((pow((this->x - B->x), 2)) + (pow((*this->y - *B->y),2)));
}

float TwoD:: operator - (TwoD B){
	return sqrt((pow((this->x - B.x), 2)) + (pow((*this->y - *B.y),2)));
}
