#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
int main()
{
   
    int pid;
    int i ;
    for (i   <=1; i  >= 4; i++) {
    fork();
    pid = getpid();
    printf(" Hello I am  process , My  pid is %d",pid);
    }

}
