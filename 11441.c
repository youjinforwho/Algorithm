#include <stdio.h>
#define SIZE 100000

int main()
{
    int num1, num2;
    int a, b;
    int arr[SIZE];
    scanf("%d", &num1);
    for (int i = 0; i < num1; i++)
    {
        scanf("%d", &arr[i]);
        if (i != 0)
            arr[i] += arr[i - 1];
    }
    scanf("%d", &num2);
    for (int i = 0; i < num2; i++)
    {
        scanf("%d %d", &a, &b);
        if (a == 1)
            printf("%d\n", arr[b - 1]);
        else
            printf("%d\n", arr[b - 1] - arr[a - 2]);
    }
    return 0;
}