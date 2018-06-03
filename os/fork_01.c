#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
int main()
{
    int status;
    int pid;
    pid=fork();
    if(pid<0)
    {
        printf("\n Error ");
        exit(1);
    }
    else if(pid==0)
    {
        printf(" Hello I am the child process My pid is %d , My parent's id is %d",getpid(),getppid());
    }
    else
    {
       printf(" Hello I am the Parent process My pid is %d , My child's id is %d",getppid(),getppid());
    }

}
