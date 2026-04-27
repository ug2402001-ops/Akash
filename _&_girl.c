#include<stdio.h>
#include<string.h>
int main()
{
    char a[100];
    int i=0;
        scanf("%s",&a);
    int len=strlen(a);
    if(len%2==0)
    {
        printf("CHAT WITH HER!\n");
    }
    else
        {
        printf("IGNORE HIM!");
    }


}
