#include "ThreeD.h"
#include "TwoD.h"
#include <iostream>


ThreeD::ThreeD(){
	y = new int;
	z = new int;
	x = *y= *z =0;
}

ThreeD::ThreeD(int x, int y, int z):TwoD(x,y){
	this->x = x;
	this->y = new int;
	this->z =new int;
	*this->y = y;
	*this->z = z;
}

ThreeD::~ThreeD(){
	delete y;
	delete z;
}

void ThreeD::printPoint(){
	cout<< "Three-D Point is " << " (" <<x  <<"," <<*y <<"," <<*z << ")" <<endl; 
}




