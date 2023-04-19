#include <stdio.h>



int main(){
    int A, B;
    int arr[1000];
    int num = 1;
    int temp = 1;
    scanf("%d %d", &A, &B);
    for (int i = 0; i < 1000; i++)
    {
        arr[i] = num;
        if (num == temp)
        {
            num++;
            temp = 1;
        }
        else temp++;
        if (i != 0) arr[i] += arr[i - 1];
    }
    if (A == 1) printf("%d\n", arr[B - 1]);
    else printf("%d\n", arr[B - 1] - arr[A - 2]);
    return 0;
}