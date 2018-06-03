#include <iostream>
using namespace std;
struct Item{
  float costPrice;
  float sellingPrice;
  int quantity;
  float profit;
};

void readAllItems(Item A[], int arraySize);//read all values into the array, ask user for values
void modifyQuantity(Item *data);//ask the user for the quantity, for one item
void printDetails(Item data); //print cp, sp, qty, profit, and total profit =profit*qty. (for one item)
void printAll(Item *X, int arrySize);//print for all elements in the array. Make use of printDetails() function above in this function.
void computeProfit(Item &data );//profit =cp-sp
float setSellingPrice(Item A[], int index);//pass array, ask user to supply selling price for one time
int main() {
  Item *P;
  int size = 2;
  P = new Item[size];
  readAllItems(P, size);
  printDetails(P[1]);
  printAll(P, size);
  return 0;
}

void readAllItems(Item A[], int arraySize){
  for(int i = 0 ; i < arraySize ; i++){
  cout << "Enter cost of item : ";
  cin>>A[i].costPrice;
  modifyQuantity(&A[i]);
  setSellingPrice(A, i);
  computeProfit(*A);
}
}

void modifyQuantity(Item *data){
   cout << "Enter quantity of item: ";
   cin>>data->quantity;
}
void printDetails(Item item){
 cout << " The cost is : " << item.costPrice <<endl;
 cout << " The selling price is :" << item.sellingPrice <<endl;
 cout << " The quantity is :" << item.quantity <<endl;
 cout << " The profit is :" << item.profit <<endl;
 cout << " The total profit is : "<< item.profit * item.quantity <<endl;
}
void printAll(Item *X, int arraySize){
  for(int i = 0 ; i < arraySize ; i++){
  printDetails(X[i]);
}
}
void computeProfit(Item &data ){
    data.profit = data.sellingPrice - data.costPrice;

}
float setSellingPrice(Item A[], int index){
    cout << "Enter selling price of item : ";
    cin>>A[index].sellingPrice;
    return A[index].sellingPrice;
}
